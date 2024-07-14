package com.diego.yankenpo;

import java.util.*;

public class Main {
    private final static Random r = new Random();
    private final static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        List<String> opts = new ArrayList<>();
        for (int i = 1; i <= args.length; i++) {
            opts.add(String.valueOf(i));
        }

        try {
            int playerMoveIndex;
            String playerChoice;

            while (true) {
                int pcMoveIndex = r.nextInt(args.length);
                String pcMove = args[pcMoveIndex];
                MoveKey mk = new MoveKey();
                HMAC hmac = new HMAC(mk.getKey(), pcMove);
                
                System.out.println("<< YANKENPO >>");
                System.out.println("The computer has chosen its move");
                System.out.println("HMAC: " + hmac.getHmac());
                System.out.println("--------------------------"
                        + "--------------------------"
                        + "--------------------------"                        
                        + "\nChoose your move:");
                for (int i = 0; i < args.length; i ++) {
                    System.out.printf("%d. %s\n", i + 1, args[i]);
                }
                System.out.println("0. exit");
                System.out.println("?. help");

                System.out.print("\nYour move is: ");
                playerChoice = scanner.nextLine();

                if (playerChoice.equals("0")) {
                    System.out.println("\nClosing game...");
                    break;
                } else if (playerChoice.equals("?")) {
                    System.out.println("Choose carefully, here is the results table:");
                    ASCIITable.renderTable(args);
                }
                else if(opts.contains(playerChoice)){
                    playerMoveIndex = Integer.parseInt(playerChoice);
                    Game.winner(pcMoveIndex, playerMoveIndex - 1, args.length);
                    System.out.println("Computer move: " + pcMove);
                    System.out.println("HMAC Key: " + mk.getKey());
                    System.out.println();
                } else {
                    System.out.println("Invalid input. Try again.");
                }
            }
            
        } catch (IllegalArgumentException e) {
            System.out.println("Please, set up some moves next time."
                    + "\nExample: java filename rock spock paper lizzard scissors");
        }            
    }
    
}