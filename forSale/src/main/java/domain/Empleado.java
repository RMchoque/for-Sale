package domain;

import javax.swing.*;
import java.awt.*;
import java.util.stream.Collectors;

public class Empleado {
    private String nombre;
    Empleado(String elNombre){
        this.nombre = elNombre;
    }
    private List<Operacion> operaciones;


    private List<Zona> operacionesCerradas() {
        return this.operaciones
                .stream()
                .filter(o -> o.estaCerrada())
                .collest(Collectors.toList());
    }
    private List<Operacion> operacionesReservadas() {
    }

    private List<Zona> zonasOperacionesCerradas(){
        return operacionesCerradas()
        .steam()
        .map(o -> o.zonaDeInmueble())
        .collect(Collectors.toList());
    }

    public boolean podesTenerProblemasCon(Empleado otroEmpleado){
        return cerrasteOperacionEnLaMismaZonaQue(otroEmpleado)
        && concretasteOperacionReservadaPor(otroEmpleado);
    }
    private cerrasteOperacionesEnLaMismaZonaQue(Empleado otroEmpleado){
        List<Zona> misZonas = zonasOperacionesCerradas();
        List<Zona> zonasDelOtro = otroEmpleado.zonasOperacionesCerradas();

        return misZonas.stream().anyMatch(z -> zonasDelOtro.contains(z));
    }
    private boolean concretasteOperacionReservadasPor(Empleado otroEmpleado){
        List<Operacion> operacionesReservadasPorElOtro = otroEmpleado.operacionesReservadas();
        return this.operacionesCerradas()
        .stream()
        .anyMatch(o -> operacionesReservadasPorElOtro.contains(o));
    }
}
