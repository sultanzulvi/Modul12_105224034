public class NikPenumpang implements Penumpang {
    @Override
    public void validasi(String nik, String nama) throws DataPenumpangTidakValidException {
        if (nik == null || nik.length() != 16 || !nik.matches("\\d+")) {
            throw new DataPenumpangTidakValidException("Format NIK tidak valid! NIK harus tepat 16 digit angka.");
        }
        if (nama == null || nama.trim().isEmpty()) {
            throw new DataPenumpangTidakValidException("Nama penumpang tidak boleh kosong.");
        }
    }
}