package de.pk.control.spiel.speichern;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import de.pk.model.karte.generator.untergruende.KartenGeneratorUntergrund;
import de.pk.model.karte.generator.untergruende.KartenGeneratorUntergrundIndex;
import de.pk.model.spielbrett.Kachel;

public class KartenGeneratorUntergrundSerializer implements JsonSerializer<KartenGeneratorUntergrund>
{

	/**
	 * Erzeugt eine Darstellung fuer die Serialisierung mit Json. Objekte mit dem
	 * gleichen Inhalt generieren auch den gleichen String zur Reprasentation um
	 * doppeltes speichern zu vermeiden
	 * 
	 * @return Ein String welcher den KartenGeneratorUntergrund in der
	 *         Serialisierung beschreibt
	 */
	public String toJsonRepraesentationString(KartenGeneratorUntergrund object)
	{
		return KartenGeneratorUntergrundIndex.valueOf(object.getClass().getSimpleName()).toString() + ": "
				+ object.getAnzahlDrehungenRechts();
	}

	@Override
	public JsonElement serialize(KartenGeneratorUntergrund arg0, Type arg1, JsonSerializationContext arg2)
	{
		return new JsonPrimitive(this.toJsonRepraesentationString(arg0));
	}

}
