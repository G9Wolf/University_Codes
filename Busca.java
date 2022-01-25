package com.mycompany.projetoapa;
import java.util.Scanner;

import java.io.FileNotFoundException;

public class Busca {
  
    int[] vetor_otimo;
    float nota_otima=0;
    float preco_compra_otima=0;
    float valor_temp=0;
    
    float Valor_Limite;
    
    public Busca() throws FileNotFoundException{
        
    Scanner ler = new Scanner(System.in);
        
    ListaCompras l = new ListaCompras();     
    
    vetor_otimo = new int[l.cont];     
    
    System.out.println("Digite qual o valor máximo da compra."); 
    Valor_Limite = ler.nextFloat();
    
    }
    
    void Funcao ( int produto, int fornecedor, int[] vetor) throws FileNotFoundException{  // FUNÇÃO RECURSIVA QUE ESTRUTURA A ARVORE DE POSSIBILIDADES
        TabelaNotas n = new TabelaNotas();     //[FORNECEDOR][NOTAM]
        ListaCompras l = new ListaCompras();   //[ITEM][QTD]
        TabelaT t = new TabelaT();   //  [FORNECEDOR][PRODUTO][VALOR][NOTAMEDIA]
        int cont=0;
        
        if ( produto > vetor.length-1){  // SE TODOS PRODUTOS FORAM ESCOLHIDOS
            return;
        }
        
        if (fornecedor > n.Tabela_NotaM.length-1 ){
            return;
        }
        
        for ( int i=0 ; i<= t.Tabela_T.length-1; i++ ){

            if ( ((l.ListaCompras[produto][0] .equals(t.Tabela_T[i][1]) == true) && (n.Tabela_NotaM[fornecedor][0].equals(t.Tabela_T[i][0]) == true))) {  // PROCURA A LINHA Q POSSUI O ITEM / FORNECEDOR DESEJADOS
             
             vetor[produto] = fornecedor;  //guarda o fornecedor que foi pego para o produto 
             
             valor_temp = valor_temp+ Float.parseFloat(t.Tabela_T[i][2]);
             
             if ( valor_temp > Valor_Limite){
                 return;                        // SE A COMPRA PARCIAL PASSAR DO VALOR LIMITE, FAZ O DESCARTE EM MASSA
             }
             valor_temp=0;
             
             int cont_itens=0;
             for ( i=0 ; i<= vetor.length-1 ; i++){  // VERIFICA SE NESTE RAMO, ENCONTRAMOS UMA COMPRA VIAVEL
                if ( vetor[i] != 999){
                    cont_itens++;   
                 }    
             }
              
             if ( cont_itens == vetor.length){   // SE ENCONTROU, VERIFICA SE É A MELHOR JA ENCONTRADA
                 
                 
                 float Valor_compra=0;
                 float Nota_atual = 0;
                 
                 for( i=0 ; i<= vetor.length-1 ; i++){
                     
                     for ( int j=0 ; j<= t.Tabela_T.length-1; j++){
                        if ( l.ListaCompras[i][0].equals(t.Tabela_T[j][1]) == true && n.Tabela_NotaM[vetor[i]][0].equals(t.Tabela_T[j][0])){
                         Nota_atual =  Nota_atual + Float.parseFloat(t.Tabela_T[j][3]);
                         Valor_compra= Valor_compra+ (Float.parseFloat(t.Tabela_T[j][2])* Float.parseFloat(l.ListaCompras[i][1]));  
                         
                     }    }  }
                 
             if ( Valor_compra > Valor_Limite ){
                 return;                            // SE PASSAR DO VALOR LIMITE, PARA DE ABRIR OS PROXIMOS RAMOS "LIMITAR"
             }

                 float Media=Nota_atual/vetor.length;
                 
                 if ( Media > nota_otima ){
                     
                    nota_otima = Media;
                    preco_compra_otima = Valor_compra;
                    
                    for ( i=0 ; i<= vetor.length-1 ; i++){ 
                        vetor_otimo[i] = vetor[i];
                    }
                     
                 }
             }
             break;   
            } // FIM IF
        } // FIM FOR

         produto++;
         Funcao( produto , fornecedor , vetor);  
        
         produto--;
         fornecedor++;
         Funcao( produto , fornecedor , vetor);

    }
    
}
