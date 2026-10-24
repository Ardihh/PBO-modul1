import java.util.ArrayList;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Perusahaan {
    private String namaPerusahaan;
    private ArrayList<Pegawai> daftarPegawai;

    public Perusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
        this.daftarPegawai = new ArrayList<>();
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public void tambahPegawai(Pegawai pegawai) {
        daftarPegawai.add(pegawai);
    }

    // Format nilai rupiah: 6000000 -> "Rp 6.000.000"
    private String formatRupiah(double nilai) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.of("id", "ID"));
        symbols.setGroupingSeparator('.');

        DecimalFormat formatter = new DecimalFormat("'Rp ' #,###", symbols);
        
        return formatter.format(nilai);
    }

    // Cetak satu baris slip: label dilebarkan minimal 15 karakter agar titik dua sejajar (opsional si tapi)
    private void cetak(String label, String isi) {
        System.out.printf("%-15s : %s%n", label, isi);
    }

    // Looping dan cetak slip gaji semua pegawai di ArrayList
    public void hitungSemuaGaji() {
        String garisAtas = "=======================================";
        String garisPemisah = "---------------------------------------";

        System.out.println(garisAtas);
        System.out.println("SLIP GAJI PEGAWAI");
        System.out.println(garisAtas);

        for (int i = 0; i < daftarPegawai.size(); i++) {
            Pegawai p = daftarPegawai.get(i);
            boolean capai = p.isCapaiTarget();

            // kalo gabuat method cetak berati di spasiin manual juga gpp
            cetak("Nama Pegawai", p.getNama());
            cetak("ID", p.getIdPegawai());
            cetak("Status", p.getStatus());

            // Hanya Pegawai Tetap yang punya tunjangan
            String labelGaji = p.getStatus().equals("Pegawai Tetap") ? "Gaji Pokok + Tunjangan" : "Gaji Pokok";
            cetak(labelGaji, formatRupiah(p.hitungGajiPokok()));

            int persenPajak = (int) Math.round(p.getTarifPajak() * 100);
            cetak("Pajak (" + persenPajak + "%)", formatRupiah(p.hitungPajak()));

            if (capai) {
                cetak("Status Kinerja", "Capai Target (Bonus " + formatRupiah(p.hitungBonus()) + ")");
            } else {
                cetak("Status Kinerja", "Tidak Capai Target (Potongan " + formatRupiah(p.hitungPotongan()) + ")");
            }

            cetak("Total Take Home Pay", formatRupiah(p.hitungTotalGaji(capai)));

            if (i < daftarPegawai.size() - 1) {
                System.out.println(garisPemisah);
            }
        }
        System.out.println(garisAtas);
    }
}
