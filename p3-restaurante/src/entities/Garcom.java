/**
 * @author Victor Emanuel
 * @version "11.0.8" 2020-07-14 LTS
 */

package entities;

import java.util.Random;

import application.Restaurante;

public class Garcom extends Empregado{
	
	private Cardapio cardapio = new Cardapio();
	private Random r = new Random();
	
	private Restaurante restaurante;
	private Mesa mesa;
	private Pedido pedido;
	
	public Garcom() {
	}
	
	public Garcom(Restaurante restaurante) {
		this.restaurante = restaurante;
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
	
	public void percorrerMesas() {
		for (Mesa mesa : restaurante.getMesas()) {
			System.out.println("==========================================================================");
			if (!mesa.getOcupado() || !mesa.validarMesa()) {	
				System.out.println(mesa);
				this.setMesa(mesa);
				mesa.setOcupado(true);
				
				for (Cliente c : mesa.getLugares()) {
					if (c != null) {
						System.out.printf("(Cliente: %s)\n", c.getNome());
						for (int i=0; i<r.nextInt(3)+1; i++)
							c.getPedido().addPedido(cardapio.gerarComidaAleatoria());
					}
				}
			}
			System.out.println("==========================================================================\n");
		}
	}
	
	public void mostrarPedidos(Cliente cliente) {
		System.out.println("--------------------------------------");
		System.out.println("Pedidos:");
		for (Comida comida : cliente.getPedido().getPedidos()) {
			System.out.format("Pedido: %s\nPco Unid.: %.2f\nQuantidade: %d\nPco Total: %.2f\n", comida.getNome(), comida.getPreco(), comida.getQuantidade(), comida.precoTotal());
		}
		System.out.format("\nTotal: %.2f \n", cliente.getPedido().getPrecoTotal());
		System.out.println("--------------------------------------");
	}
	
}
