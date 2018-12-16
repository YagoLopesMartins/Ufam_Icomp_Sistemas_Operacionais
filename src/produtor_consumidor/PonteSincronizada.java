package produtor_consumidor;

public class PonteSincronizada implements Ponte{
	
	// exemplo da impressora
	private int valor = -1;
	private boolean ponteocupada = false;
	
	/**/

	@Override
	public synchronized void set(int valor) throws InterruptedException {
		
		/**/
		
		while(ponteocupada ) {
			System.out.println("Ponte vazia, Produdor agurade");
			wait();
		}
		
		System.out.println("Produtor produziu " + valor);
		this.valor = valor;
		
		ponteocupada = true;
		notifyAll();
	}

	@Override
	public synchronized int get() throws InterruptedException {
		while(!ponteocupada) {
			System.out.println("Ponte vazia, Consumidor agurade");
		}
		System.err.println("Consumidor consumiu " + valor);
		
		ponteocupada = false;
		notifyAll();
		return valor;
	}

}
