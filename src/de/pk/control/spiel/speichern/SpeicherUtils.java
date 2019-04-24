package de.pk.control.spiel.speichern;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.pk.control.spiel.SpielController;
import de.pk.control.spiel.einstellungen.Einstellungen;
import de.pk.utils.Spielkonstanten;

public class SpeicherUtils
{
	private static PrintWriter erstelleWriterInDatei(File datei)
	{
		PrintWriter schreiber = null;
		try
		{
			schreiber = new PrintWriter(datei);
		} catch (FileNotFoundException e)
		{
			return null;
		}
		return schreiber;
	}

	private static File erstelleDatei(String pfad)
	{
		File f = new File(pfad);
		if (!f.exists())
		{
			try
			{
				f.createNewFile();
			} catch (IOException e)
			{
				return null;
			}
		}
		return f;
	}

	public static void speichereSpiel(SpielController zuSpeichern, String name)
	{
		PrintWriter schreiber = erstelleWriterInDatei(erstelleDatei(name));
		Gson gson = new Gson();
		String gsonRes = gson.toJson(zuSpeichern);
		schreiber.println(gsonRes);
		schreiber.close();
	}

	public static SpielController ladeSpiel(String pfad)
	{
		try
		{
			FileReader leser = new FileReader(new File(pfad));
			return new GsonBuilder().create().fromJson(leser, SpielController.class);
		} catch (FileNotFoundException e)
		{
			return null;
		}
	}

	public static void speichere(Object objekt, String name)
	{
		PrintWriter writer = erstelleWriterInDatei(erstelleDatei(name));
		new GsonBuilder().create().toJson(objekt, SpielController.class,  writer);
		writer.close();
	}

	public static void speichereEinstellungen(Einstellungen zuSpeichern, String name)
	{
		PrintWriter schreiber = erstelleWriterInDatei(erstelleDatei(name));
		String gsonRes = new Gson().toJson(zuSpeichern);
		schreiber.println(gsonRes);
		schreiber.close();
	}
	
	//TODO: Einstellungen laden
}
