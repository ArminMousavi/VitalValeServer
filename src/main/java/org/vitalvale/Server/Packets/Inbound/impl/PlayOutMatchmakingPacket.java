package org.vitalvale.Server.Packets.Inbound.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.ChannelHandlerContext;
import org.vitalvale.Server.Packets.Packet;

import java.net.InetSocketAddress;

public class PlayOutMatchmakingPacket extends Packet{

    private int packetId;
    private int sessionId;


    public int getPacketId() {
        return packetId;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setPacketId(int packetId) {
        this.packetId = packetId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public void Handle(ChannelHandlerContext ctx, InetSocketAddress sender, int packetId, String payload, ObjectMapper mapper) {

    }
}


