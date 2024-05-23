package colas;

import pilas.Contacto;

public class Colas {
    private Nodo inicio;
    private Nodo termino;

    public Colas() {
        inicio = null;
        termino = null;
    }

    public void insertar(Contacto dato) {
        Nodo i = new Nodo(dato);
        i.setNext(null);
        if (inicio == null && termino == null) {
            inicio = i;
            termino = i;
        } else {
            termino.setNext(i);
            termino = termino.getNext();
        }
    }

    public Contacto extraer() {
        if (inicio == null) {
            throw new RuntimeException("La cola está vacía");
        }
        Contacto dato = inicio.getDato();
        inicio = inicio.getNext();
        if (inicio == null) {
            termino = null;
        }
        return dato;
    }

    public boolean estaVacia() {
        return inicio == null && termino == null;
    }

    public int contar() {
        int contador = 0;
        Nodo c = this.inicio;
        while (c != null) {
            contador++;
            c = c.getNext();
        }
        return contador;
    }

    @Override
    public String toString() {
        Nodo c = this.inicio;
        StringBuilder s = new StringBuilder();
        while (c != null) {
            s.append(c.toString()).append("\n");
            c = c.getNext();
        }
        return s.toString();
    }
}
