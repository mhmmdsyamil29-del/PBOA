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