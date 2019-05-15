package de.pk.model.karte.generator.untergruende;

import de.pk.model.position.Position;

public interface UntergrundWahrscheinlichkeitsBedingung
{
	/**
	 * Prueft ob die gegebene Position auf einem Spielbrett mit gegebener Groesse die
	 * Bedingung erfuellt, dass die Kachel ihre Wahrscheinlichkeit zur Generierung
	 * anpasst. Jeder KartenGeneratorUntergrund besitzt eine solche Bedingung.
	 * 
	 * @param zuUeberpruefen Die Position welche es zu ueberpruefen gilt
	 * @param maximaleGroesseX Die Groesse des Spielbretts in X Richtung
	 * @param maximaleGroesseY Die Groesse des Spielbretts in Y Richtung
	 */
	public boolean istErfuellt(Position zuUeberpruefen, int maximaleGroesseX, int maximaleGroesseY);
}
