package com.roses.backend.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roses.backend.models.entities.Variedad;

public interface IVariedadRepository extends JpaRepository<Variedad, Integer> {

}
