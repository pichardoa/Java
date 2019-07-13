////////////////////////////////////////////////////////////////////////////////////////////////
//
//Este programa permite al usuario añadir una o varias notas hasta un máximo de 10 notas.
//Permite ver la media entre dichas notas, ver el total de aprobados y ver en orden creciente,
//cuales son las notas introducidas previamente.
//
////////////////////////////////////////////////////////////////////////////////////////////////

package clase;
import java.util.Scanner;

public class Notas {
	
	private static Scanner teclado;

	static int i, j, k, n, med, aux;
	static int aprobs = 0;
	static int notasCont= 0 ;
	static int suma = 0;
	static int [] notas = new int [10];
	
	
	public static void main(String[] args) {
		
		teclado = new Scanner(System.in);
		
		menu();
		
		}
	
	private static void pinta(String arg) {
		System.out.println(arg);
	}


	private static void menu() {
		
		pinta("\nMENU:\n(1) Añadir nota\n(2) Ver la media\n(3) Ver total aprobados\n(4) Ver notas introducidas\n(5) Salir");
		
		do {
			n = teclado.nextInt();
			
			switch(n){
			case 1:
				añadirN();
				menu();
				break;
							
			case 2:
				pinta("La media es de: " + media());
				menu();
				break;
				
			case 3:
				pinta("El total de aprobados es: " + aprobs);
				menu();
				break;
				
			case 4:
				notasOrd();
				menu();
				break;
			
			case 5:
				pinta("Saliendo..");
				break;
				
			default:
				pinta("No válido");
				menu();
				break;
			}
		} while (n!=5);
	}

	
	private static void añadirN() {
		if(notasCont<10) {
			pinta("\nIntroduce la nota:");
			n = teclado.nextInt();
			notas[notasCont] = n;
			suma = suma + n;
			notasCont = notasCont + 1;
			if (n>=5) {
				aprobs = aprobs + 1;
			}
						
		}else pinta("No más notas");
	}
	
	private static int media() {
		med = suma / notasCont;
		return med;
	}
	
	private static void notasOrd() {
		
		int []notasOrd = new int [notasCont];
		for (i=0; i < notasCont; i++) {
			if (notas[i] > 0) {
				notasOrd[i] = notas[i];
			}
			
		}
		for (i = 0; i < notasCont-1; i++) {
			for (j = 0; j < notasCont-1; j++) {
				if (notasOrd[j] > notasOrd[j + 1]) {
					k = notasOrd[j];
					notasOrd[j] = notasOrd[j + 1];
					notasOrd[j + 1] = k;
				}
			}
		}
		pinta("\nNotas ordenadas");
		for (i=0; i<notasCont; i++) {
			System.out.println(notasOrd[i]);
		}
	}

}
