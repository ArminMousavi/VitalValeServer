package org.vitalvale.Game.Player;

public class Player {
    private int uuid;

    private String name;

    private Position position;

    private Rotation rotation;

    private int health;



    private Team team;


    /**
     * Makes a Player object that used in Game Server.
     * @param name of the player
     * @param health health of the player
     */
    public Player(String name, int health) {
        this.name = name;
        this.health = health;

        this.team = null;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getUuid() {
        return uuid;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Rotation getRotation() {
        return rotation;
    }

    public void setRotation(Rotation rotation) {
        this.rotation = rotation;
    }
}