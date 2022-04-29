package com.example.wol.ui.riwayat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wol.databinding.RiwayatItemBinding;

import java.util.ArrayList;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.CardViewHolder> {

    private ArrayList<RiwayatViewModel> riwayatList;
    Context context;

    public CardViewAdapter(Context context){
        this.context = context;
    }

    public ArrayList<RiwayatViewModel> getRiwayatList() {
        return riwayatList;
    }

    public void setRiwayatList(ArrayList<RiwayatViewModel> riwayatList) {
        this.riwayatList = riwayatList;
    }


    @NonNull
    @Override
    public CardViewAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CardViewHolder(RiwayatItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(CardViewAdapter.CardViewHolder holder, int position) {
        RiwayatViewModel riwayat = riwayatList.get(position);
        holder.tvTujuan.setText(riwayat.getTujuan());
        holder.tvTanggal.setText(riwayat.getTanggal());
        holder.tvNominal.setText(riwayat.getNominal());
        holder.tvId.setText(riwayat.getId());
        holder.tvKategori.setText(riwayat.getKategori());
    }

    @Override
    public int getItemCount() {
        return getRiwayatList().size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTujuan,tvTanggal,tvNominal,tvId,tvKategori;

        public CardViewHolder(RiwayatItemBinding binding) {
            super(binding.getRoot());
            tvId = binding.tvItemId;
            tvTujuan = binding.tvItemTujuan;
            tvTanggal = binding.tvItemTanggal;
            tvNominal = binding.tvItemNominal;
            tvKategori = binding.tvItemKategori;
        }
    }
}
