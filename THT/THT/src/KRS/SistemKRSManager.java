package KRS;
import java.util.ArrayList;
import java.util.List;

import matakuliah.MataKuliah;
import repository.KRSDataRepository;
import strategy.UKTCalculationStrategy;

public class SistemKRSManager {
    private final KRSValidator validator;
    private final KRSPdfGenerator pdfGenerator;
    private final KRSDataRepository repository;

    public SistemKRSManager(KRSValidator validator, KRSPdfGenerator pdfGenerator, KRSDataRepository repository) {
        this.validator = validator;
        this.pdfGenerator = pdfGenerator;
        this.repository = repository;
    }

    public void prosesPendaftaranKRS(String mahasiswaId, List<MataKuliah> rencanaMatkul, UKTCalculationStrategy uktStrategy) {
        List<MataKuliah> matkulValid = new ArrayList<>();
        int totalSks = 0;

        for (MataKuliah matkul : rencanaMatkul) {
            if (validator.validasiPrasyarat(mahasiswaId, matkul)) {
                matkulValid.add(matkul);
                totalSks += matkul.getSks();
            }
        }

        double totalTagihan = uktStrategy.hitungTagihan(totalSks);
        System.out.println("Total tagihan UKT terhitung: Rp" + totalTagihan);

        repository.simpanKRS(mahasiswaId, matkulValid);

        pdfGenerator.cetakDrafKRS(mahasiswaId, matkulValid);
    }
}