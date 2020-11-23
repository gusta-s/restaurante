/**
 * @author Lucas Digian
 * @version "11.0.8" 2020-07-14 LTS
 */

package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entities.Caixa;
import entities.Empregado;
import entities.Fila;
import entities.Garcom;
import entities.Mesa;

public class Restaurante {
	
	public static final String[] nomes = new String[] {
			"Gustavo", "Lara", "Marcos", "Rebeca", "Victor", "Lucas", "Soares", "Danielly", "Oliveira", "Cristina", "Emanuel", "Digian",
			"Silva", "Costa", "Carvalho", "Moura", "Santos"
	};  
	
	private List<Mesa> mesas = new ArrayList<Mesa>() {{
			add(new Mesa(1));
			add(new Mesa(2));
			add(new Mesa(3));
			add(new Mesa(4));
			add(new Mesa(5));
	}};
	
	private Random r = new Random();
	private Fila filaEntrada = new Fila();
	
	private Empregado[] garcons = new Empregado[] {new Garcom(this), new Garcom(this)};
	private Caixa[] caixas = new Caixa[] {new Caixa(), new Caixa()};
	
	public Restaurante() {
	}
	
	public String[] getNomes() {
		return nomes;
	}

	public List<Mesa> getMesas() {
		return mesas;
	}
	
	public Fila getFilaEntrada() {
		return filaEntrada;
	}
	
	public Caixa[] getCaixas() {
		return caixas;
	}
	
	public Empregado garcomAleatorio() {
		Empregado garcom = garcons[r.nextInt(garcons.length)];
		return garcom;
	}
	
}
