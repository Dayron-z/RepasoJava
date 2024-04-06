package entity;

public class ReservacionPasajeroAvion {
    Reservacion reservacion;
    Pasajero pasajero;
    Vuelo vuelo;


    public ReservacionPasajeroAvion() {
    }

    public ReservacionPasajeroAvion(Reservacion reservacion, Pasajero pasajero, Vuelo vuelo) {
        this.reservacion = reservacion;
        this.pasajero = pasajero;
        this.vuelo = vuelo;
    }

    public Reservacion getReservacion() {
        return reservacion;
    }

    public void setReservacion(Reservacion reservacion) {
        this.reservacion = reservacion;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    @Override
    public String toString() {
        return "ReservacionPasajeroAvion{" +
                "reservacion=" + reservacion +
                ", pasajero=" + pasajero +
                ", vuelo=" + vuelo +
                '}';
    }
}
