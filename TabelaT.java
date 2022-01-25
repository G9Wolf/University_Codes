package com.mycompany.projetoapa;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TabelaT {

String[][] Tabela_T;   //  [FORNECEDOR][PRODUTO][VALOR][NOTAMEDIA]
String[] vet_Linhas;    
int cont=0;
     
public TabelaT() throws FileNotFoundException{  
TabelaNotas n = new TabelaNotas();
Scanner in_cont = new Scanner(new FileReader("C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\APA\\ListaFornecedores.txt"));
Scanner in_read = new Scanner(new FileReader("C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\APA\\ListaFornecedores.txt"));
//------------------------------------------------------
while (in_cont.hasNextLine()) {
    cont++;                                // CONTANDO QUANTAS LINHAS TEMOS PARA LER
    in_cont.nextLine();
}
vet_Linhas = new String[cont];                    // ALOCAMOS DINAMICAMENTE VET
Tabela_T = new String[cont][4];

cont=0;
while (in_read.hasNextLine()) {
    vet_Linhas[cont] = in_read.nextLine();       // Guarda em vet todas linhas do TXT
    cont++;
}

for ( int i=0; i<= vet_Linhas.length-1 ; i++){
String[] Separar = vet_Linhas[i].split(",");     // Guarda em Separar as palavras separadas por ","
Tabela_T[i][0] = Separar[0];
Tabela_T[i][1] = Separar[1];                      // Atribuimos a tabela os valores de separar organizadamente
Tabela_T[i][2] = Separar[2];
}

    for ( int i=0; i<= Tabela_T.length-1 ; i++){
        
       for ( int j=0; j<= n.Tabela_NotaM.length-1 ; j++){
       
           if ( Tabela_T[i][0].equals(n.Tabela_NotaM[j][0]) == true ){    // COLOCAMOS A NOTA MEDIA RESPECTIVA DE CADA FORNECEDOR EM CADA LINHA
                Tabela_T[i][3] = n.Tabela_NotaM[j][1];
           }  
       }
    }
}    // FIM CONSTRUTOR
}  // FIM CLASSE MAIN
