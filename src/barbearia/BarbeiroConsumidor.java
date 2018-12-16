package barbearia;

import java.util.Random;

public class BarbeiroConsumidor implements Runnable {
    
    private CadeirasDeEsperaInterface cadeirasEmEspera;
    private int numBarbeiros;
    private Random random = new Random(); 

     //nao precisa destes metodos...
    public int getNumBarbeiros() {
        return numBarbeiros;
    }
    public void setNumBarbeiros(int numBarbeiros) {
        this.numBarbeiros = numBarbeiros;
    }
    
    public BarbeiroConsumidor (CadeirasDeEsperaInterface cadeirasEmEspera) {
	this.cadeirasEmEspera = cadeirasEmEspera;
    }
    public BarbeiroConsumidor () {}
        
    @Override
    public void run() {
	int total = 0;
	 for(int i = 0; i < 5; i++) { // numero de threads
	     try {
		Thread.sleep(random.nextInt(3000));
		total += cadeirasEmEspera.getCliente(); // para verificar se o otal de produtores eh igual ao de consumidores
		System.err.println("\t | Total de Atendimentos: " + total);
                // p/ ver destacado
	     }catch(InterruptedException e) {}
	 }
    }
}
