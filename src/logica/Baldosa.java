/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;


/**
 *
 * @author jose9
 */
public class Baldosa {
    private int idBaldosas;
    
    public Baldosa()
    {
    }
    
    public int getIdBaldosas() {
        return idBaldosas;
    }

    public void setIdBaldosas(int idBaldosas) {
        this.idBaldosas = idBaldosas;
    }
     public int choseTile()
     {
         int rand =(int)(Math.random()*16);
         return rand;
     }
     
     public int choseImage()
     {
         int rand =(int)(Math.random()*8)+2;
         return rand;
     }
     
     public boolean pair(int[] imageChose)
     {
         for (int i = 0; i < imageChose.length; i++) {
             for (int j = 0; j < 3; j++) {
                 if (imageChose[i]==imageChose[j] && j!=i) {
                     return true;
                 }
             }
         }        
         return false;
     }
}
