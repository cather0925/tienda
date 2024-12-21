package com.tienda.dona.rosa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private double precio;
	private int cantidad;
	@Column(name="cantidad_inicial")
	private int cantidadInicial;
	@Column(name="cantidad_actual")
	private int cantidadActual;
	
	@ManyToOne
	private Usuario usuario;
	
public Producto() {
		
	}
	
public Producto(Integer id, String nombre, double precio, int cantidad, Usuario usuario) {
    this.id = id;
    this.nombre = nombre;
    this.precio = precio;
    this.cantidad = cantidad;
    this.usuario = usuario;
}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	

	public int getCantidadInicial() {
		return cantidadInicial;
	}

	public void setCantidadInicial(int cantidadInicial) {
		this.cantidadInicial = cantidadInicial;
	}
	
	public int getCantidadActual() {
        return this.cantidad; 
    }
	
	public boolean estaCercanoAgotarse() {
        return cantidad <= (cantidadInicial * 0.1);
    }

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad
				+ ", cantidadInicial=" + cantidadInicial + ", cantidadActual=" + cantidadActual + ", usuario=" + usuario
				+ "]";
	}

	public void setCantidadActual(int cantidadActua12) {
		
		
	}

	

	
}


	
	
	

