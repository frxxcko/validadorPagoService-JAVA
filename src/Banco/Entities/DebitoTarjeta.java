package Banco.Entities;

import java.time.LocalDateTime;

public class DebitoTarjeta extends Tarjeta{
    private Double saldoDisponible;

    public Double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(Double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public DebitoTarjeta(String numerosFrente, String codigoSeguridad, LocalDateTime fechaExpiracion, Double saldoDisponible) {
        super(numerosFrente, codigoSeguridad, fechaExpiracion);
        this.saldoDisponible = saldoDisponible;
    }
}
