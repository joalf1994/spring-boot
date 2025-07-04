package com.joalf1994.SpringJpaRelations;

import com.joalf1994.SpringJpaRelations.model.Direccion;
import com.joalf1994.SpringJpaRelations.model.Empleado;
import com.joalf1994.SpringJpaRelations.model.Pasaporte;
import com.joalf1994.SpringJpaRelations.repository.EmpleadoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

@DataJpaTest
public class OneToOneBidireccional {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Test
    public void insertar() {

        Empleado empleado = new Empleado(1L, "Perez", "Pepito", LocalDate.of(1984, 6, 15));
        empleado.setDireccion(new Direccion(1L, "Los Robles 123", "La esperanza", "Trujillo", "Peru"));

        Pasaporte pasaporte = new Pasaporte();
        pasaporte.setNumero("101010");
        pasaporte.setFEmision(LocalDate.of(2023,6,12));
        pasaporte.setFEmision(LocalDate.of(2028,5,13));

        empleado.setPasaporte(pasaporte);
        pasaporte.setEmpleado(empleado);

        empleadoRepository.save(empleado);

        Empleado obtenidoDb = empleadoRepository.findById(empleado.getCodigo()).orElseThrow();
        System.out.println("Empleado: " + obtenidoDb.getNombre());
        System.out.println("Pasaporte: " + obtenidoDb.getPasaporte().getNumero());
        System.out.println("empleado desde pasaporte: " + obtenidoDb.getPasaporte().getEmpleado().getNombre());
    }

}
