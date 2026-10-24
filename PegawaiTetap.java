public class PegawaiTetap extends Pegawai {
    private double tunjanganJabatan;

    public PegawaiTetap(String nama, String idPegawai, double gajiPokok, double tunjanganJabatan, boolean capaiTarget) {
        super(nama, idPegawai, "Pegawai Tetap", gajiPokok, capaiTarget);
        setTunjanganJabatan(tunjanganJabatan);
    }

    public double getTunjanganJabatan() {
        return tunjanganJabatan;
    }

    public void setTunjanganJabatan(double tunjanganJabatan) {
        if (tunjanganJabatan < 0) {
            throw new IllegalArgumentException("Tunjangan tidak boleh negatif");
        }
        this.tunjanganJabatan = tunjanganJabatan;
    }

    // Gaji pokok Pegawai Tetap sudah termasuk tunjangan jabatan (pake overloading)
    @Override
    public double hitungGajiPokok() {
        return hitungGajiPokok(tunjanganJabatan);
    }

    @Override
    public double getTarifPajak() {
        return 0.05; // 5%
    }

    @Override
    public double hitungPajak() {
        return hitungGajiPokok() * getTarifPajak();
    }

    @Override
    public double hitungBonus() {
        return hitungGajiPokok() * 0.10; // 10%
    }

    @Override
    public double hitungPotongan() {
        return hitungGajiPokok() * 0.03; // 3%
    }
}
