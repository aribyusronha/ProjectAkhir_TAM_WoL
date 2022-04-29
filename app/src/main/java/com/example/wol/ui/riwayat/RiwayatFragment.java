package com.example.wol.ui.riwayat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wol.MainActivity;
import com.example.wol.databinding.FragmentRiwayatBinding;

import java.util.ArrayList;

public class RiwayatFragment extends Fragment {

    private FragmentRiwayatBinding binding;
    private ArrayList<RiwayatViewModel> riwayatList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RiwayatViewModel riwayatViewModel =
                new ViewModelProvider(this).get(RiwayatViewModel.class);

        binding = FragmentRiwayatBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.recyclerView.setHasFixedSize(true);

        riwayatList = new ArrayList<>();
        riwayatList.addAll(RiwayatData.getListData());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        CardViewAdapter cardViewChatAdapter = new CardViewAdapter(root.getContext());
        cardViewChatAdapter.setRiwayatList(riwayatList);
        binding.recyclerView.setAdapter(cardViewChatAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}