import java.io.*;
import java.net.*;
import java.net.ServerSocket;
/**
 * A server where all the calculations will be made regarding the button game
 *
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 11 -- ButtonServer
 *
 * @author Hardit Sandhu
 * @version April 6, 2022
 */
public class ButtonServer {

    public static void main(String[] args) throws IOException {
        int c = 0;
        int totalC = 0;
        int players = 0;

        ServerSocket serverSocket = new ServerSocket(100);
        Socket socket = serverSocket.accept();

        BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream());

        String line = " ";
        while (!line.equals("done")) {
            line = bf.readLine();

            if (line.equals("list")) {
                writer.printf("Players: %d\n", players);
                writer.flush();

            } else if (line.equals("first")) {
                c = 0;

            } else if (line.equals("playerINC")) {
                players++;
                

            } else if (line.equals("click")) {
                c++;
                totalC++;

            } else if (line.equals("stats")) {

                writer.println(c);
                writer.flush();
                writer.println(totalC);
                writer.flush();

                double average = (double) totalC / players;
                writer.printf("%.2f\n", average);
                writer.flush();
            }
        }

    }

}