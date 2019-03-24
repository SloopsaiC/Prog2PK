package de.pk.model.spielbrett.spielbrettObjekte.container;


import de.pk.model.gegenstaende.Gegenstand;

public abstract class Container
{
	private Gegenstand[] inhalt = null; //Der Inhalt dieses Containers
	private int maximaleGroesse = 0; //Die maximale Anzahl von Gegenstaenden in diesem Container
}
