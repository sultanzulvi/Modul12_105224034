package main;

import java.util.Arrays;
import java.util.List;

import KRS.*;
import matakuliah.*;
import repository.*;
import strategy.*;

public class App {
    public static void main(String[] args) {

        KRSValidator validator = new KRSValidator();
        
        KRSPdfGenerator pdfGenerator = new KRSPdfGenerator();
        
        KRSDataRepository repository = new CloudNoSQLKRSRepository();

        SistemKRSManager krsManager = new SistemKRSManager(validator, pdfGenerator, repository);

        MataKuliah matkul1 = new MataKuliahTeori("MK01", "Rekayasa Perangkat Lunak", 3);
        MataKuliahPraktikum matkul2 = new MataKuliahPraktikum("MK02", "Praktikum Jaringan Komputer", 1);
        List<MataKuliah> rencanaKrs = Arrays.asList(matkul1, matkul2);

        System.out.println("PROSES KRS MAHASISWA JALUR MBKM");
        UKTCalculationStrategy strategiMbkm = new MbkmUKTStrategy();
        krsManager.prosesPendaftaranKRS("MHS2024034", rencanaKrs, strategiMbkm);

        System.out.println("\nEKSEKUSI OPERASI KHUSUS PRAKTIKUM");
        for (MataKuliah mk : rencanaKrs) {
            if (mk instanceof LaboratoriumAkses) {
                ((LaboratoriumAkses) mk).alokasiAsistenLab();
                ((LaboratoriumAkses) mk).cekPeralatanPraktikum();
            }
        }
    }
}