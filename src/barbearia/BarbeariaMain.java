package barbearia;

import java.util.Scanner;

public class BarbeariaMain {
    
	public static void main(String [] args) {
            /*
            Scanner input = new Scanner(System.in);
            BarbeiroConsumidor bc = new BarbeiroConsumidor();
            
             int i = 0;
                while(i != -1){
                    System.out.println("Bem bindo a Barbearia Los Cubanos in EUA");
                    System.out.println("Quantos barbeiros: ");
                    int qtdB = input.nextInt();
                    bc.setNumBarbeiros(qtdB);
                }
            */
         CadeirasDeEsperaInterface cadeiraEspera = new CadeiraEsperaSincronizada();
			new Thread(new ClienteProdutor(cadeiraEspera)).start();
			new Thread(new BarbeiroConsumidor(cadeiraEspera)).start();
	}
}
