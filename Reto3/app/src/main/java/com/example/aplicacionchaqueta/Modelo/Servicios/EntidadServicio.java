package com.example.aplicacionchaqueta.Modelo.Servicios;

public class EntidadServicio {

   private int img;
   private String descripcion;

    public EntidadServicio(int img, String descripcion) {
        this.img = img;
        this.descripcion = descripcion;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
