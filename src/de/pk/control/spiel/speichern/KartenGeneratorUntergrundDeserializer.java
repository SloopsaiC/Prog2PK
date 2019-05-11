package de.pk.control.spiel.speichern;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import de.pk.model.karte.generator.Richtung;
import de.pk.model.karte.generator.untergruende.KartenGeneratorUntergrund;
import de.pk.model.karte.generator.untergruende.KartenGeneratorUntergrundIndex;

public class KartenGeneratorUntergrundDeserializer implements JsonDeserializer<KartenGeneratorUntergrund>
{

	private void dreheUntergrundXMalNachOsten(int x, KartenGeneratorUntergrund untergrund)
	{
		for (int i = 0; i < x; i++)
		{
			untergrund.drehe(Richtung.OSTEN);
		}
	}

	@Override
	public KartenGeneratorUntergrund deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext arg2)
			throws JsonParseException
	{
		String untergrund = arg0.getAsJsonPrimitive().getAsString();
		String[] split = untergrund.split(": ");
		KartenGeneratorUntergrund deserialisiert = KartenGeneratorUntergrundIndex.values()[Integer
				.parseInt(split[0].trim())].getObjektKopie();
		dreheUntergrundXMalNachOsten(Integer.parseInt(split[1].trim()), deserialisiert);
		return deserialisiert;
	}

}
