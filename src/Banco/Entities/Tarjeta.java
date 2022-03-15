package Banco.Entities;

import java.time.LocalDateTime;
import java.util.Date;

public abstract class Tarjeta {
    private String numerosFrente;
    private String codigoSeguridad;
    private LocalDateTime fechaExpiracion;

    public Tarjeta(String numerosFrente, String codigoSeguridad, LocalDateTime fechaExpiracion) {
        this.numerosFrente = numerosFrente;
        this.codigoSeguridad = codigoSeguridad;
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getNumerosFrente() {
        return numerosFrente;
    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public LocalDateTime getFechaExpiracion() {
        return fechaExpiracion;
    }
}