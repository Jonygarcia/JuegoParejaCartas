package auxPackage;

import java.util.Random;

public class RandomCards {

	public int[] getCardNumbers() {
		// Creamos un array para meter los números aleatorios y asignar valores a las cartas entre
		// 1 y 8, y tendremos 2 cartas de cada número.
		int[] numeros = new int[16];
		int count = 0;
		
		while (count < 16) {
			Random random = new Random();
			int numAleatorio = random.nextInt(8) + 1;
			int numPareja = 0;
			
			for(int i = 0; i < numeros.length; i++) {
				if(numeros[i] == numAleatorio) {
					numPareja++;
				}
			}
			if (numPareja < 2) {
				numeros[count] = numAleatorio;
				count++;
			}
			
		}
		
		return numeros;
	}
	
}
