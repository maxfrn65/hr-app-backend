package org.example.hr_app_backend.controllers;

import lombok.RequiredArgsConstructor;
import org.example.hr_app_backend.entities.Absence;
import org.example.hr_app_backend.entities.Employee;
import org.example.hr_app_backend.repositories.EmployeeRepository;
import org.example.hr_app_backend.services.AbsenceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/absence")
@RequiredArgsConstructor
public class AbsenceController {
    private final AbsenceService absenceService;
    private final EmployeeRepository employeeRepository;

    @PostMapping
    public Absence create(@RequestBody Absence absence) {
        Employee emp = employeeRepository.findById(absence.getEmployee().getId())
                .orElseThrow(() -> new RuntimeException("Employé non trouvé"));
        absence.setEmployee(emp);
        return absenceService.save(absence);
    }
}
