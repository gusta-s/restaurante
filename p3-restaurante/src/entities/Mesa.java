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

	public Mesa(){
	}
	
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

	public void levantarMesa(){
		if (lugaresVagos < 4) lugares[lugaresVagos++] = null;
	}

	public boolean validarMesa() {
		return (lugaresVagos <= 4 && lugaresVagos > 0) ? true : false;
	}
	
	public void addCliente(Cliente cliente) {
		if (validarMesa()) {
			lugares[--lugaresVagos] = cliente;
		}
	}
	
	public String visualizacaoPontos(boolean x) {
		String dots = "";
		for (Cliente cliente : lugares) {
			if (cliente instanceof Object)	
				dots += " ⬜"; //⬜👨•
		}
		return "[" + dots + " ]";
	}

	@Override
	public String toString() {
		return "Mesa <Lugares Vazios: " + lugaresVagos + ", No: " + numero + ">  " + visualizacaoPontos(true);
	}
	
}
