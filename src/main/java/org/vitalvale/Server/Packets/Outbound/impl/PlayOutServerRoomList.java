package org.vitalvale.Server.Packets.Outbound.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.ChannelHandlerContext;
import org.vitalvale.Game.GameSession;
import org.vitalvale.Server.Packets.Packet;

import java.net.InetSocketAddress;

public class PlayOutServerRoomList extends Packet {

    private int PacketID;
    private GameSession[] GameSessions;

    public void setPacketID(int packetID) {
        PacketID = packetID;
    }

    public int getPacketID() {
        return PacketID;
    }

    public void setGameSessions(GameSession[] GameSessions) {
        this.GameSessions = GameSessions;
    }

    public GameSession[] getGameSessions() {
        return GameSessions;
    }

    @Override
    public void Handle(ChannelHandlerContext ctx, InetSocketAddress sender, int packetId, String payload, ObjectMapper mapper) {

    }
}
