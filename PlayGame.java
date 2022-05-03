import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
/**
 * This class is the prgram where the battleship game will be played. Either automatically or actively, the progam
 * will then it will output to the "GameLog.txt" file using the Gamelog class.
 *
 * Purdue University -- CS18000 -- Spring 2022 -- Project 2 -- PlayGame
 *
 * @author Hardit Sandhu
 * @version March 28, 2022
 */
public class PlayGame {
    public static ArrayList<String> readFile(String fileName) throws FileNotFoundException { 

        ArrayList<String> list = new ArrayList<>();
        FileReader fr = new FileReader(fileName); 
        BufferedReader bfr = new BufferedReader(fr); 

        try {
            String line = bfr.readLine();
            while (line != null) {
                list.add(line);
                line = bfr.readLine();
            }
        
        } catch (IOException e) {
            e.printStackTrace();

        }
        return list;
    }

    
    public static void writeFile(String fileName, GameLog log) throws FileNotFoundException {
       
 
        try {
            FileOutputStream fos = new FileOutputStream(fileName, true);

            PrintWriter pw = new PrintWriter(fos); 
           
            pw.print(log.toString());
            pw.close();
        
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
    }

    public static void cleanFile(String fileName) throws FileNotFoundException {
       
        try { 
            FileWriter writer = new FileWriter(fileName, false);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public static void main(String[] args) throws FileNotFoundException {  

        

        // --- try*("try catch with the 2 arrays")
        ArrayList<String> playerOneLIST = readFile("ShipPositionsPlayerOne.txt");
        String[][] playerONE = new String[10][14];
        for (int i = 0; i < playerOneLIST.size(); i++) {
            String line = playerOneLIST.get(i);
            for (int x = 0; x < line.length(); x++) {
                char cord = line.charAt(x);
                playerONE[i][x] = Character.toString(cord);
            }
        }

        // ------------------------------------------------------
        //for (int i = 0; i < playerONE.length; i ++) {
            //for (int j = 0; j < playerONE[i].length; j ++) {
                //System.out.print(playerONE[i][j] + " ");
            //}
            //System.out.println();
        //}
        // ------------------------------------------------------


        ArrayList<String> playerTwoLIST = readFile("ShipPositionsPlayerTwo.txt");
        String[][] playerTWO = new String[10][14];
        for (int i = 0; i < playerTwoLIST.size(); i++) {
            String line = playerTwoLIST.get(i);
            for (int x = 0; x < line.length(); x++) {
                char cord = line.charAt(x);
                playerTWO[i][x] = Character.toString(cord);
            }
        }
        
        // --- -----------------------------------^
        // --- 'new area in code, might want to change'
        int turn = 0;
        int player1HITS = 0;
        int player2HITS = 0;
        int rowP1 = 0; 
        int colP1 = 1;
        int rowP2 = 2;
        int colP2 = 3;
        //String[][] playOneCopy = playerONE;
        //String[][] playTwoCopy = playerTWO;
        int winningplayer = 0;
        int losing = 0;
        int topBoard1 = 0;
        int middleBoard1 = 0; 
        int bottomBoard1 = 0;
        int topBoard2 = 0;
        int middleBoard2 = 0;
        int bottomBoard2 = 0;
        String board1 = "Bottom Heavy";
        String board2 = "Bottom Heavy";
        // --- ---------------------------------------^
        
        
        System.out.print("Hello, Welcome to Battleship!");
        System.out.println(" Please enter a Game mode:");
        System.out.println("1. Automated\n2. Active");
        Scanner scanner = new Scanner(System.in); 
        int choice = Integer.parseInt(scanner.nextLine());

        cleanFile("GameLog.txt");

        if (choice == 1) {

            //scanner.nextLine();
            System.out.println("Enter the filename with the game data: ");
            String file1 = scanner.nextLine();

            ArrayList<String> autoGame = readFile(file1);
            //System.out.println(autoGame);

            int i = 0;
            while (player1HITS <= 17 || player2HITS <= 17 ) {
                try {
                    turn++;
                    String player1row = autoGame.get(rowP1);
                    int player1col = Integer.parseInt(autoGame.get(colP1)) - 1;

        
                    if (player1row.equals("A")) {
                        i = 0;
                    } else if (player1row.equals("B")) {
                        i = 1;
                    } else if (player1row.equals("C")) {
                        i = 2;
                    } else if (player1row.equals("D")) {
                        i = 3;
                    } else if (player1row.equals("E")) {
                        i = 4;
                    } else if (player1row.equals("F")) {
                        i = 5;
                    } else if (player1row.equals("G")) {
                        i = 6;
                    } else if (player1row.equals("H")) {
                        i = 7;
                    } else if (player1row.equals("I")) {
                        i = 8;
                    } else if (player1row.equals("J")) {
                        i = 9;
                    }

                    //System.out.println(playerTWO[i][player1col]);
                    String mane = playerTWO[i][player1col]; 

                    if (mane.equals("H")) {
                        player1HITS++;
                        playerTWO[i][player1col] = "*H";
                    }

                    String player2row = autoGame.get(rowP2);
                    int player2col = Integer.parseInt(autoGame.get(colP2)) - 1;

                    //System.out.println("Player 2 Row: " + player2row);
                    //System.out.println("Player 2 Column: " + player2col);
                
                    if (player2row.equals("A")) {
                        i = 0;
                    } else if (player2row.equals("B")) {
                        i = 1;
                    } else if (player2row.equals("C")) {
                        i = 2;
                    } else if (player2row.equals("D")) {
                        i = 3;
                    } else if (player2row.equals("E")) {
                        i = 4;
                    } else if (player2row.equals("F")) {
                        i = 5;
                    } else if (player2row.equals("G")) {
                        i = 6;
                    } else if (player2row.equals("H")) {
                        i = 7;
                    } else if (player2row.equals("I")) {
                        i = 8;
                    } else if (player2row.equals("J")) {
                        i = 9;
                    }

                    //System.out.println(playerONE[i][player2col]);
                    String mane2 = playerONE[i][player2col];
                    if (mane2.equals("H")) {
                        player2HITS++;
                        playerONE[i][player2col] = "*H";
                    }


                    // Moving up by four spaces because 
                    //each respective variable is 4 spaces apart
                    rowP1 = rowP1 + 4; 
                    colP1 = colP1 + 4;
                    rowP2 = rowP2 + 4;
                    colP2 = colP2 + 4;

                    
                    if (player1HITS == 17) {
                        //System.out.println("Enemy fleet destroyed. Congratulations player 1!");
                        //winningplayer = 1;
                        //losing = player2HITS;
                        break;

                    } else if (player2HITS == 17) {
                        //System.out.println("Enemy fleet destroyed. Congratulations player 2!");
                        //winningplayer = 2;
                        //losing = player1HITS;
                        break;
                    }   

                    
                } catch (IndexOutOfBoundsException e) {
                    break;
                }
            }

        } else if (choice == 2) {

            boolean output = false;
            
            do {
                // ------ Player 1 ------
                turn++;
                System.out.println("Player 1 - Enter a row letter from A - J");
                String player1Row = scanner.nextLine();

                System.out.println("Player 1 - Enter a column number from 1 - 14");
                int player1Col = Integer.parseInt(scanner.nextLine());

                player1Col = player1Col - 1;
                int i = 0;
                if (player1Row.equals("A")) {
                    i = 0;
                } else if (player1Row.equals("B")) {
                    i = 1;
                } else if (player1Row.equals("C")) {
                    i = 2;
                } else if (player1Row.equals("D")) {
                    i = 3;
                } else if (player1Row.equals("E")) {
                    i = 4;
                } else if (player1Row.equals("F")) {
                    i = 5;
                } else if (player1Row.equals("G")) {
                    i = 6;
                } else if (player1Row.equals("H")) {
                    i = 7;
                } else if (player1Row.equals("I")) {
                    i = 8;
                } else if (player1Row.equals("J")) {
                    i = 9;
                }
                
                
                String mane = playerTWO[i][player1Col]; 

                if (mane.equals("*H")) {
                    System.out.println("Value:" + "M");
                } else if (mane.equals("H")) {
                    player1HITS++;
                    playerTWO[i][player1Col] = "*H";
                    System.out.println("Value:" + "H");
                } else {
                    System.out.println("Value:" + mane);
                }

                if (player1HITS == 17) {
                    //System.out.println("Enemy fleet destroyed. Congratulations player 1!");
                    //winningplayer = 1;
                    //losing = player2HITS;
                    output = true;
                    break;

                } else if (player2HITS == 17) {
                    //System.out.println("Enemy fleet destroyed. Congratulations player 2!");
                    //winningplayer = 2;
                    //losing = player1HITS;
                    output = true;
                    break;
                }   
                
                
                // ------- Player 2 -------

                //scanner.nextLine();
                System.out.println("Player 2 - Enter a row letter from A - J");
                String player2Row = scanner.nextLine();

                System.out.println("Player 2 - Enter a column number from 1 - 14");
                int player2Col = Integer.parseInt(scanner.nextLine());

                player2Col = player2Col - 1;
                int z = 0;
                if (player2Row.equals("A")) {
                    z = 0;
                } else if (player2Row.equals("B")) {
                    z = 1;
                } else if (player2Row.equals("C")) {
                    z = 2;
                } else if (player2Row.equals("D")) {
                    z = 3;
                } else if (player2Row.equals("E")) {
                    z = 4;
                } else if (player2Row.equals("F")) {
                    z = 5;
                } else if (player2Row.equals("G")) {
                    z = 6;
                } else if (player2Row.equals("H")) {
                    z = 7;
                } else if (player2Row.equals("I")) {
                    z = 8;
                } else if (player2Row.equals("J")) {
                    z = 9;
                }
                
                String mane2 = playerONE[z][player2Col];
                 

                if (mane2.equals("*H")) {
                    System.out.println("Value:M");

                } else if (mane2.equals("H")) {
                    System.out.println("Value:H");
                    player2HITS++;
                    playerONE[z][player2Col] = "*H";

                } else {
                    System.out.println("Value:" + mane2);
                }

                // ------- temp ---------
                //System.out.println("Player 1 Hits: " + player1HITS);
                // ---------------------

                // ------- temp ---------
                //System.out.println("Player 2 Hits: " + player2HITS);
                // ---------------------
                
                // -------- end --------
                
                if (player1HITS == 17) {
                    //System.out.println("Enemy fleet destroyed. Congratulations player 1!");
                    //winningplayer = 1;
                    //losing = player2HITS;
                    output = true;
                    break;

                } else if (player2HITS == 17) {
                    //System.out.println("Enemy fleet destroyed. Congratulations player 2!");
                    //winningplayer = 2;
                    //losing = player1HITS;
                    output = true;
                    break;
                }   
                
            } while (output == false) ;

        }

        if (player1HITS == 17) {
            System.out.println("Enemy fleet destroyed. Congratulations player 1!");
            winningplayer = 1;
            losing = player2HITS;
          
            

        } else if (player2HITS == 17) {
            System.out.println("Enemy fleet destroyed. Congratulations player 2!");
            winningplayer = 2;
            losing = player1HITS;
            
                   
        }   
        // ---------- temp ------------
        //System.out.println("Player 1");
        //for (int i = 0; i < playerONE.length; i ++) {
            //for (int j = 0; j < playerONE[i].length; j ++) {
                //System.out.print(playerONE[i][j] + " ");
            //}
            //System.out.println();
        //}
        // --------------------------
        
        // ---------- temp ------------
        //System.out.println("Player 2");
        //for (int i = 0; i < playerTWO.length; i ++) {
            //for (int j = 0; j < playerTWO[i].length; j ++) {
                //System.out.print(playerTWO[i][j] + " ");
            //}
            //System.out.println(); 
        //}
        // --------------------------
        

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 14; c++) {
                if (playerONE[r][c].equals("H") ||
                    playerONE[r][c].equals("*H")) {   
                    topBoard1++;
                }
                if (playerTWO[r][c].equals("H") ||
                    playerTWO[r][c].equals("*H")) {  
                    topBoard2++;
                }
            }
        }
        for (int r = 3; r < 7; r++) {
            for (int c = 0; c < 14; c++) {
                if (playerONE[r][c].equals("H") ||
                    playerONE[r][c].equals("*H")) {   
                    middleBoard1++;
                }
                if (playerTWO[r][c].equals("H") ||
                    playerTWO[r][c].equals("*H")) {
                    middleBoard2++;
                }
            }
        }
        for (int r = 7; r < 10; r++) {
            for (int c = 0; c < 14; c++) {
                if (playerONE[r][c].equals("H") ||
                    playerONE[r][c].equals("*H")) {   
                    bottomBoard1++;
                }
                if (playerTWO[r][c].equals("H") ||
                    playerTWO[r][c].equals("*H")) {
                    bottomBoard2++;
                }
            }
        }

        if (topBoard1 >= 9) {
            board1 = "Top Heavy";
        } else if (middleBoard1 >= 9) {
            board1 = "Middle Heavy";
        } else if (bottomBoard1 >= 9) {
            board1 = "Bottom Heavy";
        } else {
            board1 = "Scattered";
        }
        if (topBoard2 >= 9) {
            board2 = "Top Heavy";
        } else if (middleBoard2 >= 9) {
            board2 = "Middle Heavy";
        } else if (bottomBoard2 >= 9) {
            board2 = "Bottom Heavy";
        } else {
            board2 = "Scattered";
        }
        
        

        
        
        
        GameLog newMANE = new GameLog(winningplayer, losing, turn, board1, board2);
        writeFile("GameLog.txt", newMANE);

        scanner.close();
    }

}