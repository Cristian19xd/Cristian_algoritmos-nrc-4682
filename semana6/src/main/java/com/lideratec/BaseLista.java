package com.lideratec;

public class BaseLista {
    static class Nodo{
        int dato;
        Nodo siguiente;

        Nodo(int dato){
            this.dato = dato;
            this.siguiente = null;
        }
    }

    static class ListaEnlazada{
        Nodo cabeza;
        void insertarFinal(int dato){
            Nodo nuevo = new Nodo(dato);
            if(cabeza == null){
                cabeza = nuevo;
                return;
            }
            Nodo actual = cabeza;
            while(actual.siguiente !=null){
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        void mostrar(){
            Nodo actual = cabeza;
            while(actual !=null){
                System.out.println(actual.dato + " ");
                actual = actual.siguiente;
            }
        }

        Nodo buscar(int valor){
            Nodo actual = cabeza;
            while( actual != null){
                if(actual.dato == valor){
                    return actual;
                }
                actual = actual.siguiente;
            }
            return null;
        }

        boolean modificar(int valorBuscado, int nuevoValor){
            Nodo actual = cabeza;
            while (actual != null) {
                if(actual.dato == valorBuscado){
                    actual.dato = nuevoValor;
                    return true;
                }
                actual = actual.siguiente;
            }
            return false;
        }

        boolean eliminarPrimero(){
            if(cabeza == null){
                return false;
            }
            cabeza = cabeza.siguiente;
            return true;
        }

        boolean eliminarUltimo(){
            if(cabeza==null){
                return false;
            }
            if(cabeza.siguiente == null){
                cabeza= null;
                return true;
            }
            Nodo anterior = null;
            Nodo actual = cabeza;

            while(actual.siguiente !=null){
                anterior= actual;
                actual = actual.siguiente;
            }
            anterior.siguiente = null;
            return true;
        }
    }

    public static void main(String[] args){
        ListaEnlazada lista = new ListaEnlazada();
        lista.insertarFinal(10);
        lista.insertarFinal(20);
        lista.insertarFinal(30);
        System.out.println("Antes de modificar / Eliminar: ");
        lista.mostrar();

        Nodo encontrado = lista.buscar(30);
        System.out.println(encontrado !=null? "Encontrado " + encontrado.dato : "No encontrado");
        Nodo ausente = lista.buscar(99);
        System.out.println(ausente !=null? "Encontrado " + ausente.dato : "No encontrado");

        System.out.println("Modificar de 20 -> 99: " + lista.modificar(20,99));
        System.out.println("Despues de modificar: ");
        lista.mostrar();

        System.out.println("Modificar de 77 -> 50: " + lista.modificar(77,50));

        /*System.out.println("Eliminacion realizada " + lista.eliminarPrimero());
        System.out.println("Despues de eliminar: ");
        lista.mostrar();*/

        System.out.println("Eliminacion realizada " + lista.eliminarUltimo());
        System.out.println("Despues de eliminar: ");
        lista.mostrar();
    }
}
