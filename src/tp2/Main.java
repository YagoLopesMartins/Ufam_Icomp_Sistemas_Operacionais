package tp2;

import java.util.LinkedList;
import java.util.Scanner;
import tp2.AlgoritmoFifo;
import tp2.AlgoritmoLRU;

/*
    Código em Java que simula os algoritmos de substituição de páginas FIFO, 
    LRU e Segunda Chance. A entrada da cadeia de referências segue o formato: 
    1,0;1,1;2,0;1,1;2,1;3,0;1,3;0,0; que corresponde a sequência de referências à 
    página 0 do processo 1, seguido da página 1 do processo 1, etc.
*/


public class Main {
 public static void main(String[] args) {
  Scanner scanner = new Scanner(System.in);
  String referencia = scanner.nextLine();
  String[] stringReferencia = referencia.split(";");

  // FIFO
  AlgoritmoDeSubstituicao fifo = new AlgoritmoFifo(3);

  for (int i = 0; i < (stringReferencia.length - 1); i++) {
   fifo.inserir(stringReferencia[i]);

  }
  System.out.println("Page Faults: " + fifo.getPageFaultCount());

  // LRU
  AlgoritmoDeSubstituicao lru = new AlgoritmoLRU(3);

  for (int i = 0; i < (stringReferencia.length - 1); i++) {
   lru.inserir(stringReferencia[i]);

  }
  System.out.println("Page Faults: " + lru.getPageFaultCount());

  // SEGUNDA CHANCE
  AlgoritmoDeSubstituicao sc = new AlgoritmoSegundaChance(3);

  for (int i = 0; i < (stringReferencia.length - 1); i++) {
   sc.inserir(stringReferencia[i]);
   // sc.imprimirQuadros();

  }
  System.out.println("Page Faults: " + sc.getPageFaultCount());

 }
}
