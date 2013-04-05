package aula01;

public class Menor {
	
	public int encontrar(int[] valores){
		int menor = valores[0];
		int i = 1;
		while(i < valores.length){
			if (valores[i] < menor){
				menor = valores[i];
			}
			
			i++;
		}
		return menor;
	}

}
