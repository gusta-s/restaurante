/**
 * @author Gustavo Soares
 * @version "11.0.8" 2020-07-14 LTS
 */

package entities;

import java.util.Random;

public class Cardapio {
	
	private static int[] chance = new int[] {0,1,0}; // 33.3%
	
	private Comida comida = new Comida();
	private Random r = new Random();

	private float precos[] = new float[] {14.99f, 20.0f, 35.5f, 59.99f, 4.99f, 2.5f, 6.0f, 16.5f};
	private String nomes[] = new String[] {"Carne", "Peixe", "Hamburguer", "Bufalo", "Breja", "Agua", "Coquinha gelada hummm", "Vegan"};
	
	public Cardapio() {
	}
	
	public float[] getPrecos() {
		return precos;
	}
	
	public String[] getNomes() {
		return nomes;
	}
	
	public Comida gerarComidaAleatoria() {
		int opcao = r.nextInt(precos.length);
		
		if (chance[r.nextInt(chance.length)] == 1)
			comida = new Comida(nomes[opcao], precos[opcao]);
		else
			comida = new Comida(nomes[opcao], precos[opcao], r.nextInt(4)+1);
		
		System.out.println(comida);
		return comida;
	}
}
