package com.mkyong.rest.client;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import java.sql.*;

import com.mkyong.database.ClentData;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mykong.pojo.Product;

public class ApacheHttpClientPost {


	public static void main(String[] args) throws Exception {

			 
		String textUri = "mongodb://gunjan:khandelwal@ds047592.mongolab.com:47592/client_db";
		MongoClientURI uri = new MongoClientURI(textUri);
		MongoClient mongoClient = new MongoClient( uri );
				
                Product product=new Product();
    			DB db = mongoClient.getDB( "client_db" );

			      //STEP 2: Register JDBC driver
                DBCollection table = db.getCollection("device");
                
            	BasicDBObject searchQuery = new BasicDBObject();
            	searchQuery.put("object_id", "3333");
             
            	DBCursor cursor = table.find(searchQuery);
             
			    
                  
                   String uri1 = null;
			      StringEntity input=null;
				    while (cursor.hasNext()){
						   DBObject rs = cursor.next();
		    	 input = new StringEntity("{\"object_id\":"+"\""+rs.get("object_id").toString()+"\",\"resource_id\":"+"\""+rs.get("resource_id").toString()+rs.get("lifetime").toString()+"\"}");
			     uri1=rs.get("uri").toString();
				    }


			input.setContentType("application/json");
			DefaultHttpClient httpClient = new DefaultHttpClient();



			HttpPost postRequest = new HttpPost(uri1);



			postRequest.setEntity(input);

			HttpResponse response = httpClient.execute(postRequest);

			if (response.getStatusLine().getStatusCode() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(response.getEntity().getContent())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				System.out.println(output);
			}

			httpClient.getConnectionManager().shutdown();
	}
}

		
