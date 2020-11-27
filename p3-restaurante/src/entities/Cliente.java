/**
 * @author Lucas Digian
 * @version "11.0.8" 2020-07-14 LTS
 */

package entities;

import java.util.Random;

public class Cliente extends Pessoa{
	private static Random r = new Random();
	private Pedido pedido;
	private boolean atendido, atendidoCaixa;

	public static final String[] nomes = new String[] {
		"Gustavo", "Lara", "Marcos", "Rebeca", "Victor", "Lucas", "Soares", "Danielly", "Oliveira", "Cristina", "Emanuel", "Digian",
		"Silva", "Costa", "Carvalho", "Moura", "Santos"
	};
	
	public Cliente() {
		super(nomes[r.nextInt(nomes.length)], r.nextInt(999));
		pedido = new Pedido();
		//atendido = false;
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public void addPedido(Comida c) {
		pedido.addPedido(c);
	}

	public boolean getAtendido(){
		return atendido;
	}

	public void setAtendido(boolean atendido){
		this.atendido = atendido;
	}

	public boolean getAtendidoCaixa(){
		return atendidoCaixa;
	}

	public void setAtendidoCaixa(boolean atendidoCaixa){
		this.atendidoCaixa = atendidoCaixa;
	}

	@Override
	public String toString() {
		return getNome();
	}
}
