package Dog;
public class Dog {
    String name;
    
    public static void main (String[] args){
        Dog dog1 = new Dog();
        dog1.bark();
        dog1.name = "Charlotte";

        Dog[] myDogs = new Dog[3];
        myDogs[0] = new Dog();
        myDogs[1]= new Dog();
        myDogs[2]=dog1;

        myDogs[0].name = "Evelyn";
        myDogs[1].name = "Rebecca";

        System.out.println("Last dog's name is"+myDogs[2].name);
        System.out.println("First dog's name is" + myDogs[0].name);

        int x=0;
        while (x<myDogs.length){
            myDogs[x].bark();
            x=x+1;
        }
    }

    public void bark(){
        System.out.println(name+" says Ruff");
    }
    
    public void eat(){
    }
    
    public void chaseCat(){
    }
}

