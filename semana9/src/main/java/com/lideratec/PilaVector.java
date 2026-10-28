package com.lideratec;

public class PilaVector {

    private int[] vector;
    private int tope;
    private int tamanio;

    PilaVector(int tamanio){
        this.tamanio = tamanio;
        vector = new int [tamanio];
        tope = -1;
    }

    public void push(int dato){
        if (isFull()){
            System.out.println("Error: Pila esta llena");
            return;
        }
        System.out.println("Tope a base: ");
        for (int i= tope; i>=0; i--){
            System.out.println(vector[i] + "");
        }
        tope++;
        vector[tope] = dato;
        System.out.println("Apilado " + dato);
    }
    public void mostrar(){
        if(tope == -1){
            System.out.println("La pila esta vacio, no hay contenido para mostar");
            return;
        }
        System.out.println("Tope base ");
        for (int i = tope; i >=0; i--){
            System.out.println(vector[i] + "");
        }
    }

    public int pop(){
        if (tope ==-1){
            System.out.println("Error: Pila esta vacia");
            return -1;
        }
        int dato = vector[tope];
        tope--;
        return dato;
    }
    public boolean isFull(){
        return tope == tamanio-1;
    }

    public static void main(String[] args){
        PilaVector pila = new PilaVector(3);
        pila.push(10);
        pila.push(30);
        pila.push(40);
        pila.mostrar();
        System.out.println("------------------------------");
        pila.pop();
        pila.mostrar();
        System.out.println("------------------------------");
        System.out.println("Esta lleno? " + pila.isFull());
    }
}
