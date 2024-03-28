package entity;

public class Producto {
    private String id;
    private String nombre;
    private String descripción;
    private double precioInicial;
    private double precioActual;
    private Usuario vendedor;

    private Estado estado;

    public Producto() {
    }

    public Producto(String id, String nombre, String descripción, double precioInicial, double precioActual, Usuario vendedor, Estado estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripción = descripción;
        this.precioInicial = precioInicial;
        this.precioActual = precioActual;
        this.vendedor = vendedor;
        this.estado = estado;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public double getPrecioInicial() {
        return precioInicial;
    }

    public void setPrecioInicial(double precioInicial) {
        this.precioInicial = precioInicial;
    }

    public double getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(double precioActual) {
        this.precioActual = precioActual;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripción='" + descripción + '\'' +
                ", precioInicial=" + precioInicial +
                ", precioActual=" + precioActual +
                ", vendedor=" + vendedor +
                ", estado=" + estado +
                '}';
    }
}
