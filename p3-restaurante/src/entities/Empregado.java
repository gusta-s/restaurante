/**
 * @author Victor Emanuel
 * @version "11.0.8" 2020-07-14 LTS
 */

package entities;

import java.util.Random;

public class Empregado extends Pessoa{
	
	private static final String[] nomes = new String[] {"Ritinha", "Rubinho", "Bibi Perigosa", "Eurico"};
	private static Random r = new Random();
	
	public Empregado() {
		super(nomes[r.nextInt(nomes.length)], r.nextInt(999));
	}

	@Override
	public String toString() {
		return "Atendente <Nome: " + getNome() + ", ID: " + getID() + ">";
	}
}
