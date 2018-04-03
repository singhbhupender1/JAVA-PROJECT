/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Validations;

import java.awt.Color;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Zeppelin
 */
public class EmailVerifier extends InputVerifier{
    
@Override
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText();
        String pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" ;
                //+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if (text.length() > 0) {
            if (text.toLowerCase().startsWith(" ") || text.length() == 0 || text.trim().length() == 0 || text.trim().isEmpty() || text.matches(pattern) != true) {
                input.setBackground(Color.red);
                JOptionPane.showMessageDialog(input, "Please enter valid string. Special characters are not allowed", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                input.setBackground(Color.white);
                return true;
            }
        } else {
            input.setBackground(Color.red);
            return false;
        }
    }
}

