package de.pk.control.interaktion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import de.pk.model.interaktion.WuerfelWurf;
import de.pk.utils.AusnahmeNachrichten;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * Klasse welche WuerfelWuerfe generiert und alle Beobachter ueber alle Wuerfe.
 *
 * Ein Wuerfel hat hierbei allderdings keine Augenzahl oder aehnliches wie in
 * der echten Welt, sondern modelliert nur den Zufall basierend auf
 * Wahrscheinlichkeiten. Es koennen Observer registriert werden um alle
 * WuerfelWuerfe in der GUI anzeigen zu koennen.
 *
 * @author Mattheo
 */
public class Wuerfel implements ObservableValue<WuerfelWurf>
{
	private WuerfelWurf letzterWurf = null; // Der letzte Wurf dieses Wuerfels, die "ObservableValue"
	private List<ChangeListener<? super WuerfelWurf>> changeListeners = null; // Die Listener die informiert werden
																				// sollte ein neuer Wurf erfolgen
	private List<InvalidationListener> invalidationListeners = null; // Siehe changeListeners

	/**
	 * Erstellt einen neuen Wuerfel.
	 */
	public Wuerfel()
	{
		this.changeListeners = Collections.synchronizedList(new ArrayList<ChangeListener<? super WuerfelWurf>>());
		this.invalidationListeners = Collections.synchronizedList(new ArrayList<InvalidationListener>());
	}

	@Override
	public void addListener(ChangeListener<? super WuerfelWurf> listener)
	{

		this.changeListeners.add(Objects.requireNonNull(listener));
	}

	@Override
	public void addListener(InvalidationListener listener)
	{
		this.invalidationListeners.add(Objects.requireNonNull(listener));
	}

	@Override
	public WuerfelWurf getValue()
	{
		return this.letzterWurf;
	}

	@Override
	public void removeListener(ChangeListener<? super WuerfelWurf> listener)
	{
		if (!this.changeListeners.contains(listener))
		{
			throw new IllegalArgumentException(AusnahmeNachrichten.WUERFEL_NICHT_GUELTIGER_LISTENER);
		}
		this.changeListeners.add(listener);
	}

	@Override
	public void removeListener(InvalidationListener listener)
	{
		if (!this.invalidationListeners.contains(listener))
		{
			throw new IllegalArgumentException(AusnahmeNachrichten.WUERFEL_NICHT_GUELTIGER_LISTENER);
		}
		this.invalidationListeners.remove(listener);
	}

	/**
	 * Wird aufgerufen wenn ein neuer Wurf erfolgt ist.
	 *
	 * @param alterWurf Der vorherige Wurf
	 */
	private void veraendert(WuerfelWurf alterWurf)
	{
		for (ChangeListener<? super WuerfelWurf> listener : this.changeListeners)
		{
			listener.changed(this, alterWurf, this.letzterWurf);
		}
		for (InvalidationListener listener : this.invalidationListeners)
		{
			listener.invalidated(this);
		}
	}

	/**
	 * Erstellt einen neuen WuerfelWurf und informiert alle Listener darueber, dass
	 * ein neuer Wurf erfolgt ist.
	 *
	 * @param erfolgsWahrscheinlichkeit Die Wahrscheinlichkeit mit der dieser Wurf
	 *                                  erfolgreich ist
	 */
	public void werfen(float erfolgsWahrscheinlichkeit)
	{
		synchronized (this)
		{
			WuerfelWurf alterWurf = this.letzterWurf;
			this.letzterWurf = new WuerfelWurf(erfolgsWahrscheinlichkeit, ThreadLocalRandom.current().nextFloat());
			this.veraendert(alterWurf);
		}
	}
}
