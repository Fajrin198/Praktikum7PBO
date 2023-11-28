/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PendahuluanNomor2;

/**
 *
 * @author MY ASUS
 */
public class Lingkaran extends BangunDatar implements Geometri {
    public double r;

    public void setR(double r) {
        this.r = r;
    }
    
    @Override
    public void hitungLuas(){
        luas = PI*r*r;
        System.out.println("Luas lingkaran = "+luas);
    }
    
    @Override
    public void hitungKeliling(){
        keliling = 2*PI*r;
        System.out.println("Keliling Lingkaran = "+keliling);
    }
    
    @Override
    public double getKeliling() {
        return keliling;
    }

    @Override
    public double getLuas() {
        return luas;
    }
}
