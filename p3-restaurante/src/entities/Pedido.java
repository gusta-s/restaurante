/**
 * @author Marcos Costa
 * @version "11.0.8" 2020-07-14 LTS
 */

package entities;

import java.util.ArrayList;

public class Pedido {
	private ArrayList<Comida> pedidos = new ArrayList<Comida>();	
	
	public Pedido() {
		pedidos = new ArrayList<Comida>();
	}

	public void addPedido(Comida comida) {
		pedidos.add(comida);
	}
	
	public ArrayList<Comida> getPedidos() {
		return pedidos;
	}
	
	public void removerPedido() {
		pedidos.clear();
	}
	
	public float getPrecoTotal() {
		float precoTotal = 0;
		for (Comida comida : pedidos) {
			precoTotal += comida.precoTotal();
		}
		return precoTotal;
	}
}
