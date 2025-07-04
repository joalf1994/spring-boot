package com.jbobadilla.onetomany.repository;

import com.jbobadilla.onetomany.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva,Long> {
    List<Reserva> findByFechaEntrada(LocalDate fechaEntrada);
    List<Reserva> findByHuesped_Id(Long huespedId);

}
