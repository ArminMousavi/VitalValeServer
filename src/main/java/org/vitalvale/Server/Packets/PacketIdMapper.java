package org.vitalvale.Server.Packets;

import java.util.HashMap;
import java.util.Map;

public class PacketIdMapper {
    private static final Map<Integer, EPacket> map = new HashMap<>();

    public static void init() {
        for (EPacket ePacket : EPacket.values()) {
            map.put(ePacket.PacketId, ePacket);
            System.out.println("Initialized Packet " + ePacket.name() + " with id " + ePacket.PacketId);
        }
    }

    public static EPacket getEnumByPacketId(int packetId) {
        return map.get(packetId);
    }
}