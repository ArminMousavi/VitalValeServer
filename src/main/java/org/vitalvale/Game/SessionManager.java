package org.vitalvale.Game;

import org.vitalvale.Structures.Packets;

import java.util.ArrayList;

public class SessionManager {

    private ArrayList<Packets.GameSession> sessions;

    public SessionManager() {
        sessions = new ArrayList<>();
    }

    public Packets.GameSession createSession(int sessionId, int maxPlayers) {
        Packets.GameSession session = Packets.GameSession.newBuilder()
                .setSessionId(sessionId)
                .setMaxPlayers(maxPlayers)
                .setGameMap("dust2")
                .setCurrentPlayers(0)
                .build();

//        GameSession session = new GameSession(this, sessionId, maxPlayers, "داست");
        sessions.add(session);

        return session;
    }

    public void endSession(Packets.GameSession session) {
        sessions.remove(session);
    }



    public Packets.GameSession[] getAllSessions() {
        Packets.GameSession[] gameSessions = new Packets.GameSession[this.sessions.size()];
        for (int i = 0; i < this.sessions.size(); i++) {
            gameSessions[i] = this.sessions.get(i);
        }

        return gameSessions;
    }

    public Packets.GameSession getSessionById(int sessionId) {
        return this.sessions.stream().filter(e -> e.getSessionId() == sessionId).findFirst().get();
    }

    public Packets.GameSession getFreeSession() {
        for (Packets.GameSession session : this.sessions) {
            if(!session.getIsStarted() && session.getPlayersList().size() < session.getMaxPlayers()) {
                return session;
            }
        }

        return null;
    }

    public ArrayList<Packets.GameSession> getSessions() {
        return sessions;
    }



}