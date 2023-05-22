package org.vitalvale.Server.Packets.Inbound.impl;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.ChannelHandlerContext;
import org.vitalvale.Game.GameSession;
import org.vitalvale.Game.Player.Player;
import org.vitalvale.Game.Player.Position;
import org.vitalvale.Game.Player.Rotation;
import org.vitalvale.Server.Packets.Packet;
import org.vitalvale.VitalVale;

import java.net.InetSocketAddress;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PlayInPosRot extends Packet {

    public PlayInPosRot(@JsonProperty("PacketID") int PacketID, @JsonProperty("PlayerID") int PlayerID, @JsonProperty("RoomID") int RoomID,
                        @JsonProperty("XPos") float XPos, @JsonProperty("YPos") float YPos,
                        @JsonProperty("ZPos") float ZPos, @JsonProperty("XRot") float XRot,
                        @JsonProperty("YRot") float YRot, @JsonProperty("ZRot") float ZRot)
    {
        this.PacketID = PacketID;
        this.PlayerID = PlayerID;
        this.RoomID = RoomID;

        this.XPos = XPos;
        this.YPos = YPos;
        this.ZPos = ZPos;
        this.XRot = XRot;
        this.YRot = YRot;
        this.ZRot = ZRot;
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
    public void Handle(ChannelHandlerContext ctx, InetSocketAddress sender, int packetId, String payload, ObjectMapper mapper)
    {
//        Position position = new Position(this.XPos, this.YPos, this.ZPos);
//        System.out.println("Position Packet Received PID: " + getPlayerID() + ", Position: " + position.getString());
//        GameSession session = VitalVale.getSessionManager().getSessionById(getRoomID());
//        if(session != null)
//        {
//            Player player = session.getPlayerByID(getPlayerID());
//            if(player != null)
//            {
//                // Security/Cheat Checks later...
//                player.setPosition(new Position(this.XPos, this.YPos, this.ZPos));
//                player.setRotation(new Rotation(this.XRot, this.YRot, this.ZRot));
//            }
//        }
    }

    public int PacketID;
    public int PlayerID;
    public int RoomID;

    public float XPos, YPos, ZPos;
    public float XRot, YRot, ZRot;

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
