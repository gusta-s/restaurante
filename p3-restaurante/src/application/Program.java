/**
 * @author Gustavo Soares
 * @version "11.0.8" 2020-07-14 LTS
 */

package application;

import java.util.Random;

import entities.Cliente;
import entities.Fila;
import entities.Garcom;
import entities.Mesa;

public class Program {

	public static void main(String[] args) {	
		
		Restaurante res = new Restaurante();
		Random r = new Random();
		
		for (String nome : res.getNomes()) {
			res.getFilaEntrada().addFila(new Cliente(nome));
		}
		
		res.getFilaEntrada().mostarFila();
		adicionarClientes(res, res.getFilaEntrada());
		
		Garcom garcom = (Garcom)res.garcomAleatorio();

		System.out.println(garcom + "\n");
		garcom.percorrerMesas();		
		res.getFilaEntrada().mostarFila();
	
		for (Mesa m : res.getMesas()) {
			for (Cliente c : m.getLugares()) {
				if (c != null) {
					//garcom.mostrarPedidos(c);
					res.getCaixas()[r.nextInt(res.getCaixas().length)].getFila().addFila(c);
				}
			}
			m.esvaziarMesa();
			adicionarClientes(res, res.getFilaEntrada());
		}
		
		for (Mesa m : res.getMesas()) {
			for (Cliente c : m.getLugares()) {
				if (c != null) System.out.println(c);
			}
		}
		
		for (int i=0; i<res.getCaixas().length; i++) {
			System.out.printf("<Fila Caixa %d>: ", i+1);
			res.getCaixas()[i].getFila().mostarFila();
			System.out.println();
		}
		
		for (int i=0; i<res.getCaixas().length; i++) {
			System.out.printf("- Caixa %d\n", i+1);
			for (Cliente c : res.getCaixas()[i].getFila().getFila()) {
				res.getCaixas()[i].pagar(c);
			}
			res.getCaixas()[i].getFila().getFila().clear();
			res.getCaixas()[i].getFila().mostarFila();
			System.out.println();
		}

	}
	
	public static void adicionarClientes(Restaurante res, Fila filaEntrada) {
		for (Mesa mesa : res.getMesas()) {
			while (mesa.validarMesa() && !filaEntrada.getFila().isEmpty()) {
				mesa.addCliente(filaEntrada.getFila().get(0));
				filaEntrada.popFila();
			}
		}
	}

}
