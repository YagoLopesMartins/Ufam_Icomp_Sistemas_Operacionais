/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import java.util.LinkedList;

/**
 *
 * @author RUBSON
 */
public class AlgoritmoFifo extends AlgoritmoDeSubstituicao{
    private static int INSERCAO = 0;

 public AlgoritmoFifo(int numeroDeQuadros) {

  super(numeroDeQuadros);
  this.quadros = new LinkedList();
 }

 @Override
 public void inserir(String pageNumber) {
  // antes de inserir, checar se a pagina ja esta na lista
  if (!quadros.contains(pageNumber)) {

   // se a quantidade de paginas na memoria for menor que o numero de
   // quadros
   // ou seja, ainda ha espaco
   if (quadros.size() < numeroDeQuadros) {
    quadros.add(pageNumber);
   } else {
    quadros.remove(INSERCAO);
    quadros.add(INSERCAO, pageNumber);
    INSERCAO++;
    if (INSERCAO == numeroDeQuadros) {
     INSERCAO = 0;
    }
   }
   numeroDeFalhas++;

  }
 }
}
