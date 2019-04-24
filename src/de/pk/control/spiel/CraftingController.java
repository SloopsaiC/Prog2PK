package de.pk.control.spiel;

import de.pk.model.gegenstaende.CraftingRezept;
import de.pk.model.gegenstaende.Gegenstand;
import de.pk.model.gegenstaende.Material;
import de.pk.utils.DebugAusgabeKlasse;
import de.pk.utils.DebugEingabeKlasse;
import de.pk.utils.Spielkonstanten;
import de.pk.utils.ZweidimensionaleArrayOperationen;
import de.pk.utils.lokalisierung.DE_de;
import java.util.InputMismatchException;


/**
 * Regelt den Ablauf beim Craften. Beinhaltet Methoden in Zusammenhang mit dem Craften von neuen Gegenstaenden (Waffen
 * etc.).
 *
 * @author Dylan
 */
public class CraftingController
{

    /**
     * Versucht einen Gegenstand aus der Materialieneingabe zu craften und diesen zurueckzugeben, ansonsten wird eine
     * Exception geworfen. Dabei wird die Eingabe mit dem Muster jedes CraftingRezepts abgeglichen.
     *
     * @param materialien Anwendereingabe an Materialien.
     * @return aus den eingegebenen Materialien gecrafteter Gegenstand.
     * @throws InputMismatchException Falls die eingegebenen Materialien auf keinen craftbaren Gegenstand zutreffen.
     */
    private Gegenstand crafteGegenstandAusEingegebenenMaterialien (Material[][] materialien)
            throws InputMismatchException
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
     * Listet alle zur Verfuegung stehenden Materialien erst auf und verwaltet dann das eigentliche Crafting als
     * Abgleich der Anwendereingabe und den vordefinierten Mustern zum Craften von neuen Gegenstaenden.
     */
    private void craften ()
    {
        String ausgabe = DE_de.CRAFTEN_EINGABEAUFFORDERUNG;
        for (Material m : Material.values())
        {
            ausgabe += m.toString() + DE_de.STANDARD_SPLITTER;
        }
        DebugAusgabeKlasse.ausgeben(ausgabe); // Auflistung aller Materialien

        try
        {
            Gegenstand gecrafteterGegenstand = this
                    .crafteGegenstandAusEingegebenenMaterialien(this.materialienEingabeEinlesen());
            // Eingabe und Craftingversuch
            DebugAusgabeKlasse
                    .ausgeben(DE_de.CRAFTEN_ERFOLG + gecrafteterGegenstand.toString());
            // Bei erfolgreichem Crafting

            // TO-DO: gecrafteten Gegenstand ins Inventar des Helden legen.
        }
        catch (InputMismatchException e) // Bei Misserfolg des Craftings (Exception wurde geworfen)
        {
            DebugAusgabeKlasse.ausgeben(DE_de.CRAFTEN_KEIN_GEGENSTAND);
        }
        catch (NullPointerException e) // Bei Abbruch waehrend des Craftings
        {
        }
    }


    /**
     * Repraesentiert das Menue des Craftings, wird in Dauerschleife durchlaufen, bis abbgebrochen wird.
     */
    public void craftingMenue ()
    {
        boolean amLeben = true;
        while (amLeben)
        {
            DebugAusgabeKlasse.ausgeben(DE_de.CRAFTINGMENUE);
            DebugAusgabeKlasse.ausgeben(DE_de.MENUE_WAS_TUN);
            DebugAusgabeKlasse.ausgeben(DE_de.CRAFTINGMENUE_AKTIONSAUSWAHL);
            switch (DebugEingabeKlasse.leseZeileEin().charAt(0))
            {
                case DE_de.EINGABESYMBOL_CRAFTINGMENUE_NEU_CRAFTEN: // Neuen Gegenstand craften
                    this.craften();
                    break;
                case DE_de.EINGABESYMBOL_MENUE_BEENDEN_ODER_ZURUECK: // Abbruch
                    amLeben = false;
                    break;
                default:
                    DebugAusgabeKlasse.ausgeben(DE_de.MENUE_INKORREKTE_KONSOLEN_EINGABE);
            }
        }
    }


    /**
     * Liest die Materialien-Eingabe aus der Konsole ein. Bei Abbruch wird null zurueckgegeben!
     *
     * @return eingegebene Materialien als zweidimensionalses Array oder null, wenn das Crafting mittendrin abbgebrochen
     *         wird.
     */
    private Material[][] materialienEingabeEinlesen ()
    {
        Material[][] eingabe
                = new Material[CraftingRezept.MATERIAL_MUSTER_DIMENSION][CraftingRezept.MATERIAL_MUSTER_DIMENSION];
        boolean amLeben = true;
        while (amLeben)
        {
            try
            {
                DebugAusgabeKlasse.ausgeben(DE_de.CRAFTEN_INFO);
                for (int y = 0; y < eingabe[0].length; y++)
                {
                    String zeile = DebugEingabeKlasse.leseZeileEin();
                    if (zeile.charAt(0) == DE_de.EINGABESYMBOL_MENUE_BEENDEN_ODER_ZURUECK) // Abbruch
                    {
                        return null;
                    }
                    String[] gerateneMaterialien = zeile.toUpperCase().split(DE_de.STANDARD_SPLITTER);
                    for (int x = 0; x < eingabe.length; x++)
                    {
                        eingabe[y][x] = Material.valueOf(gerateneMaterialien[x]);
                    }
                }
                amLeben = false;
            }
            catch (ArrayIndexOutOfBoundsException e) // Falls weniger als drei Materialien in einer Zeile eingegeben
            // wurden.
            {
                DebugAusgabeKlasse.ausgeben(DE_de.CRAFTEN_ZU_KURZE_EINGABE);
            }
            catch (IllegalArgumentException e) // Falls Woerter falsch geschrieben, Leerzeichen oder Kommata vergessen
            // wurden.
            {
                DebugAusgabeKlasse.ausgeben(DE_de.CRAFTEN_SONSTIGER_SYNTAXFEHLER);
            }
        }
        DebugAusgabeKlasse.ausgeben(DE_de.CRAFTEN_MATERIALAUSGABE, eingabe); // Ausgabe der Eingabe zur Pruefung.
        return eingabe;
    }


    /**
     * Prueft, ob die eingegebenen Materialien materialien zum entsprechenden CraftingMuster muster passen. Hierzu wird
     * die Materialieneingabe vier mal gedreht und gespiegelt, um das Erraten der richtigen Kombination aus Materialien
     * etwas zu erleichtern und Richtungs- sowie Betrachtungsunabhaengig zu gestalten.
     *
     * @param materialien Materialieneingabe
     * @param muster      CraftingMaterialMuster
     * @return wahr, wenn die Eingabe je um 90 Grad gedreht oder gespiegelt zum Muster passt.
     */
    private boolean materialienEingabePasstZuMuster (Material[][] materialien, Material[][] muster)
    {
        for (int i = 0; i < Spielkonstanten.ANZAHL_MAXIMALE_DREHUNGEN_REZEPT; i++)
        {
            Material[][] gedrehteMaterialEingabe = ZweidimensionaleArrayOperationen
                    .dreheQuadratisches2DArrayUm90Grad(materialien, i);
            if (ZweidimensionaleArrayOperationen.vergleiche(muster, gedrehteMaterialEingabe))
            {
                return true;
            }
            else if (ZweidimensionaleArrayOperationen.vergleiche(muster,
                    ZweidimensionaleArrayOperationen.spiegle2DArrayVertikal(gedrehteMaterialEingabe)))
            {
                return true;
            }
        }
        return false;
    }


}
