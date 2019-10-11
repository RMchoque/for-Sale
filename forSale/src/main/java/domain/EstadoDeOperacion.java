package domain;

public interface EstadoDeOperacion extends Operacion {
    public void reservar(Cliente unCliente,Empleado unEmpleado,Inmueble unInmueble);

}