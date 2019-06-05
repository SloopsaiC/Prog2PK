package de.pk.utils.lokalisierung;

import java.util.ResourceBundle;

/**
 * Das Interface Lokalisierbar soll von allen fxml-Controllern implementiert
 * werden, deren fxml-Komponenten eine sprachabhaengige Ausgabe beinhalten. Es
 * soll somit erzwungen werden, dass die Zuweisung von Textausgaben dieser
 * Komponenten in der Methode aktualisiereTextKomponenten() geschieht, um eine
 * Lokalisierung zu ermoeglichen.
 *
 * @author Dylan
 */
public interface Lokalisierbar
{

	/**
	 * In dieser Methode sollen alle (sprachabhaengigen) Textausgaben den
	 * entsprechenden fxml- bzw. GUI-Komponenten zugewiesen werden. Dazu dient der
	 * Parameter sprachRessource, ueber welchen sich durch einen entsprechenden Key
	 * aus lokalisierung.{@link LokalisierungsKeys} der entsprechende Text in der
	 * eingestellten Sprache holen laesst.
	 *
	 * Beispiel fuer eine Lokalisierung eines Labeltexts mit dem Key "LABEL_KEY":
	 * {@code this.label.setText(sprachRessource.getString(LokalisierungsKeys.LABEL_KEY));}
	 *
	 * Unter "LABEL_KEY" sollte dann ein Key als String gespeichert werden, der auf
	 * den entsprechenden Text, der auf dem Label erscheinen soll, in den sprache_"
	 * ".properties-Ressourcen zeigt. Ist der "LABEL_KEY" z.B. = "labelKey1", so
	 * sollte in der Datei sprache_de.properties eine Zeile
	 * {@code labelKey1=Knoepfe sind toll} und in sprache_en.properties eine Zeile
	 * {@code labelKey1=Buttons are great} stehen, um zu bewirken, dass das Label
	 * bei eingesteller Sprache "Deutsch" den Text "Knoepfe sind toll", bei Englisch
	 * "Buttons are great" anzeigt.
	 *
	 * @param sprachRessource Ueber die sprachRessource kann ueber einen Aufruf der
	 *                        Methode {@code .getString("")} durch Uebergabe eines
	 *                        Keys auf einen unter diesem Key abgespeicherten Text
	 *                        in mehreren Sprachen zugegriffen werden. Je nach
	 *                        eingestellter Sprache wird der Text unter dem Key aus
	 *                        der .properties-Ressource geladen, die die
	 *                        eingestellte Sprache repraesentiert.
	 */
	void aktualisiereTextKomponenten(ResourceBundle sprachRessource);

}
