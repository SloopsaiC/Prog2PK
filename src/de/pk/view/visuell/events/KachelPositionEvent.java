package de.pk.view.visuell.events;

import de.pk.model.position.KachelPosition;
import javafx.event.Event;
import javafx.event.EventType;

public class KachelPositionEvent extends Event
{

	public static final EventType<KachelPositionEvent> KACHEL_ANGELICKT = new EventType<>("KACHEL_ANGELICKT");

	private KachelPosition eventKachelPosition = null;

	public KachelPositionEvent(EventType<? extends Event> eventType, KachelPosition eventKachelPosition)
	{
		super(eventType);
		this.eventKachelPosition = eventKachelPosition;
	}

	public KachelPosition getEventKachelPosition()
	{
		return this.eventKachelPosition;
	}

}
