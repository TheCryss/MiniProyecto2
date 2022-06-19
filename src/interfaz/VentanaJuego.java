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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import logica.*;
/**
 *
 * @author jose9
 */

public class VentanaJuego extends JFrame {
   private JPanel pnlBaldosas; 
   private JPanel pnlVidas; 
   private JLabel[] lblB = new JLabel[16];
   private JLabel[] lblC = new JLabel[3];
   private JLabel lblTime;
   private JLabel imgBoton;
   private final ImageIcon[] imagenes = new ImageIcon[20];
   private final ImageIcon[] icoC = new ImageIcon[5];
   private ImageIcon icoBoton;
   private Baldosa mibaldosa= new Baldosa();
   private Juego miJuego = new Juego();
   //private Ronda miRonda = new Ronda();
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
        setSize(700,800);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Pair Colors");
        setResizable(false);
        SwingUtilities.updateComponentTreeUI(contenedorInicial);
    }
    
    private void startGame()
    {
        miJuego.setCantidadBaldosas(4);
    }
    
    private void winOrLose()
    {
        if (miJuego.isPlay()) {
            if (mibaldosa.pair(imageChose) && !miJuego.isInicioJuego()) {
                miJuego.setEnd(true);
                System.out.println("Perdiste");
                
            }
            
        }
        
    }
    
    private void paint()
    {
        
        if (miJuego.isInicioJuego()) {
        System.out.println("PRIMERA");
            for (int j = 0; j < miJuego.getCantidadBaldosas(); j++) 
        {
                        tileChose[j] = mibaldosa.choseTile();
                        for (int k = 0; k < j; k++) {
                            if (tileChose[k]==tileChose[j]) {
                                //System.out.println("Iguales");
                                //System.out.println(""+tileChose[k]+"|"+tileChose[j]);
                                while (tileChose[k]==tileChose[j]){
                                    tileChose[j] = mibaldosa.choseTile();
                                    k=0;
                                }
                                
                                //System.out.println("Distintas");
                                //System.out.println(""+tileChose[k]+"|"+tileChose[j]);
                            }
                        }
                        imageChose[j]= mibaldosa.choseImage();
                        lblB[tileChose[j]].setIcon(imagenes[imageChose[j]]);
        }
            
        } else {
            System.out.println("SEGUNDA");
           int pos = miJuego.changeTitle();
           int tile =tileChose[pos];
           int nTile =mibaldosa.choseTile();;
           
            for (int i = 0; i < tileChose.length; i++) {
                if (tileChose[i]==nTile) {
                                
                    while (tileChose[i]==nTile){
                        nTile = mibaldosa.choseTile();
                        i=0;
                    }
            }
            }
           int img = mibaldosa.choseImage();
           lblB[tile].setIcon(imagenes[0]);
           lblB[nTile].setIcon(imagenes[img]/*imagenes[6]*/); 
           tileChose[pos]= nTile;
           //System.out.println("img value:"+imageChose[pos]);
           imageChose[pos]= img;
           /*
            System.out.println("tile pos :"+pos);
            System.out.println("tile value:"+tile);
            System.out.println("new tile value:"+nTile);
            System.out.println("new img value:"+img);
*/        
}
        
        
    }
    private void animateHeart()
    {
        for (int i = 0; i < 5; i++) {
            try {
                lblC[0].setIcon(icoC[i]);
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                
            }
            
            
        }
    }
    
    private void iniciarComponentes()
    {
        pnlBaldosas = new JPanel(new GridLayout(4, 4, 1 ,1));
        pnlBaldosas.setBounds(90, 90, 500, 500);
        pnlBaldosas.setBackground(Color.CYAN);
        
        pnlVidas = new JPanel(new GridLayout(1, 4, 1, 1));
        pnlVidas.setBounds(350, 20, 200, 50);
        //pnlVidas.setBackground(Color.yellow);
        int i=0;
      
        //Creo array de imagenes
        for (ImageIcon imagen : imagenes){
            try {
                imagen = new ImageIcon(getClass().getResource("/imagenes/"+(i+1)+".png"));
            } catch (Exception e) {
                imagen = new ImageIcon(getClass().getResource("/imagenes/"+(i+1)+".jpg"));
            }
            //imagen = new ImageIcon(getClass().getResource("/imagenes/"+(i+1)+".png"));
            Image image = (imagen).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            
            
            imagenes[i]= new ImageIcon(image);
            i++;
        }
        i=0;
        
        for (ImageIcon imagen: icoC) {
            imagen = new ImageIcon(getClass().getResource("/imagenes/C"+(i+1)+".png"));
            Image image = (imagen).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            icoC[i]= new ImageIcon(image);
            i++;
        }
        
        for (int j = 0; j < lblC.length; j++) {
            lblC[j]= new JLabel(icoC[0]);
            pnlVidas.add(lblC[j]);
            
        }
        
        for (int j=0;j<lblB.length;j++) {
           
                
           lblB[j] = new JLabel(imagenes[0]);
           lblB[j].setBackground(Color.red);
           pnlBaldosas.add(lblB[j]);
        }
        
        lblTime = new JLabel();
        lblTime.setBounds(200, 0, 200, 70);
        lblTime.setFont(new Font("Serif", Font.PLAIN, 20));
        
        
        icoBoton = new ImageIcon(getClass().getResource("/imagenes/boton.png"));
        imgBoton = new JLabel(icoBoton);
        imgBoton.setBounds(290, 620, 100, 100);
        Image image = (icoBoton).getImage().getScaledInstance(imgBoton.getWidth(), imgBoton.getHeight(), Image.SCALE_SMOOTH);
        icoBoton = new ImageIcon(image);
        imgBoton.setIcon(icoBoton);
        imgBoton.addMouseListener(new ManejoClick());
        
        
        
            startGame();
        task= new TimerTask() {
            @Override
            public void run() {
                int tic = 0;
                winOrLose();
                if (tic%2==0 && !miJuego.isEnd()) {              
                    if (miJuego.isEnd()==false) {
                        paint();
                        
                    } else {
                        System.out.println("Perdiste");
                    }
                    animateHeart();
                }                
                tic++;
                
                miJuego.setInicioJuego(false);
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
        contenedorInicial.add(pnlVidas);
        contenedorInicial.add(lblTime);
        contenedorInicial.add(imgBoton);
       
       SwingUtilities.updateComponentTreeUI(contenedorInicial); 
    }    
    
    
    private class ManejoClick extends MouseAdapter
    {

        @Override
        public void mouseClicked(MouseEvent e) {
            
            try {
                System.out.println(""+mibaldosa.pair(imageChose));
                Thread.sleep(1500);
                
            } catch (InterruptedException ex) {
                
            }
        }
        
    }
}




