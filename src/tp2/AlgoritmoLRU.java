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
public class AlgoritmoLRU extends AlgoritmoDeSubstituicao{
    public AlgoritmoLRU(int numeroDeQuadros) {
  super(numeroDeQuadros);
  // TODO Auto-generated constructor stub
  this.quadros = new LinkedList();

 }

 @Override
 public void inserir(String pageNumber) {
  // TODO Auto-generated method stub
  int tmp = quadros.indexOf(pageNumber);
  if (tmp == -1) {

   if (quadros.size() < numeroDeQuadros) {
    quadros.add(pageNumber);
   } else {

    quadros.remove(0);
    quadros.add(pageNumber);
   }
   numeroDeFalhas++;

  } else {
   quadros.remove(tmp);
   quadros.add(pageNumber);
  }
 }
}
