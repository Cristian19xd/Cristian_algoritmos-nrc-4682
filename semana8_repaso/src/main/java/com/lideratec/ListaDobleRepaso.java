package com.lideratec;

public class ListaDobleRepaso {

    static class NodoDoble {
        int id;
        NodoDoble anterior;
        NodoDoble siguiente;

        NodoDoble(int id) {
            this.id = id;
            this.anterior = null;
            this.siguiente = null;
        }
    }

    static class ListaDoble {
        NodoDoble primero;
        NodoDoble ultimo;

        void agregarFinal(int id) {
            NodoDoble nuevo = new NodoDoble(id);

            if (primero == null) {
                primero = nuevo;
                ultimo = nuevo;
                return;
            }
            nuevo.anterior = ultimo;
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }

        String recorridoAdelante() {
            StringBuilder texto = new StringBuilder();
            NodoDoble actual = primero;
            while (actual != null) {
                if (texto.length() > 0) {
                    texto.append(" -> ");
                }
                texto.append(actual.id);
                actual = actual.siguiente;
            }
            return texto.length() == 0 ? "(vacio) " : texto.toString();
        }

        String recorridoAtras() {
            StringBuilder texto = new StringBuilder();
            NodoDoble actual = primero;
            while (actual != null) {
                if (texto.length() > 0) {
                    texto.append(" <-> ");
                }
                texto.append(actual.id);
                actual = actual.siguiente;
            }
            return texto.length() == 0 ? "(vacio) " : texto.toString();

        }

        public static void main(String[] args) {
            ListaDoble lista = new ListaDoble();
            lista.agregarFinal(10);
            lista.agregarFinal(20);
            lista.agregarFinal(30);
            System.out.println("Recorrer adelante: " + lista.recorridoAdelante());
            System.out.println("Recorrer adelante: " + lista.recorridoAtras());
        }
    }
}
