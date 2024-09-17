package com.example.parkapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.parkapp.R;
import com.example.parkapp.models.Ticket;
import java.util.List;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.TicketViewHolder> {

    private List<Ticket> ticketList;
    private Context context;

    public TicketAdapter(Context context, List<Ticket> ticketList) {
        this.context = context;
        this.ticketList = ticketList;
    }

    @NonNull
    @Override
    public TicketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ticket, parent, false);
        return new TicketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TicketViewHolder holder, int position) {
        Ticket ticket = ticketList.get(position);
        holder.tvTicketType.setText(ticket.getType());
        holder.tvTicketQuantity.setText(String.valueOf(ticket.getQuantity()));
        holder.tvTicketPrice.setText(String.format("MZN %.2f", ticket.getPrice()));
    }

    @Override
    public int getItemCount() {
        return ticketList.size();
    }

    public static class TicketViewHolder extends RecyclerView.ViewHolder {

        TextView tvTicketType;
        TextView tvTicketQuantity;
        TextView tvTicketPrice;

        public TicketViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTicketType = itemView.findViewById(R.id.tv_ticket_type);
            tvTicketQuantity = itemView.findViewById(R.id.tv_ticket_quantity);
            tvTicketPrice = itemView.findViewById(R.id.tv_ticket_price);
        }
    }
}
