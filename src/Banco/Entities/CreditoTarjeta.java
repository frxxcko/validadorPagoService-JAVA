package Banco.Entities;

import java.time.LocalDateTime;

public class CreditoTarjeta extends Tarjeta{
    private Double limite;
    private Double saldoUtilizado;

    public Double limiteDisponible(){
        return  this.limite - this.saldoUtilizado;
    }

    public CreditoTarjeta(String numerosFrente, String codigoSeguridad, LocalDateTime fechaExpiracion, Double limite, Double saldoUtilizado) {
        super(numerosFrente, codigoSeguridad, fechaExpiracion);
        this.limite = limite;
        this.saldoUtilizado = saldoUtilizado;
    }
}
