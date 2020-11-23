/**
 * @author Victor Emanuel
 * @version "11.0.8" 2020-07-14 LTS
 */

package entities;

import java.util.Random;

public class Empregado {
	
	private static final String[] nomes = new String[] {"Ritinha", "Rubinho", "Bibi Perigosa", "Eurico"};
	
	private Random r = new Random();
	private String nome;
	private int id;
	
	public Empregado() {
		nome = nomes[r.nextInt(nomes.length)];
		id = r.nextInt(999);
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Atendente <Nome: " + nome + ", ID: " + id + ">";
	}
	
}
