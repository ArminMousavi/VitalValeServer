package org.vitalvale.Server.Database;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.vitalvale.Settings.Constant;
import redis.clients.jedis.Jedis;

public class DatabaseManager {
    private static MongoClient mongoClient;
    private static MongoDatabase mongoDatabase;
    private static Jedis jedis;

    /*
     * Setting up MongoDB database configurations for Game Server.
     */
    public static void SetupMongoDB()
    {
        ConnectionString connectionString = new ConnectionString(
                Constant.ConnectionString
        );
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .retryWrites(true)
                .build();
        mongoClient = MongoClients.create(settings);
        mongoDatabase = mongoClient.getDatabase(Constant.DatabaseName);

    }

    /*
     * Setting up KeyDB(Redis) database configurations for Game Server.
     */
    public static void SetupRedis() {
        jedis = new Jedis(Constant.RedisServerAddress, Constant.RedisServerPort);
    }

    public static MongoClient getMongoClient() {
        return mongoClient;
    }

    public static MongoDatabase getMongoDatabase() {
        return mongoDatabase;
    }

    public static Jedis getJedis() {
        return jedis;
    }
}
