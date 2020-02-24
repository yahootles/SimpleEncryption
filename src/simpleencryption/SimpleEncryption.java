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
        String input;
        String output;
        int shift = 0;
        int type = 0;//encrypt or decrypt

        try {
            input = JOptionPane.showInputDialog(null, "This program will encrypt or decrypt a phrase using"
                    + " the simple encryption method of rotating the letters.\n\nPlease enter a phrase:");

            input = input.toUpperCase();

            boolean flag = false;
            while (!flag) {
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
            flag = false;

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

            if (type == 1) {
                char[] arr = input.toCharArray();
                if (Character.isAlphabetic(shift)) {
                    for (char ch : arr) {
                        ch = (char)((int)ch + shift);
                        if (ch > 90) {
                            ch -= 26;
                        }
                    }
                }
                output = new String(arr);
                JOptionPane.showMessageDialog(null, "The original phrase was: " + input 
                        + "\nThe encrypted phrase is: " + output);
            } else if (type == 2) {
                char[] arr = input.toCharArray();
                if (Character.isAlphabetic(shift)) {
                    for (char ch : arr) {
                        ch -= shift;
                        if (ch < 64) {
                            ch += 26;
                        }
                    }
                }
                output = new String(arr);
                JOptionPane.showMessageDialog(null, "The original phrase was: " + input 
                        + "\nThe decrypted phrase is: " + output);
            }
            
        } catch (NullPointerException npe) {
            System.exit(0);
        }
    }

}
