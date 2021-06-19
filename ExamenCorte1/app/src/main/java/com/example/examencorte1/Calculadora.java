package com.example.examencorte1;

public class Calculadora {

    private float num1;
    private float num2;

    public Calculadora(){
        this.setNum1(0.0f);
        this.setNum2(0.0f);
    }

    public Calculadora(float num1, float num2){
        this.setNum1(num1);
        this.setNum2(num2);
    }

    public float suma(){
        return this.num1 + this.num2;
    }

    public float resta(){
        return this.num1 - this.num2;
    }

    public float multiplicacion(){
        return this.num1 * this.num2;
    }

    public float division(){
        return this.num1/this.num2;
    }


    public float getNum1() {
        return num1;
    }

    public void setNum1(float num1) {
        this.num1 = num1;
    }

    public float getNum2() {
        return num2;
    }

    public void setNum2(float num2) {
        this.num2 = num2;
    }
}
