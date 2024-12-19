package com.tienda.dona.rosa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.dona.rosa.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
