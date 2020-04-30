/**
 * 
 */
package com.covid.Spring.tools;

/**
 * @author Thomas
 *
 */
public enum PaysCsv {
	ISOCODE2(2), ISOCODE3(3), NOMPAYSFR(4), NOMPAYSEN(5);

	public final int indice;

	/**
	 * Indice de la colonne dans le csv (ex : le nom du pays en francais est
	 * accessible à l'indice 4)
	 * 
	 * @param i
	 */
	PaysCsv(int i) {
		indice = i;
	}
}
