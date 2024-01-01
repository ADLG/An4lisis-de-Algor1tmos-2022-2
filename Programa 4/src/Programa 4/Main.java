import java.util.Scanner;
/**
 * Main para probar el funcionamiento correcto del Programa 4.
 * @author ADLG.
 */

public class Main
{
	public static void main(String[] args)
	{
		Scanner t = new Scanner(System.in);
		float [] array;
		System.out.println("\n\t\t*** Programa 4 ***\n\nIngrese el valor k entre 1 y 20.");
		int k=0; float x=0;

		k = valorK(k);

    	array = arregloRandom(k);

		mergeSort(array,array.length);

		System.out.print("\nEste es el arreglo ordenado:");
		imprimeArreglo(array);
		System.out.print("\nDigite la x que quiere encontrar:\n\n");

		x = valorX(x);

		detSuma(array,x);
	}

	/**
	 * Metodo que verificara si es que existen 2 elementos cuya suma sea x.
	 * @param a El arreglo aleatorio con los numeros reales generados aleatoriamente.
	 * @param valor El valor x a encontrar.
	 */
	public static void detSuma(float[] a, float valor) 
	{	
	    int i = 0;
	    int j = a.length - 1;
	    boolean solucion=false;
	    while(i<j)
	    {
	        if(a[i]+a[j] == valor)
	        {
	        	solucion = true;
	    		break;
	    	}
	        else if(a[i]+a[j] > valor)
	            {j--;}
	        else
	            {i++;}
	    }

	    if (solucion)
	    	{System.out.println("Si hay solucion: "+a[i]+" + "+a[j]+" = "+valor);}
	    else
	    	{System.out.println("No hay solucion");}
	}

	/**
	 * Metodo para generar un arreglo con numeros reales aleatorios.
	 * @param k El valor que determinara el tamaño del arreglo.
	 */
	public static float [] arregloRandom(int k)
	{
		float elemento;
    	k*=50;
    	float [] array = new float[k];

    	for (int i = 0; i < k ; i++)
    	{
    	  elemento = (float) Math.round(Math.random() * k);
    	  elemento*=1.12;
    	  array[i]=elemento;
    	}

    	System.out.println("Este es el arreglo con numeros aleatorios:");

		imprimeArreglo(array);

    	return array;
	}

	/**
	 * Metodo para verificar que el valor k esta entre los limites de 1 y 20.
	 * @param k El valor que definira el tamaño del arreglo.
	 */
	public static int valorK(int k)
	{
		Scanner t = new Scanner(System.in);
		do {
		try
		{
			k = t.nextInt();
			do {
			if (k<1 || k>20)
			{
				System.out.println("*Porfavor, digite un numero Entero entre 1 y 20");
				k = t.nextInt();
			}
			else
			{
				break;
			}
			} while (true);

			break;
		}catch (java.util.InputMismatchException Ime)
		{
			System.out.println("\n*Porfavor, digite un numero Entero.");
			t.next();
		}
		}while (true);
		return k;
	}

	/**
	 * Metodo para verificar que el valor x a buscar sea del tipo pedido.
	 * @param x El valor a encontrar en el arreglo.
	 */
	public static float valorX(float x)
	{
		Scanner t = new Scanner(System.in);
		do {
		try
		{
			x = t.nextFloat();
			break;
		}catch (java.util.InputMismatchException Ime)
		{
			System.out.println("\n*Porfavor, digite un numero Entero.");
			t.next();
		}
		}while (true);
		return x;
	}

	/**
	 * Metodo que imprime un arreglo para que se vea de forma correcta.
	 * @param a El arreglo con los elementos a imprimir.
	 */
	public static void imprimeArreglo(float[] a)
	{
		int cont = 0;
		System.out.print("[");
    	for (float e: a)
    	{
    		System.out.print(e+",");
    		cont++;
    		if (cont == a.length)
    		{
    			System.out.print(e);
    		}
    	}
    	System.out.print("]\n");
	}

	/**
	 * MergeSort, algoritmo que ordena el arreglo de n elementos.
	 * @param a El arreglo con los elementos del conjuto S.
	 * @param n El tamaño del arreglo.
	 */
	public static void mergeSort(float[] a, int n)
	{
    	if (n < 2)
    	{return;}

    	int mid = n / 2;
    	float[] l = new float[mid];
    	float[] r = new float[n - mid];
	
    	for (int i = 0; i < mid; i++)
    	{
    	    l[i] = a[i];
    	}
    	for (int i = mid; i < n; i++)
    	{
    	    r[i - mid] = a[i];
    	}

    	mergeSort(l, mid);
    	mergeSort(r, n - mid);
	
    	merge(a, l, r, mid, n - mid);
	}

	/**
	 * Metodo merge para ordenar los elementos del arreglo.
	 * @param a el arreglo con los elementos del conjuto S.
	 * @param l Elementos centinela de la parte izquierda.
	 * @param r Elementos centinela de la parte derecha.
	 * @param left Elemento minimo left.
	 * @param right Elemento minimo right.
	 */
	public static void merge(float[] a, float[] l, float[] r, int left, int right)
	{
    	int i = 0, j = 0, k = 0;
    	while (i < left && j < right)
    	{
    	    if (l[i] <= r[j])
    	    {
    	        a[k++] = l[i++];
    	    }
    	    else
    	    {
    	        a[k++] = r[j++];
    	    }
    	}
    	while (i < left)
    	{
    	    a[k++] = l[i++];
    	}
    	while (j < right)
    	{
    	    a[k++] = r[j++];
    	}
	}

}
