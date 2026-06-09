import java.util.List;

public interface KeretaRepository {
    List<Kereta> ambilSemuaKereta();
    Kereta cariBerdasarkanKode(String kodeKereta);
}