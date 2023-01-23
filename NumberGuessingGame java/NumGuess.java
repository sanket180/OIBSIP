package internship;

import javax.swing.*;

public class NumGuess {
    public static void main(String[] args) {
        int cnum = (int) (Math.random() * 100 + 1);
        int userans = 0;
        int count = 10;
        
        JOptionPane.showMessageDialog(null, "A number is chosen from 1 to 100 \n You have 10 attempts to guess the correct number");
        
        try {
            while (userans != cnum && count>0) {
                String response = JOptionPane.showInputDialog(null, "Enter a guess between 1 and 100");
                userans = Integer.parseInt(response);
                JOptionPane.showMessageDialog(null, "" + findNum(userans, cnum, count));
                count--;
                if (count == 0) {
                	JOptionPane.showMessageDialog(null, "You Lose \n Better Luck Next Time");
                }
                
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static String findNum(int userans , int cnum , int count )
    {
        if (userans <= 0 || userans > 100 ) {
            return "Your guess is invalid";
        } 
        else if (userans == cnum ) {
        	return "Correct! \n Total Attempts left : " + (count - 1);
        } 
        else if (userans > cnum) {
        	return "Your guess is too high, try again, \n Attempts Left : " + (count - 1);
        } 

        else {
        	return "Your guess is too low, try again, \n Attempts Left :  " + (count - 1);
        }
        }
    }
