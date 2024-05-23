package pilas;

public class Contacto {
    private int id;
    private String nombre;
    private String telefono;

    public Contacto(int id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Contacto{id=" + id + ", nombre='" + nombre + "', telefono='" + telefono + "'}";
    }
}
