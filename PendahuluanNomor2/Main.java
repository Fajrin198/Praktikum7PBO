package PendahuluanNomor2;

public class Main {
    private static Persegi persegi01;
    private static Lingkaran lingkaran01;
    
    public static void main(String[] args) {
        persegi01 = new Persegi(4);
        persegi01.hitungLuas();
        persegi01.hitungKeliling();
        System.out.println("");
        lingkaran01 = new Lingkaran();
        lingkaran01.setR(7);
        lingkaran01.hitungLuas();
        lingkaran01.hitungKeliling();
    }
}
