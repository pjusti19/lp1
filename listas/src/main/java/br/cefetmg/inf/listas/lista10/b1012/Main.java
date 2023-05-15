package br.cefetmg.inf.listas.lista10.b1012;

import java.util.Scanner;

class Poligono {
    private double lado;

    void setLado(double lado) {
        this.lado = lado; 
    }
    double getLado(){
        return lado;
    }
    double getArea() {
        return lado;
    }
}

class Triangulo extends Poligono {
    private double altura;
    
    void setAltura(double altura){
        this.altura = altura;
    }
    
    double getArea() {
        return getLado() * altura / 2;
    }
}

class Circulo extends Poligono {

    double getArea() {
        return 3.14159 * (getLado() * getLado());
    }
}

class Trapezio extends Poligono {
    private double base;
    private double altura;

    void setBase(double base){
        this.base = base;
    }
    void setAltura(double altura){
        this.altura = altura;
    }
    double getArea() {
        return ((getLado() + base) * altura) / 2.0;
    }
}

class Quadrado extends Poligono {
    double getArea() {
        return getLado() * getLado();
    }
}

class Retangulo extends Poligono {
    double largura;
    
    void setLargura(double largura){
        this.largura = largura;
    }
    double getArea() {
        return getLado() * largura;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double a, b, c;
        a = in.nextDouble();
        b = in.nextDouble();
        c = in.nextDouble();

        Triangulo triangulo = new Triangulo();
        triangulo.setLado(a);
        triangulo.setAltura(c);

        Circulo circulo = new Circulo();
        circulo.setLado(c);

        Trapezio trapezio = new Trapezio();
        trapezio.setLado(a);
        trapezio.setBase(b);
        trapezio.setAltura(c);

        Quadrado quadrado = new Quadrado();
        quadrado.setLado(b);

        Retangulo retangulo = new Retangulo();
        retangulo.setLado(a);
        retangulo.setLargura(b);

        System.out.printf("TRIANGULO: %.3f%n", triangulo.getArea());
        System.out.printf("CIRCULO: %.3f%n", circulo.getArea());
        System.out.printf("TRAPEZIO: %.3f%n", trapezio.getArea());
        System.out.printf("QUADRADO: %.3f%n", quadrado.getArea());
        System.out.printf("RETANGULO: %.3f%n", retangulo.getArea());

        in.close();
    }
}
