public class Main {
    public static void main(String[] args) {
        // Membuat objek ATM
        ATM atm1 = new ATM("Budi Santoso", "1234567890");
        atm1.saldo = 5000000.0;
        atm1.jenisTransaksi = "Penarikan Tunai";
        atm1.jumlahTransaksi = 1500000.0;
        
        // Menjalankan method
        atm1.cekSaldo();
        atm1.tarikTunai();
        
        System.out.println("===================================\n");
        
        // Contoh kedua
        ATM atm2 = new ATM("Siti Rahayu", "0987654321");
        atm2.saldo = 2500000.0;
        atm2.jenisTransaksi = "Penarikan Tunai";
        atm2.jumlahTransaksi = 3000000.0;
        
        atm2.cekSaldo();
        atm2.tarikTunai(); // Akan menampilkan saldo tidak cukup
    }
}