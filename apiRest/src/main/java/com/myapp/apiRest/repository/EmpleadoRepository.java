package com.myapp.apiRest.repository;

import com.myapp.apiRest.dominio.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpleadoRepository extends JpaRepository<Empleados, Long> {

}
