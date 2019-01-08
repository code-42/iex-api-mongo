package net.ed.api;

//https://www.tutorialspoint.com/gson/gson_first_application.htm

import java.io.IOException;
import java.io.StringReader;

import com.google.gson.Gson; 
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

class JsonDecoder {

   public static void jsonDecoder(String symbol, String jsonStr) {
	   
//	GsonBuilder builder = new GsonBuilder(); 
//	builder.setPrettyPrinting(); 
//	Gson gson = builder.create();
//	Gson jsonG = new Gson();
//	
	JsonParser parser = new JsonParser();
	
	try {
        Object obj = parser.parse(jsonStr);
        JsonArray array = (JsonArray)obj;

        System.out.println("The last element of array");
        String jsonString = (array.get(array.size()-1)).toString();
        System.out.println(jsonString);
        System.out.println("\n");
		
        JsonReader jsonReader = new JsonReader(new StringReader(jsonString));
		
        // http://tutorials.jenkov.com/java-json/gson-jsonreader.html
		while(jsonReader.hasNext()) {
	        JsonToken nextToken = jsonReader.peek();
	        System.out.println(nextToken);
	        

	        if(JsonToken.BEGIN_OBJECT.equals(nextToken)){

	            jsonReader.beginObject();

	        } else if(JsonToken.NAME.equals(nextToken)){

	            String name  =  jsonReader.nextName();
	            System.out.println(name);

	        } else if(JsonToken.STRING.equals(nextToken)){

	            String value =  jsonReader.nextString();
	            System.out.println(value);
	            
	        } else if(JsonToken.NUMBER.equals(nextToken)){
	        	try {
	        		long value =  jsonReader.nextLong();
	        		System.out.println(value);
	        		
		        } catch (Exception e) {
//		        	    e.printStackTrace();
	        	}
	        	
	        } else if(JsonToken.NUMBER.equals(nextToken)){
	        	try {
	        		double value =  jsonReader.nextDouble();
	        		System.out.println(value);
	        		
		        } catch (Exception e) {
//		        	    e.printStackTrace();
	        	}
        	}
	        
			}
		
			if(!jsonReader.hasNext()) {
				jsonReader.endObject();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("inside catch");
			e.printStackTrace();

	   } catch (Exception e) {
		    e.printStackTrace();
		}
	
   }
}