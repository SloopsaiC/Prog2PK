package de.pk.utils;

import java.util.Set;

import de.pk.control.spielbrett.spielbrettObjekte.SpielbrettObjektController;
import de.pk.model.position.Position;
import de.pk.model.spielbrett.Spielbrett;

public class DemonstrationsSpielbrettAusgabe
{
	public static void spielbrettAusgeben(Spielbrett ausgeben)
	{
		Set<Position> alleKacheln = ausgeben.getAlleKachelPositionen();

		for (int yK = 0; yK < Spielkonstanten.KACHEL_GROESSE_Y * Spielkonstanten.STANDARD_GROESSE_DUNGEON_Y; yK++)
		{
			for (int x = 0; x < Spielkonstanten.KACHEL_GROESSE_X * Spielkonstanten.STANDARD_GROESSE_DUNGEON_X; x++)
			{
				if (yK == (Spielkonstanten.KACHEL_GROESSE_Y * Spielkonstanten.STANDARD_GROESSE_DUNGEON_Y) / 2)
				{
					System.out.println();
				}
				Position kachelPosition = new Position(x / Spielkonstanten.KACHEL_GROESSE_X,
						yK / Spielkonstanten.KACHEL_GROESSE_Y);
				if (alleKacheln.contains(kachelPosition))
				{
					Position posAufKachel = new Position(x % Spielkonstanten.KACHEL_GROESSE_X,
							yK % Spielkonstanten.KACHEL_GROESSE_Y);
					SpielbrettObjektController momentanesObjekt = ausgeben.getKachelBei(kachelPosition)
							.getSpielbrettObjektBei(posAufKachel);
					if (momentanesObjekt == null)
					{
						System.out.print(ausgeben.getKachelBei(kachelPosition).getUntergrundBei(posAufKachel) + "\t");
					} else
					{
						System.out.print("P" + "\t");
					}
				}
			}
			System.out.println();
		}
	}
}
