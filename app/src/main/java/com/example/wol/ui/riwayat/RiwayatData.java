package com.example.wol.ui.riwayat;

import java.util.ArrayList;

public class RiwayatData {
    public static String[][] data = new String[][]{
            {"Pantai Marina","24-04-2022","Rp. 750.000","FT001","Selesai"},
            {"Pantai Klara","30-04-2022","Rp. 800.000","FT002","Berlangsung"},
            {"Gunung Betung","10-08-2022","Rp. 650.000","FT003","Sudah Dibayar"},
            {"Museum Lampung","17-08-2022","Rp. 350.000","FT003","Belum Dibayar"},
    };

    public static ArrayList<RiwayatViewModel> getListData() {
        RiwayatViewModel riwayat = null;
        ArrayList<RiwayatViewModel> list = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            riwayat = new RiwayatViewModel();
            riwayat.setTujuan(data[i][0]);
            riwayat.setTanggal(data[i][1]);
            riwayat.setNominal(data[i][2]);
            riwayat.setId(data[i][3]);
            riwayat.setKategori(data[i][4]);

            list.add(riwayat);
        }
        return list;
    }
}
