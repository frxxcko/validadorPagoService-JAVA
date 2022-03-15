package Banco.Exceptions.ServiceExceptions;

public class ServiceException extends Exception{
    public ServiceException(String mensajeError) {
        super(mensajeError);
    }
}
