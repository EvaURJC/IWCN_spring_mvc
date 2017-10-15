package com.iwcn.products;

import org.springframework.stereotype.Component;

@Component
public class Producto {

//		public Producto() {
//		}
		
		public String codigo;
		
		public String nombre;
		
		public String descripcion;
		
		public Integer precio;
		
		// Getters y setters

		public String getCodigo() {
			return codigo;
		}

		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public Integer getPrecio() {
			return precio;
		}

		public void setPrecio(Integer precio) {
			this.precio = precio;
		}
		
}
