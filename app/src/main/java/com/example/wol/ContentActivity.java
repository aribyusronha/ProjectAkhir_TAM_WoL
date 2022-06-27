package com.example.wol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.wol.databinding.ActivityContentBinding;
import com.example.wol.databinding.ActivityLoginBinding;
import com.example.wol.databinding.ContentMainBinding;
import com.example.wol.ui.riwayat.RiwayatViewModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ContentActivity extends AppCompatActivity {
    ActivityContentBinding binding;

    private DatabaseReference mDatabase;
    private String nama;
    private String lokasi;
    private String rating;
    private String harga;
    private String deskripsi;
    private String image;
    private RiwayatViewModel riwayat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        binding = ActivityContentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        nama = getIntent().getStringExtra("NAMA");
        lokasi = getIntent().getStringExtra("LOKASI");
        rating = getIntent().getStringExtra("RATING");
        harga = getIntent().getStringExtra("HARGA");
        deskripsi = getIntent().getStringExtra("DESKRIPSI");
        image = getIntent().getStringExtra("IMAGE");

        mDatabase = FirebaseDatabase.getInstance().getReference();
        riwayat = new RiwayatViewModel(nama,lokasi,harga);

        binding.tvNama.setText(nama);
        binding.tvLokasi.setText(lokasi);
        binding.tvRating.setText(rating);
        binding.tvHarga.setText(harga);
        binding.tvDeskripsi.setText(deskripsi);
        Glide
                .with(this)
                .load(image)
                .into(binding.imgContent);

        binding.btnRiwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNewRiwayat(riwayat);
                Toast.makeText(ContentActivity.this, "Data di Masukkan ke Riwayat", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void writeNewRiwayat(RiwayatViewModel riwayat) {
        mDatabase.child("riwayat").child(riwayat.getNama()).setValue(riwayat);

    }
}