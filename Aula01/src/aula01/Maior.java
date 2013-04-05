package aula01;

public class Maior {
	
	public int encontrar(int[] valores){
		int maior = valores[0];
		int i = 1;
		while(i < valores.length){
			if (valores[i] > maior){
				maior = valores[i];
			}
			
			i++;
		}
		return maior;
	}

}
