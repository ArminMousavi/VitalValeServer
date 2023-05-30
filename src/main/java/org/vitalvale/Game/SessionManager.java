package org.vitalvale.Game;

import java.util.ArrayList;

public class SessionManager {

    private ArrayList<GameSession> sessions;

    public SessionManager() {
        sessions = new ArrayList<>();
    }

    public GameSession createSession(int sessionId, int maxPlayers) {

        GameSession session = new GameSession(this, sessionId, maxPlayers, "داست");
        sessions.add(session);

        return session;
    }

    public void endSession(GameSession session) {
        sessions.remove(session);
    }



    public GameSession[] getAllSessions() {
        GameSession[] gameSessions = new GameSession[this.sessions.size()];
        for (int i = 0; i < this.sessions.size(); i++) {
            gameSessions[i] = this.sessions.get(i);
        }

        return gameSessions;
    }

    public GameSession getSessionById(int sessionId) {
        return this.sessions.stream().filter(e -> e.getSessionId() == sessionId).findFirst().get();
    }

    public GameSession getFreeSession() {
        for (GameSession session : this.sessions) {
            if(!session.isStarted() && session.getPlayers().size() < session.getMaxPlayers()) {
                return session;
            }
        }

        return null;
    }

    public ArrayList<GameSession> getSessions() {
        return sessions;
    }



}