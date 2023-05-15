package br.cefetmg.inf.listas.lista10.b1049;

import java.util.Scanner;

class Animal {

    String tipo;

    Animal(String tipo) {
        this.tipo = tipo;
    }

    String getTipo() {
        return tipo;
    }
}

//vertebrados

class Vertebrado extends Animal{
    Vertebrado(String tipo) {
        super(tipo);
    }
}

//ave

class Ave extends Vertebrado{
    Ave(String tipo) {
        super(tipo);
    }
}
class Aguia extends Ave{
    Aguia() {
        super("aguia");
    }
}
class Pomba extends Ave{
    Pomba() {
        super("pomba");
    }
}

// mamifero

class Mamifero extends Vertebrado{
    Mamifero(String tipo) {
        super(tipo);
    }
}
class Homem extends Mamifero{
    Homem() {
        super("homem");
    }
}
class Vaca extends Ave{
    Vaca() {
        super("vaca");
    }
}

// invertebrados

class Invertebrado extends Animal{
    Invertebrado(String tipo) {
        super(tipo);
    }
}

//inseto

class Inseto extends Invertebrado{
    Inseto(String tipo) {
        super(tipo);
    }
}
class Pulga extends Inseto{
    Pulga() {
        super("pulga");
    }
}
class Lagarta extends Inseto{
    Lagarta() {
        super("lagarta");
    }
}

// anelideo

class Anelideo extends Invertebrado{
    Anelideo(String tipo) {
        super(tipo);
    }
}
class Sanguessuga extends Ave{
    Sanguessuga() {
        super("sanguessuga");
    }
}
class Minhoca extends Anelideo{
    Minhoca() {
        super("minhoca");
    }
}
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String filo, classe, alimento;

        filo = in.nextLine();
        classe = in.nextLine();
        alimento = in.nextLine();
        Animal animal;
        
        if(filo.equals("vertebrado")){
            if(classe.equals("ave")){
                if(alimento.equals("carnivoro"))
                    animal = new Aguia();
                else
                    animal = new Pomba();
            }
            else{
                if(alimento.equals("onivoro"))
                    animal = new Homem();
                else
                    animal = new Vaca();  
            }
        }
        else {
            if(classe.equals("inseto")){
                if(alimento.equals("hematofago"))
                    animal = new Pulga();
                else
                    animal = new Lagarta();
            }
            else{
                if(alimento.equals("hematofago"))
                    animal = new Sanguessuga();
                else
                    animal = new Minhoca(); 
            }
            
        }
        System.out.println(animal.getTipo());
        in.close();
    }
}