package com.example.wol.ui.home;

import static android.content.ContentValues.TAG;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.wol.ContentActivity;
import com.example.wol.databinding.FragmentHomeBinding;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class HomeFragment extends Fragment{

    private FragmentHomeBinding binding;
    private ArrayList<HomeViewModel> homeList;
    private CardViewHomeAdapter cardViewHomeAdapter;
    private FirebaseFirestore db;
    private ProgressDialog progressDialog;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Loading data");
        progressDialog.setMessage("Silahkan Tunggu!");
        progressDialog.setCancelable(false);
        progressDialog.show();

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        db = FirebaseFirestore.getInstance();
        homeList = new ArrayList<HomeViewModel>();

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));

        EventChangeListener();

        cardViewHomeAdapter = new CardViewHomeAdapter(getContext(),homeList);
        binding.recyclerView.setAdapter(cardViewHomeAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void EventChangeListener(){
        db.collection("WoL").orderBy("rating", Query.Direction.DESCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                        if(e != null){
                            if (progressDialog.isShowing()){
                                progressDialog.dismiss();
                            }
                            Log.e("Firestore Error",e.getMessage());
                            return;
                        }

                        for(DocumentChange dc : queryDocumentSnapshots.getDocumentChanges()){
                            if(dc.getType()==DocumentChange.Type.ADDED){
                                homeList.add(dc.getDocument().toObject(HomeViewModel.class));
                            }
                            cardViewHomeAdapter.notifyDataSetChanged();

                            if (progressDialog.isShowing()){
                                progressDialog.dismiss();
                            }
                        }
                    }
                });
    }

}