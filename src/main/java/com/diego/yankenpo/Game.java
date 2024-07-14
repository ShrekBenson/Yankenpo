package com.diego.yankenpo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private List<List<String>> moves = new ArrayList<>();

    public Game(String[] moves) {
        movesTable(moves);
    }

    public List<List<String>> getMoves() {
        return moves;
    }

    private void movesTable(String[] moves) {
       List<Integer> indexes = new ArrayList<>();

       for (int i = 0; i < moves.length; i++) {
           indexes.add(i);
       }
       for (int i = 0; i < moves.length; i++) {
           List<String> rs = new ArrayList<>();
           for (int j = 0; j < moves.length; j++) {
               rs.add(result(i, j, moves.length));
           }
           this.moves.add(rs);
       }
    }

    private String result(int cm, int pm, int n) {
        int p = n / 2;
        int r = (cm - pm + p + n) % n - p;

        if (r == 0) return "TIE";
        else if (r > 0) return "LOSE";

        return "WIN";
    }

    public static void winner(int cm, int pm, int n) {
        int p = n / 2;
        int r = (cm - pm + p + n) % n - p;
        
        if (r == 0) System.out.println("TIE!");
        else if (r > 0) System.out.println("YOU LOSE!");
        else System.out.println("YOU WIN!");
    }
}
