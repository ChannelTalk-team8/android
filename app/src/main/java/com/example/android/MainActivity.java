package com.example.android;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ChipGroup purposeChipGroup;
    private ChipGroup weightChipGroup;
    private ChipGroup priceChipGroup;
    private ChipGroup sizeChipGroup;

    private Button btnSearch;

    private String selectedPurpose = null;
    private String selectedWeight = null;
    private String selectedPrice = null;
    private String selectedSize = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        purposeChipGroup = (ChipGroup) findViewById(R.id.purpose_chip_group);
        weightChipGroup = (ChipGroup) findViewById(R.id.weight_chip_group);
        priceChipGroup = (ChipGroup) findViewById(R.id.price_chip_group);
        sizeChipGroup = (ChipGroup) findViewById(R.id.size_chip_group);

        btnSearch = findViewById(R.id.button_search);

        ArrayList<String> purpose = new ArrayList<>();
        purpose.add("사무/인강용");
        purpose.add("휴대용");
        purpose.add("그래픽 작업용");
        purpose.add("개발용");

        for(int i = 0; i<purpose.size(); i++){
            Chip chip = new Chip(this);
            chip.setText(purpose.get(i));
            chip.setCheckable(true);             // 체크 표시 사용 여부
            chip.setCloseIconVisible(false);     // close icon 표시 여부
            purposeChipGroup.addView(chip);             // chip group 에 해당 chip 추가

            chip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(chip.isChecked()){
                        selectedPurpose = chip.getText().toString();
                    }
                    else{
                        selectedPurpose = null;
                    }
                }
            });
        }

        ArrayList<String> weight = new ArrayList<>();
        weight.add("1kg 미만");
        weight.add("1.0~1.6kg");
        weight.add("1.7~2.0kg");
        weight.add("2.0kg~2.5kg");
        weight.add("2.0kg~2.5kg");
        weight.add("2.6~3.0kg");
        weight.add("3kg 이상");

        for(int i = 0; i<weight.size(); i++){
            Chip chip = new Chip(this);
            chip.setText(weight.get(i));
            chip.setCheckable(true);
            chip.setCloseIconVisible(false);   
            weightChipGroup.addView(chip);     

            chip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(chip.isChecked()){
                        selectedWeight = chip.getText().toString();
                    }
                    else{
                        selectedWeight = null;
                    }
                }
            });
        }

        ArrayList<String> price = new ArrayList<>();
        price.add("100만 미만");
        price.add("100~150만");
        price.add("150~200만");
        price.add("200~250만");
        price.add("250만~300만");
        price.add("300만 초과");

        for(int i = 0; i<price.size(); i++){
            Chip chip = new Chip(this);
            chip.setText(price.get(i));
            chip.setCheckable(true);
            chip.setCloseIconVisible(false);
            priceChipGroup.addView(chip);

            chip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(chip.isChecked()){
                        selectedPrice = chip.getText().toString();
                    }
                    else{
                        selectedPrice = null;
                    }
                }
            });
        }

        ArrayList<String> size = new ArrayList<>();
        size.add("17인치");
        size.add("16인치");
        size.add("15인치");
        size.add("14인치");
        size.add("13인치");
        size.add("그 외");

        for(int i = 0; i<size.size(); i++){
            Chip chip = new Chip(this);
            chip.setText(size.get(i));
            chip.setCheckable(true);
            chip.setCloseIconVisible(false);
            sizeChipGroup.addView(chip);

            chip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(chip.isChecked()){
                        selectedSize = chip.getText().toString();
                    }
                    else{
                        selectedSize = null;
                    }
                }
            });
        }
        
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedPurpose == null || selectedWeight == null || selectedPrice == null || selectedSize == null) {
                    Toast.makeText(getApplicationContext(), "선택하지 않은 항목이 있습니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    System.out.println("purpose = " + selectedPurpose);
                    System.out.println("price = " + selectedWeight);
                    System.out.println("price = " + selectedPrice);
                    System.out.println("size = " + selectedSize);
                }
            }
        });
    }

}