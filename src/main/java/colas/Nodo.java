package colas;

import pilas.Contacto;

public class Nodo {
    private Contacto dato;
    private Nodo next;

    public Nodo(Contacto dato) {
        this.dato = dato;
    }

    public Contacto getDato() {
        return dato;
    }

    public void setDato(Contacto dato) {
        this.dato = dato;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return dato.toString();
    }
}

