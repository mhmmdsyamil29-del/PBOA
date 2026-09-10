public class ATM {
    // Atribut/field/properties
    public String nama;
    public String nomorRekening;
    public double saldo;
    public String jenisTransaksi;
    public double jumlahTransaksi;

    // Constructor
    ATM(String nama, String nomorRekening) {
        this.nama = nama;
        this.nomorRekening = nomorRekening;
    }

    // Method
    public void cekSaldo() {
        if (this.saldo == 0.0 && this.saldo == 0) {
            throw new IllegalArgumentException("Maaf, saldo bernilai 0 atau belum diisi!\n");
        }
        System.out.println("Saldo rekening " + this.nomorRekening + 
                         " atas nama " + this.nama + 
                         " adalah: Rp" + String.format("%,.2f", this.saldo) + "\n");
    }

    public void tarikTunai() {
        if (this.jenisTransaksi == null) {
            throw new IllegalArgumentException("Maaf, jenisTransaksi bernilai NULL!\n");
        }
        if (this.jumlahTransaksi == 0.0 && this.jumlahTransaksi == 0) {
            throw new IllegalArgumentException("Maaf, jumlahTransaksi bernilai 0 atau belum diisi!\n");
        }
        
        if (this.jumlahTransaksi > this.saldo) {
            System.out.println("Maaf, saldo tidak mencukupi!\n");
        } else {
            System.out.println(this.nama + " melakukan transaksi " + this.jenisTransaksi + 
                             " sebesar Rp" + String.format("%,.2f", this.jumlahTransaksi) + 
                             " dari rekening " + this.nomorRekening + "\n");
            this.saldo -= this.jumlahTransaksi;
            System.out.println("Sisa saldo: Rp" + String.format("%,.2f", this.saldo) + "\n");
        }
    }
}