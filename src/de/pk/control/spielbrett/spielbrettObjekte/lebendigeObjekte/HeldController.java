package de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte;

import java.util.Arrays;

import de.pk.model.gegenstaende.ausruestung.Accessoire;
import de.pk.model.gegenstaende.ausruestung.Ruestung;
import de.pk.model.gegenstaende.ausruestung.Waffe;
import de.pk.model.gegenstaende.spezifikationen.Ausruestbar;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;

public class HeldController extends LebendigesObjektController
{

	private Held modell = (Held) super.getModell();

	public HeldController(String name, int lebensPunkte, int bewegungsPunkte)
	{
		super(new Held(name, lebensPunkte, bewegungsPunkte));
	}

	/**
	 * Ruestet dem Helden das Accessoire aus und legt es in sein Accesoire-Inventar
	 * an die entsprechende Stelle (slot). War zuvor bereits eine anderes Accessoire
	 * in diesem Slot ausgeruestet, so gibt die Methode dieses zurueck, die
	 * Accessoires werden also getauscht.
	 *
	 * @param accessoire Das auszuruestende Accessoire
	 * @param slot       Position an dem das Accessoire eingefuegt werden soll, wobei
	 *                   0 die erste Position ist. slot darf nicht groesser sein als
	 *                   {@link Held.ANZAHL_MAXIMALE_ACCESSOIRES}-1.
	 * @return das alte Accessoire, welches zuvor an der Stelle slot ausgeruestet
	 *         war oder null, wenn zuvor kein Accessoire in diesem Slot ausgeruestet
	 *         war.
	 * @throws IllegalStateException     falls der Held die vorausgesetzten
	 *                                   Faehigkeiten, um dieses Accessoire zu
	 *                                   tragen nicht erfuellt.
	 * @throws IndexOutOfBoundsException falls slot groesser ist als
	 *                                   {@link Held.ANZAHL_MAXIMALE_ACCESSOIRES}-1.
	 */
	public Accessoire ausruesten(Accessoire accessoire, int slot)
			throws IllegalStateException, IndexOutOfBoundsException
	{
		if (slot > (Held.ANZAHL_MAXIMALE_ACCESSOIRES - 1))
		{
			throw new IndexOutOfBoundsException();
		}
		this.pruefeAusruestungAufFaehigkeitsVoraussetzungen(accessoire);
		return this.modell.getAccessoires().put(slot, accessoire);
	}

	/**
	 * Ruestet dem Helden eine Ruestung aus. War zuvor bereits eine andere Ruestung
	 * ausgeruestet, so gibt die Methode diese zurueck, die Ruestungen werden also
	 * getauscht.
	 *
	 * @param ruestung Die auszuruestende Ruestung
	 * @param slot     Position an dem die Ruestung eingefuegt werden soll, wobei 0
	 *                 die erste Position ist. slot darf nicht groesser sein als
	 *                 {@link Held.ANZAHL_MAXIMALE_RUESTUNGS_GEGENSTAENDE}-1.
	 * @return die alte Ruestung, welche zuvor ausgeruestet war oder null, wenn
	 *         zuvor keine Ruestung ausgeruestet war.
	 * @throws IllegalStateException     falls der Held die vorausgesetzten
	 *                                   Faehigkeiten, um diese Ruestung zu tragen
	 *                                   nicht erfuellt.
	 * @throws IndexOutOfBoundsException falls slot groesser ist als
	 *                                   {@link Held.ANZAHL_MAXIMALE_RUESTUNGS_GEGENSTAENDE}-1.
	 */
	public Ruestung ausruesten(Ruestung ruestung, int slot) throws IllegalStateException, IndexOutOfBoundsException
	{
		if (slot > (Held.ANZAHL_MAXIMALE_RUESTUNGS_GEGENSTAENDE - 1))
		{
			throw new IndexOutOfBoundsException();
		}
		this.pruefeAusruestungAufFaehigkeitsVoraussetzungen(ruestung);
		return this.modell.getRuestung().put(slot, ruestung);
	}

	/**
	 * Ruestet dem Helden eine Waffe aus. War zuvor bereits eine andere Waffe
	 * ausgeruestet, so gibt die Methode diese zurueck, die Waffen werden also
	 * getauscht.
	 *
	 * @param waffe Die auszuruestende Waffe
	 * @return die alte Waffe, welche zuvor ausgeruestet war oder null, wenn zuvor
	 *         keine Waffe ausgeruestet war.
	 * @throws IllegalStateException falls der Held die vorausgesetzten
	 *                               Faehigkeiten, um diese Waffe zu tragen nicht
	 *                               erfuellt.
	 */
	public Waffe ausruesten(Waffe waffe) throws IllegalStateException
	{
		this.pruefeAusruestungAufFaehigkeitsVoraussetzungen(waffe);
		try
		{
			return this.modell.getWaffe();
		} finally
		{
			this.modell.setWaffe(waffe);
		}
	}

	public Waffe getWaffe()
	{
		return this.modell.getWaffe();
	}

	/**
	 * Prueft, ob der Held die Faehigkeits-Voraussetzungen erfuellt, um die
	 * auszuruestende Ausruestung zu tragen.
	 *
	 * @param ausruestung auszuruestende Ausruestung, dessen Voraussetzungen mit den
	 *                    Faehigkeiten des Helden abgeglichen werden sollen.
	 * @throws IllegalStateException falls der Held die vorausgesetzten
	 *                               Faehigkeiten, um diese Auszuruestung zu tragen
	 *                               nicht alle erfuellt.
	 */
	private void pruefeAusruestungAufFaehigkeitsVoraussetzungen(Ausruestbar ausruestung) throws IllegalStateException
	{
		if (!this.modell.getFaehigkeiten().containsAll(Arrays.asList(ausruestung.getVoraussetzungen())))
		{
			throw new IllegalStateException();
		}
	}

}
