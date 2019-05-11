package de.pk.control.spiel.speichern;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

import de.pk.model.position.Position;
import de.pk.model.spielbrett.Kachel;

public class HashMapSerializer implements JsonSerializer<HashMap<Position, Kachel>>
{
	private Gson gson = null;

	@Override
	public JsonElement serialize(HashMap<Position, Kachel> arg0, Type arg1, JsonSerializationContext arg2)
	{
		if (this.gson == null)
		{
			this.gson = new GsonBuilder().create();
		}
		return this.gson.toJsonTree(arg0, new TypeToken<Map<Position, Kachel>>()
		{
		}.getType());
	}

}
