package DuckConstructor;
class Duck{
    int size;

    public Duck(){
        System.out.println("Quack");
    }

    public void setSize(int newSize){
        size = newSize;
    }
}

public class UseADUCK{
    public static void main(String[] args){
        Duck d = new Duck();

        d.setSize(42);
    }
}

