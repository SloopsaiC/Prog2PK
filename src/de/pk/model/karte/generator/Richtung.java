package de.pk.model.karte.generator;

import de.pk.model.position.Vektor;

public enum Richtung
{
	NORDEN
	{
		@Override
		public Vektor getVersatz()
		{
			return new Vektor(0, -1);
		}

		@Override
		public Vektor getVerschiebeVektor()
		{
			return new Vektor(1, 0);
		}
	},
	OSTEN
	{
		@Override
		public Vektor getVersatz()
		{
			return new Vektor(1, 0);
		}

		@Override
		public Vektor getVerschiebeVektor()
		{
			return new Vektor(0, 1);
		}
	},
	SUEDEN
	{
		@Override
		public Vektor getVersatz()
		{
			return new Vektor(0, 1);
		}

		@Override
		public Vektor getVerschiebeVektor()
		{
			return new Vektor(1, 0);
		}
	},
	WESTEN
	{
		@Override
		public Vektor getVersatz()
		{
			return new Vektor(-1, 0);
		}

		@Override
		public Vektor getVerschiebeVektor()
		{
			return new Vektor(0, 1);
		}
	};

	/**
	 * Erstellt einen Vektor der angibt wie die Koordinaten veraendert werden
	 * muessen um in diese Richtung verschoben zu werden.
	 * 
	 * @return Ein Vektor, welcher diese Richtung als Vektor darstellt.
	 */
	public abstract Vektor getVersatz();

	/**
	 * Erstellt einen Vektor welche die Achse auf der diese Richtung nichts
	 * veraendert. Wird genutzt um beim pruefen von Verbindungen entlang einer Kante
	 * zu verschieben, die an einer bestimmten Richtung liegt.
	 * 
	 * @return Ein Vektor der genutzt werden kann um eine Position zu verschieben
	 *         waehrend nichts an der Koordinate veraendert wird in die diese
	 *         Richtung zeigt.
	 */
	public abstract Vektor getVerschiebeVektor();
}
