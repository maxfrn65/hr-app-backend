package org.example.hr_app_backend.controllers;

import lombok.RequiredArgsConstructor;
import org.example.hr_app_backend.entities.Conges;
import org.example.hr_app_backend.entities.Employee;
import org.example.hr_app_backend.repositories.EmployeeRepository;
import org.example.hr_app_backend.services.CongesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leave")
@RequiredArgsConstructor
public class CongesController {

    private final CongesService congesService;
    private final EmployeeRepository employeeRepository;

    @GetMapping
    public List<Conges> getAll() {
        return congesService.findAll();
    }

    @GetMapping("/{id}")
    public Conges getById(@PathVariable Long id) {
        return congesService.findById(id);
    }

    @PostMapping
    public Conges create(@RequestBody Conges conges) {
        if (conges.getEmployee() != null) {
            Employee emp = employeeRepository.findById(conges.getEmployee().getId())
                    .orElseThrow(() -> new RuntimeException("Employé non trouvé"));
            conges.setEmployee(emp);
        }
        return congesService.save(conges);
    }

    @PutMapping("/{id}")
    public Conges update(@PathVariable Long id, @RequestBody Conges conges) {
        return congesService.update(id, conges);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        congesService.delete(id);
    }
}
