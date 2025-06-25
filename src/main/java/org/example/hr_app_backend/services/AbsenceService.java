package org.example.hr_app_backend.services;

import lombok.RequiredArgsConstructor;
import org.example.hr_app_backend.entities.Absence;
import org.example.hr_app_backend.repositories.AbsenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AbsenceService {
    private final AbsenceRepository absenceRepository;

    public List<Absence> findAll() {
        return absenceRepository.findAll();
    }

    public Absence findById(Long id) {
        return absenceRepository.findById(id).orElseThrow(() -> new RuntimeException("Congé non trouvé"));
    }

    public Absence save(Absence absence) {
        return absenceRepository.save(absence);
    }

    public Absence update(Long id, Absence updated) {
        updated.setId(id);
        return absenceRepository.save(updated);
    }

    public void delete(Long id) {
        absenceRepository.deleteById(id);
    }
}
