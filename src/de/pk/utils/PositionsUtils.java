package de.pk.utils;

import de.pk.model.position.Position;

public class PositionsUtils
{

	/**
	 * Berechnet die Position auf der (neuen) Kachel aus der absoluten Position
	 *
	 * @param absolutePos Die absolute Position
	 *
	 * @return Die Position auf der (neuen) Kachel
	 */
	public static Position getPositionAufKachelAusAbsoluterPosition(Position absolutePos)
	{
	
		// Rumgerechne mit doppeltem Modulo, damit z.B. eine -1 Die KachelGroesse -1
		// wird, also 3 == 3 und -3 == KachelGroesse - 3
		return new Position(
				((absolutePos.getX() % Spielkonstanten.KACHEL_GROESSE_X) + Spielkonstanten.KACHEL_GROESSE_X)
						% Spielkonstanten.KACHEL_GROESSE_X,
				((absolutePos.getY() % Spielkonstanten.KACHEL_GROESSE_Y) + Spielkonstanten.KACHEL_GROESSE_Y)
						% Spielkonstanten.KACHEL_GROESSE_Y);
	}

}
