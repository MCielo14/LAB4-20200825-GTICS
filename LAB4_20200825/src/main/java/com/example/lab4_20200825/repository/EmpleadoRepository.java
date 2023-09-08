package com.example.lab4_20200825.repository;

import com.example.lab4_20200825.entidad.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Employee, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM employees where first_name = ?1 or last_name= ?1")
    List<Employee> buscarPorNombre(String textoIngreso);

}
