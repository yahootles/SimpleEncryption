/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleencryption;

/**
 *
 * @author antho6229
 */
import javax.swing.JOptionPane;

public class SimpleEncryption {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //variable declaration
        String input;
        String output = "";
        int shift = 0;
        int type = 0;//encrypt or decrypt

        try {
            //get user input
            input = JOptionPane.showInputDialog(null, "This program will encrypt or decrypt a phrase using"
                    + " the simple encryption method of rotating the letters.\n\nPlease enter a phrase:");

            //convert to uppercase to simplify encryption
            input = input.toUpperCase();
            
            //flag needed in case input is incorrect
            boolean flag = false;
            while (!flag) {
                //get integer between 1 and 25 inclusive, don't accept invalid inputs
                try {
                    shift = Integer.parseInt(JOptionPane.showInputDialog("Enter the rotation amount:"));
                    if (shift <= 0 || shift > 25) {
                        throw new NumberFormatException();
                    }
                    flag = true;
                } catch (NullPointerException e) {
                    System.exit(0);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input.");
                }
            }
            //reset flag
            flag = false;

            //get input that is either 1 or 2
            while (!flag) {
                try {
                    type = Integer.parseInt(JOptionPane.showInputDialog("1 - Ecryption\n2 - Decryption"));
                    if (type < 1 || type > 2) {
                        throw new NumberFormatException();
                    }
                    flag = true;
                } catch (NullPointerException npe) {
                    System.exit(0);
                } catch (NumberFormatException nfe) {
                    System.err.println("Invalid input.");
                }
            }

            //encrypt
            if (type == 1) {
                //definately a bad way to do this, but I was too deep
                char[] arr = input.toCharArray();
                //iterate through all characters
                for (char ch : arr) {
                    //only want to change alphabetic characters
                    if (Character.isAlphabetic(ch)) {
                        //shift
                        ch += shift;
                        //wrap around if it is out of range
                        if (ch > 90) {
                            ch -= 26;
                        }
                    }
                    //add to our output string
                    output += ch;
                }
                //display to user
                JOptionPane.showMessageDialog(null, "The original phrase was: " + input
                        + "\nThe encrypted phrase is: " + output);
            } else if (type == 2) {//same as above but with decryption
                char[] arr = input.toCharArray();
                for (char ch : arr) {
                    if (Character.isAlphabetic(ch)) {

                        ch -= shift;
                        if (ch < 64) {
                            ch += 26;
                        }
                    }
                    output += ch;
                }
                JOptionPane.showMessageDialog(null, "The original phrase was: " + input
                        + "\nThe decrypted phrase is: " + output);
            }

        } catch (NullPointerException npe) {//exit program if exit button clicked
            System.exit(0);
        }
    }

}
