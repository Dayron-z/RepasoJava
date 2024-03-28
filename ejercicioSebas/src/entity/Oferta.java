package entity;

public class Oferta {
    private String id;
    private double monto;
    private Usuario comprador;
    private Producto producto;

    public Oferta() {
    }

    public Oferta(String id, double monto, Usuario comprador, Producto producto) {
        this.id = id;
        this.monto = monto;
        this.comprador = comprador;
        this.producto = producto;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Usuario getComprador() {
        return comprador;
    }

    public void setComprador(Usuario comprador) {
        this.comprador = comprador;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }


    @Override
    public String toString() {
        return "Oferta{" +
                "id='" + id + '\'' +
                ", monto=" + monto +
                ", comprador=" + comprador +
                ", producto=" + producto +
                '}';
    }
}
