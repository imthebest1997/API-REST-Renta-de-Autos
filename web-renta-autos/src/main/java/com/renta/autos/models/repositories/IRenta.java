package com.renta.autos.models.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.renta.autos.models.entities.Renta;

public interface IRenta extends JpaRepository<Renta,Integer> {

}


