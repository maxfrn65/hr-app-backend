package org.example.hr_app_backend.services;

import lombok.RequiredArgsConstructor;
import org.example.hr_app_backend.entities.Employee;
import org.example.hr_app_backend.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employé non trouvé"));
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee update(Long id, Employee updated) {
        Employee existant = findById(id);
        updated.setId(id);
        return employeeRepository.save(updated);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
