package entity;

public class ReservacionPasajeroVuelo {
    Reservacion reservacion;
    Pasajero pasajero;
    Vuelo vuelo;


    public ReservacionPasajeroVuelo() {
    }

    public ReservacionPasajeroVuelo(Reservacion reservacion, Pasajero pasajero, Vuelo vuelo) {
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
        String separador = "----------------------------------------------------------"; // Línea de separación


        String mensaje = "Datos generales:\n" +
                "    ID de reservación: " + reservacion.getId_reservacion() + "\n" +
                "    Nombre del pasajero: " + pasajero.getNombre_pasajero() + " " + pasajero.getApellido_pasajero() + "\n" +
                "    Destino: " + vuelo.getDestino() + " " +
                "    Fecha de salida: " + vuelo.getFecha_salida().toString() + " " +
                "    Hora de salida: " + vuelo.getHora_salida() + "\n" +
                "    Asiento: " + reservacion.getAsiento() + " " +
                "    Documento de identidad: " + pasajero.getDocumento_identidad() + "\n" +
                separador + "\n"; // Línea de separación y salto de línea al final

        return mensaje;



    }
}
