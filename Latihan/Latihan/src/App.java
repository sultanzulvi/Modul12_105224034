import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        KeretaRepository repository = new InMemoryKeretaRepository();
        Penumpang validator = new NikPenumpang();
        
        ReservasiKontrol kontrol = new ReservasiKontrol(repository, validator);
        boolean berjalan = true;

        System.out.println("SISTEM RESERVASI TIKET KERETA API JAVA EXPRESS");

        try {
            while (berjalan) {
                System.out.println("\nMENU UTAMA");
                System.out.println("1. Lihat Jadwal & Sisa Kursi");
                System.out.println("2. Pesan Tiket");
                System.out.println("3. Keluar");
                System.out.print("Pilih menu: ");

                int menu = 0;
                try {
                    menu = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Error: Pilihan menu harus berupa angka!");
                    scanner.nextLine();
                    continue;
                }

                switch (menu) {
                    case 1:
                        System.out.println("\nJADWAL KERETA API:");
                        for (Kereta k : kontrol.getDaftarKereta()) {
                            System.out.println(k.getKodeKereta() + " | " + k.getNamaKereta() + " | " + k.getRute() + " | Sisa Kursi: " + k.getSisaKursi());
                        }
                        break;

                    case 2:
                        try {
                            System.out.print("Masukkan Kode Kereta: ");
                            String kode = scanner.nextLine();
                            System.out.print("Masukkan NIK Penumpang: ");
                            String nik = scanner.nextLine();
                            System.out.print("Masukkan Nama Penumpang: ");
                            String nama = scanner.nextLine();
                            
                            System.out.print("Masukkan Jumlah Tiket: ");
                            int jumlahTiket = scanner.nextInt();
                            scanner.nextLine();

                            kontrol.pesanTiket(kode, nik, nama, jumlahTiket);

                        } catch (InputMismatchException e) {
                            System.out.println("Error: Jumlah tiket harus dimasukkan dalam bentuk angka!");
                            scanner.nextLine();
                        } catch (DataPenumpangTidakValidException e) {
                            System.out.println("Kegagalan Validasi: " + e.getMessage());
                        } catch (RuteTidakDitemukanException e) {
                            System.out.println("Gagal Memesan: " + e.getMessage());
                        } catch (TiketHabisException e) {
                            System.out.println("Gagal Memesan: " + e.getMessage());
                            System.out.println("Detail: Kereta " + e.getNamaKereta() + " hanya tersisa " + e.getSisaKursi() + " kursi.");
                        }
                        break;

                    case 3:
                        berjalan = false;
                        break;

                    default:
                        System.out.println("Pilihan menu tidak tersedia. Silakan pilih menu 1-3.");
                }
            }
        } finally {
            System.out.println("\nTerima kasih telah menggunakan layanan JAVA EXPRESS.");
            scanner.close();
        }
    }
}