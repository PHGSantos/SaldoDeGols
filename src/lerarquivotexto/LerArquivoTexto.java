/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerarquivotexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author User-PC
 */
public class LerArquivoTexto {  
//C:\Users\vaio\Desktop\LerArquivoTexto\campeonatos\2003\brasileiao-seriea.txt 
  public static void main(String[] args) {
    Scanner ler = new Scanner(System.in);
 
    System.out.printf("Informe o ano do campeonato:\n");
    String ano = ler.nextLine();
    
    System.out.printf("Informe o nome primeiro time:\n");
    String time = ler.nextLine();
 
    saldoDeGolsPorRodada(ano, time);
  
  }
  
  public static void saldoDeGolsPorRodada(String ano, String time){
    try {
      FileReader arq = new FileReader(ano+".txt");
      BufferedReader lerArq = new BufferedReader(arq);
 
      String linha = lerArq.readLine(); // lê a primeira linha
                                        // a variável "linha" recebe o valor "null" quando o processo
                                        // de repetição atingir o final do arquivo texto
      ArrayList lista = new ArrayList();
            
      while (linha != null) {
        String s = linha.toUpperCase();
        if(s.contains(time.toUpperCase())){
            lista.add(linha);
        }  
        linha = lerArq.readLine(); // lê da segunda até a última linha
      }
      //dá split na string e depois checa a posição no vetor resoltante pra saber de qual lado é
      int i = lista.size();
      
      int gm1 = 0, gs1 = 0, sg1 = 0;
      
      for(int j = 0; j < i; j++){
          //System.out.printf("%s\n", lista.get(j));
          String a = (String) lista.get(j);
          String vetor[] = a.split("\t");
          
          if(vetor[3].equalsIgnoreCase(time)){
              gm1 = Integer.parseInt(vetor[4]);
              gs1 = Integer.parseInt(vetor[6]);
          }else if(vetor[7].equalsIgnoreCase(time)){
              gm1 = Integer.parseInt(vetor[6]);
              gs1 = Integer.parseInt(vetor[4]);
          }else{
              System.out.println("DEU RUIM");
          }
          
           sg1 = gm1 - gs1;
           System.out.println("Rodada " +vetor[0]+ " -> SG("+time.toUpperCase()+")= " + sg1);
      }
      arq.close();
      
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }
  }
   
}   

