package tads;

import dominio.*;
import java.util.Objects;

public class Lista<T> implements ILista<T> {
    
    public Nodo<T> cabeza;
    public int cant;

    //constructor
 
    public Lista() {
        this.cabeza = null;
    }
    
    //setter &&  getter
    public Nodo<T> getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo<T> cabeza) {
        this.cabeza = cabeza;
    }
    
    
    //implementacion de los métodos a utilizar
    
    @Override
    public boolean esVacia() {
        
        return cabeza == null;
        
    }

    @Override
    public void agragarInicio(T dato) {
        
        Nodo nuevo = new Nodo<>(dato);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    @Override
    public void agregarOrdenado(T dato) {
//        Nodo<T> nodoAux = new Nodo<T>(dato);
//        if(esVacia()|| cabeza.getDato().compareTo(dato)> 0){
//            agragarInicio(dato);
//            cant++;
//        }else{
//            Nodo<T> nodoActual = cabeza;
//            while(nodoActual.siguiente != null && nodoActual.siguiente.getDato().compareTo(dato)< 0 ){
//                nodoActual = nodoActual.siguiente;
//            }
//            nodoAux.siguiente = nodoActual.siguiente;
//            nodoActual.siguiente = nodoAux;
//            cant++;
//        }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregarFinal(T dato) {
        
        Nodo<T> nuevoNodo = new Nodo<>(dato); 
        
        if(cabeza == null){
            cabeza = nuevoNodo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.siguiente != null){
                actual = actual.siguiente;
            }
            actual.siguiente =  nuevoNodo;
        }
    }

    @Override
    public void borrarInicio() {
        
        if(!this.esVacia()){
            cabeza = cabeza.siguiente;
        }
        
    }

    @Override
    public void borrarFinal() {
        
        if(!this.esVacia()){
            
            if(cabeza.siguiente == null){
                cabeza = null;
            } else {
                Nodo actual = cabeza;
                while (actual.siguiente != null){
                    actual = actual.siguiente;
                }
                actual.siguiente = null;
            }
            
        }
        
    }

    @Override
    public void borrarElemento(T dato) {
        
        if(!this.esVacia()){
           Nodo<T> actual = cabeza;
            while (actual.siguiente != null && !actual.siguiente.dato.equals(dato)) {
                actual = actual.siguiente;
            }  
            if (actual.siguiente != null) {
                actual.siguiente = null;
            } else {
                System.out.println("Elemento no encontrado: " + dato);
            }
        }
        
    }

    

    @Override
    public void vaciar() {
        
        this.cabeza =  null;
        
    }

    @Override
    public String mostrar() {
        Nodo<T> aux = this.cabeza;
        String respuesta = "";
        while (aux != null) {
            respuesta += aux.getDato().toString();
            aux = aux.getSiguiente();
        }
        return respuesta;
    }

   
    @Override
    public String mostrarElementos() {
        String mostrar = "";
        
        if(!this.esVacia()){
            Nodo<T> aux = cabeza;
            while(aux != null){
                mostrar += aux.getDato().toString()+"|\n";
                aux = aux.getSiguiente();
            }
        }
        
        return mostrar;
    }
    
 
    @Override
    public int cantElementos() {
        
        int tamaño = 0;
        
        Nodo<T> actual = cabeza;
            while (actual.siguiente != null){
                tamaño++;
                actual = actual.siguiente;
            }
        
        return tamaño;    
        
    }

    @Override
    public Nodo<T> obtenerElemento(T dato) {

        Nodo<T> aux = new Nodo<T> (null); 

        Nodo<T> aux2 = cabeza;

        boolean encontrado = false;
        while(aux2 != null && !encontrado){
            if(aux2.dato.equals(dato)){
                encontrado = true;

                aux = aux2;
            } else{
              aux2= aux2.siguiente;
            }

        }
        return aux;
    }
    


    @Override
    public boolean existeElemento(T dato) {
        Nodo aux = this.getCabeza();
        boolean encontrado = false;
        while (aux != null && !encontrado) {
            if (dato == aux.getDato()) {
                encontrado = true;
            }
            aux = aux.getSiguiente();
        }

       return encontrado;   
    }

    
    @Override
    public void agregar(T dato) {
        
        Nodo<T> nuevoNodo = new Nodo<>(dato); 
        
        if(cabeza == null){
            cabeza = nuevoNodo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.siguiente != null){
                actual = actual.siguiente;
            }
            actual.siguiente =  nuevoNodo;
        }
        
    }

    @Override
    public int tamaño() {
        
        int tamaño = 0;
        
        Nodo<T> actual = cabeza;
            while (actual.siguiente != null ){
                tamaño++;
                actual = actual.siguiente;
            }
        
        return tamaño;
    }

    @Override
    public T obtener(int indice) {
       
        if (indice < 0 || indice > tamaño()){
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        } else {
            Nodo<T> actual = cabeza;
            for(int i = 0; i < indice; i++){
                actual = actual.siguiente;
            }
            return actual.dato;
        }
    }

    @Override
    public String mostrarRecursivo(Nodo<T> nodo) {
	if (nodo == null) {
            return "";
        }
        
        return nodo.getDato().toString()+ mostrarRecursivo(nodo.getSiguiente());
    }
    




    





   

    
    
    
}
