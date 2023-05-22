package org.vitalvale.Server.Packets.Inbound.impl;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import org.vitalvale.Game.GameSession;
import org.vitalvale.Server.Packets.Packet;
import org.vitalvale.VitalVale;

import java.net.InetSocketAddress;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PlayInMatchmakingPacket extends Packet {
    public PlayInMatchmakingPacket(@JsonProperty("PacketID") int PacketID , @JsonProperty("PlayerID") int PlayerID) {
        this.PacketID = PacketID;
        this.PlayerID = PlayerID;
    }

    public int PacketID;
    public int PlayerID;


    public int getPacketID() {
        return this.getPacketID();
    }

    public int getPlayerID() {
        return PlayerID;
    }

    @Override
    public void Handle(ChannelHandlerContext ctx, InetSocketAddress sender, int packetId, String payload, ObjectMapper mapper) {


//        GameSession gameSession = VitalVale.getSessionManager().getFreeSession();
//        if(gameSession != null) {
//            System.out.println("Found a Session for Player " + this.getPlayerID() + " with id of " + gameSession.getSessionId());
//        }else {
//            System.out.println("Currently there isn't any free sessions, Creating a Session for player " + this.getPlayerID());
//            gameSession = VitalVale.getSessionManager().createSession(VitalVale.getSessionManager().getSessions().size() + 1, 50);
//        }
//
//
//
//
//        PlayOutMatchmakingPacket p = new PlayOutMatchmakingPacket();
//        p.setPacketId(0);
//        p.setSessionId(gameSession.getSessionId());
//
//        try {
//            String jsonString = mapper.writeValueAsString(p);
//
//            ByteBuf buf = Unpooled.copiedBuffer(jsonString.getBytes());
//
//            DatagramPacket datagramPacket = new DatagramPacket(buf, sender);
//            ctx.writeAndFlush(datagramPacket);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
    }
}
