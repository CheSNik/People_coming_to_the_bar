import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Lab 3 P6.13
 * @author Sergei Chekhonin
 * This program simulates changing number of people coming in and leave the Bar
 */

public class Main {

    public static void main(String[] args) {
        //This block initialize printWriter and dateFormatter
        PrintWriter out = null;
        try {
            out = new PrintWriter("Lab3_P6.13output.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        final JFrame frame = new JFrame();

        //initialize TheBar object
        TheBar Bar = new TheBar(60);

        //printout message
        out.println(dtf.format(now));
        out.println("Welcome to The Bar");
        JOptionPane.showMessageDialog(frame,
                "Welcome to The Bar",
                "Bar control system",
                JOptionPane.PLAIN_MESSAGE);

        out.println("There are currently " + Integer.toString(Bar.GetNumberOfPeople())+ " people in the Bar");
        JOptionPane.showMessageDialog(frame,
                "There are currently " + Integer.toString(Bar.GetNumberOfPeople())+ " people in the Bar",
                "Bar control system",
                JOptionPane.PLAIN_MESSAGE);

        /**
         * stores input number of people in or out
         */
        int numberOfPeople = 0;

        while (Bar.GetNumberOfPeople()<100) {

            //user input number of people
            /**
             * stores input number in form of string
             */
            String input = JOptionPane.showInputDialog("How many people you want to come in or leave(use `-`) the Bar?");
            numberOfPeople= Integer.parseInt(input);
            if (numberOfPeople>0)
            out.println("User wanted " + input+ " people to enter the Bar");
            else
            {
                out.println("User wanted " + input.substring(1,input.length())+ " people to leave the Bar");
            }

            //check if group allowed to enter
            if (Bar.ControlNumberOfPeople(numberOfPeople))
            {
                if (numberOfPeople>0) {
                    out.println("Group of " + input + " entered the Bar");
                    JOptionPane.showMessageDialog(frame,
                            "Group of " + input + " entered the Bar",
                            "Bar control system",
                            JOptionPane.PLAIN_MESSAGE);
                }
                else
                {
                    out.println("Group of " + input.substring(1,input.length()) + " leaved the Bar");
                    JOptionPane.showMessageDialog(frame,
                            "Group of " + input.substring(1,input.length()) + " leaved the Bar",
                            "Bar control system",
                            JOptionPane.PLAIN_MESSAGE);
                }

                out.println("There are currently " + Integer.toString(Bar.GetNumberOfPeople()) + " people in the Bar");
                JOptionPane.showMessageDialog(frame,
                        "There are currently" + Integer.toString(Bar.GetNumberOfPeople()) + " people in the Bar",
                        "Bar control system",
                        JOptionPane.PLAIN_MESSAGE);
            }
            else
            {
                out.println("Group exceeds allowed number of people to enter");
                JOptionPane.showMessageDialog(frame,
                        "Group exceeds allowed number of people to enter",
                        "Bar control system",
                        JOptionPane.PLAIN_MESSAGE);
            }
        }

        out.println("Bar is full load, no more entrance");
        JOptionPane.showMessageDialog(frame,
                "Bar is full load, no more entrance",
                "Bar control system",
                JOptionPane.PLAIN_MESSAGE);

        out.close();
        System.exit(0);

    }
}
