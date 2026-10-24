public class PegawaiKontrak extends Pegawai {
    private double upahPerHari;
    private int jumlahHariKerja;

    public PegawaiKontrak(String nama, String idPegawai, double upahPerHari, int jumlahHariKerja, boolean capaiTarget) {
        super(nama, idPegawai, "Pegawai Kontrak", 0, capaiTarget);
        setUpahPerHari(upahPerHari);
        setJumlahHariKerja(jumlahHariKerja);
    }

    public double getUpahPerHari() {
        return upahPerHari;
    }

    public void setUpahPerHari(double upahPerHari) {
        if (upahPerHari < 0) {
            upahPerHari = 0;
        }
        this.upahPerHari = upahPerHari;
        setGajiPokok(upahPerHari * jumlahHariKerja);
    }

    public int getJumlahHariKerja() {
        return jumlahHariKerja;
    }

    public void setJumlahHariKerja(int jumlahHariKerja) {
        if (jumlahHariKerja < 0) {
            jumlahHariKerja = 0;
        }
        this.jumlahHariKerja = jumlahHariKerja;
        setGajiPokok(upahPerHari * jumlahHariKerja);
    }

    @Override
    public double getTarifPajak() {
        return 0.02; // 2%
    }

    @Override
    public double hitungPajak() {
        return hitungGajiPokok() * getTarifPajak();
    }

    @Override
    public double hitungBonus() {
        return hitungGajiPokok() * 0.05; // 5%
    }

    @Override
    public double hitungPotongan() {
        return hitungGajiPokok() * 0.01; // 1%
    }
}
