package org.example.hr_app_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String numeroCarteId;
    private LocalDate dateNaissance;
    private String adresse;
    private String email;
    private String tel;
    private Double note;
    private String domaineTechnique;
    private LocalDate dateEntretien;
    private String observations;
}
