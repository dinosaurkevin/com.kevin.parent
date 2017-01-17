package com.kevin.toolweb;

import java.util.concurrent.TimeUnit;

import com.couchbase.client.java.*;
import com.couchbase.client.java.cluster.ClusterManager;
import com.couchbase.client.java.document.*;
import com.couchbase.client.java.document.json.*;
import com.couchbase.client.java.query.*;

public class TestCouchbase {

    public static void main(String... args) throws Exception { 
        // Initialize the Connection
        Cluster cluster = CouchbaseCluster.create("192.168.100.129:11211");
        
        Bucket bucket =   cluster.openBucket("default",1,TimeUnit.MINUTES );
        // Create a JSON Document
        JsonObject arthur = JsonObject.create()
            .put("name", "Arthur")
            .put("email", "kingarthur@couchbase.com")
            .put("interests", JsonArray.from("Holy Grail", "African Swallows"));

        // Store the Document
        bucket.upsert(JsonDocument.create("u:king_arthur", arthur), 1, TimeUnit.MINUTES);
        System.out.println(bucket.get("u:king_arthur"));
        JsonObject arthur1 = JsonObject.create()
                .put("name", "Arthur1")
                .put("email", "kingarthur@couchbase.com1")
                .put("interests", JsonArray.from("Holy Grail", "African Swallows1"));
        
        bucket.upsert(JsonDocument.create("u:king_arthur1", arthur1));
        // Load the Document and print it
        // Prints Content and Metadata of the stored Document
        System.out.println(bucket.get("u:king_arthur1"));

        // Create a N1QL Primary Index (but ignore if it exists)
        bucket.bucketManager().createN1qlPrimaryIndex(true, false);

        // Perform a N1QL Query
//        N1qlQueryResult result = bucket.query(
//            N1qlQuery.parameterized("SELECT name FROM default WHERE $1 IN interests",
//            JsonArray.from("African Swallows"))
//        );
//
//        // Print each found Row
//        for (N1qlQueryRow row : result) {
//            // Prints {"name":"Arthur"}
//            System.out.println(row);
//        }
    }
}