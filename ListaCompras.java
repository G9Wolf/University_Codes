package com.mycompany.projetoapa;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ListaCompras {

    String[][] ListaCompras;    //[ITEM][QTD]
    String[] vet_Linhas; 
    int cont=0;
    
    public ListaCompras() throws FileNotFoundException{
       
    Scanner in_cont = new Scanner(new FileReader("C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\APA\\ListaCompras.txt"));
    Scanner in_read = new Scanner(new FileReader("C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\APA\\ListaCompras.txt"));
//------------------------------------------------------
while (in_cont.hasNextLine()) {
    cont++;                                // CONTANDO QUANTAS LINHAS TEMOS PARA LER
    in_cont.nextLine();
    }
    vet_Linhas = new String[cont];                    // ALOCAMOS DINAMICAMENTE VET
    ListaCompras = new String[cont+1][2];

    cont=0;
    while (in_read.hasNextLine()) {
    vet_Linhas[cont] = in_read.nextLine();       // Guarda em vet todas linhas do TXT
    cont++;
    }

    for ( int i=0; i<= vet_Linhas.length-1 ; i++){
        String[] Separar = vet_Linhas[i].split(",");     // Guarda em Separar as palavras separadas por ","
        ListaCompras[i][0] = Separar[0];
        ListaCompras[i][1] = Separar[1];                // Atribuimos a tabela os valores de separar organizadamente
        
        }   

    }
}
