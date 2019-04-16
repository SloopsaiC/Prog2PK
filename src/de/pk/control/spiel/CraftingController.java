package de.pk.control.spiel;

import de.pk.model.gegenstaende.CraftingRezept;
import de.pk.model.gegenstaende.Gegenstand;
import de.pk.model.gegenstaende.Material;
import de.pk.utils.DebugAusgabeKlasse;
import de.pk.utils.DebugEingabeKlasse;
import de.pk.utils.ZweidimensionaleArrayOperationen;
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
     * Repraesentiert das Menue des Craftings, wird in Dauerschleife durchlaufen, bis abbgebrochen wird.
     */
    public void craftingMenue ()
    {
        boolean amLeben = true;
        while (amLeben)
        {
            DebugAusgabeKlasse.ausgeben("\nDu befindest Dich im Crafting-Menue");
            DebugAusgabeKlasse.ausgeben("Was wollen Sie tun?");
            DebugAusgabeKlasse.ausgeben("\tn = versuchen neuen Gegenstand zu craften" + "\n\tx = abbrechen");
            switch (DebugEingabeKlasse.leseZeileEin().charAt(0))
            {
                case 'n': //Neuen Gegenstand craften
                    this.craften();
                    break;
                case 'x': //Abbruch
                    amLeben = false;
                    break;
                default:
                    DebugAusgabeKlasse.ausgeben("Inkorrekte Eingabe\n\n\n");
            }
        }
    }


    /**
     * Listet alle zur Verfuegung stehenden Materialien erst auf und verwaltet dann das eigentliche Crafting als
     * Abgleich der Anwendereingabe und den vordefinierten Mustern zum Craften von neuen Gegenstaenden.
     */
    private void craften ()
    {
        String ausgabe = "\nKombiniere einen neuen Gegenstand aus folgenden Materialen:\n";
        for (Material m : Material.values())
        {
            ausgabe += m.toString() + ", ";
        }
        DebugAusgabeKlasse.ausgeben(ausgabe); //Auflistung aller Materialien

        try
        {
            Gegenstand gecrafteterGegenstand = crafteGegenstandAusEingegebenenMaterialien(materialienEingabeEinlesen());
            //Eingabe und Craftingversuch
            DebugAusgabeKlasse.ausgeben("Glueckwunsch! Du hast " + gecrafteterGegenstand.toString() + " gecraftet.\n\n\n");
            //Bei erfolgreichem Crafting

            //TO-DO: gecrafteten Gegenstand ins Inventar des Helden legen.
        }
        catch (InputMismatchException e) //Bei Misserfolg des Craftings (Exception wurde geworfen)
        {
            DebugAusgabeKlasse.ausgeben("\tist leider kein gueltiger Gegenstand.\n\n\n");
        }
        catch (NullPointerException e) //Bei Abbruch waehrend des Craftings
        {
            DebugAusgabeKlasse.ausgeben("\tAbbruch.\n\n\n");
        }
    }


    /**
     * Versucht einen Gegenstand aus der Materialieneingabe zu craften und diesen zurueckzugeben, ansonsten wird eine
     * Exception geworfen. Dabei wird die Eingabe mit dem Muster jedes CraftingRezepts abgeglichen.
     *
     * @param materialien Anwendereingabe an Materialien.
     * @return aus den eingegebenen Materialien gecrafteter Gegenstand.
     * @throws InputMismatchException Falls die eingegebenen Materialien auf keinen craftbaren Gegenstand zutreffen.
     */
    private Gegenstand crafteGegenstandAusEingegebenenMaterialien (Material[][] materialien) throws
            InputMismatchException
    {
        for (CraftingRezept craftGegenstandRezept : CraftingRezept.values())
        {
            if (materialienEingabePasstZuMuster(materialien, craftGegenstandRezept.getCraftingMaterialMuster()))
            {
                return craftGegenstandRezept.getCraftGegenstand();
            }
        }
        throw new InputMismatchException();
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
        for (int i = 0; i < 4; i++)
        {
            Material[][] gedrehteMaterialEingabe
                    = ZweidimensionaleArrayOperationen.dreheQuadratisches2DArrayUm90Grad(materialien, i);
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


    /**
     * Liest die Materialien-Eingabe aus der Konsole ein. Bei Abbruch wird null zurueckgegeben!
     *
     * @return eingegebene Materialien als zweidimensionalses Array oder null, wenn das Crafting mittendrin abbgebrochen
     *         wird.
     */
    private Material[][] materialienEingabeEinlesen ()
    {
        Material[][] eingabe = new Material[3][3];
        boolean amLeben = true;
        while (amLeben)
        {
            try
            {
                DebugAusgabeKlasse.ausgeben("Gib deine Materialien in 3x3 Form ein (3 Zeilen mit je 3 Materialien durch \", \" getrennt), x = abbrechen");
                for (int y = 0; y < eingabe[0].length; y++)
                {
                    String zeile = DebugEingabeKlasse.leseZeileEin();
                    if (zeile.charAt(0) == 'x') //Abbruch
                    {
                        return null;
                    }
                    String[] gerateneMaterialien = zeile.toUpperCase().split(", ");
                    for (int x = 0; x < eingabe.length; x++)
                    {
                        eingabe[y][x] = Material.valueOf(gerateneMaterialien[x]);
                    }
                }
                amLeben = false;
            }
            catch (ArrayIndexOutOfBoundsException e) //Falls weniger als drei Materialien in einer Zeile eingegeben wurden.
            {
                DebugAusgabeKlasse.ausgeben("\n\n\nGib 3 Materialien pro Zeile ein.\n\n\n");
            }
            catch (IllegalArgumentException e) //Falls Woerter falsch geschrieben, Leerzeichen oder Kommata vergessen wurden.
            {
                DebugAusgabeKlasse.ausgeben("\n\n\nHoppla, da hat sich wohl ein Syntaxfehler eingeschlichen. "
                        + "Vergiss nicht deine Eingaben mit \", \" zu trennen.\n\n\n");
            }
        }
        DebugAusgabeKlasse.ausgeben("\nDeine Materialien-Eingabe: ", eingabe); //Ausgabe der Eingabe zur Pruefung.
        return eingabe;
    }


}
