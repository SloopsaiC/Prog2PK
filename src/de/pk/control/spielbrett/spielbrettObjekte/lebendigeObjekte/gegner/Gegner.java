package de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.gegner;

import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.LebendigesObjekt;
import de.pk.model.gegenstaende.container.Container;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.GegnerModell;

public class Gegner extends LebendigesObjekt
{
	private final GegnerModell modell;

	public Gegner(GegnerArt art, float hauDraufModifikator)
	{
		super(new GegnerModell(art, hauDraufModifikator));
		this.modell = (GegnerModell) super.getModell();

	}

	@Override
	protected Container generiereAuswurf()
	{
		return new Container(10);
	}

}
