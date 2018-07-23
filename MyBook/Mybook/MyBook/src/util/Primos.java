package util;

import java.util.LinkedList;

public class Primos {
    private static final LinkedList<Integer> PRIMOS = new LinkedList<Integer> ();

    public static int nextPrime(int j){
        if(PRIMOS.isEmpty())
            start();            
        int maior = PRIMOS.get(PRIMOS.size()-1);
        if(j>maior)
            for(int i = maior; i<j;i++)
                isPrime(i);
        for(int i = j; !isPrime(j);j++ ){}
        return j;
    }
    
    private static boolean isPrime(int i) {
        for(int j : PRIMOS)
            if (i%j == 0 && i!=j) 
                return false;
        PRIMOS.add(i);
        return true;
    }
    
    private static void start(){
        PRIMOS.add(2);
        PRIMOS.add(3);
        PRIMOS.add(5);
        PRIMOS.add(7);
        PRIMOS.add(11);
        PRIMOS.add(13);
        PRIMOS.add(17);
        PRIMOS.add(19);
        PRIMOS.add(23);
        PRIMOS.add(23);
        PRIMOS.add(29);
        PRIMOS.add(31);
    }
}