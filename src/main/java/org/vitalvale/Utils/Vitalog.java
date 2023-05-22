package org.vitalvale.Utils;

public class Vitalog {

    private boolean m_DebugEnabled = false;


    /**
     * Vital Vale Logging Technique.
     * @param debugEnabled Is Debug mode Enabled or Not.
     */
    public Vitalog(boolean debugEnabled) {
        m_DebugEnabled = debugEnabled;

        System.out.println("[+] Starting Vitalog Logger. [+]");
    }

    /**
     * Prints and Saves a Log for the Game.
     * @param message The Printable Message.
     */
    public void Log(String message) {
        System.out.println("[!] " + message + " [!]");
    }

    /**
     * Prints and Saves a Log for the Game.
     * @param message The Printable Message.
     * @param sign The Sign Structure for the Message.
     */
    public void Log(String message, String sign) {
        System.out.println("[" + sign + "] " + message + " [" + sign + "]");
    }


}
