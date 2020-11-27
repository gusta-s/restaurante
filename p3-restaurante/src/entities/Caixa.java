/**
 * @author Lara Danielly
 * @version "11.0.8" 2020-07-14 LTS
 */

package entities;

import java.util.Random;

public class Caixa {//implements Runnable{
	
	private static final int[] chances = new int[] {0,0,0,1,0}; // 20%
	private Random r = new Random();
		
	private Pagamento pagamento = new Pagamento();
	private Fila fila = new Fila();
	
	public Caixa() {
		fila = new Fila();
		pagamento = new Pagamento();
	}

	public Fila getFila() {
		return fila;
	}
	
	public void pagar(Cliente cliente){
		float preco = cliente.getPedido().getPrecoTotal();

		if (chances[r.nextInt(chances.length)] == 1) {
			this.pagamento.realizarPagamento(preco, r.nextInt(20));
		}
		else {		
			this.pagamento.realizarPagamento(preco);
		}
		cliente.getPedido().removerPedido();
	}
}
