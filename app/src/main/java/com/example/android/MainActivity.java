package com.example.android;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ChipGroup purposeChipGroup;
    private ChipGroup weightChipGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        purposeChipGroup = (ChipGroup) findViewById(R.id.purpose_chip_group);
        weightChipGroup = (ChipGroup) findViewById(R.id.weight_chip_group);

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
                    System.out.println("purpose = " + chip.getText().toString());
//                    Toast.makeText(getApplicationContext(), "Check", Toast.LENGTH_SHORT).show();
                }
            });
        }

        ArrayList<String> price = new ArrayList<>();
        price.add("1kg 미만");
        price.add("1.0~1.6kg");
        price.add("1.7~2.0kg");
        price.add("2.0kg~2.5kg");
        price.add("2.0kg~2.5kg");
        price.add("2.6~3.0kg");
        price.add("3kg 이상");

        for(int i = 0; i<purpose.size(); i++){
            Chip chip = new Chip(this);
            chip.setText(price.get(i));
            chip.setCheckable(true);             // 체크 표시 사용 여부
            chip.setCloseIconVisible(false);     // close icon 표시 여부
            weightChipGroup.addView(chip);             // chip group 에 해당 chip 추가

            chip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println("purpose = " + chip.getText().toString());
//                    Toast.makeText(getApplicationContext(), "Check", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}