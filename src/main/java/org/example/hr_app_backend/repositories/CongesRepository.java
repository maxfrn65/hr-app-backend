package org.example.hr_app_backend.repositories;

import org.example.hr_app_backend.entities.Conges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CongesRepository extends JpaRepository<Conges, Long> {}
