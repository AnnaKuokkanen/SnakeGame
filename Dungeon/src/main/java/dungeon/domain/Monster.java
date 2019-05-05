/*
 * @author olli m
 */
package dungeon.domain;

import dungeon.backend.Game;
import dungeon.backend.PathFinder;

/**
 * This class is the primary enemy of the game. Will make this an abstract class
 * if I decide to add multiple monster classes. AI should probably be refactored
 * into another class.
 */
public class Monster extends Actor {

    private static final int MAX_HEALTH = 20;
    private double visionRatio;
    private double fleeThreshold;
    private double safeThreshold;
    private double alertRadius;
    private char symbol;

    private ActorState state;
    private boolean alerted;

    public Monster(int x, int y) {
        super.setPosition(new Node(x, y));
        super.setNextTurn(0);
        super.setHealth(MAX_HEALTH);
        super.setMaxHealth(MAX_HEALTH);
        super.setIntervalModifier(1.0);
        boolean[] hostileSymbols = new boolean[Character.MAX_VALUE];
        hostileSymbols['@'] = true;
        super.setHostileSymbols(hostileSymbols);
        this.visionRatio = 0.8;
        this.fleeThreshold = 0.25;
        this.safeThreshold = 0.75;
        this.alertRadius = 10.0;
        this.state = ActorState.STAY;
        this.symbol = 'D';
        setAttack(new Bite());
        this.alerted = false;
    }

    public Monster(int x, int y, ActorType monsterType) {
        this(x, y);
        if (monsterType != null) {
            super.setHealth(monsterType.maxHealth);
            super.setMaxHealth(monsterType.maxHealth);
            this.visionRatio = monsterType.visionRatio;
            this.fleeThreshold = monsterType.fleeThreshold;
            this.safeThreshold = monsterType.safeThreshold;
            this.alertRadius = monsterType.alertRadius;
            this.symbol = monsterType.symbol;
            setAttack(monsterType.attack);
            setActorType(monsterType);
        }
    }

    @Override
    public char getSymbol() {
        return symbol;
    }

    public void setState(ActorState state) {
        this.state = state;
    }

    public void setVisionRatio(double visionRatio) {
        this.visionRatio = visionRatio;
    }

    public void setAlertRadius(double alertRadius) {
        this.alertRadius = alertRadius;
    }

    public double getFleeThreshold() {
        return fleeThreshold;
    }

    public void setFleeThreshold(double fleeThreshold) {
        this.fleeThreshold = fleeThreshold;
    }

    public void reactOnSight(Game game) {
        if (this.distanceTo(game.getPlayer()) < visionRatio * game.getVisionRadius()) {
            alert(game);
        }
    }

    /**
     * Setting up an alert that spreads to nearby monsters.
     *
     * @param game
     */
    public void alert(Game game) {
        char[][] map = game.getMap();
        Player player = game.getPlayer();
        PathFinder pathFinder = game.getPathFinder();
        if (!pathFinder.getOldCenter().equals(player.getPosition())) {
            pathFinder.computePaths(map, player.getPosition().getX(), player.getPosition().getY());
        }
        DijkstraMap attackMap = pathFinder.getDijkstraMap();
        if (state == ActorState.FLEE) {
            setDijkstraMap(attackMap.copy().invert());
        } else {
            setDijkstraMap(attackMap);
        }
        state = ActorState.ATTACK;
        this.alerted = true;
        alertNearby(game, attackMap);
    }

    private void alertNearby(Game game, DijkstraMap attackMap) {
        for (Actor actor : game.getActors()) {
            if (actor.getClass() == this.getClass()) {
                Monster monster = (Monster) actor;
                if (this.distanceTo(monster) < alertRadius
                        && monster.getActorType() != ActorType.DRAGON
                        && !monster.alerted) {
                    monster.alerted = true;
                    monster.state = ActorState.ATTACK;
                    monster.setDijkstraMap(attackMap);
                }
            }
        }
    }

    /**
     * Monster AI: Wait in place until player is seen; flee if HP low; stop
     * running away when HP is above threshold.
     *
     * @param game
     * @param map map generated by populateMap(), represents what the actor sees
     */
    @Override
    public void act(Game game, char[][] map) {
        if (getDijkstraMap() == null) {
            setDijkstraMap(new DijkstraMap(map[0].length, map.length));
        }
        if (getHealth() < getMaxHealth() * fleeThreshold) {
            if (state != ActorState.FLEE) {
                state = ActorState.FLEE;
                setDijkstraMap(getDijkstraMap().copy().invert(getActorType().escapeBias));
            }
            alerted = false;
        } else if (state == ActorState.FLEE && getHealth() > getMaxHealth() * safeThreshold) {
            state = ActorState.STAY;
        }
        if (state == ActorState.STAY) {
            idle();
        } else {
            followDijkstraMap(game, map);
        }
        heal();
    }

    private void followDijkstraMap(Game game, char[][] map) {
        boolean success = false;
        for (Direction direction : getDijkstraMap().candidates(getPosition())) {
            if (move(direction, game, map)) {
                success = true;
                break;
            }
        }
        if (!success) {
            idle();
        }
    }

    @Override
    public String toString() {
        return "" + getNextTurn();
    }

}
