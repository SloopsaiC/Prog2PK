package de.pk.control.spiel.speichern;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.pk.control.spiel.Spiel;
import de.pk.control.spiel.einstellungen.Einstellungen;

public class SpeicherUtils
{
	/**
	 * Erstellt eine neue Datei an dem gegebenen Pfad, sollte noch keine existieren
	 * 
	 * @param pfad Der Pfad an welchem die Datei erstellt werden soll
	 * 
	 * @return File, die Datei die eine Referenz auf die Datei im lokalen System ist
	 */
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

	/**
	 * Erstellt einen "PrintWriter" fuer die gegebene Datei
	 * 
	 * @param datei Die Datei in welche geschrieben werden soll
	 * 
	 * @return PrintWriter, ein Writer der in die gegebene Datei schreibt
	 */
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

	/**
	 * Laedt ein Spiel aus dem gegebenen Pfad
	 * 
	 * @param pfad Der Pfad aus welchem geladen werden soll
	 * 
	 * @return SpielController, Das geladene Spiel
	 * */
	public static Spiel ladeSpiel(String pfad)
	{
		try
		{
			FileReader leser = new FileReader(new File(pfad));
			return new GsonBuilder().create().fromJson(leser, Spiel.class);
		} catch (FileNotFoundException e)
		{
			return null;
		}
	}

	/**
	 * Speichert ein Spiel, oder die Einstellungen
	 * 
	 * @param objekt Das Objekt welches gespeichert werden soll
	 * @param name Der Name unter welchem gespeichert werden soll
	 * */
	public static void speichere(Object objekt, String name)
	{
		PrintWriter writer = SpeicherUtils.erstelleWriterInDatei(SpeicherUtils.erstelleDatei(name));
		new GsonBuilder().create().toJson(objekt, Spiel.class, writer);
		writer.close();
	}

	// TODO: Einstellungen laden
}
