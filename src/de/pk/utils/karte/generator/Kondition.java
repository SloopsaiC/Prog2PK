package de.pk.utils.karte.generator;

import de.pk.model.position.Position;

public interface Kondition
{
	public boolean istErfuellt(Position aktuellePosition, int maximaleGroesseX, int maximaleGroesseY);
}
