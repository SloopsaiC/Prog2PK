package de.pk.model.gegenstaende;

import static de.pk.model.gegenstaende.Material.EISEN;
import static de.pk.model.gegenstaende.Material.HOLZ;
import static de.pk.model.gegenstaende.Material.LEER;
import de.pk.model.gegenstaende.ausruestung.Ruestung;
import de.pk.model.gegenstaende.ausruestung.Waffe;


/**
 * Enum mit "Rezepten" fuer das Crafting, sie bilden die Grundlage des Crafting-Systems. Jedes Rezept beinhaltet einen
 * craftGegenstand sowie ein Muster aus Materialien, welche beim Craften in der Form des Musters erraten werden muessen,
 * um den jeweiligen Gegenstand herzustellen.
 *
 * @author Dylan
 */
public enum CraftingRezept
{

    SCHWERT_REZEPT(new Material[][]
    {
        {
            LEER, HOLZ, LEER
        },
        {
            LEER, EISEN, LEER
        },
        {
            LEER, EISEN, LEER
        }
    }, new Waffe()),
    SCHILD_REZEPT(new Material[][]
    {
        {
            HOLZ, HOLZ, HOLZ
        },
        {
            HOLZ, EISEN, HOLZ
        },
        {
            HOLZ, HOLZ, HOLZ
        }
    }, new Ruestung());

    private Material[][] craftingMaterialMuster = null;
    private Gegenstand craftGegenstand = null;

    private CraftingRezept (Material[][] craftingMaterialMuster, Gegenstand craftGegenstand)
    {
        this.craftingMaterialMuster = craftingMaterialMuster;
        this.craftGegenstand = craftGegenstand;
    }


    /**
     * Liefert das Muster, welches das Rezept repraesentiert.
     *
     * @return craftingMaterialMuster
     */
    public Material[][] getCraftingMaterialMuster ()
    {
        return craftingMaterialMuster;
    }


    /**
     * Gibt den Gegenstand zurueck, welcher durch das Erraten des zugehoerigen Musters gecraftet werden kann.
     *
     * @return CraftGegenstand, eine neue Instanz des gecrafteten Gegenstands.
     */
    public Gegenstand getCraftGegenstand ()
    {
        return craftGegenstand;
    }


}
