public interface Penumpang {
    void validasi(String nik, String nama) throws DataPenumpangTidakValidException;
}