package de.pk.view.visuell.events;

import de.pk.model.position.Position;
import javafx.event.Event;
import javafx.event.EventType;

/**
 * Ein PositionEvent wird von einem Kacheluntergrund ausgeloest, wenn auf diesen
 * geklickt wurde.
 *
 * @author Dylan
 *
 */
public class PositionEvent extends Event
{

	/**
	 * EventType fuer einen angeklickten Untergrund.
	 */
	public static final EventType<PositionEvent> UNTERGRUND_ANGELICKT = new EventType<>("UNTERGRUND_ANGELICKT");

	/**
	 * Die Position des Events.
	 */
	private Position eventPosition = null;

	/**
	 * Erstellt ein neues PositionEvent.
	 *
	 * @param eventType     Art des Events (s.UNTERGRUND_ANGELICKT)
	 * @param eventPosition Position des Events.
	 */
	public PositionEvent(EventType<? extends Event> eventType, Position eventPosition)
	{
		super(eventType);
		this.eventPosition = eventPosition;
	}

	/**
	 * Gibt die Position des Events innerhalb der Kachel wieder.
	 * 
	 * @return Position des Events
	 */
	public Position getEventPosition()
	{
		return this.eventPosition;
	}

}
