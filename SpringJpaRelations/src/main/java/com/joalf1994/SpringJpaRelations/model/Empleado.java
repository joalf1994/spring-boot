package com.joalf1994.SpringJpaRelations.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "EMPLEADO")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Empleado {

    @Id
    @Column(name = "COD_EMPLEADO")
    private Long codigo;

    @Column(name = "APELLIDOS")
    private String apellidos;

    @Column(name = "NOMBRES")
    private String nombre;

    @Column(name = "FECHA_NAC")
    private LocalDate fechaNacimiento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DIRECCION_ID")
    private Direccion direccion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PASAPORTE_ID", referencedColumnName = "id")
    private Pasaporte pasaporte;

    public Empleado(Long codigo, String apellidos, String nombre, LocalDate fechaNacimiento) {
        this.codigo = codigo;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }
}
