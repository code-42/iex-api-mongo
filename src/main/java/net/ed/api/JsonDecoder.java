package net.ed.api;

//https://www.tutorialspoint.com/gson/gson_first_application.htm
/**
 * this class parses the json array we get from iextrading.com api
 * and returns only the last element of the json array
 * with the stock symbol added to the json string
 */

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

class JsonDecoder {

   public static String jsonDecoder(String symbol, String jsonStr) {


	   // declare variables
	   JsonParser parser = new JsonParser();
	   String jsonString = "";
		
	   try {
			// first parse the input to array
			JsonArray array = (JsonArray) parser.parse(jsonStr);
			
			// peel off the last element of the array
			jsonString = (array.get(array.size()-1)).toString();
			
			// instantiate a json Object to put the string into
			JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
			
			// add the symbol to end of the jsonObject
			jsonObject.addProperty("symbol", symbol);
			
			// write it back into a string
			jsonString = jsonObject.toString();

	   } catch (Exception e) {
		   e.printStackTrace();
	   }

	   // return the thing we sent in after decoding it
	   return jsonString;

	   }
   
}