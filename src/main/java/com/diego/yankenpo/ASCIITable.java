package com.diego.yankenpo;

import com.github.freva.asciitable.AsciiTable;
import com.github.freva.asciitable.Column;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ASCIITable {

    public static void renderTable(String[] moves) {
        Game tb = new Game(moves);
        List<String> list = new ArrayList<>();
        list.add("vv Computer/User >>");
        list.addAll(Arrays.asList(moves));

        String[] headers = new String[list.size()];
        headers = list.toArray(headers);

        String[][] rsArrays = new String[moves.length][moves.length + 1];

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j <= moves.length; j++) {
                if (j == 0) {
                    rsArrays[i][j] = moves[i];
                } else {
                    rsArrays[i][j] = tb.getMoves().get(i).get(j - 1);
                }
            }
        }

        System.out.println(AsciiTable.getTable(headers, rsArrays));
    }
}
