package Banco;

import Banco.Entities.CreditoTarjeta;
import Banco.Entities.DebitoTarjeta;
import Banco.Services.Impl.ProcesadorCreditoService;
import Banco.Services.Impl.ProcesadorDebitoService;
import Banco.Services.Impl.ProcesadorPago.Exceptions.ProcesadorPagoTarjetaException;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) throws ProcesadorPagoTarjetaException {

        LocalDateTime fechaFuturo = LocalDateTime.of(2026, 8,21, 23, 59);

        DebitoTarjeta tarjetaDebito1 = new DebitoTarjeta("4580 4080 4652 5465", "123",
                fechaFuturo, 188200.56);

        ProcesadorDebitoService procesadorDePagoDebito = new ProcesadorDebitoService();

        // CASO SIGUENTE DEBERIA DAR OK Y MOSTRAR NUEVO SALDO EN TARJETA DE DEBITO (PARA FORZAR UN ERROR INGRESE UNA FECHA VENCIDA O MONTO MAYOR AL saldoDisponible)
        procesadorDePagoDebito.procesarPago(tarjetaDebito1, 15000.00);

        CreditoTarjeta tarjetaCredito1 = new CreditoTarjeta("4580 4080 4652 5465", "123", fechaFuturo, 80000.00, 0.00);

        ProcesadorCreditoService procesadorDePagoCredito = new ProcesadorCreditoService();

        // CASO SIGUENTE DEBERIA DAR OK Y MOSTRAR NUEVO LIMITE DISPONIBLE EN TARJETA DE CREDITO (PARA FORZAR UN ERROR INGRESE UNA FECHA VENCIDA O MONTO MAYOR AL LIMITE DISPONIBLE)
        procesadorDePagoCredito.procesarPago(tarjetaCredito1, 27500.00);
    }
}
