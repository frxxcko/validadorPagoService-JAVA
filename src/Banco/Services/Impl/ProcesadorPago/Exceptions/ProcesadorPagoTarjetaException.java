package Banco.Services.Impl.ProcesadorPago.Exceptions;

import Banco.Exceptions.ServiceExceptions.ServiceException;

public abstract class ProcesadorPagoTarjetaException extends ServiceException {
    // CONSTRUCTOR PADRE ABSTRACT
    public ProcesadorPagoTarjetaException(String mensajeError) {
        super(mensajeError);
    }
}
