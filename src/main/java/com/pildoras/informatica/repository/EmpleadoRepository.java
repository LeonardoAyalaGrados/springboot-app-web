package com.pildoras.informatica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pildoras.informatica.entity.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {

}
