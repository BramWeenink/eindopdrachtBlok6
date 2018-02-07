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

/**
 *
 * @author BramWeenink
 */
public class Virus extends VirusGUI implements Comparable<Virus>{
    private int viral_id;
    private String species;
    private String clasification; 
    private ArrayList hosts;
    
    public Virus(int gen_id, String soort, String clasificatie, ArrayList hostList) {
        this.viral_id = gen_id;
        this.species = soort;
        this.clasification = clasificatie;
        this.hosts = hostList;
    }
    
    public int getID(){
        return viral_id;
    }
    
    public String getSpec(){  
        return species;
    }
    
    public String getClas(){  
        return clasification;
    }
    
    public ArrayList getHost(){
        return hosts;
    }


    @Override
    public int compareTo(Virus o) {
        return clasification.compareTo(o.clasification);
    }
}
