/**
 * 
 */
package tp5;

/**
 * @author utilisateur
 *
 */
public class Facto2 {

	
	
	public static long factorielle (int n) throws EntierNegatifException,
	TropGrandException{ 
		if (n<0)
			throw new EntierNegatifException("l'entier doit �tre positif");
		if (n>20)
			throw new TropGrandException ("�valuation impossible");
		if (n==0) return 1 ; else return ( n*factorielle(n-1) ) ; 
	}
}

