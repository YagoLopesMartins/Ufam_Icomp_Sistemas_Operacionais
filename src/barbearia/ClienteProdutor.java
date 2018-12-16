package barbearia;

import java.util.Random;

/* */
public class ClienteProdutor implements Runnable {

        /* Cliente compartilha do recurso que são as cadeiras, por isso
            precisa inicializar o objeto compartilhado via construtor */
	private CadeirasDeEsperaInterface cadeirasEmEspera;
	private Random random = new Random(); 
        
        /* Cliente inicializando via construtor o objeto compartilhado "Cadeiras" */
	public ClienteProdutor (CadeirasDeEsperaInterface cadeirasEmEspera) {
		this.cadeirasEmEspera = cadeirasEmEspera;
	}
        /* Gera informações a serem armazenados nas Cadeiras, neste caso,
          gerando 5 clientes nas cadeiras */
	@Override
	public void run() {
		int total = 0; // total de clientes criados
		for(int i = 0; i < 5; i++) { // gerando 5 clientes nas cadeiras
			try {
                                /* Aguardando um periodo inderteminado de tempo, para simular
                                    uma barbearia real, ou seja, uma espera como normalmente acontece,
                                    Ex.: cria-se 5 clientes, depois de um tempo aparece outros clientes */
				Thread.sleep(random.nextInt(3000)); // tempo de 0 a 3 segundos
				total += i;
				cadeirasEmEspera.setCliente(i);  // armazenado/criando nas cadeiras um cliente
				System.out.println("\t | Total de Clientes: " + total); // total de clientes
			}catch(InterruptedException e) {
                        
                        }
		}
	}

}
