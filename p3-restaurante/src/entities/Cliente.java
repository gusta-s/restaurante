/**
 * @author Lucas Digian
 * @version "11.0.8" 2020-07-14 LTS
 */

package entities;

public class Cliente {
	private String nome;
	private Pedido pedido;
	
	public Cliente() {
		pedido = new Pedido();
	}
	
	public Cliente(String nome) {
		this.nome = nome;
		pedido = new Pedido();
	}
	
	public String getNome() {
		return nome;
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public void addPedido(Comida c) {
		pedido.addPedido(c);
	}

	@Override
	public String toString() {
		return nome;
	}
}
