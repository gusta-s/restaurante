package entities;

public abstract class Pessoa {
	private String nome;
	private int id;
	
	public Pessoa() {
	}
	
	public Pessoa(String nome, int id) {
		this.nome = nome;
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getID() {
		return id;
	}

	public boolean comparar(Cliente c){
		return ((nome == c.getNome()) && (id == c.getID())) ? true : false;
	}
}
