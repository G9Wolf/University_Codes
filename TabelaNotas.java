package com.mycompany.projetoapa;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TabelaNotas {
    
    String[][] Tabela_Notas;    //[FORNECEDOR][NOTA]
    String[][] Tabela_NotaM;    //[FORNECEDOR][NOTAM]
    String[] vet_Linhas; 
    int cont=0;
    
    public TabelaNotas() throws FileNotFoundException{
        
    Scanner in_cont = new Scanner(new FileReader("C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\APA\\ListaNotas.txt"));
    Scanner in_read = new Scanner(new FileReader("C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\APA\\ListaNotas.txt"));
//------------------------------------------------------
while (in_cont.hasNextLine()) {
    cont++;                                // CONTANDO QUANTAS LINHAS TEMOS PARA LER
    in_cont.nextLine();
    }
    vet_Linhas = new String[cont];                    // ALOCAMOS DINAMICAMENTE VET
    Tabela_Notas = new String[cont][2];

    cont=0;
    while (in_read.hasNextLine()) {
    vet_Linhas[cont] = in_read.nextLine();       // Guarda em vet todas linhas do TXT
    cont++;
    }

    for ( int i=0; i<= vet_Linhas.length-1 ; i++){
        String[] Separar = vet_Linhas[i].split(",");     // Guarda em Separar as palavras separadas por ","
        Tabela_Notas[i][0] = Separar[0];
        Tabela_Notas[i][1] = Separar[1];                // Atribuimos a tabela os valores de separar organizadamente
        }    
//-------------------------------------------------------------------------------        
        String[] ListaNomes = new String[10];
        //ListaNomes[0] = Tabela_Notas[0][0];
 
        for ( int i=0; i<= Tabela_Notas.length-1 ; i++){
        
            for ( int k=0 ; k<= ListaNomes.length-1 ; k++){
            
            if ( Tabela_Notas[i][0].equals(ListaNomes[k]) == true ){

            break;                               // CRIA LISTA DE FORNECEDORES UNICOS
            }  
            if ( ListaNomes[k]== null){
            ListaNomes[k] = Tabela_Notas[i][0];
            break;
            }
            
            }
        }
        
     
        
//-------------------------------------------------------------------------------   
        int j=0;
        while ( ListaNomes[j] != null){ // CONTA QUANTOS FORNECEDORES TEMOS
            j++;
        }
        Tabela_NotaM = new String[j][2];
//-------------------------------------------------------------------------------    
        for ( int i=0; i<= Tabela_NotaM.length-1 ; i++){
            
        Tabela_NotaM[i][0] = ListaNomes[i];    // COLOCA OS NOMES NA NOVA TABELA
        }
//-------------------------------------------------------------------------------  
       
        float total=0;
        float qtd_notas=0;

        for ( int i=0; i<= Tabela_NotaM.length-1 ; i++){
        
            for ( j=0; j<= Tabela_Notas.length-1 ; j++){
                
                if( Tabela_NotaM[i][0].equals(Tabela_Notas[j][0]) == true ){
                total = total + Float.parseFloat(Tabela_Notas[j][1]);    
                qtd_notas++;
                }
            }
            Tabela_NotaM[i][1] = Float.toString(total/qtd_notas); // GERA A TABELA COM OS FORNECEDORES E SUA NOTA MEDIA
            total=0;
            qtd_notas=0;
        }
    } // FIM CONSTRUTOR
} // FIM CLASSE
