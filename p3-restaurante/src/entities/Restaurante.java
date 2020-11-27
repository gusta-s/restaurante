/**
 * @author Lucas Digian
 * @version "11.0.8" 2020-07-14 LTS
 */

package entities;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
	
	private List<Mesa> mesas = new ArrayList<Mesa>() {{
			add(new Mesa(1));
			add(new Mesa(2));
			add(new Mesa(3));
			add(new Mesa(4));
			add(new Mesa(5));
	}};

	private List<Garcom> garcons = new ArrayList<Garcom>() {{
			add(new Garcom());
			add(new Garcom());
	}};

	private Fila filaEntrada = new Fila();
	private Fila filaSaida = new Fila();
	
	private Caixa[] caixas = new Caixa[] {new Caixa(), new Caixa()};
	
	public Restaurante() {
	}

	public List<Mesa> getMesas() {
		return mesas;
	}

	public List<Garcom> getGarcons() {
		return garcons;
	}
	
	public Fila getFilaEntrada() {
		return filaEntrada;
	}
	
	public Fila getFilaSaida() {
		return filaSaida;
	}
	
	public Caixa[] getCaixas() {
		return caixas;
	}
	
}
