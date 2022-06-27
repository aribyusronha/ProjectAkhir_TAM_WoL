package com.example.wol.ui.riwayat;

import androidx.lifecycle.ViewModel;

public class RiwayatViewModel extends ViewModel {
    private String nama;
    private String lokasi;
    private String harga;

    public RiwayatViewModel() {
        nama = "";
        lokasi = "";
        harga = "";
    }

    public RiwayatViewModel(String nama, String lokasi, String harga) {
        this.setNama(nama);
        this.setLokasi(lokasi);
        this.setHarga(harga);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}