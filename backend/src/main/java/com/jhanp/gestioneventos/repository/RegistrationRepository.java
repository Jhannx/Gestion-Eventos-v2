package com.jhanp.gestioneventos.repository;

import com.jhanp.gestioneventos.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository <Registration, Long> {
}
