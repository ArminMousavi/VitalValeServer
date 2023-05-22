package org.vitalvale.Server.Network;

import io.netty.channel.Channel;

public class NetworkPlayer {
    private int m_PlayerID;
    private Channel m_PlayerChannel;


    /**
     * A NetworkPlayer is used for storing Network data for Players.
     * @param playerID The numeric Unique ID of the Player.
     * @param playerChannel Networking channel of the Player.
     */
    public NetworkPlayer(int playerID, Channel playerChannel) {
        this.m_PlayerID = playerID;
        this.m_PlayerChannel = playerChannel;
    }

    /**
     * A NetworkPlayer is used for storing Network data for Players.
     * @param playerChannel Networking channel of the Player.
     */
    public NetworkPlayer(Channel playerChannel) {
        this.m_PlayerID = -1;
        this.m_PlayerChannel = playerChannel;
    }

    public void setPlayerID(int m_PlayerID) {
        this.m_PlayerID = m_PlayerID;
    }

    public int getPlayerID() {
        return m_PlayerID;
    }

    public Channel getPlayerChannel() {
        return m_PlayerChannel;
    }
}
