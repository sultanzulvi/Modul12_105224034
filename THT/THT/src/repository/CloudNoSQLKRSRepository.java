package repository;

import java.util.List;

public class CloudNoSQLKRSRepository implements KRSDataRepository {
    @Override
    public void simpanKRS(String mahasiswaId, List<matakuliah.MataKuliah> daftarMatkul) {
        System.out.println("Menyimpan data KRS ke Cloud NoSQL dengan skalabilitas tinggi.");
    }
}
