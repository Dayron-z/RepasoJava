package entity;

public class Medico {
    private int id;
    private String nombre;
    private String apellido;
    private int id_especialidad;


    public Medico() {
    }

    public Medico(int id, String nombre, String apellido, int id_especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_especialidad = id_especialidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(int id_especialidad) {
        this.id_especialidad = id_especialidad;
    }


    @Override
    public String toString() {
        return "entity.Medico{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", id_especialidad=" + id_especialidad +
                '}';
    }
}
