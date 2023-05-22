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
import org.vitalvale.Server.Packets.Outbound.impl.PlayOutEnterGame;
import org.vitalvale.Server.Packets.Packet;
import org.vitalvale.VitalVale;

import java.net.InetSocketAddress;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PlayInEnterGame extends Packet {
    public PlayInEnterGame(@JsonProperty("PacketID") int PacketID, @JsonProperty("PlayerID") int PlayerID, @JsonProperty("RoomID") int RoomID){
        this.PacketID = PacketID;
        this.PlayerID = PlayerID;
        this.RoomID = RoomID;
    }

    /**
     * Handles the Packet when its received and processed.
     * @param ctx Context of network handler.
     * @param sender Packet sender network address.
     * @param packetId Id number of the Packet.
     * @param payload the Payload of the Packet.
     * @param mapper JSON Mapper for Decryption of the Packet.
     */
    @Override
    public void Handle(ChannelHandlerContext ctx, InetSocketAddress sender, int packetId, String payload, ObjectMapper mapper) {
//        GameSession gameSession = VitalVale.getSessionManager().getSessionById(this.RoomID);
//        if(gameSession != null)
//        {
//
//            PlayOutEnterGame packet = new PlayOutEnterGame();
//            packet.setPacketID(1);
//
//            if(gameSession.getCurrentPlayers() < gameSession.getMaxPlayers())
//            {
//                packet.setCanJoin(true);
//                packet.setMessage("");
//
//                VitalVale.getNetworkPlayers().get("127.0.0.1").getPlayerChannel().writeAndFlush("sdada");
//            }else
//            {
//                packet.setCanJoin(false);
//                packet.setMessage("اتاق مورد نظر پر شده است.");
//            }
//
//            try
//            {
//                String jsonString = mapper.writeValueAsString(packet);
//
//                ByteBuf buf = Unpooled.copiedBuffer(jsonString.getBytes());
//
//                DatagramPacket datagramPacket = new DatagramPacket(buf, sender);
//
//                ctx.writeAndFlush(datagramPacket);
//
//            }
//            catch (JsonProcessingException e)
//            {
//                e.printStackTrace();
//            }
//        }
    }

    public int PacketID;
    public int PlayerID;
    public int RoomID;

    public int getPacketID() {
        return PacketID;
    }

    public int getPlayerID() {
        return PlayerID;
    }

    public int getRoomID() {
        return RoomID;
    }
}
