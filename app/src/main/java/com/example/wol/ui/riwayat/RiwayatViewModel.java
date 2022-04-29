package com.example.wol.ui.riwayat;

import androidx.lifecycle.ViewModel;

public class RiwayatViewModel extends ViewModel {
    private String id;
    private String tanggal;
    private String tujuan;
    private String kategori;
    private String nominal;

    void RiwayatViewModel(){
        this.setId("");
        this.setTanggal("");
        this.setTujuan("");
        this.setNominal("");
        this.setKategori("");

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }
}