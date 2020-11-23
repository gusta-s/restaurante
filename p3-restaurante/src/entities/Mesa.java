/**
 * @author Rebeca Cristina
 * @version "11.0.8" 2020-07-14 LTS
 */

package entities;

public class Mesa {
	private Pedido pedido = new Pedido();
	private Cliente[] lugares = new Cliente[4];
	private int lugaresVagos;
	private int numero;
	private boolean ocupado;
	
	public Mesa(int numero) {
		lugaresVagos = 4;
		this.ocupado = false;
		this.numero = numero;
	}
	
	public Cliente[] getLugares() {
		return lugares;
	}

	public int getLugaresVagos() {
		return lugaresVagos;
	}

	public int getNumero() {
		return numero;
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public boolean getOcupado() {
		return ocupado;
	}
	
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	
	public boolean validarMesa() {
		return (lugaresVagos <= 4 && lugaresVagos > 0) ? true : false;
	}
	
	public void addCliente(Cliente cliente, int lugar) {
		if (validarMesa()) {
			lugaresVagos--;
			lugares[lugar] = cliente;
		}		
	}
	
	public void addCliente(Cliente cliente) {
		if (validarMesa()) {
			lugaresVagos--;
			lugares[lugaresVagos] = cliente;
		}
	}
	
	public void esvaziarMesa() {
		for (int i=0; i<lugares.length; i++)
			lugares[i] = null;
	}
	
	public void mostrarClientesNaMesa() {
		System.out.printf("Cliente(s) na mesa(%d): \n", this.numero);
		for (Cliente cliente : lugares) {
			if (cliente != null)	
				System.out.println(cliente.getNome());
		}
	}

	@Override
	public String toString() {
		return "Mesa <Lugares Vazios: " + lugaresVagos + ", No: " + numero + ">";
	}
	
}
