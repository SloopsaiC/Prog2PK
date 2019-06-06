package de.pk.view.visuell.events;

import de.pk.model.position.KachelPosition;
import javafx.event.Event;
import javafx.event.EventType;

/**
 * Ein KachelPositionEvent wird von einer Karte ausgeloest, um dem Dungeon zu
 * signalisieren, dass auf einen bestimmten Untergrund einer bestimmten Kachel
 * geklcikt wurde.
 *
 * @author Dylan
 *
 */
public class KachelPositionEvent extends Event
{

	/**
	 * EventType fuer das Anklicken einer Kachel.
	 */
	public static final EventType<KachelPositionEvent> KACHEL_ANGELICKT = new EventType<>("KACHEL_ANGELICKT");

	/**
	 * Die KachelPosition des Events.
	 */
	private KachelPosition eventKachelPosition = null;

	/**
	 * Erstellt ein neues KachelPositionEvent.
	 *
	 * @param eventType           Art des Events (s. KACHEL_ANGELICKT)
	 * @param eventKachelPosition KachelPosition
	 */
	public KachelPositionEvent(EventType<? extends Event> eventType, KachelPosition eventKachelPosition)
	{
		super(eventType);
		this.eventKachelPosition = eventKachelPosition;
	}

	/**
	 * Gibt die KachelPosition des Events wieder.
	 *
	 * @return KachelPosition
	 */
	public KachelPosition getEventKachelPosition()
	{
		return this.eventKachelPosition;
	}

}
