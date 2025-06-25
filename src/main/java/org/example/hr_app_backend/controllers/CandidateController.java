package org.example.hr_app_backend.controllers;

import lombok.RequiredArgsConstructor;
import org.example.hr_app_backend.entities.Candidate;
import org.example.hr_app_backend.services.CandidateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidate")
@RequiredArgsConstructor
public class CandidateController {
    private final CandidateService candidateService;

    @GetMapping
    public List<Candidate> getAll() {
        return candidateService.findAll();
    }

    @GetMapping("/{id}")
    public Candidate getById(@PathVariable Long id) {
        return candidateService.findById(id);
    }

    @PostMapping
    public Candidate create(@RequestBody Candidate candidate) {
        return candidateService.save(candidate);
    }

    @PutMapping("/{id}")
    public Candidate update(@PathVariable Long id, @RequestBody Candidate candidate) {
        return candidateService.update(id, candidate);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        candidateService.delete(id);
    }
}
