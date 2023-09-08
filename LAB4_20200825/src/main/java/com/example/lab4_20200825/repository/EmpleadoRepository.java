package com.example.lab4_20200825.repository;

import com.example.lab4_20200825.entidad.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Employee, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM employees where first_name = ?1 or last_name= ?1")
    List<Employee> buscarPorNombre(String textoIngreso);
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE employees SET phone_number = ?1 ,salary= ?2 WHERE ShipperID = ?3")
    void actualizarTelefonosalario(String phone, BigDecimal salary, int id);


}
