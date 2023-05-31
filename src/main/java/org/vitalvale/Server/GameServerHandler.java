package org.vitalvale.Server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.flatbuffers.FlexBuffers;
import com.google.flatbuffers.FlexBuffersBuilder;
import com.google.flatbuffers.ReadBuf;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;

import org.vitalvale.Server.Network.NetworkPlayer;
import org.vitalvale.Server.Packets.Outbound.impl.PlayOutServerRoomList;
import org.vitalvale.Server.Packets.PacketIdMapper;
import org.vitalvale.VitalVale;
import org.xerial.snappy.Snappy;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class GameServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    /**
     * Read and process the received Packet from the Client.
     *
     * @param ctx    the {@link ChannelHandlerContext} which this {@link SimpleChannelInboundHandler}
     *               belongs to
     * @param packet the message to handle
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) throws IOException {
        ByteBuf buffer = packet.content();

        int packetId = -1;

        FlexBuffers.Reference ref = FlexBuffers.getRoot(buffer.nioBuffer());

        FlexBuffers.Vector payload = ref.asVector();


        packetId = payload.get(0).asInt();

        VitalVale.getVitalog().Log("PACKET DATA: Received Packet with Numerical id of " + packetId);


//        try {
//            PlayInRoomList.PlayInRoomListPacket packets = PlayInRoomList.PlayInRoomListPacket.parseFrom(receivedBytes);
//            int packetId = packets.getPacketID();
//            int playerId = packets.getPlayerID();
//            VitalVale.getVitalog().Log("Received Packet With PacketID of " + packetId + " and PlayerID of " + playerId);
//        } catch (InvalidProtocolBufferException e) {
//            e.printStackTrace();
//        }
//        ByteBuf byteBuf = packet.content();
//
//        byte[] receivedBytes = new byte[byteBuf.readableBytes()];
//        byteBuf.readBytes(receivedBytes);
//
//        ByteBuffer buffer = ByteBuffer.wrap(receivedBytes);
//        buffer.order(ByteOrder.LITTLE_ENDIAN);

//        CharSequence data = buf.readCharSequence(100, Charset.defaultCharset());
//        String payload = data.toString().replace("\\u0000", "").replace("\u0000", "").replace(" ", "");
//
//        ObjectMapper mapper = new ObjectMapper();
//        int packetId = mapper.readTree(payload).get("PacketID").asInt();
//

//        int packetId = buffer.getInt();
//        int playerId = buffer.getInt();
//        int stringLength = buffer.getInt();
//
//        byte[] stringBytes = new byte[stringLength];
//        buffer.get(stringBytes);
//
//        String data = new String(stringBytes, StandardCharsets.UTF_8);
//
//        System.out.println("1: " + packetId);
//        System.out.println("2: " + playerId);
//        System.out.println("3: " + data);
        if (packetId == -1) return;
        HandlePacket(ctx, packet.sender(), packetId, payload);
    }

    /**
     * Handles the received Network Packet from a Client.
     *
     * @param ctx      Context of the Packet Including Packet Information.
     * @param sender   Packet Sender Internet IP Address.
     * @param packetId The id of the Received Packet.
     * @param payload  The Payload (Data) Of the Packet.
     * @throws JsonProcessingException If there's an Error in processing and Deserializing the Packet.
     */
    public void HandlePacket(ChannelHandlerContext ctx, InetSocketAddress sender, int packetId, FlexBuffers.Vector payload) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        if (!VitalVale.getNetworkPlayers().containsKey(sender.getHostString())) {
            VitalVale.getNetworkPlayers().put(sender.getHostString(), new NetworkPlayer(ctx.channel()));
            VitalVale.getVitalog().Log("New Channel " + sender.getHostString() + " Activated [New Client], Total Clients: " + VitalVale.getNetworkPlayers().size());
        } else {
            VitalVale.getVitalog().Log("Players Contains " + sender.getHostString());
        }


        switch (PacketIdMapper.getEnumByPacketId(packetId)) {
            case PlayInServerRoomList -> {


                FlexBuffersBuilder builder = new FlexBuffersBuilder();
                int smap = builder.startMap();

                Arrays.stream(VitalVale.getSessionManager().getAllSessions()).filter(gameSession -> !gameSession.isStarted()).findAny().stream().forEach(gameSession -> {
                    int svec = builder.startMap();
                    builder.putInt("session_id", gameSession.getSessionId());
                    builder.putInt("player_num", gameSession.getCurrentPlayers());
                    builder.putInt("m_players", gameSession.getMaxPlayers());
                    builder.putBoolean("is_started", gameSession.isStarted());
                    builder.putString("game_map", gameSession.getGameMap());
                    builder.endMap(String.valueOf(gameSession.getSessionId()), svec);
                });

                int sv = builder.startMap();
                builder.putInt("session_id", 69);
                builder.putInt("player_num", 12);
                builder.putInt("m_players", 16);
                builder.putBoolean("is_started", false);
                builder.putString("game_map", "dust");
                builder.endMap("69", sv);



                builder.endMap(null, smap);

                ByteBuffer bb = builder.finish();

                ctx.writeAndFlush(bb.array());
                VitalVale.getVitalog().Log("Sent Packet with size of: " + bb.array().length);
//                try {
//                    Packets.PlayInRoomList pRoomList = Packets.PlayInRoomList.parseFrom(payload);
//
//                    VitalVale.getNetworkPlayers().get(sender.getHostString()).setPlayerID(pRoomList.getPlayerID());
//
//                    Packets.PlayOutRoomList.Builder packetBuilder  = Packets.PlayOutRoomList.newBuilder();
//                    packetBuilder.setPacketID(0);
//                    packetBuilder.addAllSessions(VitalVale.getSessionManager().getSessions());
//                    Packets.PlayOutRoomList packet = packetBuilder.build();
//
//                    byte[] packetBytes = packet.toByteArray();
//                    System.out.println("Packet Length: " + packetBytes.length);
//
//                    ctx.writeAndFlush(packetBytes);
//                } catch (InvalidProtocolBufferException e) {
//                    throw new RuntimeException(e);
//                }


                break;
            }

            default -> {
                System.out.println("Invalid Packet Id " + packetId + ", not mapped.");
                break;
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
