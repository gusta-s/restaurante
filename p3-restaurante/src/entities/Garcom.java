/**
 * @author Victor Emanuel
 * @version "11.0.8" 2020-07-14 LTS
 */

package entities;

import java.util.Random;

public class Garcom extends Empregado{
	
	private Cardapio cardapio = new Cardapio();
	private Random r = new Random();
	
	private Mesa mesa;
	private Pedido pedido;
	
	public Garcom() {
	}

	public Pedido getPedido() {
		return pedido;
	}

	public Mesa getMesa() {
		return mesa;
	}
	
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	
	public void percorrerMesas(Restaurante restaurante){
		Mesa mesa = restaurante.getMesas().get(r.nextInt(restaurante.getMesas().size()));
		if (!mesa.getOcupado()) {	
			mesa.setOcupado(true);
			setMesa(mesa);
			
			Cliente c = mesa.getLugares()[r.nextInt(mesa.getLugares().length)];
			if ((c instanceof Object) && (!c.getAtendido())){
				c.setAtendido(true);
				for (int i=0; i<r.nextInt(3)+1; i++)
						c.getPedido().addPedido(cardapio.gerarComidaAleatoria());
			}
		}
		mesa.setOcupado(false);
	}
}
