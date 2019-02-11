/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AntonioAguirre;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gmartinez
 */
public class Orion {
    public static void menuOrion() throws IOException  {
        String opcio;
        Scanner sc = new Scanner(System.in);
        StringBuilder menu = new StringBuilder("");
        
        
        do {
            menu.delete(0, menu.length());
            
            menu.append(System.getProperty("line.separator"));
            menu.append("RPO Orion-A");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
            
            menu.append("1. Activar sistema Delta");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
            
            menu.append("50. Tornar al menú pare (PNS-24 Puma)");
            menu.append(System.getProperty("line.separator"));
            
            System.out.print(MenuConstructorPantalla.constructorPantalla(menu));
            
            opcio = sc.next();

            switch (opcio) {
                case "1":
                    try {
                        activarSistemaDelta();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "50":
                    break; 
                default:
                    System.out.println("COMANDA NO RECONEGUDA");
            }   
        } while (!opcio.equals("50"));
    }
    public static void activarSistemaDelta() throws InterruptedException {
        Radar_Orion_A objRadar_orion_A = new Radar_Orion_A();

        Sistema_de_guia_Delta objGuia_Delta1 = new Sistema_de_guia_Delta();
        Sistema_de_guia_Delta objGuia_Delta2 = new Sistema_de_guia_Delta();
        Sistema_de_guia_Delta objGuia_Delta3 = new Sistema_de_guia_Delta();
        Sistema_de_guia_Delta objGuia_Delta4 = new Sistema_de_guia_Delta();

        Thread filGuia_Delta1 = new Thread(objGuia_Delta1);
        filGuia_Delta1.setName("Delta-1");

        Thread filGuia_Delta2 = new Thread(objGuia_Delta2);
        filGuia_Delta2.setName("Delta-2");
        Thread filGuia_Delta3 = new Thread(objGuia_Delta3);
        filGuia_Delta3.setName("Delta-3");
        Thread filGuia_Delta4 = new Thread(objGuia_Delta4);
        filGuia_Delta4.setName("Delta-4");

        filGuia_Delta1.start();
        filGuia_Delta2.start();
        filGuia_Delta3.start();
        filGuia_Delta4.start();

        filGuia_Delta1.join();
        filGuia_Delta2.join();
        filGuia_Delta3.join();
        filGuia_Delta4.join();

        System.out.println("--------------Dormido------------");
        Thread.sleep(20000);
        System.out.println("-------------Despierta------------");

    }
    

}
