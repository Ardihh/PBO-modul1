# Sistem Penggajian Karyawan – Tech Nusantara

Program Java console untuk menghitung dan mencetak slip gaji pegawai perusahaan "Tech Nusantara". Proyek ini dibuat untuk **Jurnal Modul I** dan menerapkan konsep **Enkapsulasi, Pewarisan (Inheritance), Polimorfisme (Overriding), dan Overloading**.

## Struktur Proyek

```
.
├── Main.java            # Titik masuk program, membuat data pegawai
├── Perusahaan.java      # Menyimpan pegawai di ArrayList dan mencetak slip gaji
├── Pegawai.java         # Superclass
├── PegawaiTetap.java    # Subclass: Pegawai Tetap
├── PegawaiKontrak.java  # Subclass: Pegawai Kontrak
├── PegawaiMagang.java   # Subclass: Pegawai Magang
├── class-diagram.png    # Class diagram
└── output.txt           # Contoh hasil eksekusi
```

## Cara Menjalankan

Pastikan JDK sudah terpasang (`java -version` dan `javac -version`).

```bash
javac *.java
java Main
```

## Aturan Perhitungan

| Status | Pajak | Bonus (capai target) | Potongan (tidak capai target) |
| --- | --- | --- | --- |
| Pegawai Tetap | 5% dari gaji pokok | 10% dari gaji pokok | 3% dari gaji pokok |
| Pegawai Kontrak | 2% dari gaji pokok | 5% dari gaji pokok | 1% dari gaji pokok |
| Pegawai Magang | 0% (bebas pajak) | Rp 200.000 | Rp 50.000 |

Catatan:
- Gaji pokok Pegawai Tetap = gaji pokok + tunjangan jabatan. Nilai ini menjadi dasar pajak, bonus, dan potongan.
- Gaji pokok Pegawai Kontrak = upah per hari × jumlah hari kerja.
- Total gaji = gaji pokok − pajak + bonus (capai target) atau − potongan (tidak capai target).

## Penjelasan Class

| Class | Peran |
| --- | --- |
| `Pegawai` | Superclass berisi atribut umum (`nama`, `idPegawai`, `status`, `gajiPokok`, `capaiTarget`), getter dan setter, serta method perhitungan gaji. |
| `PegawaiTetap` | Menambah atribut `tunjanganJabatan`. Mengoverride `hitungGajiPokok()`, `getTarifPajak()`, `hitungPajak()`, `hitungBonus()`, `hitungPotongan()`. |
| `PegawaiKontrak` | Menambah atribut `upahPerHari` dan `jumlahHariKerja`. Mengoverride method tarif, pajak, bonus, dan potongan. |
| `PegawaiMagang` | Mengoverride method tarif, pajak, bonus, dan potongan dengan nominal tetap. |
| `Perusahaan` | Menyimpan `ArrayList<Pegawai>`, menambah pegawai lewat `tambahPegawai()`, dan mencetak semua slip gaji lewat `hitungSemuaGaji()`. |
| `Main` | Membuat 4 pegawai, memasukkannya ke `Perusahaan`, lalu memanggil `hitungSemuaGaji()`. |

## Konsep OOP yang Diterapkan

- **Enkapsulasi**: seluruh atribut bersifat `private` dan diakses lewat getter dan setter `public`.
- **Pewarisan**: `PegawaiTetap`, `PegawaiKontrak`, dan `PegawaiMagang` mewarisi `Pegawai` dengan `extends` dan memanggil konstruktor induk lewat `super()`.
- **Polimorfisme (Overriding)**: tiap subclass meng-override `getTarifPajak()`, `hitungPajak()`, `hitungBonus()`, dan `hitungPotongan()`. `Perusahaan` memanggil method itu lewat tipe `Pegawai`, sehingga yang dijalankan adalah versi milik subclass.
- **Overloading**: `hitungGajiPokok()` dan `hitungGajiPokok(double tunjangan)` memakai nama sama dengan parameter berbeda. Versi kedua dipakai `PegawaiTetap`.

## Data Pegawai

| Nama | ID | Status | Gaji | Target |
| --- | --- | --- | --- | --- |
| Budi | T001 | Tetap | Rp 5.000.000 + tunjangan Rp 1.000.000 | Capai |
| Siti | K001 | Kontrak | Rp 300.000 × 20 hari | Tidak capai |
| Andi | M001 | Magang | Rp 2.000.000 | Capai |
| Dewi | T002 | Tetap | Rp 6.000.000 + tunjangan Rp 1.500.000 | Tidak capai |

## Contoh Output

```
=======================================
SLIP GAJI PEGAWAI
=======================================
Nama Pegawai    : Budi
ID              : T001
Status          : Pegawai Tetap
Gaji Pokok + Tunjangan : Rp 6.000.000
Pajak (5%)      : Rp 300.000
Status Kinerja  : Capai Target (Bonus Rp 600.000)
Total Take Home Pay : Rp 6.300.000
---------------------------------------
Nama Pegawai    : Siti
ID              : K001
Status          : Pegawai Kontrak
Gaji Pokok      : Rp 6.000.000
Pajak (2%)      : Rp 120.000
Status Kinerja  : Tidak Capai Target (Potongan Rp 60.000)
Total Take Home Pay : Rp 5.820.000
---------------------------------------
Nama Pegawai    : Andi
ID              : M001
Status          : Pegawai Magang
Gaji Pokok      : Rp 2.000.000
Pajak (0%)      : Rp 0
Status Kinerja  : Capai Target (Bonus Rp 200.000)
Total Take Home Pay : Rp 2.200.000
---------------------------------------
Nama Pegawai    : Dewi
ID              : T002
Status          : Pegawai Tetap
Gaji Pokok + Tunjangan : Rp 7.500.000
Pajak (5%)      : Rp 375.000
Status Kinerja  : Tidak Capai Target (Potongan Rp 225.000)
Total Take Home Pay : Rp 6.900.000
=======================================
```