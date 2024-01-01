import java.util.Scanner;
/**
 * Main para probar el funcionamiento correcto del Programa 3.
 * @author ADLG.
 */

public class Main
{
	public static void main(String[] args)
	{
		Scanner t = new Scanner(System.in);
		int tam=0; Double e;
		System.out.println("\nPrograma para encontrar la subsecuencia aumentante con mayor numero de elementos de una secuencia S.\n");
		System.out.println("Ingrese la cantidad de elementos de la secuencia");
		do { try
		{
        	tam = t.nextInt();
        	break;
        }catch(java.util.InputMismatchException ime)
        {
            System.out.println("Ingrese un numero entero, si ingresa un numero negativo se tomara el valor absoluto de este"); 
			t.nextLine();
        }
		}while (true);

		if (tam<0)
			tam*=-1;

		Double [] array = new Double[tam];
		System.out.println("Ingrese los elementos:");
		for (int ite = 0; ite<tam; ite++)
		{
			e = t.nextDouble();
			array[ite] = e;
		}

		Integer [] previo = new Integer[array.length];
		Integer [] longitud = new Integer[array.length];
		int sarr, slong;

		for (int i=0; i<array.length; i++)
		{
			previo[i] = 0;	
			longitud[i] = 0;
		}

		longestIncreasingSubsequence(array,longitud,previo);
		sarr=array.length; slong=longitud.length;

		System.out.print("\nSecuencia:    ");
		imprimeListaS(array,sarr);
		System.out.println();
		System.out.print("\nSubsecuencia: ");
		imprimeSecuencia(longitud,array,slong);
		System.out.println();
	}

	/**
	 * Metodo para imprimir la Secuencia S.
	 * @param array el arreglo con los elementos de la secuencia.
	 * @param sarr el tamaño del arreglo array.
	 */
	public static void imprimeListaS(Double [] array, int sarr)
	{
		for (int i=0; i<sarr; i++)
		{
			System.out.print(array[i]+"\t");
		}
	}


	/**
	 * Metodo para imprimir la subsecuencia aumentante con mayor numero de elementos de S.
	 * @param array el arreglo con los elementos de la secuencia.
	 * @param longitud el arreglo de elementos de la subsecuencia que termina en xi.
	 * @param previo los elementos que preceden a xi.
	 */
	public static void imprimeSecuencia(Integer [] longitud, Double [] array, int slong)
	{
		int n=1;
		for (int i=0; i<slong; i++)
		{
			if (longitud[i]==n)
			{
				System.out.print(array[i]+"\t");
				n++;
			}
		}
	}

	/**
	 * Metodo que calcula la secuencia aumentante mas larga.
	 * @param array la subsecuencia que se ingreso.
	 * @param longitud el arreglo de elementos de la subsecuencia que termina en xi.
	 * @param previo los elementos que preceden a xi.
	 */
	public static void longestIncreasingSubsequence(Double [] array, Integer [] longitud, Integer [] previo)
	{
		longitud[0] = 1;
		previo[0] = 0;

		int max, tam;
		tam = array.length;
		double elemento;
		boolean conj;

		boolean [] ext = new boolean[tam];

		for (int i=1; i<tam; i++)
		{
			elemento = array[i];
			conj = false;

			for (int j=0; j<i; j++)
			{
				if (array[j] < elemento)
				{
					ext[j] = true;
					conj = true;
				}
			}
			
			if (conj)
			{
				max = indiceMaxLong(ext,longitud);
				longitud[i] = longitud[max]+1;
				previo[i] = max;	
			}
			else
			{
				longitud[i] = 1;
				previo[i] = 0;
			}
		}
	}

	/**
	 * Metodo que obtiene el indice de maxima longitud.
	 * @param ext es una representacion del conjunto del algoritmo longestIncreasingSubsequence(S), en este caso de booleanos.
	 * @param longitud el arreglo de elementos de la subsecuencia que termina en xi.
	 * @return el indice de maxima longitud.
	 */
	public static int indiceMaxLong(boolean [] ext,Integer [] longitud)
	{
		int index, length;
		index = length = 0;

		for (int i=0; i<ext.length; i++)
		{
			if (ext[i])
			{
				if (length < longitud[i])
				{
					index = i;
					length = longitud[i];
				}
			}
		}
		return index;
	}

}
