package de.pk.model.gegenstaende;

import static de.pk.model.gegenstaende.Material.*;
import de.pk.model.gegenstaende.ausruestung.Accessoire;
import de.pk.model.gegenstaende.ausruestung.Ruestung;
import de.pk.model.gegenstaende.ausruestung.Waffe;
import de.pk.model.gegenstaende.spezifikationen.Stapelbar;


/**
 * Enum mit "Rezepten" fuer das Crafting, sie bilden die Grundlage des Crafting-Systems. Jedes Rezept beinhaltet einen
 * craftGegenstand sowie ein Muster aus Materialien, welche beim Craften in der Form des Musters erraten werden muessen,
 * um den jeweiligen Gegenstand herzustellen.
 *
 * @author Dylan
 */
public enum CraftingRezept
{

    /**
     * Rezept fuer ein Schwert.
     */
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
    }, Waffe.SCHWERT),
    /**
     * Rezept fuer einen Bogen.
     */
    BOGEN_REZEPT(new Material[][]
    {
        {
            HOLZ, SEHNE, LEER
        },
        {
            HOLZ, SEHNE, LEER
        },
        {
            HOLZ, SEHNE, LEER
        }
    }, Waffe.BOGEN),
    /**
     * Rezept fuer einen Brustpanzer.
     */
    BRUSTPANZER_REZEPT(new Material[][]
    {
        {
            EISEN, EISEN, EISEN
        },
        {
            LEER, EISEN, LEER
        },
        {
            LEER, EISEN, LEER
        }
    }, Ruestung.BRUSTPANZER),
    /**
     * Rezept fuer einen Schild.
     */
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
    }, Ruestung.SCHILD),
    /**
     * Rezept fuer einen Ring.
     */
    RING_REZEPT(new Material[][]
    {
        {
            LEER, EISEN, LEER
        },
        {
            EISEN, LEER, EISEN
        },
        {
            LEER, EISEN, LEER
        }
    }, Accessoire.RING),
    /**
     * Rezept fuer ein Amulett
     */
    AMULETT_REZEPT(new Material[][]
    {
        {
            LEER, STOFF, LEER
        },
        {
            LEER, EISEN, LEER
        },
        {
            LEER, LEER, LEER
        }
    }, Accessoire.AMULETT);


    /**
     * Das Muster, welches den zu craftenden Gegenstand repraesentiert.
     */
    private Material[][] craftingMaterialMuster = null;
    /**
     * Der Gegenstand, welcher bei der korrekten Kombination des entsprechenden Musters gecraftet wird.
     */
    private Stapelbar craftGegenstand = null;

    /**
     * Konstrukor fuer ein CraftingRezept mit Muster und zu craftenden Gegenstand.
     *
     * @param craftingMaterialMuster 2D-Material-Array, das als Vorlage zum Craften dient.
     * @param craftGegenstand        Bei korrekter Kombination, die dem Muster entspricht, soll dieser Gegenstand
     *                               gecraftet werden.
     */
    private CraftingRezept (Material[][] craftingMaterialMuster, Stapelbar craftGegenstand)
    {
        this.craftingMaterialMuster = craftingMaterialMuster;
        this.craftGegenstand = craftGegenstand;
    }


    /**
     * Gibt den Gegenstand zurueck, welcher durch das Erraten des zugehoerigen Musters gecraftet werden kann.
     *
     * @return CraftGegenstand, eine neue Instanz des gecrafteten Gegenstands.
     */
    public Stapelbar getCraftGegenstand ()
    {
        return this.craftGegenstand;
    }


    /**
     * Liefert das Muster, welches das Rezept repraesentiert.
     *
     * @return craftingMaterialMuster
     */
    public Material[][] getCraftingMaterialMuster ()
    {
        return this.craftingMaterialMuster;
    }


    /**
     * Die x- und y-Dimensionen eines Material-Musters der Crafting-Rezepte
     */
    public static final int MATERIAL_MUSTER_DIMENSION = 3;

}
