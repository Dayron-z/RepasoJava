package entity;

public class Pasajero {
    private int id;
    private String nombre_pasajero;
    private String apellido_pasajero;
    private String documento_identidad;

    public Pasajero(int id, String nombre_pasajero, String apellido_pasajero, String documento_identidad) {
        this.id = id;
        this.nombre_pasajero = nombre_pasajero;
        this.apellido_pasajero = apellido_pasajero;
        this.documento_identidad = documento_identidad;
    }

    public Pasajero() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_pasajero() {
        return nombre_pasajero;
    }

    public void setNombre_pasajero(String nombre_pasajero) {
        this.nombre_pasajero = nombre_pasajero;
    }

    public String getApellido_pasajero() {
        return apellido_pasajero;
    }

    public void setApellido_pasajero(String apellido_pasajero) {
        this.apellido_pasajero = apellido_pasajero;
    }

    public String getDocumento_identidad() {
        return documento_identidad;
    }

    public void setDocumento_identidad(String documento_identidad) {
        this.documento_identidad = documento_identidad;
    }

    @Override
    public String toString() {
        return "Pasajero{" +
                "id=" + id +
                ", nombre_pasajero='" + nombre_pasajero + '\'' +
                ", apellido_pasajero='" + apellido_pasajero + '\'' +
                ", documento_identidad='" + documento_identidad + '\'' +
                '}';
    }
}
