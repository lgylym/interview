package Robots;

import java.util.Scanner;

/**
 * Created by lgylym on 2014/11/16.
 */
public class Controller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String psetting = sc.nextLine();
        String[] psettings = psetting.split(" ");
        int px = Integer.parseInt(psettings[0]);
        int py = Integer.parseInt(psettings[1]);

        Plateau plt = Plateau.create(px, py);
        if(plt == null) {
            return;
        }
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] words = line.split(" ");
            if(words.length != 3) {
                System.err.println("Wrong input" + line);
                return;
            }
            int iniX = Integer.parseInt(words[0]);
            int iniY = Integer.parseInt(words[1]);
            char heading = words[2].charAt(0);
            Rover rover = plt.addRover(iniX, iniY, heading);
            if(rover == null) {
                break;
            }
            String controlSequence = sc.nextLine();
            for(int i = 0; i < controlSequence.length(); i++) {
                rover.receiveControl(controlSequence.charAt(i), plt);
            }
            System.out.println(rover.getStatus());
        }
    }
}
