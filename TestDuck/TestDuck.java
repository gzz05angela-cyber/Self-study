package TestDuck;
public class TestDuck{
    public static void main(String[] args){
        int weight = 8;
        float density = 2.3F;
        String name = "Donald";
        long[] feathers = {1,2,3,4,5,6};
        boolean canFly = true;
        int airspeed = 22;

        Duck[] d = new Duck[7];
        d[0] = new Duck();
        d[1]= new Duck(density, weight);
        d[2] = new Duck(name, feathers);
        d[3] = new Duck(canFly);
        d[4] = new Duck(3.3F, airspeed);
        d[5] = new Duck(false);
        d[6] = new Duck(airspeed,density);
    }
}

class Duck{
    private int kilos = 6;
    private float floatability = 2.1F;
    private String name = "generic";
    private long[] feathers = {1,2,3,4,5,6,7};
    private boolean canFly = true;
    private int maxSpeed = 25;

    public Duck(){
        System.out.println("Type 1 duck");
    }

    public Duck(boolean fly){
        fly = canFly;
        System.out.println("Type 2 duck");
    }

    public Duck(float density, int weight){
        density = floatability;
        weight = kilos;
        System.out.println("Type 3 duck");
    }
    
    public Duck(String n, long[] f){
        n = name;
        f = feathers;
        System.out.println("Type 4 duck");
    }

    public Duck(int airspeed, float density){
        floatability = density;
        airspeed = maxSpeed;
        System.out.println("Type 5 duck");
    }
}