package repository;

import java.util.List;

public class MySQLKRSRepository implements KRSDataRepository {
    @Override
    public void simpanKRS(String mahasiswaId, List<matakuliah.MataKuliah> daftarMatkul) {
        System.out.println("Menyimpan data KRS ke MySQL Database secara transaksional.");
    }
}
