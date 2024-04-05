package entity;

import entity.Avion;
import entity.Vuelo;

public class VueloConAvion {
    private Vuelo vuelo;
    private Avion avion;

    public VueloConAvion() {
    }

    public VueloConAvion(Vuelo vuelo, Avion avion) {
        this.vuelo = vuelo;
        this.avion = avion;
    }

    // Getters y setters (según sea necesario)

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    @Override
    public String toString() {
        return "VueloConAvion{" +
                "vuelo=" + vuelo +
                ", avion=" + avion +
                '}';
    }
}
