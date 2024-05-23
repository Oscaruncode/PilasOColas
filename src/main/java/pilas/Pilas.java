
package pilas;

public class Pilas {
    Contacto[] stck;
    private int tos;

    public Pilas(int size) {
        stck = new Contacto[size];
        tos = -1;
    }

    public void push(Contacto value) {
        if (tos == stck.length - 1) {
            System.out.println("La Pila está llena - Overflow");
        } else {
            stck[++tos] = value;
        }
    }

    public Contacto pop() {
        if (tos < 0) {
            System.out.println("La Pila está vacía");
            return null;
        } else {
            return stck[tos--];
        }
    }

    public boolean isEmpty() {
        return tos == -1;
    }

    public int size() {
        return tos + 1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("La Pila está vacía");
        } else {
            for (int i = tos; i >= 0; i--) {
                System.out.println(stck[i]);
            }
        }
    }
}
