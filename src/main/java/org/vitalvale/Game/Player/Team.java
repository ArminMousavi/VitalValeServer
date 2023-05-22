package org.vitalvale.Game.Player;

import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Player> players;

    public Team(String name) {
        this.name = name;
        players = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public int getNumPlayers() {
        return players.size();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
