
package de.pk.view.visuell.fxmlSzenenLayouts;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import de.pk.control.app.Main;
import de.pk.control.spiel.einstellungen.Einstellungen;
import de.pk.utils.Spielkonstanten;
import de.pk.utils.lokalisierung.DE_de;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * @author Dylan
 */
public class AnwendungFX extends Application
{

	private static final HashMap<String, Scene> SZENEN_MAP = new HashMap<>();
	private static final String FXML_DATEI_ENDUNG = ".fxml";
	private static final String CSS_DATEI_ENDE = "Aufloesung.css";
	private static final String DATEI_TRENNER = "_";

	private static Stage anwendungsStage = null;

	private static void aktualisiereAufloesungsStyleSheets()
	{
		AnwendungFX.entferneStyleSheetsVonAllenScenes();
		String eingestellteAufloesung = Einstellungen.getEinstellungen().getAnwendungsAufloesung().toString();
		AnwendungFX.fuegeStyleSheetAllenSzenenHinzu(
				eingestellteAufloesung + AnwendungFX.DATEI_TRENNER + AnwendungFX.CSS_DATEI_ENDE);
	}

	public static void aktualisiereFensterAufloesung()
	{
		AnwendungFX.aktualisiereAufloesungsStyleSheets();
		AnwendungFX.anwendungsStage.sizeToScene();
		AnwendungFX.anwendungsStage.centerOnScreen();
	}

	private static void entferneStyleSheetsVonAllenScenes()
	{
		for (Scene szene : AnwendungFX.SZENEN_MAP.values())
		{
			szene.getStylesheets().clear();
		}
	}

	private static void fuegeStyleSheetAllenSzenenHinzu(String pfadZurCSSDatei)
	{
		for (Scene szene : AnwendungFX.SZENEN_MAP.values())
		{
			szene.getStylesheets().add(AnwendungFX.class.getResource(pfadZurCSSDatei).toExternalForm());
		}
	}

	private static void fuegeSzeneHinzu(String pfadZurFXMLDatei)
	{
		try
		{
			AnwendungFX.SZENEN_MAP.put(pfadZurFXMLDatei.replaceFirst(AnwendungFX.FXML_DATEI_ENDUNG, new String()),
					new Scene(FXMLLoader.load(AnwendungFX.class.getResource(pfadZurFXMLDatei))));
		} catch (IOException e)
		{
			e.printStackTrace(); // TODO: entfernen
			Main.anwendungBeenden();
		}
	}

	private static void initSzenen()
	{
		AnwendungFX.fuegeSzeneHinzu(Spielkonstanten.ANWENDUNG_TITEL_SZENE_PFAD_FXML);
		AnwendungFX.fuegeSzeneHinzu(Spielkonstanten.ANWENDUNG_HAUPTMENUE_SZENE_PFAD_FXML);
		AnwendungFX.fuegeSzeneHinzu(Spielkonstanten.ANWENDUNG_CREDIT_SZENE_PFAD_FXML);
		AnwendungFX.fuegeSzeneHinzu(Spielkonstanten.ANWENDUNG_OPTIONEN_SZENE_PPFAD_FXML);
		AnwendungFX.fuegeSzeneHinzu(Spielkonstanten.ANWENDUNG_DUNGEON_SZENE_PFAD_FXML);
		AnwendungFX.fuegeSzeneHinzu(Spielkonstanten.ANWENDUNG_SCHWIERIGKEIT_WAEHLEN_SZENE_PFAD_FXML);
		AnwendungFX.fuegeSzeneHinzu(Spielkonstanten.ANWENDUNG_WELTKARTE_SZENE_PFAD_FXML);
	}

	public static void starteAnwendung(String[] args)
	{
		Application.launch(args);
	}

	public static void wechselSzene(String szenenName)
	{
		AnwendungFX.anwendungsStage.setScene(AnwendungFX.SZENEN_MAP.get(szenenName));
	}

	@Override
	public void start(Stage stage) throws Exception
	{
		AnwendungFX.initSzenen();
		AnwendungFX.aktualisiereAufloesungsStyleSheets();
		AnwendungFX.anwendungsStage = stage;
		AnwendungFX.anwendungsStage.getIcons()
				.add(new Image(new File(Spielkonstanten.ANWENDUNG_ANWENDUNGS_ICON).toURI().toURL().toExternalForm()));
		AnwendungFX.anwendungsStage.setTitle(DE_de.ANWENDUNG_FENSTER_TITEL);
		AnwendungFX.anwendungsStage.setResizable(true);
		AnwendungFX.anwendungsStage.centerOnScreen();
		AnwendungFX.anwendungsStage.setOnCloseRequest(windowEvent -> Main.anwendungBeenden());
		AnwendungFX.anwendungsStage.setScene(AnwendungFX.SZENEN_MAP.get(Spielkonstanten.ANWENDUNG_TITEL_SZENE));
		AnwendungFX.anwendungsStage.show();
	}

}