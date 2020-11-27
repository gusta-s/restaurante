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

	public Cliente popFila() {
		Cliente c;
		if (!fila.isEmpty()){
			c = fila.get(0);
			fila.remove(0);
			return c;
		}
		System.out.println("Fila vazia!");
		return null;
	}
	
	public void addFila(Cliente cliente) {
		fila.add(cliente);
	}
	
	public void mostrarFila() {
		System.out.print("[ ");
		for (Cliente cliente : fila) {
			if (cliente != null)	
				System.out.print(cliente + " ");
		}
		System.out.print("]\n");
	}
	
	public String mostrarFila(boolean x) {
		String pessoasNaFila = "";
		int cont = 0;
		for (Cliente cliente : fila) {
			if (cliente instanceof Object){
				cont++;	
				pessoasNaFila += " ⬜"; //⬜👨•
			}
			if (cont >= 15){
				return 	"[ " + pessoasNaFila + " . . . ][" + fila.size() + "]";
			}
		}
		return pessoasNaFila != "" ? "[ " + pessoasNaFila + " ][" + fila.size() + "]" : "Fila Vazia!";
	}
	
	@Override
	public String toString() {
		return mostrarFila(true);
	}
}
