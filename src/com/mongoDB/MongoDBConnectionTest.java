package com.mongoDB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnectionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		
        // Now connect to your databases
//        DB db = mongoClient.getD( "m101" );
//        System.out.println("Connect to database successfully");
//        //boolean auth = db.authenticate("", "");
//        //System.out.println("Authentication: "+auth);
//        //db.createCollection("jdbcTest",null);
//        //System.out.println("collection created.");
//        Set<String> col=db.getCollectionNames();
//        for(String str:col){
//        	System.out.println(str);
//        }
//        DBCollection dbColl=db.getCollectionFromString("movieDetails");
//        dbColl.
		MongoClient client = new MongoClient();

        MongoDatabase database = client.getDatabase("m101");
        final MongoCollection<Document> collection = database.getCollection("funnynumbers");
        List<Document> results =
                collection.aggregate(Arrays.asList(
                		new Document("$group", new Document("_id", "$value").append("count", new Document("$sum", 1))),
                        new Document("$match", new Document("count", new Document("$lte", 2))),
                        new Document("$sort", new Document("_id", 1)))).into(new ArrayList<Document>());

                int answer = 0;
                for (Document cur : results) {
                    answer += (Double) cur.get("_id");
                }

                Map<String, String> answerMap = new HashMap<String, String>();
                answerMap.put("answer", Integer.toString(answer));
                System.out.println("answer:"+answer);
                System.out.println("answerMap:"+answerMap);
	}

}
