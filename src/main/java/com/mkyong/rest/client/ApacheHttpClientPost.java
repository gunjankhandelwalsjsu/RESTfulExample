package com.mkyong.rest.client;

import java.io.BufferedReader;
import org.apache.http.message.BasicNameValuePair;


import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import java.sql.*;

import com.mkyong.database.ClentData;
import com.mkyong.database.ResourceForClient;
import com.mongodb.BasicDBList;
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
        System.out.println("post");

		MongoClientURI uri = new MongoClientURI(textUri);
		MongoClient mongoClient = new MongoClient( uri );
				
                Product product=new Product();
    			DB db = mongoClient.getDB( "client_db" );

			      //STEP 2: Register JDBC driver
                DBCollection table = db.getCollection("device");
                
            	BasicDBObject searchQuery = new BasicDBObject();
            	searchQuery.put("object_id", "3333");
             
            	DBCursor cursor = table.find(searchQuery);
    			List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
    			DefaultHttpClient httpClient = new DefaultHttpClient();

			    
                  
                   String uri1 = null;
			      StringEntity input=null;
				    while (cursor.hasNext()){
						   DBObject rs = cursor.next();
						   ArrayList<ResourceForClient> resourceList = new ArrayList<ResourceForClient>(); 

						   BasicDBList list = (BasicDBList)rs.get("resource_id");

				            for( Iterator< Object > it = list.iterator(); it.hasNext(); )
				                {
				                   BasicDBObject dbo = (BasicDBObject)it.next();
				                   ResourceForClient resource = new ResourceForClient();
				                   resource.makePojoFromBson( dbo );
				                   resourceList.add(resource);
				                  
				                }
						  
		    	 input = new StringEntity("{\"object_id\":"+"\""+rs.get("object_id").toString()+"\",\"resource_id\":"+"\""+resourceList+"\",\"lifetime\":"+"\""+rs.get("lifetime").toString()+"\"}");
			     uri1=rs.get("uri").toString();
				    


			input.setContentType("application/json");
			urlParameters.add(new BasicNameValuePair("object_id", rs.get("object_id").toString()));
			urlParameters.add(new BasicNameValuePair("lifetime", rs.get("lifetime").toString()));
			urlParameters.add(new BasicNameValuePair("resource_id", "resourceList"));
			
				    }
			

			HttpPost postRequest = new HttpPost(uri1);
	/*		post.setHeader("Content-Type", "application/x-www-form-urlencoded");

			post.setEntity(new UrlEncodedFormEntity(urlParameters));
			 
			HttpResponse response = httpClient.execute(post);*/


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

		
