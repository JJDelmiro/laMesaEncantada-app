package com.example.lamesaencantada;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lamesaencantada.R;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTotalBill, editTextCouvert, editTextServiceTax, editTextNumberOfPeople;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTotalBill = findViewById(R.id.editTextTotalBill);
        editTextCouvert = findViewById(R.id.editTextCouvert);
        editTextServiceTax = findViewById(R.id.editTextServiceTax);
        editTextNumberOfPeople = findViewById(R.id.editTextNumberOfPeople);
        textViewResult = findViewById(R.id.textViewResult);
        Button buttonCalculate = findViewById(R.id.buttonCalculate);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBill();
            }
        });
    }

    private void calculateBill() {
        try {
            double totalBill = Double.parseDouble(editTextTotalBill.getText().toString());
            double couvert = Double.parseDouble(editTextCouvert.getText().toString());
            double serviceTax = Double.parseDouble(editTextServiceTax.getText().toString());
            int numberOfPeople = Integer.parseInt(editTextNumberOfPeople.getText().toString());

            double serviceTaxAmount = totalBill * (serviceTax / 100);
            double totalAmount = totalBill + couvert + serviceTaxAmount;
            double amountPerPerson = totalAmount / numberOfPeople;

            textViewResult.setText(String.format("Total por Pessoa: R$ %.2f", amountPerPerson));
        } catch (NumberFormatException e) {
            textViewResult.setText("Por favor, preencha todos os campos corretamente.");
        }
    }
}