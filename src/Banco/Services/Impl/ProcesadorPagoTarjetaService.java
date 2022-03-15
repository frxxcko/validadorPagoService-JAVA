package Banco.Services.Impl;

import Banco.Entities.CreditoTarjeta;
import Banco.Entities.DebitoTarjeta;
import Banco.Entities.Tarjeta;
import Banco.Services.Impl.ProcesadorPago.Exceptions.*;

import javax.swing.event.DocumentEvent;
import java.time.LocalDateTime;

public abstract class ProcesadorPagoTarjetaService {

    private void imprimirMensajeDeTransaccion(String mensaje){
        System.out.println(mensaje);
    }

    private Boolean fechaExpiracionValida(Tarjeta tarjeta) {
        Boolean tarjetaEsValida = false;
        LocalDateTime fechaActual = LocalDateTime.now();

        if (tarjeta.getFechaExpiracion().compareTo(fechaActual) > 0)
            tarjetaEsValida = true;

        return tarjetaEsValida;
    }

    public void procesarPago(Tarjeta tarjeta, Double monto) throws ProcesadorPagoTarjetaException {
        try {
            Boolean esDebito = tarjeta.getClass().equals(DebitoTarjeta.class);
            Boolean esCredito = tarjeta.getClass().equals(CreditoTarjeta.class);

            if (!fechaExpiracionValida(tarjeta)) {
                if (esDebito)
                    throw new FechaDeVencimientoNoValidaDebitoTarjetaException("Caducó la validez de su tarjeta de débito. \n" +
                            "Por favor solicite un repuesto en nuestro Home Banking > Tarjetas > Solicitar repuesto > Débito");
                else if (esCredito)
                    throw new FechaDeVencimientoNoValidaCreditoTarjetaException("Caducó la validez de su tarjeta de débito. \n" +
                            "Por favor solicite un repuesto en nuestro Home Banking > Tarjetas > Solicitar repuesto > Crédito");
            }
            else if(!autorizarPago(tarjeta, monto))
                throw new AutorizacionPagoDenegadoException("Su pago no pudo ser procesado. " + (esDebito? "No cuenta con saldo disponible en la cuenta." : "Alcanzó el límite disponible.") );

            // LOGICA DE PROCESAMIENTO DE PAGO
            if(esDebito){
                DebitoTarjeta tarjetaDebito = (DebitoTarjeta)tarjeta;
                Double nuevoSaldo = ((DebitoTarjeta) tarjeta).getSaldoDisponible() - monto;

                tarjetaDebito.setSaldoDisponible(nuevoSaldo);
                imprimirMensajeDeTransaccion("Operación exitosa. Su nuevo saldo es $ " + tarjetaDebito.getSaldoDisponible() + ".");
            }
            else if(esCredito){
                CreditoTarjeta tarjetaCredito = (CreditoTarjeta) tarjeta;
                tarjetaCredito.setSaldoUtilizado(monto);

                imprimirMensajeDeTransaccion("Operación exitosa. Su límite actualizado ahora es de $ " + tarjetaCredito.limiteDisponible() + ".");
            }
        } catch (FechaDeVencimientoNoValidaDebitoTarjetaException e) {
            e.printStackTrace();
        } catch (FechaDeVencimientoNoValidaCreditoTarjetaException e) {
            e.printStackTrace();
        }
    }

    // autorizarPago() SEGUN CORRESPONDA EN CADA SERVICE (ProcesadorCreditoService, ProcesadorDebitoService)
    abstract Boolean autorizarPago(Tarjeta tarjeta, Double monto);
}
