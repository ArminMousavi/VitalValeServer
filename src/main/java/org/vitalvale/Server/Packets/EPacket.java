package org.vitalvale.Server.Packets;

public enum EPacket {
    PlayInServerRoomList(0),
    PlayInEnterGame(1);

    public int PacketId;

    EPacket(int PacketId) {
        this.PacketId = PacketId;
    }
}
