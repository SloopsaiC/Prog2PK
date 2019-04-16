package de.pk.control.spiel.speichern;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;

import de.pk.control.spiel.SpielController;
import de.pk.utils.Spielkonstanten;

public class SpeicherUtils
{
	public static void speichereSpiel(SpielController zuSpeichern, String name)
	{
		File f = new File(name + Spielkonstanten.SPEICHER_DATEI_ENDUNG);
		PrintWriter schreiben = null;
		try
		{
			f.createNewFile();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		try
		{
			schreiben = new PrintWriter(f);
		} catch (FileNotFoundException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Gson gson = new Gson();
		String gsonRes = gson.toJson(zuSpeichern);
		schreiben.println(gsonRes);
		schreiben.close();

	}
}
