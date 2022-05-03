import java.io.*;
import java.util.ArrayList;
/**
 * This class reads from two game files and uses concurrency to accurately display the information, all in sync/
 *
 * Purdue University -- CS18000 -- Spring 2022 -- Challenge -- MapNavigator
 *
 * @author Hardit Sandhu
 * @version March 30, 2022
 */
public class MapNavigator extends Thread {

    private static int currentRow;
    private static int currentColumn;
    private static int moveNumber;
    private static boolean started;
    private static char[][] map;
    
    private static Object obj = new Object();
    
    // ---- Might have to change from static --------
    private int playerNumber;
    // ----------------------------------------------
    private String fileName;

    public MapNavigator(int playerNumber, String fileName){
        this.playerNumber = playerNumber;
        this.fileName = fileName;
        currentRow = 4;
        currentColumn = 4;
        moveNumber = 0;
        started = false;
        
        char[][] temp = new char[10][10]; 
        map = temp;
        
    }
    public void moveLeft() {
        synchronized(obj) {
            currentColumn--;
        }
    }
    public void moveRight() {
        synchronized(obj) {
            currentColumn++;
        }
    }
    public void moveUp() {
        synchronized(obj) {
            currentRow--;
        }
    }
    public void moveDown() {
        synchronized(obj) {
            currentRow++;
        }
    }
    public void increaseMove() {
        synchronized(obj) {
            moveNumber++;
        }
    }
    public static void setStarted() {
        synchronized(obj) {
            started = true;
        }
    }
    public static boolean started() {
        synchronized(obj) {
            return started;
        }
    }

    

    
    
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
            bfr.close();
        
        } catch (IOException e) {
            e.printStackTrace();

        }
        return list;
    }

    public synchronized static void printStartFeild() {
        
        if (started == false) {
            System.out.println("Welcome! Initial map:");
            for (int r = 0; r < map.length; r++) {
                System.out.print("[");
                for (int c = 0; c < map[r].length-1; c++) {

                    if (r == 4 && c == 4) {
                        map[r][c] = '0';
                        System.out.print(map[r][c]);
                        System.out.print("|");
                        //System.out.print(" ");
                        continue;
                    }

                    map[r][c] = ' ';
                    System.out.print(map[r][c]);
                    System.out.print("|");
                }
                System.out.println(" ]");
                System.out.println("---------------------");
                setStarted(); 
            }
        } 
    }

    public synchronized static void printNewFeild(int row, int col, int playerNumber, String type) {
        
        System.out.println("Move number: " + moveNumber);
        System.out.println("Player: " + playerNumber);
        System.out.println("Move: " + type);
        for (int r = 0; r < map.length; r++) {
            System.out.print("[");
            for (int c = 0; c < map[r].length-1; c++) {

                if (r == row && c == col) {
                    map[r][c] = '0';
                    System.out.print(map[r][c]);
                    System.out.print("|");
                    //System.out.print(" ");
                    continue;
                }

                map[r][c] = ' ';
                System.out.print(map[r][c]);
                System.out.print("|");
            }
            System.out.println(" ]");
            System.out.println("---------------------");
        }
    
    }
    
    
    

    @Override
    public void run() {
        
        ArrayList<String> autoGame = new ArrayList<>();
        try {
            autoGame = readFile(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        if (started() == false) {
            printStartFeild();
            setStarted();
        }

        //started = true;
        String typeOfMove = "";
        for (int i = 0; i < autoGame.size(); i++) {
            String temp = autoGame.get(i);
            if (temp.equals("1")) {
                moveLeft();
                typeOfMove = "Left";
            } else if (temp.equals("2")) {
                moveRight();
                typeOfMove = "Right";
            } else if (temp.equals("3")) {
                moveUp();
                typeOfMove = "Up";
            } else if (temp.equals("4")) {
                moveDown();
                typeOfMove = "Down";
            } else {
                System.out.println("Error, invalid input!");
            }

            increaseMove();
            printNewFeild(currentRow, currentColumn, playerNumber, typeOfMove);

        }

    }

    public static void main(String[] args) {
        try {
            MapNavigator[] MapNavigators = {new MapNavigator(1, "PlayerOneMoves.txt"),
                    new MapNavigator(2, "PlayerTwoMoves.txt")}; 
    
            for (int i = 0; i < MapNavigators.length; i++) {
                MapNavigators[i].start();
            }
            for (int i = 0; i < MapNavigators.length; i++) {
                MapNavigators[i].join();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }
}