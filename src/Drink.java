/*
 * Matthew G. Mershon         5/29/14
 * CSIS 293-9240              Mr. Giron
 * Project 5
 * Description: Write a vending machine applet. 
 */

import java.awt.Graphics;
import javax.swing.JApplet;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;

 public class Drink extends JApplet
 {
 private double balance;
 private int colaClicks = 0,lemonClicks=0,grapeClicks=0,rootClicks=0,waterClicks=0;
 private JTextField money;
 private JButton cola;
 private JButton lemon;
 private JButton grape;
 private JButton root;
 private JButton water;
 private JPanel buildButtons;

 public void init()
 {
 setLayout(new FlowLayout());
 buildButtons();

 add(buildButtons, BorderLayout.CENTER);

 }

 private void buildButtons()
 {
 money = new JTextField(5);
 money.setPreferredSize(money.getPreferredSize());
 money.setText("0.00");
 buildButtons = new JPanel();
 setSize(300,300);
 setLayout(new GridLayout (4,2));
 cola = new JButton("Cola");
 lemon = new JButton("Lemon-Lime");
 grape = new JButton("Grape");
 root = new JButton("Root beer");
 water = new JButton("bottle water");
 
 //Colors for the buttons.
 
 cola.setBackground(Color.red);
 lemon.setBackground(Color.yellow);
 grape.setBackground(Color.magenta);
 root.setBackground(Color.gray);
 water.setBackground(Color.pink);

 //Pointing buttonlisteners.
 
 cola.addActionListener(new ButtonHandler());
 lemon.addActionListener(new ButtonHandler());
 grape.addActionListener(new ButtonHandler());
 root.addActionListener(new ButtonHandler());
 water.addActionListener(new ButtonHandler());

 //Adding buttons to frame.
 
 add(money);
 add(cola);
 add(lemon);
 add(grape);
 add(root);
 add(water);
 
 //Cannot get the buttons to disable properly.
 
/**int amount = Integer.parseInt(money.getText());
 if(total < .75){
	 cola.setEnabled(false);
 	 lemon.setEnabled(false);
 	 grape.setEnabled(false);
 	 root.setEnabled(false);
 	 water.setEnabled(false);}
 else{
	 cola.setEnabled(true);
 	 lemon.setEnabled(true);
 	 grape.setEnabled(true);
 	 root.setEnabled(true);
	 water.setEnabled(true);}
**/ 
 	
 }
 	 
 
 private class ButtonHandler implements ActionListener
 {
 public void actionPerformed(ActionEvent e)
 {
 double amount = Double.parseDouble(money.getText());

 if(amount < 0.75) //Not enough money to buy a drink.
 JOptionPane.showMessageDialog(null, "Inadequate amount of money ");

 else
 {

 if(e.getSource() == cola )
 {
 colaClicks++;
 if(colaClicks <= 20) //Checks how many cokes are left.
 {
 balance = (amount - 0.75); //Reduces user given balance by price of drink.
 JOptionPane.showMessageDialog(null,  balance + " In Change. Enjoy your Cola!");
 }
 else
 JOptionPane.showMessageDialog(null, "Inadequate amount of Cola. ");

 }

 if(e.getSource() == lemon)
 {
 lemonClicks++;
 if(lemonClicks <= 20) //Checks how many lemons are left.
 {
 balance = (amount - 0.75); //Reduces user given balance by price of drink.
 JOptionPane.showMessageDialog(null,  balance + " In Change. Enjoy your Lemon-Lime soda!"); 
 }
 else 
JOptionPane.showMessageDialog(null, "Inadequate amount of Lemon-Lime. ");
 }

 if(e.getSource() == grape )
 {
 grapeClicks++;
 if(grapeClicks <= 20) //Checks how many grapes are left.
 {
 balance = (amount - 0.75); //Reduces user given balance by price of drink.
 JOptionPane.showMessageDialog(null, balance + " In Change. Enjoy your Grape soda!" );
 }
 else 
JOptionPane.showMessageDialog(null, "Inadequate amount of Grape. ");
 }

 if(e.getSource() ==root )
 {
 rootClicks++;
 if(rootClicks <= 20) //Checks how many roots are left.
 {
 balance = (amount - 0.75); //Reduces user given balance by price of drink.
 JOptionPane.showMessageDialog(null, balance + " In Change. Enjoy your RootBeer!");
 }
 else 
JOptionPane.showMessageDialog(null, "Inadequate amount of RootBeer. ");
 }


 if(e.getSource() == water )
 {
 waterClicks++;
 if(waterClicks <= 20) //Checks how many waters are left.
 {
 balance = (amount - 0.75); //Reduces user given balance by price of drink.
 JOptionPane.showMessageDialog(null, balance + " In Change. Enjoy your Water!");
 }
 else 
JOptionPane.showMessageDialog(null, "Inadequate amount of Water. ");
 }
 money.setText(""+balance);
 }

 }
 }
 }