package entity;

import java.time.LocalDateTime;

public class Reservacion {
    private int id_reservacion;
    private int id_pasajero;
    private int id_vuelo;
    private LocalDateTime fecha_reservacion;
    private String asiento;

    public Reservacion(int id_reservacion, int id_pasajero, int id_vuelo, LocalDateTime fechaReservacion, String asiento) {
        this.id_reservacion = id_reservacion;
        this.id_pasajero = id_pasajero;
        this.id_vuelo = id_vuelo;
        this.fecha_reservacion = fechaReservacion;
        this.asiento = asiento;
    }

    public Reservacion() {
    }

    public int getId_reservacion() {
        return id_reservacion;
    }

    public void setId_reservacion(int id_reservacion) {
        this.id_reservacion = id_reservacion;
    }

    public int getId_pasajero() {
        return id_pasajero;
    }

    public void setId_pasajero(int id_pasajero) {
        this.id_pasajero = id_pasajero;
    }

    public int getId_vuelo() {
        return id_vuelo;
    }

    public void setId_vuelo(int id_vuelo) {
        this.id_vuelo = id_vuelo;
    }

    public LocalDateTime getFechaReservacion() {
        return fecha_reservacion;
    }

    public void setFechaReservacion(LocalDateTime fechaReservacion) {
        this.fecha_reservacion = fechaReservacion;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    @Override
    public String toString() {
        return "Reservacion{" +
                "id_reservacion=" + id_reservacion +
                ", id_pasajero=" + id_pasajero +
                ", id_vuelo=" + id_vuelo +
                ", fechaReservacion=" + fecha_reservacion +
                ", asiento='" + asiento + '\'' +
                '}';
    }
}
