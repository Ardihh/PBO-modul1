public class Main {
    public static void main(String[] args) {
        Perusahaan perusahaan = new Perusahaan("Tech Nusantara");

        // pegawai1: Tetap, gaji pokok 5.000.000, tunjangan 1.000.000, capai target
        Pegawai pegawai1 = new PegawaiTetap("Budi", "T001", 5000000, 1000000, true);

        // pegawai2: Kontrak, 300.000/hari x 20 hari, tidak capai target
        Pegawai pegawai2 = new PegawaiKontrak("Siti", "K001", 300000, 20, false);

        // pegawai3: Magang, gaji pokok 2.000.000, capai target
        Pegawai pegawai3 = new PegawaiMagang("Andi", "M001", 2000000, true);

        // pegawai4: Tetap, gaji pokok 6.000.000, tunjangan 1.500.000, tidak capai target
        Pegawai pegawai4 = new PegawaiTetap("Dewi", "T002", 6000000, 1500000, false);

        perusahaan.tambahPegawai(pegawai1);
        perusahaan.tambahPegawai(pegawai2);
        perusahaan.tambahPegawai(pegawai3);
        perusahaan.tambahPegawai(pegawai4);

        perusahaan.hitungSemuaGaji();
    }
}

