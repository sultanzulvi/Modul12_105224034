package matakuliah;

public class MataKuliahPraktikum implements MataKuliah, LaboratoriumAkses {
    private String kode;
    private String nama;
    private int sks;

    public MataKuliahPraktikum(String kode, String nama, int sks) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
    }

    @Override public String getKode() { return kode; }
    @Override public String getNama() { return nama; }
    @Override public int getSks() { return sks; }

    @Override
    public void alokasiAsistenLab() {
        System.out.println("Mengalokasikan asisten lab untuk praktikum " + nama);
    }

    @Override
    public void cekPeralatanPraktikum() {
        System.out.println("Memeriksa kesiapan alat lab untuk praktikum " + nama);
    }
}