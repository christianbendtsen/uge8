package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.company.Main.cpuPost;
import static com.company.Main.playerPost;


public class Board {
    private char[][] board;

    public Board() {
        board = new char[3][3];
    }


    public void drawBoard() {

        System.out.println("-----------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-----------");
        }

    }

    public void turn(int position, String spiller) {


        //viser hvem X og 0 er, dig eller computeren
        char brick = ' ';

        if (spiller.equals("Dig")) {
            brick = 'X';
            playerPost.add(position);
        } else if (spiller.equals("Computeren")) {
            brick = 'O';
            cpuPost.add(position);
        }


        switch (position) {
            case 1:
                board[0][0] = brick;
                break;
            case 2:
                board[0][1] = brick;
                break;
            case 3:
                board[0][2] = brick;
                break;
            case 4:
                board[1][0] = brick;
                break;
            case 5:
                board[1][1] = brick;
                break;
            case 6:
                board[1][2] = brick;
                break;
            case 7:
                board[2][0] = brick;
                break;
            case 8:
                board[2][1] = brick;
                break;
            case 9:
                board[2][2] = brick;
                break;
            default:
                break;
        }
    }

    public String checkWinner() {

        List topR = Arrays.asList(1, 2, 3);
        List midR = Arrays.asList(4, 5, 6);
        List butR = Arrays.asList(7, 8, 9);
        List leftC = Arrays.asList(1, 4, 7);
        List midC = Arrays.asList(2, 5, 8);
        List rightC = Arrays.asList(3, 6, 9);
        List diagLR = Arrays.asList(1, 5, 9);
        List diagRL = Arrays.asList(3, 5, 7);

        List<List> win = new ArrayList<List>();
        win.add(topR);
        win.add(midR);
        win.add(butR);
        win.add(leftC);
        win.add(midC);
        win.add(rightC);
        win.add(diagLR);
        win.add(diagRL);

        for (List list : win) {
            if (playerPost.containsAll(list)) {
                return "Tillykke du vandt!";
            } else if (cpuPost.containsAll(list)) {
                return "Du tabte desværre, Computeren vandt..";
            } else if (playerPost.size() + cpuPost.size() == 9) {
                return "Uafgjort... -.-";
            }
        }
        return "";
    }
}
