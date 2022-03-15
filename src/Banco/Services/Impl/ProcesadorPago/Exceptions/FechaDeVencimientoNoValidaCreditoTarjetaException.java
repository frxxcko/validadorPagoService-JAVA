package Banco.Services.Impl.ProcesadorPago.Exceptions;

public class FechaDeVencimientoNoValidaCreditoTarjetaException extends ProcesadorCreditoException{
    public FechaDeVencimientoNoValidaCreditoTarjetaException(String mensajeError) {
        super(mensajeError);
    }
}
