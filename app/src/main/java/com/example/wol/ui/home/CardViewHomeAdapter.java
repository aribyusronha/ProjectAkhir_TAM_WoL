package com.example.wol.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wol.ContentActivity;
import com.example.wol.databinding.HomeItemBinding;
import com.google.api.Distribution;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CardViewHomeAdapter extends RecyclerView.Adapter<CardViewHomeAdapter.CardViewHolder> implements Filterable {

    private ArrayList<HomeViewModel> homeList;
    private ArrayList<HomeViewModel> homeListFull;
    private Context context;

    public CardViewHomeAdapter(Context context, ArrayList<HomeViewModel> homeList){
        this.homeList = homeList;
        this.context = context;
    }

    public ArrayList<HomeViewModel> getHomeList() {
        return homeList;
    }

    @NonNull
    @Override
    public CardViewHomeAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CardViewHolder(HomeItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHomeAdapter.CardViewHolder holder, int position) {
        HomeViewModel home = homeList.get(position);
        String img = home.getImage();
        Glide
                .with(context)
                .load(img)
                .into(holder.imgGambar);
        holder.tvNama.setText(home.getNama());
        holder.tvLokasi.setText(home.getLokasi());
        holder.tvRating.setText(home.getRating());
        holder.tvHarga.setText("Rp. "+ home.getHarga());

        holder.relativeLayout.setOnClickListener(new CustomOnClickListener(position, new OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Intent i = new Intent(context, ContentActivity.class);

                i.putExtra("NAMA",homeList.get(position).getNama());
                i.putExtra("LOKASI",homeList.get(position).getLokasi());
                i.putExtra("RATING",homeList.get(position).getRating());
                i.putExtra("HARGA",homeList.get(position).getHarga());
                i.putExtra("DESKRIPSI",homeList.get(position).getDeskripsi());
                i.putExtra("IMAGE",homeList.get(position).getImage());

                context.startActivity(i);
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getHomeList().size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    private Filter filter = new Filter(){

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<HomeViewModel> list = new ArrayList<>();

            if (constraint == null || constraint.length()==0){
                list.addAll(homeListFull);
            }
            else{
                String search = constraint.toString().toLowerCase().trim();

                for (HomeViewModel item : homeListFull){
                    if (item.getNama().toLowerCase().contains(search)){
                        list.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = list;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            homeList.clear();
            homeList.addAll((List)results.values);
            notifyDataSetChanged();

        }
    };

    public static class CardViewHolder extends RecyclerView.ViewHolder{
        public ImageView imgGambar;
        public TextView tvNama, tvLokasi, tvRating, tvHarga;
        public RelativeLayout relativeLayout;


        public CardViewHolder(HomeItemBinding binding) {
            super(binding.getRoot());
            imgGambar = binding.imgItem;
            tvNama = binding.tvNamaTempat;
            tvLokasi = binding.tvLokasiTempat;
            tvRating = binding.tvRatingTempat;
            tvHarga = binding.tvHargaTempat;
            relativeLayout = binding.rlChat;
        }
    }




}
