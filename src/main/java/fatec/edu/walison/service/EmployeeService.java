package fatec.edu.walison.service;

import fatec.edu.walison.model.Employee;
import fatec.edu.walison.repository.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;

public class EmployeeService {

    @Autowired
    IEmployee repository;

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public Employee findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Employee not found"));
    }

    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    public void deleteEmployee(Long id) {
        Employee employee = this.findById(id);
        repository.deleteById(employee.getUserId());
    }

}
