package de.pk.view.visuell.events;

import de.pk.model.position.Position;
import javafx.event.Event;
import javafx.event.EventType;

public class PositionEvent extends Event
{

	public static final EventType<PositionEvent> UNTERGRUND_ANGELICKT = new EventType<>("UNTERGRUND_ANGELICKT");

	private Position eventPosition = null;

	public PositionEvent(EventType<? extends Event> eventType, Position eventPosition)
	{
		super(eventType);
		this.eventPosition = eventPosition;
	}

	public Position getEventPosition()
	{
		return this.eventPosition;
	}

}
