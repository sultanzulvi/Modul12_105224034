package repository;
import  java.util.List;

public interface KRSDataRepository {
    void simpanKRS(String mahasiswaId, List<matakuliah.MataKuliah> daftarMatkul);
}
