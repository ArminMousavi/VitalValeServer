package org.vitalvale.Server.Packets.Outbound.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.ChannelHandlerContext;
import org.vitalvale.Server.Packets.Packet;

import java.net.InetSocketAddress;

public class PlayOutEnterGame extends Packet {
    private int PacketID;
    private boolean CanJoin;
    private String Message;

    public void setPacketID(int packetID) {
        PacketID = packetID;
    }

    public int getPacketID() {
        return PacketID;
    }

    public void setCanJoin(boolean canJoin) {
        CanJoin = canJoin;
    }

    public boolean isCanJoin() {
        return CanJoin;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }

    @Override
    public void Handle(ChannelHandlerContext ctx, InetSocketAddress sender, int packetId, String payload, ObjectMapper mapper) {

    }
}
