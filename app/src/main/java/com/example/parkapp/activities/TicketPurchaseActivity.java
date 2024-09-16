package com.example.parkapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.parkapp.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class TicketPurchaseActivity extends AppCompatActivity {

    private ChipGroup chipGroupTicketType;
    private TextInputLayout tilQuantity;
    private TextInputEditText etQuantity;
    private TextView tvTotalPrice;
    private ExtendedFloatingActionButton fabPurchase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_purchase);

        initializeViews();
        setListeners();
    }

    private void initializeViews() {
        chipGroupTicketType = findViewById(R.id.chip_group_ticket_type);
        tilQuantity = findViewById(R.id.til_quantity);
        etQuantity = findViewById(R.id.et_quantity);
        tvTotalPrice = findViewById(R.id.tv_total_price);
        fabPurchase = findViewById(R.id.fab_purchase);
    }

    private void setListeners() {
        fabPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quantityStr = etQuantity.getText().toString().trim();
                if (quantityStr.isEmpty()) {
                    Toast.makeText(TicketPurchaseActivity.this, "Please enter the quantity", Toast.LENGTH_SHORT).show();
                    return;
                }

                int quantity = Integer.parseInt(quantityStr);
                int selectedChipId = chipGroupTicketType.getCheckedChipId();
                if (selectedChipId == -1) {
                    Toast.makeText(TicketPurchaseActivity.this, "Please select a ticket type", Toast.LENGTH_SHORT).show();
                    return;
                }

                Chip selectedChip = findViewById(selectedChipId);
                String ticketType = selectedChip.getText().toString();
                double price = calculatePrice(ticketType, quantity);
                tvTotalPrice.setText(String.format("R$ %.2f", price));

                // Implement purchase logic here
                Toast.makeText(TicketPurchaseActivity.this, "Purchase successful", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private double calculatePrice(String ticketType, int quantity) {
        double pricePerTicket;
        switch (ticketType) {
            case "Adult":
                pricePerTicket = 20.0;
                break;
            case "Child":
                pricePerTicket = 10.0;
                break;
            case "Senior":
                pricePerTicket = 15.0;
                break;
            default:
                pricePerTicket = 0.0;
                break;
        }
        return pricePerTicket * quantity;
    }
}