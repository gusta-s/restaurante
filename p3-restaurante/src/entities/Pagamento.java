/**
 * @author Marcos Costa
 * @version "11.0.8" 2020-07-14 LTS
 */

package entities;

public class Pagamento implements IPagamento{
	
	public Pagamento() {
	}

	@Override
	public void realizarPagamento(float valor) {
		//System.out.printf("Pagamento de R$ %.2f realizado com sucesso!\n", valor);
	}

	@Override
	public void realizarPagamento(float valor, float desconto) {
		valor -= valor * (desconto / 100);
		//System.out.printf("Pagamento de R$ %.2f realizado com sucesso [desconto de %.1f%%]!\n", valor, desconto);	
	}
	
}
