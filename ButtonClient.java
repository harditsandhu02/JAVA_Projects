import java.io.*;
import java.net.*;
import javax.swing.*;
/**
 * A class for when the user plays the button game
 * 
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 11 -- ButtonClient
 *
 * @author Hardit Sandhu
 * @version April 07, 2022
 */
public class ButtonClient {

    private static int port;
    private static String host;
    private static Object[] choices = {"Click here"};
    

    
    public static void showWelcomeMessageDialog() {
        JOptionPane.showMessageDialog(null, "Welcome!",
                "Button Game!", JOptionPane.INFORMATION_MESSAGE);
    }

    public static String showHostNameInputDialog() {
        boolean tempBoo = false;
        do {
            host = JOptionPane.showInputDialog(null, "What is the host name", "Button Game!", JOptionPane.QUESTION_MESSAGE);

            if (host == null) {
                break;
            }
            

            try {
                Integer.parseInt(host);
                tempBoo = true;
                JOptionPane.showMessageDialog(null, "Please enter a valid host name!", "Botton Game!",
                    JOptionPane.ERROR_MESSAGE);

            } catch (NumberFormatException e) {
                tempBoo = false;

            }

        } while (tempBoo);

        return host;
    } 

    public static int showPortInputDialog() {
        boolean checkPort = true;
        do {
            String temp = JOptionPane.showInputDialog(null, "What is the port number?", "Botton Game!", JOptionPane.QUESTION_MESSAGE);

            if (temp == null) {
                break;
            }
            try {
                port = Integer.parseInt(temp);
                checkPort = false;

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid port number!", "Botton Game!",
                    JOptionPane.ERROR_MESSAGE);
                checkPort = true;
            }

        } while (checkPort);
        return port;
    } 

    public static int rdyPlay() {
        
        return JOptionPane.showConfirmDialog(null, "Are you ready to play?", "Botton Game!", 
        JOptionPane.YES_NO_OPTION);
    }

    public static int buttonClicks() {
        return JOptionPane.showOptionDialog(null,
        "Button Game!",
        "",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        choices,
        choices[0]);
    
    }

    public static int pressAgain() {
        return JOptionPane.showConfirmDialog(null, "Do you want to press the button again?", "Botton Game!", 
        JOptionPane.YES_NO_OPTION);
    }

    public static int playAgain() {
        return JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Botton Game!", 
        JOptionPane.YES_NO_OPTION);
    }

    
    public static void main (String[] args) throws UnknownHostException, IOException, ClassNotFoundException {

        int playAgain = JOptionPane.NO_OPTION;
        int rdyPlay = 0;
        int user = 0;
        int b, p;

        showWelcomeMessageDialog();
        Socket socket = new Socket();
        BufferedReader reader = null;
        PrintWriter writer = null;


        do {
            String host = showHostNameInputDialog();
            int port = showPortInputDialog();

            if (!socket.isConnected()) {
                try {
                    socket = new Socket(host, port);
    
                    JOptionPane.showMessageDialog(null, "Connection is successfully established!",
                        "Button Game!", JOptionPane.INFORMATION_MESSAGE);

                    reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    writer = new PrintWriter(socket.getOutputStream());
            


                } catch (UnknownHostException e) {
                    JOptionPane.showMessageDialog(null, "Connection is NOT established",
                        "Button Game!", JOptionPane.ERROR_MESSAGE);

                    reader.close();
                    writer.close();
                    socket.close();
                    return;

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Connection is NOT established",
                        "Button Game!", JOptionPane.ERROR_MESSAGE);
                    reader.close();
                    writer.close();
                    socket.close();
                    return;
                } 

            } else if (!(host.equals("localhost") && port == socket.getPort())) {
                JOptionPane.showMessageDialog(null, "Connection is NOT established",
                        "Button Game!", JOptionPane.ERROR_MESSAGE);
                reader.close();
                writer.close();
                socket.close();
                return;

            } else {
                JOptionPane.showMessageDialog(null, "Connection is successfully established!",
                        "Button Game!", JOptionPane.INFORMATION_MESSAGE);
            }
            
            writer.println("first");
            writer.flush();

            writer.println("list");
            writer.flush();
            String str = reader.readLine();
            String display = "Are you ready to play?\n" + str;

            writer.println("playerINC");
            writer.flush();

            rdyPlay = JOptionPane.showConfirmDialog(null, display, "Botton Game!", 
                    JOptionPane.YES_NO_OPTION);

            if (rdyPlay == JOptionPane.YES_OPTION) {
                        //int click;
                writer.print(String.valueOf(user));
                writer.println();
                            
                do {

                    
                    b = buttonClicks();

                    if (b == JOptionPane.OK_OPTION) {
                        writer.println("click");
                        writer.flush();
                    }
                    p = pressAgain();
                    if(p == JOptionPane.NO_OPTION) {
                        break;
                    }
            
                } while (p == JOptionPane.YES_OPTION);
            
                    writer.println("stats");
                    writer.flush();
            
                            //writer.close();
            
                    String format = "Number of Clicks During this Round: %s\n" +
                                        "Total Clicks By all the Players: %s\n" +
                                        "Average Number of Clicks: %s";
                    String statistics = String.format(format, reader.readLine(), reader.readLine(), reader.readLine());

                    // String c = "";
                    // String totalC = "";
                    // String avg = "";

                    // String line = "";
                    // line = reader.readLine();
                    // int count = 1;
                    // while (line != null) {
                    //     if (count == 1) {
                    //         c = reader.readLine();

                    //     } else if (count == 2) {
                    //         totalC = reader.readLine();
                    //     } else if (count == 3) {
                    //         avg = reader.readLine();
                    //     }
                    //     count++;
                    // }

                    // String finalPrint = "Number of Clicks During this Round: " + c + 
                    //     "\nTotal Clicks By all the Players: " + totalC +
                    //     "\nAverage Number of Clicks: " + avg;

                    JOptionPane.showMessageDialog(null, statistics,
                        "Button Game", JOptionPane.INFORMATION_MESSAGE);
            
                            
    
            
            
                    playAgain = playAgain();
                    if (playAgain == JOptionPane.NO_OPTION) {
                        writer.println("done");
                        writer.flush();
                    }
            } 

        } while (playAgain == JOptionPane.YES_OPTION);
        
        
        JOptionPane.showMessageDialog(null, "Hope you had fun!",
                    "Button Game!", JOptionPane.INFORMATION_MESSAGE);
    
        reader.close();
        writer.close();
        socket.close();

        return;

    }
}


