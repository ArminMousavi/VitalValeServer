package org.vitalvale;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import io.netty.channel.Channel;
import org.vitalvale.Game.SessionManager;
import org.vitalvale.Server.CredentialsManager;
import org.vitalvale.Server.Database.DatabaseManager;
import org.vitalvale.Server.GameServer;
import org.vitalvale.Server.Network.NetworkPlayer;
import org.vitalvale.Server.Packets.PacketIdMapper;
import org.vitalvale.Settings.Constant;
import org.vitalvale.Utils.Vitalog;
import redis.clients.jedis.Jedis;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.net.InetSocketAddress;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class VitalVale {


    private static Map<String, NetworkPlayer> m_NetworkPlayers = new HashMap<>();

    private static Vitalog vitalog;
    private static SessionManager sessionManager;


    static final double VERSION = 1.0;

    public static void main(String[] args) {

        vitalog = new Vitalog(Constant.Debug_Enabled);

        getVitalog().Log("Starting Vital Vale Server Version " + VERSION, "+");

        PacketIdMapper.init();

        sessionManager = new SessionManager();

        DatabaseManager.SetupMongoDB();
        DatabaseManager.SetupRedis();

        /*
         * Testing MongoDB Database Connection.
         */
        if (DatabaseManager.getMongoDatabase() != null) {
            DatabaseManager.getMongoDatabase().getCollection("users").countDocuments();
        } else {
            getVitalog().Log("MongoDB Database Client isn't Connected to the Cortex Server", "-");
            return;
        }
         /*
          Testing MongoDB Database Connection.
          */
        if (DatabaseManager.getJedis() == null) {
            getVitalog().Log("Redis Database Client isn't Connected to the Cortex Server", "-");
            return;
        }

        CredentialsManager credentialsManager = new CredentialsManager();

        try {
            new GameServer();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        getVitalog().Log("Closing Jedis pool.", "-");

        getVitalog().Log("Closing MongoDB pool.", "-");
    }

    public static Vitalog getVitalog() {
        return vitalog;
    }

    public static SessionManager getSessionManager() {
        return sessionManager;
    }


    public static double getVersion() {
        return VERSION;
    }

    public static Map<String, NetworkPlayer> getNetworkPlayers() {
        return m_NetworkPlayers;
    }
}