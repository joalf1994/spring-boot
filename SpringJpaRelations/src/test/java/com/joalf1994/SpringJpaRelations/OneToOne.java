package com.joalf1994.SpringJpaRelations;

import com.joalf1994.SpringJpaRelations.model.Direccion;
import com.joalf1994.SpringJpaRelations.model.Empleado;
import com.joalf1994.SpringJpaRelations.repository.EmpleadoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
public class OneToOne {

    @Autowired
    private EmpleadoRepository empleadoRepository;


    @Test
    public void insertar() {
        Empleado empleado = new Empleado(1L, "Perez", "Pepito", LocalDate.of(1984, 6, 15));
        empleado.setDireccion(new Direccion(1L, "Los Robles 123", "La esperanza", "Trujillo", "Peru"));

        Empleado empleado2 = new Empleado(2L, "Juarez", "Carlos", LocalDate.of(1999, 8, 10));
        empleado2.setDireccion(new Direccion(2L, "los pinos, 154", "Florencia", "Florencia", "Peru"));

        empleadoRepository.save(empleado);
        empleadoRepository.save(empleado2);

        List<Empleado> empleados = empleadoRepository.findByNombre("Carlos");
        assertFalse(empleados.isEmpty());
        assertEquals("Carlos", empleados.get(0).getNombre());
    }

    @Test
    public void imprimir() {
        List<Empleado> empleados = empleadoRepository.findAll();
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }
    }
}
