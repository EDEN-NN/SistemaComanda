package fatec.edu.walison.controller;

import fatec.edu.walison.model.Client;
import fatec.edu.walison.model.Employee;
import fatec.edu.walison.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> employees = service.findAll();
        return ResponseEntity.ok().body(employees);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> findEmployee(@PathVariable Long id) {
        Employee employee = service.findById(id);
        return ResponseEntity.ok().body(employee);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee newEmployee = service.findById(id);
        service.saveEmployee(newEmployee);
        return ResponseEntity.accepted().body(newEmployee);
    }

    @PostMapping("/employee/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        employee = service.saveEmployee(employee);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(employee.getUserId()).toUri();
        return ResponseEntity.created(uri).body(employee);
    }

    @DeleteMapping("/employee/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        Employee employee = service.findById(id);
        if(employee != null) {
            service.deleteEmployee(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
