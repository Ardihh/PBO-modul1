public class Pegawai {
    // Enkapsulasi: semua atribut private, diakses lewat getter/setter
    private String nama;
    private String idPegawai;
    private String status;
    private double gajiPokok;
    private boolean capaiTarget;

    public Pegawai(String nama, String idPegawai, String status, double gajiPokok, boolean capaiTarget) {
        // Konstruktor pake setter biar divalidasi
        setNama(nama);
        setIdPegawai(idPegawai);
        setStatus(status);
        setGajiPokok(gajiPokok);
        setCapaiTarget(capaiTarget);
    }

    // ===== Getter & Setter =====
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama pegawai tidak boleh kosong");
        }
        this.nama = nama;
    }

    public String getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(String idPegawai) {
        if (idPegawai == null || idPegawai.trim().isEmpty()) {
            throw new IllegalArgumentException("ID pegawai tidak boleh kosong");
        }
        this.idPegawai = idPegawai;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status == null || status.trim().isEmpty()) {
            throw new IllegalArgumentException("Status pegawai tidak boleh kosong");
        }
        this.status = status;
    }

    public double getGajiPokok() {
        return gajiPokok;
    }

    public void setGajiPokok(double gajiPokok) {
        if (gajiPokok < 0) {
            throw new IllegalArgumentException("Gaji pokok tidak boleh negatif");
        }
        this.gajiPokok = gajiPokok;
    }

    public boolean isCapaiTarget() {
        return capaiTarget;
    }

    public void setCapaiTarget(boolean capaiTarget) {
        this.capaiTarget = capaiTarget;
    }

    // ===== Overloading hitungGajiPokok =====

    // Mengembalikan gaji pokok standar
    public double hitungGajiPokok() {
        return gajiPokok;
    }

    // Gaji pokok + tunjangan khusus (hanya dipakai Pegawai Tetap)
    public double hitungGajiPokok(double tunjangan) {
        return gajiPokok + tunjangan;
    }

    // ===== Method yang di-override oleh tiap jenis pegawai =====

    // Tarif pajak (desimal), misal 0.05 = 5%. Default 0, di-override subclass
    public double getTarifPajak() {
        return 0;
    }

    // Nominal pajak berdasarkan status pegawai
    public double hitungPajak() {
        return hitungGajiPokok() * getTarifPajak();
    }

    // Bonus jika mencapai target. Default 0, di-override subclass
    public double hitungBonus() {
        return 0;
    }

    // Potongan jika tidak mencapai target. Default 0, di-override subclass
    public double hitungPotongan() {
        return 0;
    }

    // Total gaji = Gaji Pokok - Pajak + Bonus (capai target) atau - Potongan (tidak capai)
    public double hitungTotalGaji(boolean capaiTarget) {
        double total = hitungGajiPokok() - hitungPajak();
        if (capaiTarget) {
            total += hitungBonus();
        } else {
            total -= hitungPotongan();
        }
        return total;
    }
}
