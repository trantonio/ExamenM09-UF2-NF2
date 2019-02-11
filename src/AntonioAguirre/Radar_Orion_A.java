/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AntonioAguirre;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author gines
 */


public class Radar_Orion_A {
    private SortedSet<Meteorit> setObjectius = new TreeSet<Meteorit>();
    Date date = new Date();
    DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

        
    
    public Radar_Orion_A() {
        setObjectius.add(new Meteorit(1, 2000));
        setObjectius.add(new Meteorit(3, 2000));
        setObjectius.add(new Meteorit(2, 2000));
        setObjectius.add(new Meteorit(4, 12000));
        setObjectius.add(new Meteorit(5, 7000));
        setObjectius.add(new Meteorit(6, 7000));
    }
    public synchronized int assignarObjectiu(String nomSistemaDeGuia){
        for (Meteorit m : setObjectius){
            if(m.getSistemaDeGuiaAssignat()=="CAP"){
                m.setSistemaDeGuiaAssignat(nomSistemaDeGuia);
                return m.getId();
            }

        }
        System.out.println("assignarObjectiu ----"+Thread.currentThread().getName());
        try {
            setObjectius.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public Meteorit carregarDadesObjectiu(int objectiuID){
        for (Meteorit m : setObjectius){
            if(objectiuID==m.getId()){
                return m;
            }
        }
        return null;
    }
public void notifyUnDelta(String nomSistemaDeGuia){
    try {
        Thread.sleep(2500);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    setObjectius.notify();
    System.out.println(Thread.currentThread().getName()+": "+"NOTIFY() "+hourFormat.format(date));
}
    public void desconectarDeltasDelRadar(){
        setObjectius.notifyAll();

    }
    
    

    
    
    
}
