/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author jose9
 */
public class Juego {
    private int cantidadBaldosas;
    private boolean inicioJuego = true;
    private boolean end = false;
    private boolean play= true;
    public Juego()
    {
        
    }

    public int getCantidadBaldosas() {
        return cantidadBaldosas;
    }

    public void setCantidadBaldosas(int cantidadBaldosas) {
        this.cantidadBaldosas = cantidadBaldosas;
    }

    public boolean isInicioJuego() {
        return inicioJuego;
    }

    public void setInicioJuego(boolean inicioJuego) {
        this.inicioJuego = inicioJuego;
    }
    
    public int changeTitle()
    {
        int rand = (int)(Math.random()*4);
        return rand;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public boolean isPlay() {
        return play;
    }

    public void setPlay(boolean play) {
        this.play = play;
    }
    
     
}
