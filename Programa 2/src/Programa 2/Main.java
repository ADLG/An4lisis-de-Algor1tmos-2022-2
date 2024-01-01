import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
/**
 * Main para probar el funcionamiento correcto del Programa 2.
 * @author ADLG.
 */
public class Main
{
	public static void main(String[] args)
	{
		Scanner t = new Scanner(System.in);
		System.out.println("\nPrograma para simular la union de dos Conjuntos.\n");
		System.out.println("- Los conjuntos seran representados por listas");
		System.out.println("- Aunque las listas tengan elementos repetidos se\n  les realizara una verificacion"
			+" para que cumplan\n  con la definicion de conjuntos.");
		System.out.println("- Agregara los elementos que contendran las listas A y B, en ese orden.");
		System.out.println("\nA continuacion definira la lista A.");
		List<Integer> lA = new ArrayList<>();
		List<Integer> lB = new ArrayList<>();
		List<Integer> lC = new ArrayList<>();
		List<Integer> lD = new ArrayList<>();
		int a = 0, elemento = 0, opc=0;

		do { try
		{
			lB = agregarListaA(lB,opc,a);
			break;
		}catch (java.util.InputMismatchException ime)
		{
			System.out.println("\n*Porfavor, digite un numero Entero para agregar a la lista.\nSe le regresara al menu...\n");
		}
		} while (true);

		do { try
		{
			lC = agregarListaB(lC,opc,a);
			break;
		}catch (java.util.InputMismatchException ime)
		{
			System.out.println("\n*Porfavor, digite un numero Entero para agregar a la lista.\nSe le regresara al menu...\n");
		}
		} while (true);

		copia(lB,lA);
		copia(lC,lA);
		System.out.println("Estas son las listas con las que se realizara la union A U B");
		System.out.println("Lista A: "+lB+"\tLista B: "+lC);

		
		while (lA.size() != 0)
		{
			lD.add(lA.get(0));
			a = lA.get(0);

			lA = sinRepeticion(lA,a);
		}
		System.out.println("\nResultado:\nA U B = "+lD);
	}


	/**
	 * Metodo que quita las apariciones de cierto elemento de una lista.
	 * @param l Lista que puede que tenga una o varias presencias de un elemento.
	 * @param elem El elemento a quitar de la lista.
	 */
	public static List<Integer> sinRepeticion(List<Integer> l,int elem)
	{
		List<Integer> ll = new ArrayList<>();
		for (int i = 0; i < l.size(); i++)
		{
			if (elem != l.get(i))
			{
				ll.add(l.get(i));
			}	
		}
		return ll;
	}

	/**
	 * Metodo que copia los elementos de una lista a otra.
	 * @param l La lista con los elementos a copiar en l1.
	 * @param l1 La lista con los elementos copiados de l.
	 */
	public static void copia(List<Integer> l,List<Integer> l1)
	{
		for (int i=0; i < l.size(); i++)
		{
			l1.add(l.get(i));
		}
	}	

	/**
	 * Metodo que verifica que la lista sea un conjunto.
	 * @param l La lista con los elementos a copiar en l1.
	 */
	public static List<Integer> comprobarConjunto(List<Integer> l)
	{
		List<Integer> ll = new ArrayList<>();
		int b = 0;
		while (l.size() != 0)
		{
			ll.add(l.get(0));
			b = l.get(0);

			l = sinRepeticion(l,b);
		}
		return ll;
	}	

	/**
	 * Metodo que llenara la lista A desde la terminal.
	 * @param lB La lista A que se llenara con datos desde la terminal.
	 * @param opc Entero que ayudara a elegir opciones del menu.
	 * @param elemento Los enteros a añadir en la lista.
	 */
	public static List<Integer> agregarListaA(List<Integer> lB,int opc,int elemento)
	{
		Scanner t = new Scanner(System.in);
		boolean bol = true;
		while (bol)
		{
		System.out.println("Menu\n1. Agregar elemento a la lista A\n2. Terminar de agregar elementos a la lista");
		opc = t.nextInt();
		switch (opc)
		{
			case 1: 
				elemento = t.nextInt();
				lB.add(elemento);
			break;

			case 2:
				System.out.println("Aplicando definicion de conjunto a la lista A...");
				lB = comprobarConjunto(lB);
				System.out.println("La lista A: "+lB+" cumple con la definicion de Conjunto\n\n");
				bol=false;
			break;

			default:
				System.out.println("Opcion no valida, digite una opcion que aparezca en el Menu.\n");
		}
		}
		return lB;
	}

	/**
	 * Metodo que llenara la lista B desde la terminal.
	 * @param lC La lista B que se llenara con datos desde la terminal.
	 * @param opc Entero que ayudara a elegir opciones del menu.
	 * @param elemento Los enteros a añadir en la lista.
	 */
	public static List<Integer> agregarListaB(List<Integer> lC,int opc,int elemento)
	{
		Scanner t = new Scanner(System.in);
		boolean bole = true;
		System.out.println("A continuacion definira la lista B.");
		while (bole)
		{
		System.out.println("Menu\n1. Agregar elemento a la lista B\n2. Terminar de agregar elementos a la lista");
		opc = t.nextInt();
		switch (opc)
		{
			case 1: 
				elemento = t.nextInt();
				lC.add(elemento);
			break;

			case 2:
				System.out.println("Aplicando definicion de conjunto a la lista B...");
				lC = comprobarConjunto(lC);
				System.out.println("La lista B: "+lC+" cumple con la definicion de Conjunto\n\n");
				bole = false;
			break;

			default:
				System.out.println("Opcion no valida, digite una opcion que aparezca en el Menu.\n");
		}
		}
		return lC;
	}
}