package com.mkyong.rest.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.DefaultHttpClient;

public class ApacheHttpClientDelete {
	public static void main(String[] args) throws Exception {

	DefaultHttpClient httpClient = new DefaultHttpClient();
				HttpDelete deleteRequest = new HttpDelete("http://localhost:8080/RESTfulExample/device/delete/3333");
				HttpResponse response = httpClient.execute(deleteRequest);
				
				if (response.getStatusLine().getStatusCode() != 200) {
	
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
