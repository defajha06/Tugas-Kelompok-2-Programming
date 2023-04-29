import static java.lang.System.in;

import java.io.IOException;
import java.util.Scanner;

public class CopoeWordPuzzle {
    public static void main(String[] args) {
        // global variable
        Scanner scanner = new Scanner(in);
        int score;
        int totalScore = 0;
        int level = 1;
        String kataUser="";

        // setup game
        // Answer
        String Dict[][] = {
                {
                        "die", "led", "lei", "let", "lid", "lie", "lit", "tie", "deli", "diet", "edit", "idle",
                        "lied", "tide", "tied", "tile", "tilt", "tilde", "tiled", "title", "tilted", "titled"
                },
                {
                        "sec","can","ease","seen","sane","acne","scan","cane","case","scene","cease"
                },
                {
                        "heron", "hero", "honker", "hone", "honk", "horn", "eon", "roe", "ore", "hen",
                        "her", "hoe", "nor", "oke", "one", "rho"
                }
        };

        // Random Words
        char arr[][] = {{'d', 'e', 't', 'l', 'i', 't'},
                {'s', 'e', 'c', 'a', 'e', 'n'},
                {'h', 'k', 'r', 'n', 'e', 'o'}} ;

        // start the game
        System.out.println("\n- Coepoe Word Puzzle -");
        System.out.println("======================\n");
        System.out.println("" +
                "1. Create a word using give characters, min 3 characters & max 6 characters.\n" +
                "2. Each level, You have 10 chances to answer correctly.\n" +
                "3. To get through to next level, you have to score 70 point each level.\n");

        // looping level
        do {
            score = 0;
            String jawabanUser[] = {"","","","","","","","","",""};

            // level information
            System.out.println("\nLevel " + level);
            System.out.println("-------");

            // insert words into trie
            System.out.print("\t");
            for (int i = 0; i < arr[level - 1].length; i++)
                System.out.print(arr[level - 1][i] + "  ");

            System.out.println("");
            int times = 1;

            // looping input user and validation words
            do {
                System.out.print(times + "> Your Answer : ");
                kataUser = scanner.nextLine();
                boolean same = false;

                for (int a = 0; a < jawabanUser.length; a++){
                    if (jawabanUser[a].equals(kataUser)){
                        System.out.println("You had already type this word before..");
                        same = true;
                        break;
                    }
                }

                jawabanUser[times - 1] = kataUser;

                if (!same){
                    for (int a = 0; a < Dict[level - 1].length; a++){
                        if (Dict[level - 1][a].equals(kataUser)){
                            score += 10;
                            System.out.println("#Right. Score : " + score);
                        }
                    }
                    times++;
                }
            } while (times <= 10);

            // checking the score and level up decision
            if (score < 70){
                int loopExit = 1;

                System.out.println("\nYou Lose!! Try Again..");

                do {
                    System.out.print("Do you want to retry [y/t] ? ");
                    String program = scanner.next();

                    if (program.equals("y") || program.equals("Y")){
                        loopExit = 0;
                        main(args);
                    } else if (program.equals("t") || program.equals("T")) {
                        loopExit = 0;
                        level = 4;
                    } else {
                        loopExit++;
                    }
                } while (loopExit > 0);
            } else {
                totalScore += score;

                if (level < 3) {
                    System.out.println("\nYou had answered 10 times with " + score/10 + " right answers..");
                    System.out.println("Correct Answers : ");
                    for (int a = 0; a < Dict[level-1].length; a++){
                        System.out.print(Dict[level - 1][a] + " ");
                        if (a % 10 == 0)
                            System.out.println("");
                    }
                    System.out.println("");

                    level++;
                } else {
                    System.out.println("\nOverall score : " + totalScore);
                    System.out.println("You Win!!");

                    runEnter();
                    System.out.println("Congrats and Thanks :D");
                    level = 4;
                }
            }
        } while (level < 4);
    }

    // function press enter
    private static void runEnter(){
        System.out.print("Press ENTER to exit..");

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}