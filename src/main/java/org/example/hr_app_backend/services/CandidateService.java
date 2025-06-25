package org.example.hr_app_backend.services;

import lombok.RequiredArgsConstructor;
import org.example.hr_app_backend.entities.Candidate;
import org.example.hr_app_backend.repositories.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateService {
    private final CandidateRepository candidateRepository;

    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    public Candidate findById(Long id) {
        return candidateRepository.findById(id).orElseThrow(() -> new RuntimeException("Candidat non trouvé"));
    }

    public Candidate save(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public Candidate update(Long id, Candidate updated) {
        updated.setId(id);
        return candidateRepository.save(updated);
    }

    public void delete(Long id) {
        candidateRepository.deleteById(id);
    }
}
