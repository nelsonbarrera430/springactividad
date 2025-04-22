package com.example.market.infraestructure.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.market.infraestructure.entity.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {
}
