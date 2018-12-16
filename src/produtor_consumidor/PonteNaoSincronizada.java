package produtor_consumidor;

public class PonteNaoSincronizada implements Ponte {
	
	private int valor = -1;

	@Override
	public void set(int valor) throws InterruptedException {
		System.out.print("Produtor produziu " + valor); // cliente chegou
		this.valor = valor;
	}

	@Override
	public int get() throws InterruptedException {
		System.err.print("Consumidor consumiu " + valor); // barbeiro atendendo
		return valor;
	}

}
