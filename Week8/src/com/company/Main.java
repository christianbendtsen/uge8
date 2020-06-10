package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer> playerPost = new ArrayList <Integer>();
    static ArrayList<Integer> cpuPost = new ArrayList<Integer>();


    public static void main(String[] args) {

        System.out.println("Spillet starter..");
        Board board = new Board();
        board.drawBoard();


        while (true){
            System.out.println("Du er X, du starter. indtast et tal fra 1-9");
            Scanner sc = new Scanner(System.in);
            int playPos = sc.nextInt();

            while (playerPost.contains(playPos) || cpuPost.contains(playPos)){
                System.out.println("Position allerede brugt");
                playPos = sc.nextInt();
            }

            board.turn(playPos, "Dig");
            String resultat = board.checkWinner();

            if (resultat.length() > 0) {
                System.out.println(resultat);
                break;
            }

            Random random = new Random();
            int cpuPosition = random.nextInt(9)+1;
            while (playerPost.contains(cpuPosition) || cpuPost.contains(cpuPosition)){
                cpuPosition = random.nextInt(9)+1;
            }

            board.turn(cpuPosition, "Computeren");
            resultat = board.checkWinner();
            board.drawBoard();
            if (resultat.length() > 0) {
                System.out.println(resultat);
                break;
            }
        }
    }
}
