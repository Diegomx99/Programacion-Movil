package com.example.preexamen;

public class IMC {

    private float altura;
    private float peso;
    private float IMC;

    public IMC(){
        this.setAltura(0.0f);
        this.setPeso(0.0f);
        this.setIMC(0.0f);
    }

    public IMC(float altura, float peso, float IMC){
        this.setAltura(altura);
        this.setPeso(peso);
        this.setIMC(this.calcularIMC());
    }

    public float calcularIMC(){
        return this.peso/(this.altura * this.altura);
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getIMC() {
        return IMC;
    }

    public void setIMC(float IMC) {
        this.IMC = IMC;
    }
}
