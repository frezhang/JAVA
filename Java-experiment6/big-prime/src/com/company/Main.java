package com.company;

import java.math.*;

public class Main{
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        BigInteger bigNum = new BigInteger(Long.MAX_VALUE + "");
        bigNum = bigNum.add(BigInteger.ONE);
        int count = 1;
        /*while (count <= 5) {
            if (isPrime(bigNum)) {
                System.out.println(bigNum);
                count++;
            }
            bigNum = bigNum.add(BigInteger.ONE);
        }*/
        while(count<=5){
            //不一定是真正的素数，但通过手动实现判断素数效率太低
            bigNum = bigNum.nextProbablePrime();
            System.out.println(bigNum);
            count++;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time spent is " +
                (endTime - startTime) + " milliseconds");
    }

    public static boolean isPrime(BigInteger num) {
        if (num.compareTo(BigInteger.ONE) == 0 ||
                num.compareTo(new BigInteger("2")) == 0) {
            return true;
        }
        BigInteger halfNum = num.divide(new BigInteger("2"));
        for (BigInteger divisor = new BigInteger("2");
             divisor.compareTo(halfNum) <= 0;
             divisor = divisor.add(BigInteger.ONE)) {
            if (num.remainder(divisor).equals(BigInteger.ZERO)) {
                return false;
            }
        }
        return true;
    }
}