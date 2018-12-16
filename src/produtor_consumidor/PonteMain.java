package produtor_consumidor;

public class PonteMain {
	public static void main(String [] args) {
		/*
		Ponte ponte = new PonteNaoSincronizada();
			new Thread(new Produtor(ponte)).start();
			new Thread(new Consumidor(ponte)).start();
		*/
			
		Ponte ponte = new PonteSincronizada();
			new Thread(new Produtor(ponte)).start();
			new Thread(new Consumidor(ponte)).start();
	}
}
