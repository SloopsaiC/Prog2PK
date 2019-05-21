package de.pk.control.spiel;

import java.util.InputMismatchException;

import de.pk.model.gegenstaende.CraftingRezept;
import de.pk.model.gegenstaende.Material;
import de.pk.model.gegenstaende.spezifikationen.Stapelbar;
import de.pk.utils.Spielkonstanten;
import de.pk.utils.ZweidimensionaleArrayOperationen;

/**
 * Regelt den Ablauf beim Craften. Beinhaltet Methoden in Zusammenhang mit dem
 * Craften von neuen Gegenstaenden (Waffen etc.).
 *
 * @author Dylan
 */
public class CraftingController
{

	/**
	 * Versucht einen Gegenstand aus der Materialieneingabe zu craften und diesen
	 * zurueckzugeben, ansonsten wird eine Exception geworfen. Dabei wird die
	 * Eingabe mit dem Muster jedes CraftingRezepts abgeglichen.
	 *
	 * @param materialien Anwendereingabe an Materialien.
	 * @return aus den eingegebenen Materialien gecrafteter Gegenstand.
	 * @throws InputMismatchException Falls die eingegebenen Materialien auf keinen
	 *                                craftbaren Gegenstand zutreffen.
	 */
	public Stapelbar crafteGegenstandAusEingegebenenMaterialien(Material[][] materialien) throws InputMismatchException
	{
		for (CraftingRezept craftGegenstandRezept : CraftingRezept.values())
		{
			if (this.materialienEingabePasstZuMuster(materialien, craftGegenstandRezept.getCraftingMaterialMuster()))
			{
				return craftGegenstandRezept.getCraftGegenstand();
			}
		}
		throw new InputMismatchException();
	}

	/**
	 * Prueft, ob die eingegebenen Materialien materialien zum entsprechenden
	 * CraftingMuster muster passen. Hierzu wird die Materialieneingabe vier mal
	 * gedreht und gespiegelt, um das Erraten der richtigen Kombination aus
	 * Materialien etwas zu erleichtern und Richtungs- sowie Betrachtungsunabhaengig
	 * zu gestalten.
	 *
	 * @param materialien Materialieneingabe
	 * @param muster      CraftingMaterialMuster
	 * @return wahr, wenn die Eingabe je um 90 Grad gedreht oder gespiegelt zum
	 *         Muster passt.
	 */
	private boolean materialienEingabePasstZuMuster(Material[][] materialien, Material[][] muster)
	{
		for (int i = 0; i < Spielkonstanten.ANZAHL_MAXIMALE_DREHUNGEN_REZEPT; i++)
		{
			Material[][] gedrehteMaterialEingabe = ZweidimensionaleArrayOperationen
					.dreheQuadratisches2DArrayUm90Grad(materialien, i);
			if (ZweidimensionaleArrayOperationen.vergleiche(muster, gedrehteMaterialEingabe))
			{
				return true;
			} else if (ZweidimensionaleArrayOperationen.vergleiche(muster,
					ZweidimensionaleArrayOperationen.spiegle2DArrayVertikal(gedrehteMaterialEingabe)))
			{
				return true;
			}
		}
		return false;
	}

}
