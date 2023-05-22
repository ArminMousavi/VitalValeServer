package org.vitalvale.Server;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.vitalvale.Server.Database.DatabaseManager;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;

public class CredentialsManager {
    public String UserSignUp(String Username, String Email,String Password, int Age) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        if(Age < 9) return "سن شما از حداقل سن مورد نیاز ( 9 سال ) کمتر میباشد.";

        if(Username.contains(" ")) return "نام کاربری نباید دارای اسپیس باشد.";

        if(Username.length() < 8 || Username.length() < 5)
            return "نام کاربری یا رمز عبور کمتر از حد مورد نیاز میباشند.\n رمز عبور حداقل 8 کاراکتر و نام کاربری حداقل 5";




        MongoCollection<Document> collection = DatabaseManager.getMongoDatabase().getCollection("users");

        try{
            collection.insertOne(new Document().append("_id", new ObjectId())
                    .append("username", Username)
                    .append("password", Password)
                    .append("email", Email)
                    .append("age", Age));
            return "ثبت نام انجام شد.";

        }catch (MongoException exception)
        {
            return "خطایی در سرور رخ داده است.";
        }

    }
    public String UserSignIn(String Username, String Password) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        MongoCollection<Document> collection = DatabaseManager.getMongoDatabase().getCollection("users");
        Document query = new Document("username", Username).append("password", Password);
        Document result = collection.find(query).first();

        if(result != null)
        {
            return "شما وارد حساب کاربری خود شدید.";
        }else {
            return "اطلاعات وارد شده نامعتبر میباشد.";
        }
    }
}
