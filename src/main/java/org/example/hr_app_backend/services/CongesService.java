package org.example.hr_app_backend.services;

import lombok.RequiredArgsConstructor;
import org.example.hr_app_backend.entities.Conges;
import org.example.hr_app_backend.repositories.CongesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CongesService {
    private final CongesRepository congesRepository;

    public List<Conges> findAll() {
        return congesRepository.findAll();
    }

    public Conges findById(Long id) {
        return congesRepository.findById(id).orElseThrow(() -> new RuntimeException("Congé non trouvé"));
    }

    public Conges save(Conges conges) {
        return congesRepository.save(conges);
    }

    public Conges update(Long id, Conges updated) {
        updated.setId(id);
        return congesRepository.save(updated);
    }

    public void delete(Long id) {
        congesRepository.deleteById(id);
    }
}
