package Banco.Services.Impl.ProcesadorPago.Exceptions;

public class FechaDeVencimientoNoValidaDebitoTarjetaException extends ProcesadorDebitoException{
    public FechaDeVencimientoNoValidaDebitoTarjetaException(String mensajeError) {
        super(mensajeError);
    }
}
