package Extension;
public class Extension {
    public static void main(String[] args){
        Wolf wolf = new Wolf();
        Hippo hippo = new Hippo();

        wolf.eat();
        wolf.sleep();
        wolf.roam();

        hippo.eat();
        hippo.sleep();
    }
}

class Animal{
    
    public void eat(){
        System.out.println(" eats food");
    }

    public void sleep(){
        System.out.println("sleeps");
    }
}

class Wolf extends Animal{
    public void roam(){
        System.out.println("roams");
    }
}

class Hippo extends Animal{
  
    public void eat(){
        System.out.println(" crunches on plants");
    }
}