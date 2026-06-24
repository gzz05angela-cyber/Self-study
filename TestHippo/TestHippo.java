package TestHippo;
class Animal{
    public Animal(){
        System.out.println("Make an animal");
    }
}

class Hippo extends Animal{
    public Hippo(){
        System.out.println("Make a hippo");
    }
}

public class TestHippo{
    public static void main(String[] args) {
        System.out.println("Starting...");
        Hippo h = new Hippo();
    }
}
