import java.util.Scanner;
/**
 * Main para probar el funcionamiento correcto del Programa 1.
 * @author ADLG.
 */
public class Main
{
	public static void main(String[] args)
	{
		Scanner t = new Scanner(System.in);
		System.out.println("\n*Programa para calcular las soluciones para un entero n no negativo donde se cumpla que x\u00B2 + y\u00B2 < n.*"+
			"\nDigite el entero para el cual se quiere encontrar sus soluciones:");
		int entero = t.nextInt();
		problema(entero);
	}

	/**
	 * Metodo que genera las soluciones x & y acorde al parametro m recibido.
	 * @param m El entero n no negativo para el cual se quiere generar sus soluciones.
	 */
	public static void problema(int m)
	{
		int a=1, b=0,c=0, n = m, ax=0;
		if (n == 1)
		{
			System.out.println("No hay soluciones que cumplan x\u00B2 + y\u00B2 < 1");
		}
		else if (n == 2)
		{
			System.out.println("No hay soluciones que cumplan x\u00B2 + y\u00B2 < 2");
		}
		else
		{
			System.out.println("Las soluciones son las siguientes:\n");
			for (int k = 1; a<n; k++)
			{
				for (int i = 1; i<n; i++)
				{
					b = potencia(i);
					c = potencia(a);
					ax = b+c;
					if (ax < n)
					{
						System.out.println("("+a+","+i+")"+" Es decir, con x = "+a+", y = "+i+" se cumple: "+a+"\u00B2 + "+i+"\u00B2 < "+n);	
					}
				}
				a++;
			}
		}
	}

	/**
	 * Metodo que realiza el cuadrado de un numero.
	 * @param n El numero al cual se le quiere calcular su cuadrado.
	 */
	public static int potencia(int n)
	{
		return (n*n);
	}
}
