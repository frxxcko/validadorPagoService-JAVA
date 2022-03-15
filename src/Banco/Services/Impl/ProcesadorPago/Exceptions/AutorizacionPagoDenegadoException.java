package Banco.Services.Impl.ProcesadorPago.Exceptions;

public class AutorizacionPagoDenegadoException extends ProcesadorPagoTarjetaException{

    public AutorizacionPagoDenegadoException(String mensajeError) {
        super(mensajeError);
    }
}
