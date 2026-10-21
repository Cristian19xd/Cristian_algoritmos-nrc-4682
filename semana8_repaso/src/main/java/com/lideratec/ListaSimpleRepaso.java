package com.lideratec;

public class ListaSimpleRepaso {
    static class Nodo{
        int id;
        Nodo siguiente;

        Nodo(int id){
            this.id = id;
            this.siguiente = null;
        }
    }
    static class ListaSimple{
        Nodo primero;

        void agregarFinal(int id){
            Nodo nuevo = new Nodo(id);
            if(primero==null){
                primero = nuevo;
                return;
            }
            Nodo actual = primero;
            while(actual.siguiente != null){
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }

        String recorrer(){
            if(primero==null){
                return "(vacio)";
            }
            StringBuilder texto = new StringBuilder();
            Nodo actual = primero;
            while(actual.siguiente != null){
                if(texto.length() > 0){
                    texto.append(" -> ");
                }
                texto.append(actual.id);
                actual = actual.siguiente;
            }
            return texto.toString();
        }

        boolean buscar(int id){
            Nodo actual = primero;
            while (actual != null){
                if (actual.id == id){
                    return true;
                }
                actual = actual.siguiente;
            }
            return false;
        }

        boolean eliminar(int id){
            if (primero==null){
                return false;
            }
            if (primero.id ==id){
                primero = primero.siguiente;
                return true;
            }
            Nodo anterior = primero;
            Nodo actual = primero.siguiente;
            while(actual != null && actual.id !=id){
                anterior = actual;
                actual = actual.siguiente;
            }
            if (actual == null){
                return false;
            }
            anterior.siguiente = actual.siguiente;
            return true;
        }
    }

    public static void main(String[] args){
        ListaSimple lista  = new ListaSimple();
        lista.agregarFinal(10);
        lista.agregarFinal(20);
        lista.agregarFinal(30);
        System.out.println("Recorrido es: " + lista.recorrer());
        System.out.println("Buscar 9: " + lista.buscar(9));
        System.out.println("Eliminar 20: " + lista.eliminar(20));
    }
}
