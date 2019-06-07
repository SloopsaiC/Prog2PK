
package de.pk.view.visuell;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.ResourceBundle;

import de.pk.control.app.Main;
import de.pk.control.spiel.einstellungen.Einstellungen;
import de.pk.utils.Spielkonstanten;
import de.pk.utils.lokalisierung.Lokalisierbar;
import de.pk.utils.lokalisierung.LokalisierungsKeys;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Die Klasse AnwendungFX ist die Hauptklasse der GUI und des views. Sie
 * verwaltet alle Szenen im Spiel, stellt Methoden zum Wechseln zwischen
 * unterschiedlichen Szenen sowie zur Anpassung einer eingestellten Aufloesung
 * bereit und definiert grundlegende Eigenschaften des Fensters und der Stage an
 * sich.
 *
 * @author Dylan
 */
public class AnwendungFX extends Application
{

	/**
	 * Die SZENEN_ROOT_MAP beinhaltet alle "Szenen" (als Panes, nicht als Scenes!
	 * Der Einfachhaltheiber aber nachfolgend dennoch "Szenen" genannt), die im
	 * Spiel gezeigt werden sollen und ordnet diese einem Namen als String zu, mit
	 * welchem diese dann aufgerufen werden koennen, um z.B. die aktuelle Szene zu
	 * wechseln.
	 */
	private static final HashMap<String, Pane> SZENEN_ROOT_MAP = new HashMap<>();

	/**
	 * Die Map beinhaltet alle SzenenControllern und ordnet Ihnen einen Namen zu.
	 */
	private static final HashMap<String, Lokalisierbar> SZENEN_CONTROLLER_LIST = new HashMap<>();

	/**
	 * Die anwendungsStage ist die Stage des Spiels, auf der sich die
	 * anwendungsSzene abspielt.
	 */
	private static Stage anwendungsStage = null;
	/**
	 * Die AnwendungsSzene beinhaltet das rootPane und legt dieses als seine einzige
	 * Szene auf die anwendungsStage.
	 */
	private static Scene anwendungsSzene = null;
	/**
	 * Das rootPane ist das Fundament fuer alle "Szenen". Sie werden aus
	 * fxml-Dateien geladen und dem rootPane hinzugefuegt.
	 */
	private static Pane rootPane = null;

	/**
	 * Aktualisiert die Aufloesung des Fensters, indem die Werte fuer alle Groessen,
	 * Abstaende, etc. aus dem css-StyleSheet fuer die aktuell eingestellte
	 * Aufloesung geladen werden. Die Einstellung "Vollbild" wird ebenfalls
	 * beachtet.
	 */
	public static void aktualisiereFensterAufloesungUndStyleSheets()
	{
		AnwendungFX.entferneAlleStyleSheetsVonAnwendungsSzene(); // Alle css werden entfernt
		AnwendungFX.fuegeSzenenBedingteStyleSheetsHinzu(); // Alle "nur-Layot-css" werden wieder hinzugefuegt
		AnwendungFX.anwendungsStage.setFullScreen(Einstellungen.getEinstellungen().getVollbild());
		String eingestellteAufloesung = Einstellungen.getEinstellungen().getAnwendungsAufloesung().toString();
		if (Einstellungen.getEinstellungen().getVollbild()) // bei Vollbild
		{
			AnwendungFX.fuegeStyleSheetsAnwendungsSzeneHinzu(Spielkonstanten.CSS_DATEI_PFAD_AUFLOESUNG
					+ eingestellteAufloesung + Spielkonstanten.VOLLBILD_DATEI_ZUSATZ + Spielkonstanten.CSS_DATEI_ENDE);
		} else
		{
			AnwendungFX.fuegeStyleSheetsAnwendungsSzeneHinzu( // bei Fenster
					Spielkonstanten.CSS_DATEI_PFAD_AUFLOESUNG + eingestellteAufloesung
							+ Spielkonstanten.CSS_DATEI_ENDE);
			AnwendungFX.anwendungsStage.centerOnScreen();
		}
		AnwendungFX.anwendungsStage.sizeToScene();
	}

	/**
	 * Aktualisiert alle GUI Komponenten, die einen Text darstellen oder beinhalten,
	 * hinsichtlich der eingestellten Sprache. Hierzu wird eine entsprechende
	 * Methode in den Einstellungen aufgerufen.
	 */
	public static void aktualisiereSzenenSprache()
	{
		Einstellungen.getEinstellungen().setAnwendungsSprache(Einstellungen.getEinstellungen().getAnwendungsSprache());
	}

	/**
	 * Es wird durch die Controller aller Szenen iteriert um diesem jeweils zu
	 * signalisieren, dass alle Komponenten, die einen Text darstellen oder
	 * beinhalten, ihren Inhalt an die (neu) eingestellte Sprache anpassen sollen.
	 * Diese Methode wird implizit von den Einstellungen aufgerufen. Fuer das
	 * Aktualisieren der Sprache sollte "aktualisiereSzenenSprache()" aufgerufen
	 * werden.
	 *
	 * @param sprachRessource Aus dieser Ressource werden die neuen Strings geladen.
	 */
	public static void aktualisiereSzenenSprache(ResourceBundle sprachRessource)
	{
		AnwendungFX.anwendungsStage.setTitle(sprachRessource.getString(LokalisierungsKeys.ANWENDUNGS_TITEL_KEY));
		for (Lokalisierbar controller : AnwendungFX.SZENEN_CONTROLLER_LIST.values())
		{
			controller.aktualisiereTextKomponenten(sprachRessource);
		}
	}

	/**
	 * Entfernt alle im Code hinzugefuegten css-StyleSheets von der anwendungsSzene.
	 * Hat keine Auswirkungen auf SytleSheets, die in einer fxml-Datei eines
	 * customControls verlinkt wurden!
	 */
	private static void entferneAlleStyleSheetsVonAnwendungsSzene()
	{
		AnwendungFX.anwendungsSzene.getStylesheets().clear();
	}

	/**
	 * Fuegt alle im Parameter aufgelisteten StyleSheets der anwendungsSzene hinzu.
	 * Sobald der Szene ein neuer StyleSheet hinzugefuegt wurde, wird dieser
	 * automatisch und sofort angewendet.
	 *
	 * @param pfadeZuCSSDateien Anzuwendende StyleSheets
	 */
	private static void fuegeStyleSheetsAnwendungsSzeneHinzu(String... pfadeZuCSSDateien)
	{
		for (String cssPfad : pfadeZuCSSDateien)
		{
			AnwendungFX.anwendungsSzene.getStylesheets().add(AnwendungFX.class.getResource(cssPfad).toExternalForm());
		}
	}

	/**
	 * Fuegt die FXML-Datei mit dem Namen dateiNameDerFXML der SZENEN_ROOT_MAP als
	 * neue Szene hinzu. Als String-Name in der SZENEN_ROOT_MAP dient der
	 * dateiNameDerFXML. Der Pfad wird ueber diesen Dateinamen ermittelt, indem ihm
	 * die Endung ".fxml" angefuegt wird. Voraussetzung ist, dass alle
	 * fxmlSzenen-Dateien im selben package unter
	 * {@link Spielkonstanten}.FXML_DATEI_PFAD liegen.
	 *
	 * @param dateiNameDerFXML Der Name der fxml-Datei fuer die hinzuzufuegende
	 *                         Szene
	 */
	public static void fuegeSzeneHinzu(String dateiNameDerFXML)
	{
		try
		{
			FXMLLoader loader = new FXMLLoader(AnwendungFX.class.getResource(
					Spielkonstanten.FXML_DATEI_PFAD + dateiNameDerFXML + Spielkonstanten.FXML_DATEI_ENDUNG));
			AnwendungFX.SZENEN_ROOT_MAP.put(dateiNameDerFXML, loader.load());
			AnwendungFX.SZENEN_CONTROLLER_LIST.put(dateiNameDerFXML, loader.getController());
		} catch (IOException e)
		{
			e.printStackTrace();
			Main.anwendungBeenden();
		}
	}

	/**
	 * Liefert die Controller zu allen regestrierten Szenen.
	 *
	 * @return SzenenController
	 */
	public static HashMap<String, Lokalisierbar> getSzenenController()
	{
		return AnwendungFX.SZENEN_CONTROLLER_LIST;
	}

	/**
	 * Hier werden alle Szenen in der SZENEN_ROOT_MAP registriert und dieser
	 * hinzugefuegt.
	 */
	private static void initSzenen()
	{
		AnwendungFX.fuegeSzeneHinzu(Spielkonstanten.ANWENDUNG_TITEL_SZENE);
		AnwendungFX.fuegeSzeneHinzu(Spielkonstanten.ANWENDUNG_HAUPTMENUE_SZENE);
		AnwendungFX.fuegeSzeneHinzu(Spielkonstanten.ANWENDUNG_CREDIT_SZENE);
		AnwendungFX.fuegeSzeneHinzu(Spielkonstanten.ANWENDUNG_OPTIONEN_SZENE);
		AnwendungFX.fuegeSzeneHinzu(Spielkonstanten.ANWENDUNG_DUNGEON_SZENE);
		AnwendungFX.fuegeSzeneHinzu(Spielkonstanten.ANWENDUNG_SCHWIERIGKEIT_WAEHLEN_SZENE);
		AnwendungFX.fuegeSzeneHinzu(Spielkonstanten.ANWENDUNG_WELTKARTE_SZENE);
	}

	/**
	 * Es werden lediglich die Layout relevanten css-SytleSheets der AnwendungsSzene
	 * hinzugefuegt.
	 */
	private static void fuegeSzenenBedingteStyleSheetsHinzu()
	{
		fuegeStyleSheetsAnwendungsSzeneHinzu(Spielkonstanten.CSS_STANDARD_LAYOUT_SHEET);
		for (String szeneBezeichner : AnwendungFX.SZENEN_ROOT_MAP.keySet())
		{
			try
			{
				AnwendungFX.fuegeStyleSheetsAnwendungsSzeneHinzu(Spielkonstanten.CSS_DATEI_PFAD + szeneBezeichner
						+ Spielkonstanten.CSS_SZENEN_SPEZIFISCH_ZUSATZ + Spielkonstanten.CSS_DATEI_ENDE);
			} catch (NullPointerException e)
			{
				//
			}

		}

	}

	/**
	 * Startet die Anwendung, indem die JavaFX Application Methode launch()
	 * aufgerufen wird.
	 *
	 * @param args
	 * @see javafx.application.Application
	 */
	public static void starteAnwendung(String[] args)
	{
		Application.launch(args);
	}

	/**
	 * Es wird die Szene gewechselt. Die anwendungsStage zeigt dann also die Szene
	 * szenenName. Im Detail verbleibt die anwendungsSzene und lediglich dem
	 * rootPane werden andere Knoten hinzugeordnet.
	 *
	 * @param szenenName Der Name der anzuzeigenden Szene.
	 */
	public static void zeigeSzene(String szenenName)
	{
		AnwendungFX.rootPane.getChildren().setAll(AnwendungFX.SZENEN_ROOT_MAP.get(szenenName));
		AnwendungFX.rootPane.applyCss();
	}

	/**
	 * Die Start Methode wird implizit durch das Aufrufen von Apllication.launch()
	 * aufgerufen. Sie startet die eigentliche Anwendung.
	 */
	@Override
	public void start(Stage stage) throws Exception
	{
		// Zuweisungen und Instanzierunge des Basis-Geruests
		AnwendungFX.anwendungsStage = stage;
		AnwendungFX.rootPane = new Pane();
		AnwendungFX.anwendungsSzene = new Scene(AnwendungFX.rootPane);
		AnwendungFX.anwendungsStage.setScene(AnwendungFX.anwendungsSzene);
		// Initialisierungen von Szene, Sprache und StyleSheets
		AnwendungFX.initSzenen();
		AnwendungFX.aktualisiereSzenenSprache();
		AnwendungFX.aktualisiereFensterAufloesungUndStyleSheets();
		// Einstellungen des Fensters (Stage)
		AnwendungFX.anwendungsStage.getIcons()
				.add(new Image(new File(Spielkonstanten.ANWENDUNG_ANWENDUNGS_ICON).toURI().toURL().toExternalForm()));
		AnwendungFX.anwendungsStage.setResizable(false);
		AnwendungFX.anwendungsStage.setFullScreenExitHint(new String());
		AnwendungFX.anwendungsStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
		AnwendungFX.anwendungsStage.setOnCloseRequest(windowEvent -> Main.anwendungBeenden());
		// Setzen einer Start-Szene und anzeigen des Fensters
		AnwendungFX.zeigeSzene(Spielkonstanten.ANWENDUNG_TITEL_SZENE);
		AnwendungFX.anwendungsStage.show();
	}

}