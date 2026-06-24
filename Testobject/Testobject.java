package Testobject;
public class Testobject {
    public static void main (String[] args){
        Dog a = new Dog();
        Cat c = new Cat();
        if (a.equals(c)){
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        Cat b = new Cat();
        System.out.println(b.getClass());

        Cat d = new Cat();
        System.out.println(d.hashCode());

        Cat e = new Cat();
        System.out.println(e.toString());
    }   
}

class Dog{

}


class Cat{

}