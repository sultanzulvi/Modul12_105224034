import java.util.List;

public class ReservasiKontrol {
    private final KeretaRepository keretaRepository;
    private final Penumpang validatorPenumpang;

    public ReservasiKontrol(KeretaRepository keretaRepository, Penumpang validatorPenumpang) {
        this.keretaRepository = keretaRepository;
        this.validatorPenumpang = validatorPenumpang;
    }

    public List<Kereta> getDaftarKereta() {
        return keretaRepository.ambilSemuaKereta();
    }

    public void pesanTiket(String kodeKereta, String nik, String namaPenumpang, int jumlahTiket) 
            throws RuteTidakDitemukanException, TiketHabisException {
        
        validatorPenumpang.validasi(nik, namaPenumpang);

        Kereta keretaDipilih = keretaRepository.cariBerdasarkanKode(kodeKereta);

        if (carikeretaDipilih(keretaDipilih)) {
            throw new RuteTidakDitemukanException("Kereta dengan kode '" + kodeKereta + "' tidak ditemukan.");
        }

        if (jumlahTiket > keretaDipilih.getSisaKursi()) {
            throw new TiketHabisException(
                "Jumlah pemesanan melebihi sisa kursi yang tersedia.", 
                keretaDipilih.getNamaKereta(), 
                keretaDipilih.getSisaKursi()
            );
        }

        keretaDipilih.kurangiKursi(jumlahTiket);
        System.out.println("Pemesanan Berhasil!");
        System.out.println("Penumpang: " + namaPenumpang);
        System.out.println("Kereta: " + keretaDipilih.getNamaKereta() + " (" + jumlahTiket + " tiket)");
    }

    private boolean carikeretaDipilih(Kereta kereta) {
        return kereta == null;
    }
}