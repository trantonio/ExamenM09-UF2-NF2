/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AntonioAguirre;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gines
 */
public class Sistema_de_guia_Delta implements Runnable{
    private Radar_Orion_A objRadar_orion_A = new Radar_Orion_A();

    @Override
    public void run() {
        System.out.println("    " + Thread.currentThread().getName() + ".INICIO");
        objRadar_orion_A.assignarObjectiu(Thread.currentThread().getName());

        System.out.println("    " + Thread.currentThread().getName() + ".FINAL");

    }
}
