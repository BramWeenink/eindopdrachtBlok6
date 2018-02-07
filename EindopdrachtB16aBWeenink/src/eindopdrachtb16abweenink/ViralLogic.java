/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eindopdrachtb16abweenink;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author BramWeenink
 */
public class ViralLogic extends VirusGUI{
    static ArrayList<Virus> virusList = new ArrayList();
    static ArrayList hostList = new ArrayList();
    
    public static void main(String[] args) {
        final long startTime = System.nanoTime();
        bestandLezen();
        final long duration = System.nanoTime() - startTime;
        System.out.println("Duratie van Sorteeralgoritme: "+ duration);
    }
    private static BufferedReader inFile;
    
    
    public static void bestandLezen(){
        String line = null;
//        int count = 0;
        try {
            inFile = new BufferedReader(new FileReader("C:\\Users\\BramWeenink\\Desktop\\eindtest.tsv"));
            inFile.readLine();
            while ((line = inFile.readLine()) != null) {
                if(!line.startsWith("#")){
//                    System.out.println(line.split("\t")[0]); // id
//                    System.out.println(line.split("\t")[1]); // soort / naam
//                    System.out.println(line.split("\t")[2]); // lineage / clasificatie
//                    System.out.println(line);
                    if(line.split("\t",-1)[1].equals(line.split("\t",-1)[1])){
                        hostList.add(line.split("\t",-1)[7]); // host id
                    }
                    String[] input = line.split("\t",-1);
                    Virus v = new Virus(Integer.valueOf(input[0]), input[1], input[2], hostList);
                    virusList.add(v);
                    } 
            }
            Collections.sort(virusList);
            System.out.println(hostList);
            inFile.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Bestand niet gevonden!");
        } catch (IOException ioe){
            System.out.println("Fout met lezen van een regel!");
        }
    }
}
