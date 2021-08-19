/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrey R
 */
public class Carrito {

    public class ItemCarrito {

        private Calzado calzado;
        private int cantidad;

        public ItemCarrito(Calzado calzado, int cantidad) {
            this.calzado = calzado;
            this.cantidad = cantidad;
        }

        public ItemCarrito() {
        }

        public double getSubTotal() {
            return this.calzado.getPrecio()*this.cantidad;
        }
        
        public Calzado getCalzado() {
            return calzado;
        }

        public void setCalzado(Calzado calzado) {
            this.calzado = calzado;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }

    }

    private List<ItemCarrito> productos = new ArrayList<ItemCarrito>();

    public List<ItemCarrito> getProductos() {
        return productos;
    }

    public void setProductos(List<ItemCarrito> productos) {
        this.productos = productos;
    }

    public Carrito() {
    }

    public void agregarCalzado(Calzado c, int cantidad) {
        ItemCarrito item = new ItemCarrito();

        if (this.buscarItemCarrito(c) == null) {
            item.setCalzado(c);
            item.setCantidad(cantidad);
            this.productos.add(item);
        } else if (this.buscarItemCarrito(c) != null) {
            this.buscarItemCarrito(c).setCantidad(this.buscarItemCarrito(c).getCantidad()+cantidad);
        }

    }

    public void eliminarItem(int indice) {

        if (this.productos.get(indice).cantidad > 1) {
            this.productos.get(indice).setCantidad(this.productos.get(indice).cantidad - 1);
        } else if (this.productos.get(indice).cantidad == 1) {
            this.productos.remove(indice);

        }
    }

    public double obtenerTotal() {

        double total = 0;
        for (ItemCarrito itemCarrito : this.productos) {

            total += itemCarrito.calzado.getPrecio() * itemCarrito.cantidad;
        }

        return total;

    }

    public ItemCarrito buscarItemCarrito(Calzado c) {

        for (ItemCarrito item : this.productos) {
            if (item.getCalzado().getIdCalzado().equals(c.getIdCalzado())) {

                return item;
            }
        }
        return null;

    }

}
