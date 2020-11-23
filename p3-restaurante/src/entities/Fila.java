/**
 * @author Lara Danielly
 * @version "11.0.8" 2020-07-14 LTS
 */

package entities;

import java.util.ArrayList;

public class Fila{
	private ArrayList<Cliente> fila = new ArrayList<Cliente>();
	
	public Fila() {
	}
	
	public ArrayList<Cliente> getFila() {
		return fila;
	}

	public void popFila() {
		if (!fila.isEmpty())
			fila.remove(0);
		else {
			System.out.println("Fila vazia!");
		}
	}
	
	public void addFila(Cliente cliente) {
		fila.add(cliente);
	}
	
	public void mostarFila() {
		System.out.print("Fila: [");
		for (Cliente cliente : fila) {
			System.out.print(" " + cliente + " ");
		}
		System.out.print("]\n");
	}
}
