package com.tienda.dona.rosa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tienda.dona.rosa.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    @Query("SELECT p FROM Producto p WHERE p.cantidad < (0.1 * :cantidadInicial)")
    List<Producto> findProductosCercaDeAcabarse(@Param("cantidadInicial") int cantidadInicial);

    @Query("SELECT SUM(p.precio * p.cantidad) FROM Producto p")
    Double calcularCostoTotalInventario();
}