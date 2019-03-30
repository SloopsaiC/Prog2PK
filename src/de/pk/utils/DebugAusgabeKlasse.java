package de.pk.utils;


/**
 *
 * @author Dylan
 */
public abstract class DebugAusgabeKlasse
{

    private static boolean ausgabeAktiv = false;

    public static void ausgeben (String info)
    {
        if (ausgabeAktiv)
        {
            System.out.println(info);
        }
    }


    public static void setAusgabeAktiv (boolean setzeAusgabeAktiv)
    {
        ausgabeAktiv = setzeAusgabeAktiv;
    }


//    // Test-Main
//    public static void main (String[] args)
//    {
//        DebugAusgabeKlasse.setAusgabeAktiv(true);
//
//        Held derHeroische = new Held("Der Heroische", 10, 5);
//        ausgeben("Held: Ich bin " + derHeroische.getName());
//
//        Gegner derBoese = new Gegner(2, 4, 1);
//
//        derHeroische.agiere(new Aktion(), derHeroische);
//
//        derBoese.sterben();
//        derHeroische.sterben();
//        derHeroische.sterben();
//
//    }
}
