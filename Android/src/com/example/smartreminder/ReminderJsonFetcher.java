package com.example.smartreminder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;

public class ReminderJsonFetcher
{
	private static final String url = "http://192.168.1.7:50625/api/remindermobile/get";
	
	public JSONArray getJson()
	{
		JSONArray array = null;
		
		try
		{
			HttpEntity entity = getEntity();
			array = getJsonArray(entity);
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return array;
	}
	
	private HttpEntity getEntity() throws ClientProtocolException, IOException
	{
		HttpClient httpclient = new DefaultHttpClient();

	    HttpGet httpget = new HttpGet(url);
	    httpget.setHeader("Content-type", "application/json");

		HttpResponse response = httpclient.execute(httpget);           
		HttpEntity entity = response.getEntity();
		
		return entity;
	}
	
	private JSONArray getJsonArray(HttpEntity entity) throws IllegalStateException, IOException, JSONException
	{
		InputStream inputStream = entity.getContent();

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
		StringBuilder sb = new StringBuilder();

		String line = null;
		while ((line = reader.readLine()) != null)
		{
		    sb.append(line + "\n");
		}
		
		String result = sb.toString();
		
		return new JSONArray(result);
	}
}
