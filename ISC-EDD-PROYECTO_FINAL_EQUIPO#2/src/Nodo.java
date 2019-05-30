/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Omen
 */
public class Nodo {
    
    //Atributo para crear la lista (Referencias)
    private int NSeg;
   private String Nombre;
   private String Sintomas;
   private String Diagnostico;
   private int prioridad;
   private Nodo siguiente;
   private Nodo previo;
   private int Edad;
   private String Sexo;
   private String Fecha;
   private String Hora;

    public Nodo() {
        this.siguiente=null;
        this.previo=null;
    }

    public Nodo(int NSeg, String Nombre, String Sintomas, String Diagnostico, int prioridad, int Edad, String Sexo, String Fecha, String Hora) {
        this.NSeg = NSeg;
        this.Nombre = Nombre;
        this.Sintomas = Sintomas;
        this.Diagnostico = Diagnostico;
        this.prioridad = prioridad;
        this.Edad = Edad;
        this.Sexo = Sexo;
        this.Fecha = Fecha;
        this.Hora = Hora;
    }


    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getPrevio() {
        return previo;
    }

    public void setPrevio(Nodo previo) {
        this.previo = previo;
    }

    public int getNSeg() {
        return NSeg;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getSintomas() {
        return Sintomas;
    }

    public String getDiagnostico() {
        return Diagnostico;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public int getEdad() {
        return Edad;
    }

    public String getSexo() {
        return Sexo;
    }

    public String getFecha() {
        return Fecha;
    }

    public String getHora() {
        return Hora;
    }

    
}
