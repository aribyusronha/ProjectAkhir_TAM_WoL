package com.example.wol.ui.riwayat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wol.databinding.RiwayatItemBinding;
import com.example.wol.ui.home.HomeViewModel;

import java.util.ArrayList;

public class CardViewRiwayatAdapter extends RecyclerView.Adapter<CardViewRiwayatAdapter.CardViewHolder> {

    private ArrayList<RiwayatViewModel> riwayatList;
    Context context;

    public CardViewRiwayatAdapter(Context context,ArrayList<RiwayatViewModel> riwayatList){
        this.context = context;
        this.riwayatList = riwayatList;
    }

    public ArrayList<RiwayatViewModel> getRiwayatList() {
        return riwayatList;
    }

    @NonNull
    @Override
    public CardViewRiwayatAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CardViewHolder(RiwayatItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(CardViewRiwayatAdapter.CardViewHolder holder, int position) {
        RiwayatViewModel riwayat = riwayatList.get(position);
        holder.tvNama.setText(riwayat.getNama());
        holder.tvLokasi.setText(riwayat.getLokasi());
        holder.tvHarga.setText("Rp. "+riwayat.getHarga());
    }

    @Override
    public int getItemCount() {
        return riwayatList == null ? 0 : riwayatList.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNama,tvLokasi,tvHarga;

        public CardViewHolder(RiwayatItemBinding binding) {
            super(binding.getRoot());

            tvNama = binding.tvNamaItem;
            tvLokasi = binding.tvLokasiItem;
            tvHarga = binding.tvHargaItem;
        }
    }
}
