package Autoboxing;

import java.util.ArrayList;

public class Autoboxing {
    public int num;

    public static Autoboxing autoboxing(){
        Autoboxing a = new Autoboxing();
        int x = 32;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(x);

        a.num = list.get(0);
        return a;
    }

    public static void main(String[] args) {
        System.out.println(autoboxing().num);
    }
}
