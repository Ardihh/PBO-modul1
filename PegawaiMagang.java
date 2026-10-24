public class PegawaiMagang extends Pegawai {
    private static final double BONUS_TETAP = 200000;
    private static final double POTONGAN_TETAP = 50000;

    public PegawaiMagang(String nama, String idPegawai, double gajiPokok, boolean capaiTarget) {
        super(nama, idPegawai, "Pegawai Magang", gajiPokok, capaiTarget);
    }

    @Override
    public double getTarifPajak() {
        return 0.0; // bebas pajak
    }

    @Override
    public double hitungPajak() {
        return hitungGajiPokok() * getTarifPajak();
    }

    @Override
    public double hitungBonus() {
        return BONUS_TETAP; // nominal tetap
    }

    @Override
    public double hitungPotongan() {
        return POTONGAN_TETAP; // nominal tetap
    }
}
