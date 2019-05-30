
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Omen
 */
public class Apoyo {

    Scanner yol = new Scanner(System.in);
    static Nodo inicio;
    static Nodo fin;
    static Nodo pivote;
    static Nodo actual;
    static Nodo nFin;
    static int Cont = 0;
    static Nodo aux = null;
    static Nodo aux1 = null;
    static Nodo aux2 = null;
    static String Datos = "";
    static String DatosEnf = "";
    static String ordenado = "No hay";

    public static void AgregarPaciente(Nodo nNuevo) {
        //LISTA INICIO
        if (Cont == 0) {
            inicio = null;
            fin = null;
        }
        aux1 = inicio;
        if (inicio == null) {
            inicio = nNuevo;
            fin = nNuevo;
        } else {
            if (inicio == fin) {
                inicio.setSiguiente(nNuevo);
                fin = nNuevo;
            } else {
                do {
                    aux1 = aux1.getSiguiente();
                } while (aux1.getSiguiente() != null);
                aux1.setSiguiente(nNuevo);
                fin = nNuevo;
            }
        }
        Cont++;
    }

    public static String Imprimir() {
        String Lista = "";
        Nodo nTemp = inicio;
        while (nTemp != null) {
            Lista += ("Nombre: " + nTemp.getNombre() + " Edad: " + nTemp.getEdad() + " Sexo: " + nTemp.getSexo() + "  N. Seguro: " + nTemp.getNSeg()
                    + "\n Diagnostico: " + nTemp.getDiagnostico() + " Sintomas: " + nTemp.getSintomas()
                    + "\n Hora: " + nTemp.getHora() + " Fecha: " + nTemp.getFecha()
                    + "\n ________________________________________________________________\n");

            nTemp = nTemp.getSiguiente();

        }
        return Lista;

    }

    public String buscar(int nSeg) {
        Nodo nTemp = inicio;
        while (nTemp != null) {

            //DETENER EL CICLO CUANDO LO ENCONTREMOS
            if (nSeg == nTemp.getNSeg()) {
                Datos = ("Nombre: " + nTemp.getNombre() + " Edad: " + nTemp.getEdad() + " Sexo: " + nTemp.getSexo() + "  N. Seguro: " + nTemp.getNSeg()
                        + "\n Diagnostico: " + nTemp.getDiagnostico() + " Sintomas: " + nTemp.getSintomas()
                        + "\n Hora: " + nTemp.getHora() + " Fecha: " + nTemp.getFecha()
                        + "\n ________________________________________________________________\n");
                break;
            } else {
                Datos = "No se encuentra ese registro";
            }

            nTemp = nTemp.getSiguiente();
        }
        return Datos;
    }

    public static String buscarPorEnfermedad(String tEnf) {
        aux1 = inicio;
        int x = 0;
        DatosEnf = "";
        String mns = "";
        while (aux1 != null) {

            //DETENER EL CICLO CUANDO LO ENCONTREMOS
            if (tEnf == aux1.getDiagnostico()) {
                x++;
                DatosEnf += ("Nombre: " + aux1.getNombre() + " Edad: " + aux1.getEdad() + " Sexo: " + aux1.getSexo() + "  N. Seguro: " + aux1.getNSeg()
                        + "\n Diagnostico: " + aux1.getDiagnostico() + " Sintomas: " + aux1.getSintomas()
                        + "\n Hora: " + aux1.getHora() + " Fecha: " + aux1.getFecha()
                        + "\n ________________________________________________________________\n");

            } else {

            }

            aux1 = aux1.getSiguiente();
        }
        if (x != 0) {
            mns = DatosEnf;
        } else {
            mns = "No hay pacientes con esta enfermedad";
        }
        return mns;
    }

    public void borrarNodo(int nSegu) {

        if (inicio != null) {
            if(inicio == fin){
                if(nSegu == inicio.getNSeg()){
                    inicio = fin = null;
                    Cont--;
                    JOptionPane.showMessageDialog(null, "Se eliminó el registro");
                }
            } else{
            if (nSegu == inicio.getNSeg()) { //nodo inicial
                inicio = inicio.getSiguiente();
                //EL PROBLEMA ES EL NODO FIN
                if (inicio.getSiguiente() == null) {
                    fin = inicio;
                }
                Cont--;
                JOptionPane.showMessageDialog(null, "Se eliminó el registro");
            } else {
                Nodo nTemp = inicio;

                while (nTemp != null) {
                    if (nSegu != nTemp.getNSeg()) {
                        aux = nTemp;
                        nTemp = nTemp.getSiguiente();
                        
                    }else{
                        aux.setSiguiente(nTemp.getSiguiente());
                        if(nTemp.getSiguiente()== null){
                        fin = nTemp;
                        }
                        Cont--;
                        JOptionPane.showMessageDialog(null, "Se eliminó el registro");
                       break;
                    }
                }
                if(nTemp == null) {
                        JOptionPane.showMessageDialog(null, "No hay registros con ese numero de seguro");
                        
                    }
            }
            } 
        }else {
            //GENERAR UNA EXEPCION --> LISTA VACIA
            JOptionPane.showMessageDialog(null, "No hay registros para eliminar");
        }
    }

   /* public static void EliminaNodoEspecifico(int nSegu) {
        aux2 = aux1;
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, "No hay registros para eliminar");
        } else {
            if (inicio == fin){
                if(nSegu == inicio.getNSeg()) {
                inicio = fin = null;
                JOptionPane.showMessageDialog(null, "Se eliminó el registro");
            } else {
                
                    if (nSegu == inicio.getNSeg()) {
                        inicio = aux2.getSiguiente();
                        JOptionPane.showMessageDialog(null, "Se eliminó el registro");
                    } else {
                        while ((aux2 != null) && (aux2.getNSeg()!= nSegu)) {
                            aux3 = aux2;
                            aux2 = aux2.siguiente;
                        }
                        if (aux2 == null) {
                            System.out.println("No hay elemento");
                        } else {
                            aux3.siguiente = aux2.siguiente;
                            System.out.println("elemnto eliminado : " + aux2.Nombre + " Control " + aux2.numControl);
                        }
                    }
                }
            }
        }
    }*/

    public void InsertionSort(Nodo nuevo) {
        aux = inicio;
        if (inicio == null) { //Lista vacía
            inicio = nuevo;
            fin = nuevo;
        } else {
            if (inicio == fin && nuevo.getNSeg() > inicio.getNSeg()) { //Lista con un elemento
                inicio.setSiguiente(nuevo);
                fin = nuevo;
            } else if (inicio == fin && nuevo.getNSeg() < inicio.getNSeg()) {
                nuevo.setSiguiente(aux);
                inicio = nuevo;
                fin = aux;
            } else {   //Lista con más de un elemento
                aux1 = inicio;
                while (aux1 != null) {//Hace recorrido de la lista, siempre y cuando el aux1 sea algo(tenga un dato)
                    aux2 = aux1.getSiguiente();
                    if (nuevo.getNSeg() < aux1.getNSeg()) { //Cuando la posicion es menor o igual al actual
                        nuevo.setSiguiente(aux1);
                        inicio = nuevo;
                        break;
                    } else {   //Cuando la posicion es mayor
                        if (nuevo.getNSeg() > aux1.getNSeg() && aux2 == null) { //Pero es el último el actual
                            aux1.setSiguiente(nuevo);
                            fin = nuevo;
                            break;
                        } else {
                            if (nuevo.getNSeg() > aux1.getNSeg() && nuevo.getNSeg() <= aux2.getNSeg()) { //Pero el siguiente es mayor al nuevo
                                aux1.setSiguiente(nuevo);
                                nuevo.setSiguiente(aux2);
                                break;
                            }
                        }
                    }
                    aux1 = aux2;//Indica que tomamos el dato siguiente para seguir con el recorrido
                }//null fin del recorrido
            }
        }
    }
    
    //Método que realiza el ordenamiento y regresa los nodos
     Nodo partition(Nodo low,Nodo high){ 
       //Se guarda el valor del último nodo en la lista para hacer las comparaciones
        System.out.println("entra a partition ");
        int mayor = high.getNSeg(); 
        Nodo i = low.getPrevio(); 
        //For adaptado a listas
        for(Nodo j = low; j != high; j = j.getSiguiente()){ 
            System.out.println("Entra al for");
            if(j.getNSeg()< mayor){ 
                i = (i==null) ? low : i.getSiguiente(); 
                /*Nodo nTemp = i;
                i.setSiguiente(j.getSiguiente());
                j.setPrevio(i.getPrevio());
                j.setSiguiente(nTemp.getSiguiente());
                j.setPrevio(nTemp.getPrevio());
                 
                System.out.println("intercambio");
                System.out.println(Imprimir());*/
                
                /*Nodo nTemp = j;
                nTemp.setPrevio(i.getPrevio());
                nTemp.setSiguiente(j.getSiguiente());
                i.setSiguiente(j.getSiguiente());
                j.setPrevio(i.getPrevio());
                i.setPrevio(nTemp.getPrevio());
                j.setSiguiente(nTemp.getPrevio());
                j.getPrevio().setSiguiente(j);
                nTemp.getPrevio().setSiguiente(i);
                i.getSiguiente().setPrevio(i);
                nTemp.getPrevio().setPrevio(j);*/
                
                /*Nodo nTempi = null;
                i.getPrevio().setSiguiente(nTempi);
                nTempi.setPrevio(i.getPrevio());
                i.getSiguiente().setPrevio(nTempi);
                nTempi.setSiguiente(i.getSiguiente());
                
                Nodo nTempj = null;
                j.getPrevio().setSiguiente(nTempj);
                nTempj.setPrevio(j.getPrevio());
                j.getSiguiente().setPrevio(nTempj);
                nTempj.setSiguiente(j.getSiguiente());
                
                i.setSiguiente(nTempj.getSiguiente());
                nTempj.getSiguiente().setPrevio(i);
                i.setPrevio(nTempj.getPrevio());
                
                j.setPrevio(nTempi.getPrevio());
                nTempi.getSiguiente().setPrevio(j);
                j.setPrevio(nTempi.getPrevio());*/
                
                Nodo nTempi = i.getSiguiente();
                Nodo nTempj = j.getSiguiente();
                
                
                
                
            } 
        } 
        i = (i==null) ? low : i.getSiguiente();
         System.out.println("Otro intercambio");
       /* Nodo nTemp = i;
        
        i.setSiguiente(high.getSiguiente());
        i.setPrevio(high.getPrevio());
        high.setSiguiente(nTemp.getSiguiente());
        high.setPrevio(nTemp.getPrevio());*/
       
        /*Nodo nTemp = high;
        nTemp.setSiguiente(i.getSiguiente());
        nTemp.setPrevio(i.getPrevio());
        nTemp.getPrevio().setSiguiente(high);
        high.setSiguiente(nTemp.getSiguiente());
        high.getPrevio().setSiguiente(i);
        i.setPrevio(high.getPrevio());
        high.setPrevio(nTemp.getPrevio());
        nTemp.getSiguiente().setPrevio(high);
        i.setSiguiente(null);*/
        
        Nodo nTempi = null;
                i.getPrevio().setSiguiente(nTempi);
                nTempi.setPrevio(i.getPrevio());
                i.getSiguiente().setPrevio(nTempi);
                nTempi.setSiguiente(i.getSiguiente());
                
                Nodo nTempj = null;
                high.getPrevio().setSiguiente(nTempj);
                nTempj.setPrevio(high.getPrevio());
                high.getSiguiente().setPrevio(nTempj);
                nTempj.setSiguiente(high.getSiguiente());
                
                i.setSiguiente(nTempj.getSiguiente());
                nTempj.getSiguiente().setPrevio(i);
                i.setPrevio(nTempj.getPrevio());
                
                high.setPrevio(nTempi.getPrevio());
                nTempi.getSiguiente().setPrevio(high);
                high.setPrevio(nTempi.getPrevio());
        
        return i;
    } 
      
    //El método recursivo para la implementación de quicksort
    private  void quickSortRecur(Nodo low,Nodo high){ 
        System.out.println("Entra a recur");
        if(high!=null && low!=high && low!=high.getSiguiente()){
            System.out.println("Dentro de la decision");
            Nodo temp = partition(low,high); 
            System.out.println("Sale de particion");
            quickSortRecur(low,temp.getPrevio()); 
            quickSortRecur(temp.getSiguiente(),high); 
        } 
    } 
      
    // Función que interactúa con el usuario
    public  void quickSort(Nodo nNodo){ 
        //Se necesita el último Nodo
          System.out.println("entra a quicksort 1");
        nFin = NodoFin(nNodo);
        System.out.println("sale nodoFin");
        quickSortRecur(nNodo,nFin); 
    } 
    
    //Método que busca el último Nodo y lo regresa    
     static Nodo NodoFin(Nodo nNodo){ 
         System.out.println("entra a nodoFin2");
        while(nNodo.getSiguiente()!= null) 
            nNodo = nNodo.getSiguiente(); 
        return nNodo; 
    } 
     
    public Nodo intercambio(Nodo primero, Nodo ultimo){
        System.out.println("********************************");
        
        //Variableas auxiliares para sostener el segmento de la lista
        //en intercambios largos
        Nodo s = null;
        Nodo r = null;
       
        //Si el siguiente del nodo que se va a intercambiar es 
        //diferente al nodo con el que se va a intercambiar 
        //(Si estan juntos)
        if(primero.getSiguiente()!= ultimo){
            //Se inicializan las variables
            s = primero.getSiguiente();
            r = ultimo.getPrevio();
        }
        //Se rompen los enlaces que estan en la parte que apunta el
        //pedazo de la lista interna
        primero.setSiguiente(ultimo.getSiguiente());
        ultimo.setPrevio(primero.getPrevio());
        
        //Si ultimo no es el ultimo nodo de la lista
        if(ultimo.getSiguiente()!= null){
            ultimo.getSiguiente().setPrevio(primero);
        }
        //Si primero no es el primer nodo de la lista
        if(primero.getPrevio() != null){
            primero.getPrevio().setSiguiente(ultimo);
        } else{
            this.inicio = ultimo;
        }
        //Si s o r se inicializaron significa que hay un segmento de la 
        //lista entre los nodos que se van a intercambiar
        if(s != null && r != null){
            //Se establece el segmento de la lista que esta en medio de los
            //nodos a intercambiarse
            r.setSiguiente(primero);
            s.setPrevio(ultimo);
            ultimo.setSiguiente(s);
            primero.setPrevio(r);
        }else{
            //Si no hay nodos entre los que se intercambian, es decir que los
            //nodos estan juntos, solo se deben apuntar entre ellos
            ultimo.setSiguiente(primero);
            primero.setPrevio(ultimo);
        }
        
        //Regresa a ultimo porque es el nodo que se encuentra mas a la 
        //derecha luego del intercambio
        
        return ultimo;
    }

    public int longitud() {
        return Cont;
    }

    public Boolean quitarSeguroDuplicado(int nSegu) {

        Nodo nTemp = inicio;
        Boolean exist = false;
        while (nTemp != null) {

            //DETENER EL CICLO CUANDO LO ENCONTREMOS
            if (nSegu == nTemp.getNSeg()) {
                exist = true;
                break;
            }

            nTemp = nTemp.getSiguiente();
        }
        return exist;
    }

    public void Duplex() {
        String Valores[][] = new String[Cont][9];
        aux1 = inicio;
        for (int i = 0; i < Cont; i++) {
            Valores[i][0] = Integer.toString(aux1.getNSeg());
            Valores[i][1] = aux1.getNombre();
            Valores[i][2] = aux1.getSintomas();
            Valores[i][3] = aux1.getDiagnostico();
            Valores[i][4] = Integer.toString(aux1.getPrioridad());
            Valores[i][5] = Integer.toString(aux1.getEdad());
            Valores[i][6] = aux1.getSexo();
            Valores[i][7] = aux1.getFecha();
            Valores[i][8] = aux1.getHora();
            aux1 = aux1.getSiguiente();
        }
        inicio = fin = null;
        for (int i = 0; i < Valores.length; i++) {
            InsertionSort(new Nodo(Integer.valueOf(Valores[i][0]),
                    Valores[i][1],
                    Valores[i][2],
                    Valores[i][3],
                    Integer.valueOf(Valores[i][4]),
                    Integer.valueOf(Valores[i][5]),
                    Valores[i][6],
                    Valores[i][7],
                    Valores[i][8]));

        }

    }

}
