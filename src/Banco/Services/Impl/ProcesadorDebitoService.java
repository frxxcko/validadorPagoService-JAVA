package Banco.Services.Impl;

import Banco.Entities.DebitoTarjeta;
import Banco.Entities.Tarjeta;

public class ProcesadorDebitoService extends ProcesadorPagoTarjetaService {
    private DebitoTarjeta tarjetaDebito;

    @Override
    Boolean autorizarPago(Tarjeta tarjeta, Double monto) {
        tarjetaDebito = (DebitoTarjeta) tarjeta;
        Boolean autorizado = tarjetaDebito.getSaldoDisponible() > monto;

        return autorizado;
    }
}
