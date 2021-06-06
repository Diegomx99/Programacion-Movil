package com.example.preexamen;

public class Temperatura {

    private float tempInicial;

    public Temperatura(){
        this.setTempInicial(0.0f);
    }

    public Temperatura(float tempInicial){
        this.setTempInicial(tempInicial);
    }

    public double CelsToFahr(){
        return ( 1.8 * this.tempInicial) + 32;
    }

    public double FahrToCels(){
        return (this.tempInicial - 32) * 0.555556;
    }

    public float getTempInicial() {
        return tempInicial;
    }

    public void setTempInicial(float tempInicial) {
        this.tempInicial = tempInicial;
    }

}
