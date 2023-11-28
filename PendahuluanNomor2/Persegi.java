package PendahuluanNomor2;

public class Persegi extends BangunDatar implements Geometri {
    public int panjang_sisi;

    public Persegi(int panjang_sisi) {
        this.panjang_sisi = panjang_sisi;
    }
    
    @Override
    public void hitungKeliling() {
        keliling = panjang_sisi * 4;
        System.out.println("Keliling Persegi = "+keliling);
    }

    @Override
    public void hitungLuas() {
        luas = panjang_sisi * panjang_sisi;
        System.out.println("Luas Persegi = "+luas);
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
