package view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import entities.Restaurante;
import entities.Garcom;
import entities.Mesa;

public class PanelConfig extends JFrame{
	private static JTextArea PCgerais;
	
	public PanelConfig() {
		super("Restaurante PARASITAS");

		PCgerais = new JTextArea("", 100, 100);
		PCgerais.setLineWrap(false);
		PCgerais.setFont(new Font("Cascadia Code", Font.BOLD, 17)); // Font.PLAIN
		
		add(PCgerais, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 550);
        setVisible(true);
	}
	
	public void addMessage(String msg) {
        String text = PCgerais.getText();
		if (text == null || text.length() == 0) {
			PCgerais.setText(msg);
		}
		else {
			PCgerais.setText(PCgerais.getText() + "\n" + msg);
        }
	}
	
	public void printPanel(Restaurante res){
			
		limparPanel();

		addMessage("Fila Entrada: " + res.getFilaEntrada().toString() + "\n"); // mudanca
		System.out.println("Fila Entrada: " + res.getFilaEntrada().toString() + "\n");

		try{
			for (Garcom g : res.getGarcons()) {
				if (g.getMesa() != null){
					Thread.sleep(10);
					addMessage("[GARCOM] " + g.getNome() + " esta na mesa #" + g.getMesa().getNumero() + "\n");
					System.out.println("[GARCOM] " + g.getNome() + " esta na mesa #" + g.getMesa().getNumero() + "\n");
				}
				else{
					Thread.sleep(10);
					addMessage("[GARCOM] " + g.getNome() + " esta ocioso" + "\n");
					System.out.println("[GARCOM] " + g.getNome() + " esta ocioso" + "\n");
				}
			}

			for (Mesa m : res.getMesas()) {
				addMessage(m.toString());
				System.out.println(m.toString());
				Thread.sleep(10);
			}

			for (int i=0; i<res.getCaixas().length; i++){
				Thread.sleep(10);
				addMessage("\nFila Caixa # " + (i+1) + ": " + res.getCaixas()[i].getFila().toString());
			}

		}
		catch(InterruptedException e){
			e.printStackTrace();
		}

		addMessage("\nFila saida: " + res.getFilaSaida().toString());
		System.out.println("\nFila saida: " + res.getFilaSaida().toString());
	}
	
	public void limparPanel() {
		PCgerais.selectAll();
		PCgerais.replaceSelection("");
	}
}
