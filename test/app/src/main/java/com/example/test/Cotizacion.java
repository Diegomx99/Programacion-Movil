package com.example.test;

import java.util.Random;

public class Cotizacion {
    private int folio;
    private String descripcion;
    private float valorAuto;
    private float porEnganche;
    private float plazo;

    public int generarFolio(){
        Random r = new Random();

        return Math.abs(r.nextInt()%1000);
    }

    public Cotizacion () {
        this.setFolio(this.generarFolio());
        this.setDescripcion("");
        this.setValorAuto(0.0f);
        this.setPorEnganche(0.0f);
        this.setPlazo(0);
    }
    public Cotizacion(int folio, String descripcion, float valorAuto, float porEnganche, float plazo) {
        this.setFolio(this.generarFolio());
        this.setDescripcion(descripcion);
        this.setValorAuto(valorAuto);
        this.setPorEnganche(porEnganche);
        this.setPlazo(plazo);
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getValorAuto() {
        return valorAuto;
    }

    public void setValorAuto(float valorAuto) {
        this.valorAuto = valorAuto;
    }

    public float getPorEnganche() {
        return porEnganche;
    }

    public void setPorEnganche(float porEnganche) {
        this.porEnganche = porEnganche;
    }

    public float getPlazo() {
        return plazo;
    }

    public void setPlazo(float plazo) {
        this.plazo = plazo;
    }

    public float calcularEnganche(){
        return this.valorAuto * (this.porEnganche/100);
    }

    public float calcularPagoMensual(){
        return ((this.valorAuto - this.calcularEnganche()) / this.plazo);
    }
}
