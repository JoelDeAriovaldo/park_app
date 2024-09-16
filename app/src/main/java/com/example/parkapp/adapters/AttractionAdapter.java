package com.example.parkapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.parkapp.R;
import com.example.parkapp.models.Attraction;
import java.util.List;

public class AttractionAdapter extends RecyclerView.Adapter<AttractionAdapter.AttractionViewHolder> {

    private List<Attraction> attractionList;
    private Context context;

    public AttractionAdapter(Context context, List<Attraction> attractionList) {
        this.context = context;
        this.attractionList = attractionList;
    }

    @NonNull
    @Override
    public AttractionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_attraction, parent, false);
        return new AttractionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AttractionViewHolder holder, int position) {
        Attraction attraction = attractionList.get(position);
        holder.tvAttractionName.setText(attraction.getName());
        holder.tvAttractionDescription.setText(attraction.getDescription());
    }

    @Override
    public int getItemCount() {
        return attractionList.size();
    }

    public static class AttractionViewHolder extends RecyclerView.ViewHolder {

        TextView tvAttractionName;
        TextView tvAttractionDescription;

        public AttractionViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAttractionName = itemView.findViewById(R.id.tv_attraction_name);
            tvAttractionDescription = itemView.findViewById(R.id.tv_attraction_description);
        }
    }
}
