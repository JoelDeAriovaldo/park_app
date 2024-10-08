package com.example.parkapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.parkapp.R;
import com.example.parkapp.activities.TicketPurchaseActivity;
import com.example.parkapp.adapters.AttractionAdapter;
import com.example.parkapp.models.Attraction;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView rvAttractions;
    private AttractionAdapter attractionAdapter;
    private List<Attraction> attractionList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rvAttractions = view.findViewById(R.id.rv_attractions);
        ExtendedFloatingActionButton fabBuyTickets = view.findViewById(R.id.fab_buy_tickets);

        setupRecyclerView();
        setupFabButton(fabBuyTickets);
        loadAttractions();

        return view;
    }

    private void setupRecyclerView() {
        rvAttractions.setLayoutManager(new LinearLayoutManager(getContext()));
        attractionList = new ArrayList<>();
        attractionAdapter = new AttractionAdapter(getContext(), attractionList);
        rvAttractions.setAdapter(attractionAdapter);
    }

    private void setupFabButton(ExtendedFloatingActionButton fabBuyTickets) {
        fabBuyTickets.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), TicketPurchaseActivity.class);
            startActivity(intent);
        });
    }

    private void loadAttractions() {
        attractionList.add(new Attraction("Montanha Russa", "Uma emocionante montanha russa."));
        attractionList.add(new Attraction("Roda Gigante", "Uma roda gigante com vista panorâmica."));
        attractionAdapter.notifyDataSetChanged();
    }
}