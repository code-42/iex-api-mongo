package net.ed.api;

import java.util.Arrays;
import java.util.List;

// https://www.tutorialspoint.com/gson/gson_first_application.htm

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson; 
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

class JsonDecoder {

   public static void jsonDecoder(String symbol, String jsonArr) {
	
	  JSONParser parser = new JSONParser();
	  String s = jsonArr.toString();
	  
	try {
		Object obj = parser.parse(s);
		JSONArray array = (JSONArray) obj;
		System.out.println(array.get(array.size()-1));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}