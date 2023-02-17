package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MainAdapter mainAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int[] userchoice = {-1,-1};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ExpandableListView main_lv = findViewById(R.id.main_explv);
        mainAdapter = new MainAdapter(MainActivity.this);
        main_lv.setAdapter(mainAdapter);

        initMainData();
        main_lv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                return false;
            }
        });
        main_lv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                startNext(i1);
                return false;
            }
        });
    }

    private void initMainData() {
        ArrayList<Cateslot> cateslots = new ArrayList<>();
        ArrayList<ArrayList<Cateslot_child>> cateslot_children = new ArrayList<>();

        Cateslot aaa = new Cateslot();
        aaa.setBig("전자기기");

        ArrayList<Cateslot_child> cateslotChildArrayList1 =new ArrayList<>();
        cateslotChildArrayList1.add(new Cateslot_child("노트북"));
        cateslotChildArrayList1.add(new Cateslot_child("조립 PC"));
        cateslotChildArrayList1.add(new Cateslot_child("TV"));
        cateslotChildArrayList1.add(new Cateslot_child("가전"));
        cateslot_children.add(cateslotChildArrayList1);

        Cateslot bbb = new Cateslot();
        bbb.setBig("가구");

        ArrayList<Cateslot_child> cateslotChildArrayList2 =new ArrayList<>();
        cateslotChildArrayList2.add(new Cateslot_child("소파"));
        cateslotChildArrayList2.add(new Cateslot_child("세탁기"));
        cateslotChildArrayList2.add(new Cateslot_child("냉장고"));
        cateslotChildArrayList2.add(new Cateslot_child("TV"));
        cateslot_children.add(cateslotChildArrayList2);

        Cateslot ccc = new Cateslot();
        ccc.setBig("명품");

        ArrayList<Cateslot_child> cateslotChildArrayList3 =new ArrayList<>();
        cateslotChildArrayList3.add(new Cateslot_child("구찌"));
        cateslotChildArrayList3.add(new Cateslot_child("루이비통"));
        cateslotChildArrayList3.add(new Cateslot_child("입생로랑"));
        cateslotChildArrayList3.add(new Cateslot_child("샤넬"));
        cateslotChildArrayList3.add(new Cateslot_child("에르메스"));
        cateslot_children.add(cateslotChildArrayList3);

        cateslots.add(aaa);
        cateslots.add(bbb);
        cateslots.add(ccc);
        mainAdapter.setCateslot_children(cateslot_children);
        mainAdapter.setCateslots(cateslots);
        mainAdapter.notifyDataSetChanged();
    }


    void startNext(int i){
        Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
        intent.putExtra("id",i);
        Log.d("test", "startNext: "+i);
        startActivity(intent);
    }
}