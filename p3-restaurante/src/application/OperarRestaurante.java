/**
 * @author Gustavo Soares
 * @version "11.0.8" 2020-07-14 LTS
 */

package application;

import java.io.IOException;
import java.util.Random;
import entities.Restaurante;

import entities.Cliente;
import entities.Garcom;
import entities.Mesa;
import view.PanelConfig;

public class OperarRestaurante {
	private static PanelConfig pc = new PanelConfig();
	private static Restaurante res = new Restaurante();
    private static Random r = new Random();
    
    public OperarRestaurante() throws InterruptedException{
        while (true) {
			new Thread(chegarRestaurante).start();
			new Thread(checarMesa).start();
			new Thread(pagamento).start();
			new Thread(sair).start();
			Thread.sleep(2000);
			clearConsole();
			pc.printPanel(res);
		}
    }

	private static Runnable chegarRestaurante = new Runnable() {
		public void run() {
			try{
				for (int i=0; i<r.nextInt(4) + 1; i++){
					res.getFilaEntrada().addFila(new Cliente());
					Thread.sleep(10);	
				}
			}
			catch(InterruptedException e){e.printStackTrace();}

			for (Mesa m : res.getMesas()){
				if (m.validarMesa() && !res.getFilaEntrada().getFila().isEmpty()){
					m.addCliente(res.getFilaEntrada().popFila());
				} 
			}
		}
	};

	private static Runnable checarMesa = new Runnable() {
		public void run() {
			for (Garcom g : res.getGarcons()){
				try{
					g.percorrerMesas(res);
					Thread.sleep(3000);
				}
				catch(InterruptedException e){e.printStackTrace();}
			}

			for (Mesa m : res.getMesas()) {
				for (Cliente c : m.getLugares()) {
					if (c != null && c.getAtendido()) {
						try{
							Thread.sleep(2000);
							res.getCaixas()[r.nextInt(res.getCaixas().length)].getFila().addFila(c);
							m.levantarMesa();
						}
						catch(InterruptedException e){e.printStackTrace();}	
					}
				}
			}
		}
	};

	private static Runnable pagamento = new Runnable() {
		public void run() {

			int caixa = r.nextInt(res.getCaixas().length);
			int qntSaida = r.nextInt(7) + 1;
			if (res.getCaixas()[caixa].getFila().getFila().size() >= qntSaida){
				for (int i=0; i<qntSaida; i++){
					Cliente c = res.getCaixas()[caixa].getFila().popFila();
					if (c != null){
						try{
							Thread.sleep(100);
							res.getCaixas()[caixa].pagar(c);
							res.getFilaSaida().addFila(c);
						}
						catch(InterruptedException e){e.printStackTrace();}	
					}
				}
			}
		}
	};

	private static Runnable sair = new Runnable() {
		public void run() {
			try{
				int qntSaida = r.nextInt(4) + 1;
				if (!res.getFilaSaida().getFila().isEmpty()){
					if (res.getFilaSaida().getFila().size() >= qntSaida){
						for (int i=0; i<qntSaida; i++){
							res.getFilaSaida().popFila();
						}
					}
					else{
						res.getFilaSaida().popFila();
					}
				}
				Thread.sleep(2000);
			}
			catch(InterruptedException e){e.printStackTrace();}
		}
	};

	public static void clearConsole() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			}
			else {
				System.out.print("\033\143");
			}
		} catch (IOException | InterruptedException ex) {}
	}
}
