package com.mycompany.projetoapa;
import java.io.BufferedWriter;
import java.util.Scanner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
      
public static void main(String args[]) throws FileNotFoundException, IOException{

TabelaNotas n = new TabelaNotas();    
ListaCompras l = new ListaCompras();
TabelaT t = new TabelaT();
Busca b = new Busca();
Scanner ler = new Scanner(System.in);

int operacao=1;
    
int[] vetor_compras = new int[l.cont];

for ( int i=0 ; i<= vetor_compras.length-1 ; i++){
    vetor_compras[i] = 999;
}

int produto = 0;
int fornecedor =0;

b.Funcao(produto, fornecedor ,vetor_compras);
 
if ( b.preco_compra_otima != 0 && b.nota_otima != 0 ) {
    
 for ( int j=0; j <= vetor_compras.length-1 ; j++){
     System.out.println( "Fornecedor:"+n.Tabela_NotaM[b.vetor_otimo[j]][0]+" Produto:"+ l.ListaCompras[j][0]+" Qtd:"+ l.ListaCompras[j][1] );
 }
     System.out.println("Avaliação média dos produtos:"+b.nota_otima);
     System.out.println("Preço Total da Compra:"+b.preco_compra_otima);
     
             String[] ListaAvaliacoes = new String[9999];
 
        for ( int i=0; i<= b.vetor_otimo.length-1 ; i++){
        
            for ( int k=0 ; k<= ListaAvaliacoes.length-1 ; k++){
            
            if ( n.Tabela_Notas[b.vetor_otimo[i]][0].equals(ListaAvaliacoes[k]) == true ){
            break;                               // CRIA LISTA DE FORNECEDORES UNICOS
            }  
            if ( ListaAvaliacoes[k]== null){
            ListaAvaliacoes[k] = n.Tabela_Notas[b.vetor_otimo[i]][0];
            break;
            }
            
            }
        }
         
              FileWriter arq = new FileWriter("C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\APA\\ListaNotas.txt",true);
              BufferedWriter Writer = new BufferedWriter(arq);
              
              int y=0;
              while ( ListaAvaliacoes[y] != null){
                  
               System.out.println("Digite uma nota de 1 a 5 para o fornecedor:"+ListaAvaliacoes[y]);   
               int nota = ler.nextInt();
               
              String inserir = ListaAvaliacoes[y]+","+nota;
              
              Writer.newLine();
              Writer.write(inserir);
              
              y++;    
              }
        
              Writer.close();
     
 }
 else
         System.out.println("Não é possível efetuar a compra com o orçamento determinado.");
         System.out.println("Se deseja tentar novamente, execute o programa novamente com outro valor.");
   
}
    
}
