package de.pk.model.interaktion.effekt;

/**
 * Effekte haben bestimmte Typen die ihre Verarbeitung an bestimmten stellen
 * veraendern. Ein Effekt mit dem Typ "Kaelte" koennte z.B. durch eine waermende
 * Decke entfernt werden, ein Effekt mit dem Typ "Gift" interessiert sich
 * weniger dafuer
 */
public enum EffektTyp
{
	NORMAL, BEWEGUNG;
}
