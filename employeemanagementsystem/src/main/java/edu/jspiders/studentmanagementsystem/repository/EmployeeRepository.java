package edu.jspiders.studentmanagementsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.jspiders.studentmanagementsystem.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

Optional<Employee> findById(int id);

Optional<Employee> findByEmail(String email);
List<Employee> findEmployeeByName(String name);

List<Employee> findBySalary(double salary);

}
