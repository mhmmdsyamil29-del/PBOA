# Tugas 1 — Class ATM (Java & PHP)
Nama : [Muhammad Syamil]
NPM : [4525210130]

# Domain
**ATM (Automatic Teller Machine)** — merepresentasikan sebuah mesin ATM dengan atribut identitas pengguna (nama, nomor rekening) serta atribut aktivitas transaksi (saldo, jenis transaksi, dan jumlah transaksi).

# Struktur Class
| Field |	Tipe |	Keterangan |
|-------|------|-------------|
| `nama` | `String` |	`Wajib diisi lewat constructor` |
| `nomorRekening` |	`String` |	`Wajib diisi lewat constructor` |
| `saldo` |	`double (nullable)` |	`Saldo rekening pengguna` |
| `jenisTransaksi` |	`String (nullable)` |	`Jenis transaksi yang dilakukan` |
| `jumlahTransaksi` |	`double (nullable)` |	`Jumlah nominal transaksi` |
# Method:

- cekSaldo() — menampilkan informasi saldo rekening berdasarkan saldo

- tarikTunai() — menampilkan aktivitas penarikan tunai berdasarkan jenisTransaksi dan jumlahTransaksi

# Invarian & Alasan
1. saldo tidak boleh null/0 saat cekSaldo() dipanggil.
Alasan: method cekSaldo() merepresentasikan aktivitas pengecekan saldo rekening. Tanpa informasi saldo yang valid, tidak ada data yang bisa ditampilkan secara bermakna kepada pengguna. Pelanggaran akan melempar IllegalArgumentException (Java) / InvalidArgumentException (PHP).

2. jenisTransaksi dan jumlahTransaksi tidak boleh null saat tarikTunai() dipanggil.
Alasan: method tarikTunai() merepresentasikan aktivitas transaksi penarikan uang. Tanpa jenis transaksi dan jumlah nominal yang ditentukan, proses penarikan tidak dapat dijalankan dengan valid. Pelanggaran akan melempar IllegalArgumentException (Java) / InvalidArgumentException (PHP).

# Struktur Berkas
 ```Struktur Folder
PBO/ **(Root Folder)**
├── Tugas1_ATM/
│   ├── img/
│   ├── src/
│   │    ├── ATM.java        # Definisi class (Java)
│   │    ├── Main.java       # Program utama (Java)
│   │    ├── ATM.php         # Definisi class (PHP)
│   │    └── index.php       # Program utama (PHP)
│   └── README.md
```
# Cara Menjalankan
### Java
```Powershell / bash
javac ATM.java Main.java
java Main
```
### PHP
```Powershell / bash
php index.php
```
# Kode Program

### ATM.java
```Struktur Folder
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
        if (this.saldo == 0.0) {
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
        if (this.jumlahTransaksi == 0.0) {
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
```
### Main.java
```Struktur Folder
java
public class Main {
    public static void main(String[] args) {
        // Membuat objek ATM pertama
        ATM atm1 = new ATM("Budi Santoso", "1234567890");
        atm1.saldo = 5000000.0;
        atm1.jenisTransaksi = "Penarikan Tunai";
        atm1.jumlahTransaksi = 1500000.0;
        
        atm1.cekSaldo();
        atm1.tarikTunai();
        
        System.out.println("===================================\n");
        
        // Membuat objek ATM kedua
        ATM atm2 = new ATM("Siti Rahayu", "0987654321");
        atm2.saldo = 2500000.0;
        atm2.jenisTransaksi = "Penarikan Tunai";
        atm2.jumlahTransaksi = 3000000.0;
        
        atm2.cekSaldo();
        atm2.tarikTunai(); // Akan menampilkan saldo tidak cukup
    }
}
```

### ATM.php
```Struktur Folder
php
<?php
class ATM {
    // Atribut/field/properties
    public $nama;
    public $nomorRekening;
    public $saldo;
    public $jenisTransaksi;
    public $jumlahTransaksi;

    // Constructor
    public function __construct($nama, $nomorRekening) {
        $this->nama = $nama;
        $this->nomorRekening = $nomorRekening;
    }

    // Method
    public function cekSaldo() {
        if ($this->saldo == 0) {
            throw new InvalidArgumentException("Maaf, saldo bernilai 0 atau belum diisi!\n");
        }
        echo "Saldo rekening " . $this->nomorRekening . 
             " atas nama " . $this->nama . 
             " adalah: Rp" . number_format($this->saldo, 2, ',', '.') . "\n\n";
    }

    public function tarikTunai() {
        if ($this->jenisTransaksi == null) {
            throw new InvalidArgumentException("Maaf, jenisTransaksi bernilai NULL!\n");
        }
        if ($this->jumlahTransaksi == 0) {
            throw new InvalidArgumentException("Maaf, jumlahTransaksi bernilai 0 atau belum diisi!\n");
        }
        
        if ($this->jumlahTransaksi > $this->saldo) {
            echo "Maaf, saldo tidak mencukupi!\n\n";
        } else {
            echo $this->nama . " melakukan transaksi " . $this->jenisTransaksi . 
                 " sebesar Rp" . number_format($this->jumlahTransaksi, 2, ',', '.') . 
                 " dari rekening " . $this->nomorRekening . "\n";
            $this->saldo -= $this->jumlahTransaksi;
            echo "Sisa saldo: Rp" . number_format($this->saldo, 2, ',', '.') . "\n\n";
        }
    }
}
?>
```
### index.php
```Struktur Folder
php
<?php
require_once 'ATM.php';

// Membuat objek ATM pertama
$atm1 = new ATM("Budi Santoso", "1234567890");
$atm1->saldo = 5000000.0;
$atm1->jenisTransaksi = "Penarikan Tunai";
$atm1->jumlahTransaksi = 1500000.0;

$atm1->cekSaldo();
$atm1->tarikTunai();

echo "===================================\n\n";

// Membuat objek ATM kedua
$atm2 = new ATM("Siti Rahayu", "0987654321");
$atm2->saldo = 2500000.0;
$atm2->jenisTransaksi = "Penarikan Tunai";
$atm2->jumlahTransaksi = 3000000.0;

$atm2->cekSaldo();
$atm2->tarikTunai(); // Akan menampilkan saldo tidak cukup
?>
```
# Contoh Output
```Struktur Folder
Saldo rekening 1234567890 atas nama Budi Santoso adalah: Rp5,000,000.00

Budi Santoso melakukan transaksi Penarikan Tunai sebesar Rp1,500,000.00 dari rekening 1234567890
Sisa saldo: Rp3,500,000.00

Saldo rekening 0987654321 atas nama Siti Rahayu adalah: Rp2,500,000.00

Maaf, saldo tidak mencukupi!
```
# Deklarasi Penggunaan AI
Asisten AI (Claude, Anthropic) digunakan untuk membantu menyusun struktur dan format dokumen README.md ini, berdasarkan ketentuan tugas dan kode program yang telah dibuat sebelumnya. AI tidak digunakan untuk menulis kode Java/PHP pada tugas ini.
