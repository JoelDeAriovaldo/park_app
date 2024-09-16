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
import com.example.parkapp.adapters.TicketAdapter;
import com.example.parkapp.models.Ticket;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class TicketsFragment extends Fragment {

    private RecyclerView rvActiveTickets;
    private RecyclerView rvPastTickets;
    private TicketAdapter activeTicketAdapter;
    private TicketAdapter pastTicketAdapter;
    private List<Ticket> activeTicketList;
    private List<Ticket> pastTicketList;
    private ExtendedFloatingActionButton fabAddTicket;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tickets, container, false);

        rvActiveTickets = view.findViewById(R.id.rv_active_tickets);
        rvPastTickets = view.findViewById(R.id.rv_past_tickets);
        fabAddTicket = view.findViewById(R.id.fab_add_ticket);

        // Configurar RecyclerView para tickets ativos
        rvActiveTickets.setLayoutManager(new LinearLayoutManager(getContext()));
        activeTicketList = new ArrayList<>();
        activeTicketAdapter = new TicketAdapter(getContext(), activeTicketList);
        rvActiveTickets.setAdapter(activeTicketAdapter);

        // Configurar RecyclerView para tickets passados
        rvPastTickets.setLayoutManager(new LinearLayoutManager(getContext()));
        pastTicketList = new ArrayList<>();
        pastTicketAdapter = new TicketAdapter(getContext(), pastTicketList);
        rvPastTickets.setAdapter(pastTicketAdapter);

        // Adicionar lógica para FloatingActionButton
        fabAddTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar para a tela de adicionar novo ticket
                // Exemplo: Navigation.findNavController(v).navigate(R.id.action_ticketsFragment_to_addTicketFragment);
            }
        });

        // Carregar dados de exemplo
        loadTickets();

        return view;
    }

    private void loadTickets() {
        // Adicionar dados de exemplo para tickets ativos
        activeTicketList.add(new Ticket("Adulto", 2, 50.00));
        activeTicketList.add(new Ticket("Criança", 1, 25.00));
        activeTicketAdapter.notifyDataSetChanged();

        // Adicionar dados de exemplo para tickets passados
        pastTicketList.add(new Ticket("Adulto", 1, 50.00));
        pastTicketList.add(new Ticket("Senior", 1, 30.00));
        pastTicketAdapter.notifyDataSetChanged();
    }
}