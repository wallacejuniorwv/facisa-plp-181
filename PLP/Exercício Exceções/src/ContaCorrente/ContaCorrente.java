package ContaCorrente;

public class ContaCorrente {

	private float limite;
	private float saldo;
	private float valorLimite = 800;

	public void sacar(float valor) {
		if(valor <= 0) {
			throw new IllegalArgumentException("� necessario um valor de saque");
		}else if (valor > valorLimite) {
			throw new IllegalArgumentException("Valor solicitado maior que o disponivel para saque");
		} else if (valor > limite) {
			try {
				throw new SaldoInsuficienteException("Valor solicitado maior que o disponivel");
			} catch (SaldoInsuficienteException e) {
				System.out.println("Valor de saldo: " + limite);
			}
		}
		this.limite -= valor;
	}

	public void depositar(float valor) {
		if(valor <= 0) {
			throw new IllegalArgumentException("� necessario algum valor de deposito");
		}
		this.limite += valor;
	}

	public void setValorLimite(float valorLimite) {
		this.valorLimite = valorLimite;
	}

}