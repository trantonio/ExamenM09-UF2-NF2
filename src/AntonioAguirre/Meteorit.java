/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AntonioAguirre;

import java.util.Objects;

/**
 *
 * @author gmartinez
 */

//OJO que a la declaració de la classe  li falta algo...
public class Meteorit implements Comparable{
    private Integer id;
    private Integer distancia;
    private String SistemaDeGuiaAssignat;

    
    Meteorit(int id, int distancia) {
        this.id = id;
        this.distancia = distancia;
        this.SistemaDeGuiaAssignat = "CAP";
    }

    public Integer getId() {
        return id;
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public String getSistemaDeGuiaAssignat() {
        return SistemaDeGuiaAssignat;
    }

    public void setSistemaDeGuiaAssignat(String sistemaDeGuiaAssignat) {
        SistemaDeGuiaAssignat = sistemaDeGuiaAssignat;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
