/**
 * @author Rebeca Carvalho
 * @version "11.0.8" 2020-07-14 LTS
 */

package entities;

public class Comida {
	private String nome;
	private float preco;
	private int quantidade = 1;
	
	public Comida() {
	}
	
	public Comida(String nome, float preco, int quantidade) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	
	public Comida(String nome, float preco) {
		quantidade = 1;
		this.nome = nome;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public float getPreco() {
		return preco;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public float precoTotal() {
		return preco * quantidade;
	}

	@Override
	public String toString() {
		return "Comida <Nome: " + nome + ", Preco: " + preco + ", Qnt: " + quantidade + ", Pco Total: " + precoTotal() + ">";
	}
	
}
