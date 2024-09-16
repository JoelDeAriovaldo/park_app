package com.example.parkapp.fragments;

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
import com.example.parkapp.adapters.AttractionAdapter;
import com.example.parkapp.models.Attraction;
import java.util.ArrayList;
import java.util.List;

public class AttractionsFragment extends Fragment {

    private RecyclerView rvAttractions;
    private AttractionAdapter attractionAdapter;
    private List<Attraction> attractionList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attractions, container, false);

        rvAttractions = view.findViewById(R.id.rv_attractions);

        // Configure RecyclerView
        rvAttractions.setLayoutManager(new LinearLayoutManager(getContext()));
        attractionList = new ArrayList<>();
        attractionAdapter = new AttractionAdapter(getContext(), attractionList);
        rvAttractions.setAdapter(attractionAdapter);

        // Load attractions data
        loadAttractions();

        return view;
    }

    private void loadAttractions() {
        // Add sample data
        attractionList.add(new Attraction("Montanha Russa", "Uma emocionante montanha russa."));
        attractionList.add(new Attraction("Roda Gigante", "Uma roda gigante com vista panorâmica."));
        attractionAdapter.notifyDataSetChanged();
    }
}