package KRS;
public class KRSValidator {
    public boolean validasiPrasyarat(String mahasiswaId, matakuliah.MataKuliah matkul) {
        System.out.println("Memvalidasi prasyarat akademik untuk: " + matkul.getNama());
        return true; 
    }
}