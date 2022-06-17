/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import logica.*;
/**
 *
 * @author jose9
 */

public class VentanaJuego extends JFrame {
   private JPanel pnlBaldosas; 
   private JLabel[] lblB = new JLabel[16];
   private JLabel lblTime;
   private ImageIcon[] imagenes = new ImageIcon[10];
   private Baldosa mibaldosa= new Baldosa();
   private int[] tileChose= new int[4];
   private int[] imageChose= new int[4];
   
   private Timer timer = new Timer();
   private Timer timert = new Timer();
   private TimerTask task;
   private TimerTask taskt;
   private int time;
   
   
   
   
    private Container contenedorInicial;
    public VentanaJuego()
    {
        iniciarComponentes();   
        setSize(700,700);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Pair Colors");
        setResizable(false);
        SwingUtilities.updateComponentTreeUI(contenedorInicial);
    }
    
    private void iniciarComponentes()
    {
        pnlBaldosas = new JPanel(new GridLayout(4, 4, 1 ,1));
        pnlBaldosas.setBounds(90, 90, 500, 500);
        pnlBaldosas.setBackground(Color.CYAN);
        int i=0;
        
       
       /*
       imagenes[0] = new ImageIcon(getClass().getResource("/imagenes/10.png")); 
       Image image = (imagenes[0]).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
       imagenes[0]= new ImageIcon(image);
       */
       
        for (ImageIcon imagen : imagenes){
            imagen = new ImageIcon(getClass().getResource("/imagenes/"+(i+1)+".png"));
            Image image = (imagen).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            //imagen = new ImageIcon(image);
            
            imagenes[i]= new ImageIcon(image);
            i++;
        }
       
        for (int j=0;j<lblB.length;j++) {
           
                
           lblB[j] = new JLabel(imagenes[1]);
           //System.out.println("se creo"+i);
           lblB[j].setBackground(Color.red);
           pnlBaldosas.add(lblB[j]);
        }
        
        lblTime = new JLabel();
        lblTime.setBounds(200, 0, 200, 70);
        lblTime.setFont(new Font("Serif", Font.PLAIN, 20));
        
        task= new TimerTask() {
            @Override
            public void run() {
                int tic = 0;
                if (tic%2==0) {
                    //System.out.println("1");
                    
                    for (int j = 0; j < 4; j++) {
                        lblB[tileChose[j]].setIcon(imagenes[1]);
                    }
                    
                    for (int j = 0; j < 4; j++) {
                        tileChose[j] = mibaldosa.choseTile();
                        for (int k = 0; k < j; k++) {
                            if (tileChose[k]==tileChose[j]) {
                                tileChose[j] = mibaldosa.choseTile();
                            }
                        }
                        imageChose[j]= mibaldosa.choseImage();
                        lblB[tileChose[j]].setIcon(imagenes[imageChose[j]]);
                    }
                    System.out.println("Imagenes");
                    for (int j = 0; j < imageChose.length; j++) {
                        System.out.println(""+imageChose[j]);
                    }
                    System.out.println("--------------");
                    System.out.println("Tiles");
                    for (int j = 0; j < tileChose.length; j++) {
                        System.out.println(""+tileChose[j]);
                    }
                    System.out.println("--------------");
                }
                //System.out.println("2");
                tic++;
                
            }  
        };
        timer.schedule(task, 10,3000);
        
       taskt= new TimerTask() {
            @Override
            public void run() {
                lblTime.setText("Tiempo: "+time);
                time++;
            }
            
       };
       timert.schedule(taskt, 1,1000);
       
        contenedorInicial = getContentPane();
        contenedorInicial.setLayout(null);
        contenedorInicial.add(pnlBaldosas);
        contenedorInicial.add(lblTime);
       
       SwingUtilities.updateComponentTreeUI(contenedorInicial); 
    }
    
    
    
}




