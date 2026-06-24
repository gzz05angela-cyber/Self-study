package DuckConstructor;

public class Duck2 {
    int size;
    
    public static void main (String[] args){
        Duck2 duck = new Duck2();
        Duck2 duck2 = new Duck2(78);

    }

    public Duck2() {
        this(0);
    }

    public Duck2(int newSize){
        if (newSize == 0){
            size = 27;
        } else {
            size = newSize;
        }
        System.out.println("the size of the duck is "+ size);
    }
}
