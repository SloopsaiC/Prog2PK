package de.pk.model.spielbrett.spielbrettTeile;

import java.util.HashMap;

import de.pk.kartenGenerator.KartenGeneratorKachel;
import de.pk.model.position.Position;
import de.pk.model.spielbrett.spielbrettObjekte.SpielbrettObjekt;

public class Kachel
{
	private HashMap<Position, SpielbrettObjekt> kachelObjekte = null;
	private KartenGeneratorKachel kartenKachel = null;
}
