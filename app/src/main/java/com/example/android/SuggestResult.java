package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SuggestResult extends AppCompatActivity {
    SuggestAdapter suggestAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest_result);

        ListView suggest_lv = findViewById(R.id.suggest_result_lv);
        suggestAdapter = new SuggestAdapter(getApplicationContext());
        initsuggestData();
        suggest_lv.setAdapter(suggestAdapter);
        suggestAdapter.notifyDataSetChanged();

        suggest_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SuggestData suggestData = suggestAdapter.getSuggestDataArrayList().get(i);
                Intent intent = new Intent(SuggestResult.this,CardActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initsuggestData() {
        ArrayList<SuggestData> suggestDataArrayList = new ArrayList<>();
        SuggestData smp1 = new SuggestData();
        smp1.setName("추천인A");
        smp1.setPrice("1,434,370원");
        smp1.setProduct("APPLE 맥북에어");
        smp1.setRate("4.9");
        smp1.setHuman("388");
        SuggestData smp2 = new SuggestData();
        smp2.setName("추천인A");
        smp2.setPrice("1,773,960원");
        smp2.setProduct("LG 그램17");
        smp2.setRate("4.2");
        smp2.setHuman("129");
        SuggestData smp3 = new SuggestData();
        smp3.setName("추천인C");
        smp3.setPrice("1,638,760원");
        smp3.setProduct("삼성 갤럭시북 울트라");
        smp3.setRate("3.9");
        smp3.setHuman("61");
        suggestDataArrayList.add(smp1);
        suggestDataArrayList.add(smp2);
        suggestDataArrayList.add(smp3);
        suggestAdapter.setSuggestDataArrayList(suggestDataArrayList);
    }
}