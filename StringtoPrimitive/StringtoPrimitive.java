package StringtoPrimitive;

public class StringtoPrimitive {
    public static void main(String[] args){
        String s = "2";
        int x = Integer.parseInt(s);
        double d = Double.parseDouble("420.43");
        boolean b = Boolean.parseBoolean("True");

        if (b == true){
            System.out.println("x is" + x + " while d is" + d);
        } else {
            System.out.println("Dunno what's going on, bro");
        }

    }
}
