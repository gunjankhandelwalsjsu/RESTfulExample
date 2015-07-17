package com.mkyong.rest.client;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.mykong.pojo.Product;

public class ApacheHttpClientPut {
	

	public static void main(String[] args) throws Exception {

			
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPut putRequest = new HttpPut("http://localhost:8080/RESTfulExample/device/3333/ten");
			HttpResponse response = httpClient.execute(putRequest);
			
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

