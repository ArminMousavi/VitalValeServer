package org.vitalvale.Game;

import io.netty.channel.Channel;
import org.vitalvale.Game.Player.Player;
import org.vitalvale.Game.Player.Team;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameSession {
    private final int m_SessionId;


    private Team m_Terrorist;
    private Team m_Defence;

    private final String m_GameMap;

    private int m_CurrentPlayers;
    private final int m_MaxPlayers;
    private final ArrayList<Player> m_Players;

    private boolean m_IsStarted = false;

    private SessionManager m_SessionManager;


    /**
     * Constructs a GameSession for a Couple of Players when they are ready.
     *
     * @param sessionManager Instance of the Session Manager.
     * @param sessionId      ID of the Session.
     * @param maxPlayers     Max Players of the Session.
     * @param gameMap        Map of the Game ( The Name of Map ).
     */
    public GameSession(SessionManager sessionManager, int sessionId, int maxPlayers, String gameMap) {
        this.m_SessionId = sessionId;
        this.m_Terrorist = new Team("Terrorist");
        this.m_Defence = new Team("Defence");
        this.m_GameMap = gameMap;
        this.m_MaxPlayers = maxPlayers;
        this.m_Players = new ArrayList<>();
        this.m_CurrentPlayers = 0;
        this.m_SessionManager = sessionManager;

        System.out.println("New Session Created, Session #" + this.m_SessionId + ".");
    }

    /**
     * Adds a Player into GameSession and sets the Player Team.
     *
     * @param player Player Object
     */
    public void addPlayer(Player player) {
        if (m_Terrorist.getNumPlayers() <= m_Defence.getNumPlayers()) {
            m_Terrorist.addPlayer(player);
            player.setTeam(m_Terrorist);
        } else {
            m_Defence.addPlayer(player);
            player.setTeam(m_Defence);
        }
        m_Players.add(player);
        m_CurrentPlayers = m_Players.size();
    }

    /**
     * Removes a Player from GameSession.
     *
     * @param player
     */
    public void removePlayer(Player player) {
        if (player.getTeam() == m_Terrorist) {
            m_Terrorist.removePlayer(player);
        } else {
            m_Defence.removePlayer(player);
        }
        m_Players.remove(player);
        m_CurrentPlayers = m_Players.size();

    }

//    public void endSession() {
//        m_IsStarted = false;
//        m_SessionManager.endSession(this);
//    }

    public boolean isStarted() {
        return m_IsStarted;
    }

    public int getSessionId() {
        return m_SessionId;
    }

    public Team getTerrorist() {
        return m_Terrorist;
    }

    public Team getDefence() {
        return m_Defence;
    }

    public String getGameMap() {
        return m_GameMap;
    }

    public ArrayList<Player> getPlayers() {
        return m_Players;
    }

    /**
     * Get a InGame Player By Player ID.
     *
     * @param playerId ID of the Player
     * @return Returns the Player Object / null.
     */
    public Player getPlayerByID(int playerId) {
        for (Player player : getPlayers()) {
            if (player.getUuid() == playerId) {
                return player;
            }
        }
        return null;
    }

    public int getMaxPlayers() {
        return m_MaxPlayers;
    }

    public int getCurrentPlayers() {
        return m_CurrentPlayers;
    }

}
