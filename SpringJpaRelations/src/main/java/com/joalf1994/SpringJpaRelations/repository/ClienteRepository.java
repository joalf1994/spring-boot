package com.joalf1994.SpringJpaRelations.repository;

import com.joalf1994.SpringJpaRelations.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
