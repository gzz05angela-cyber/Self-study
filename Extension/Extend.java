package Extension;
import java.util.ArrayList;

public class Extend {
    public static void main (String[] args){
        ArrayList<Animal> animals = new ArrayList<Animal>();
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Wolf());

        for (Animal animal:animals){
            animal.speak();
        }
    }
}

class Animal{
    public void speak(){
        System.out.println("Ruff!Ruff!");
    }
}

class Dog extends Animal{
}

class Cat extends Animal{
    public void speak(){
        System.out.println("Meow!Meow!");
    }
}

class Wolf extends Animal{
    public void speak(){
        System.out.println("Howl!Howl!");
    }
}