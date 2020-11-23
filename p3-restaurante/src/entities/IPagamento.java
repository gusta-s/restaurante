/**
 * @author Lucas Digian
 * @version "11.0.8" 2020-07-14 LTS
 */

package entities;

public interface IPagamento {
	void realizarPagamento(float valor);
	void realizarPagamento(float valor, float desconto);
}
