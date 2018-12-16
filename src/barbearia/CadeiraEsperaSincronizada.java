package barbearia;

public class CadeiraEsperaSincronizada implements CadeirasDeEsperaInterface{
	private int valor = -1; // valor compartilhado, simulando um cliente
        
        /* criada para que as threads e´perem por determinada condicao para exec metodos get e sets*/
	private boolean cadeiraOcupada = false;
	
        /* Tanto o cliente que chega, quanto o barbeiro atendendo, é feito uma única vez */
	@Override
	public synchronized void setCliente(int valor) throws InterruptedException {
            /**/
		while(cadeiraOcupada ) {
			System.out.println("Cadeiras Lotadas, Por favor, cliente aguarde"); 
			wait(); //  faz a threads ficar aguradando, pois as cadeiras estao ocupadas
		}
		System.out.print("cliente chegou " + valor); // cliente chegou
		this.valor = valor;
		
		cadeiraOcupada = true;
		notifyAll(); // avisa para todas as threds que está liberado
	}
	@Override
	public synchronized int getCliente() throws InterruptedException {
            
		while(!cadeiraOcupada) {
			System.out.println("Cadeiras de espera vazias, Barbeiro pode ir dormir");
                        wait(); // faz barbeiro ir dormir, ou seja, aguardar já que não tem clientes para atender
		}
		System.err.print("Barbeiro atendeu " + valor);  // barbeiro atendendo
                    cadeiraOcupada = false;
                    notifyAll(); // cliente pode chegar, pois, barbeiro atendeu
                    return valor;
	}

}
