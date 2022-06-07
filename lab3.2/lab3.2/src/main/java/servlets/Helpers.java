package servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import valuta.Valuta;
import jakarta.servlet.http.HttpServletRequest;

public class Helpers {
	
	public static JsonElement bodyParse(HttpServletRequest request) {
		JsonElement jsonElement=null;	
		
		try {
			jsonElement = JsonParser.parseReader(request.getReader());
		} catch (JsonIOException | JsonSyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonElement;
	}
	
	public static Valuta valutaParse(HttpServletRequest request) {
		Valuta valuta = new Valuta();
		JsonElement jsonElement = bodyParse(request);
		valuta.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
		valuta.setValuta(jsonElement.getAsJsonObject().get("valuta").getAsString());
		valuta.setCount(jsonElement.getAsJsonObject().get("count").getAsDouble());
		valuta.setCountry(jsonElement.getAsJsonObject().get("country").getAsString());
		return valuta;
	}
	
	public static int getNextId(List<Valuta> list) {
		int maxId = 0;
		
		Iterator<Valuta> iterator = list.iterator();
		while(iterator.hasNext()) {
			int currentId = iterator.next().getId();
			if(currentId>maxId) maxId=currentId;
		}
		return maxId+1;
	}
	
	public static int getIndexByValutaId(int id,List<Valuta> list) {
		int listId = id;
		
		Iterator<Valuta> iterator = list.iterator();
		while(iterator.hasNext()) {
			Valuta temp =iterator.next();
			if(temp.getId()==listId) { 
				listId=list.indexOf(temp);
				break;
			}
		}
		return listId;
	}
	
	

}