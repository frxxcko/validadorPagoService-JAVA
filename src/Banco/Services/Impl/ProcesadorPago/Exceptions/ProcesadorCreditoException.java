package Banco.Services.Impl.ProcesadorPago.Exceptions;

public class ProcesadorCreditoException extends ProcesadorPagoTarjetaException{
    public ProcesadorCreditoException(String mensajeError) {
        super(mensajeError);
    }
}
