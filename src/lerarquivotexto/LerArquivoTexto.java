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
 
    System.out.printf("Informe o limite de rodadas:\n");
    int n = ler.nextInt();
    String rodadas = n+1+"ª";
    
    saldoDeGolsPorRodada2(ano, time, rodadas, n);
  
  }
  
  public static void saldoDeGolsPorRodada(String ano, String time, String rodada){
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
            
            if(s.contains(rodada))
                break;
          
            lista.add(linha);
            
        }  
        linha = lerArq.readLine(); // lê da segunda até a última linha
      }
      //dá split na string e depois checa a posição no vetor resoltante pra saber de qual lado é
      int i = lista.size();
      
      int gm = 0, gs = 0, sg = 0;
      int gmg = 0, gsg = 0, sgg = 0;
      
      
      for(int j = 0; j < i; j++){
          //System.out.printf("%s\n", lista.get(j));
          String a = (String) lista.get(j);
          String vetor[] = a.split("\t");
          
          if(vetor[3].equalsIgnoreCase(time)){
              gm = Integer.parseInt(vetor[4]);
              gs = Integer.parseInt(vetor[6]);
              
              gmg = gmg + gm;
              gsg = gsg + gs;
          }else if(vetor[7].equalsIgnoreCase(time)){
              gm = Integer.parseInt(vetor[6]);
              gs = Integer.parseInt(vetor[4]);
              
              gmg = gmg + gm;
              gsg = gsg + gs;
          }else{
              System.out.println("DEU RUIM");
          }
          
           sg = gm - gs;
           System.out.println("Rodada " +vetor[0]+ " -> SG("+time.toUpperCase()+")= " + sg);
      }
      arq.close();
      sgg = gmg - gsg;
           System.out.println("Resultado Geral SG("+time.toUpperCase()+")= " + sgg);
      
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }
  }
   
  
  
  public static void saldoDeGolsPorRodada2(String ano, String time, String rodada,int n){
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
            
            if(s.contains(rodada))
                break;
          
            lista.add(linha);
            
        }  
        linha = lerArq.readLine(); // lê da segunda até a última linha
      }
      //dá split na string e depois checa a posição no vetor resoltante pra saber de qual lado é
      int i = lista.size();
      
      int gm = 0, gs = 0, sg = 0;
      int gmg = 0, gsg = 0, sgg = 0;
      
      int rodadas[] = new int[n];
      for(int j = 0; j < i; j++){
          //System.out.printf("%s\n", lista.get(j));
          String a = (String) lista.get(j);
          String vetor[] = a.split("\t");
          
          if(vetor[3].equalsIgnoreCase(time)){
              gm = gm + Integer.parseInt(vetor[4]);
              gs = gs + Integer.parseInt(vetor[6]);
              
          }else if(vetor[7].equalsIgnoreCase(time)){
              gm = gm + Integer.parseInt(vetor[6]);
              gs = gs + Integer.parseInt(vetor[4]);
              
          }else{
              System.out.println("DEU RUIM");
          }
          
           sg = gm - gs;
           rodadas[j] = sg; 
           System.out.println("Rodada " +vetor[0]+ " -> SG("+time.toUpperCase()+")= " + rodadas[j]);
      }
      arq.close();
      
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }
  }
  
  
}   

