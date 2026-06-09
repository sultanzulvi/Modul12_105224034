import java.util.ArrayList;
import java.util.List;

public class InMemoryKeretaRepository implements KeretaRepository {
    private final List<Kereta> daftarKereta;

    public InMemoryKeretaRepository() {
        this.daftarKereta = new ArrayList<>();
        inisialisasiDataAwal();
    }

    private void inisialisasiDataAwal() {
        daftarKereta.add(new Kereta("K01", "Argo Bromo", "JKT - SBY", 50));
        daftarKereta.add(new Kereta("K02", "Parahyangan", "JKT - BDG", 15));
    }

    @Override
    public List<Kereta> ambilSemuaKereta() {
        return new ArrayList<>(daftarKereta);
    }

    @Override
    public Kereta cariBerdasarkanKode(String kodeKereta) {
        for (Kereta k : daftarKereta) {
            if (k.getKodeKereta().equalsIgnoreCase(kodeKereta)) {
                return k;
            }
        }
        return null;
    }
}