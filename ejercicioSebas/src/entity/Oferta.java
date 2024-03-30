package entity;

public class Oferta {
    private String id;
    private double monto;
    private String comprador;
    private String producto;

    public Oferta() {
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

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Oferta{" +
                "id='" + id + '\'' +
                ", monto=" + monto +
                ", comprador='" + comprador + '\'' +
                ", producto='" + producto + '\'' +
                '}';
    }
}
