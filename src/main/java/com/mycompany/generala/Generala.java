/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.generala;

/**
 *
 * @author Marcelo
 */
public class Generala {

    protected int[] dice;
    public Generala(int d1, int d2, int d3, int d4, int d5){
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = d5;
    }

    public static int chance(int d1, int d2, int d3, int d4, int d5) {
        int total = 0;
        total += d1 + d2 + d3 + d4 + d5;
        return total;
    }

    // '(int... dice)' es similar a tener public static int generala(int d1, int d2, int d3 , etc) pero permite realizar operaciones como -> for (int die : dice)
    //es una forma de decir que el metodo puede aceptar 1 o más parametros de tipo int ... lista de parametros dinamicos.
    public static int generala(int... dice){
        int[] counts = new int[6];
        for (int die : dice)
            counts[die-1]++;
        for (int i = 0; i != 6; i++)
            if (counts[i] == 5)
                return 50;
        return 0;
    }

    public static int ones(int... dice) {
        int sum = 0;
        for(int die : dice)
            if(die == 1)
                sum++;
        return sum;
    }

    public static int twos(int... dice) {
        int sum = 0;
        for(int die : dice)
            if(die == 2)
                sum+=2;
        return sum;
    }

    public static int threes(int... dice) {
        int sum = 0;
        for(int die : dice)
            if(die == 3)
                sum+=3;
        return sum;
    }

    public int fours(){
        int sum=0;
        for (int die : dice)
            if (die == 4)
                sum += 4;
        return sum;
    }

    public int fives(){
        int sum = 0;
        for (int die : dice)
            if(die == 5)
                sum+=5;
        return sum;
    }

    public int sixes(){
        int sum = 0;
        for (int die : dice)
            if (die == 6)
                sum += 6;
        return sum;
    }

    public static int score_pair(int... dice) {
        int[] counts = new int[6];
        for(int die : dice)
            counts[die-1]++;
        for (int i = 0; i != 6; i++)
            if (counts[6-i-1] >= 2)
                return (6-i)*2;
        return 0;
    }

    public static int two_pair(int... dice){
        int[] counts = new int[6];
        for(int die : dice)
            counts[die-1]++;
        int n = 0;
        int sum = 0;
        for (int i = 0; i != 6; i++)
            if (counts[6-i-1] >= 2) {
                n++;
                sum += (6-i);
            }        
        if (n == 2)
            return sum * 2;
        else
            return 0;
    }

    public static int four_of_a_kind(int... dice){
        int[] counts = new int[6];
        for(int die : dice)
            counts[die-1]++;
        for (int i = 0; i != 6; i++)
            if (counts[i] >= 4)
                return (i+1) * 4;
        return 0;
    }

    public static int three_of_a_kind(int... dice){
        int[] counts = new int[6];
        for(int die : dice)
            counts[die-1]++;
        for (int i = 0; i < 6; i++)
            if (counts[i] >= 3)
                return (i+1) * 3;
        return 0;
    }

    public static int smallStraight(int... dice){
        int[] counts = new int[6];
        for(int die : dice)
            counts[die-1]++;
        for(int i = 0;i!=5;i++)
            if (counts[i]>=2 || counts[i]==0)
                return 0;
        return 15;
    }

    public static int largeStraight(int... dice) {
        int[] counts = new int[6];
        for(int die : dice)
            counts[die-1]++;
        for(int i = 5; i != 0;i--)
            if(counts[i]>=2 || counts[i]==0) {
                return 0;
            }
        return 20;
    }

    public static int fullHouse(int... dice) {
        int[] counts = new int[6];
        int par = 0;
        int trio = 0;
        for(int die : dice)
            counts[die-1]++;
        for (int i = 0; i != 6; i += 1)
            if (counts[i] == 2) {
                par = i+1;
            }else if(counts[i]==3){
                trio = i+1;
            }
        if (par!=0 && trio != 0)
            return par * 2 + trio * 3;
        else
            return 0;
    }
}

