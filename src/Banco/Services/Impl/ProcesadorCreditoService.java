package Banco.Services.Impl;

import Banco.Entities.CreditoTarjeta;
import Banco.Entities.Tarjeta;

public class ProcesadorCreditoService extends ProcesadorPagoTarjetaService{
    CreditoTarjeta tarjetaCredito;

    @Override
    Boolean autorizarPago(Tarjeta tarjeta, Double monto) {
        tarjetaCredito = (CreditoTarjeta) tarjeta;
        Boolean limiteDisponible = tarjetaCredito.limiteDisponible() > monto;

        return limiteDisponible;
    }
}
