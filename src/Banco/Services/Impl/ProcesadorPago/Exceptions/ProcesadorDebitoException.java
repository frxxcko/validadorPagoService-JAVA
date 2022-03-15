package Banco.Services.Impl.ProcesadorPago.Exceptions;

public class ProcesadorDebitoException extends ProcesadorPagoTarjetaException{
    // CONSTRUCTOR
    public ProcesadorDebitoException(String mensajeError) {
        super(mensajeError);
    }
}