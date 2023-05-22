package org.vitalvale.Server.Packets;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.net.InetSocketAddress;

public abstract class Packet {

    /**
     * Handles the Packet when its received and processed.
     * @param ctx Context of network handler.
     * @param sender Packet sender network address.
     * @param packetId Id number of the Packet.
     * @param payload the Payload of the Packet.
     * @param mapper JSON Mapper for Decryption of the Packet.
     */
    public abstract void Handle(ChannelHandlerContext ctx, InetSocketAddress sender, int packetId, String payload, ObjectMapper mapper);

}
