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
        aaa.setBig("test1");

        ArrayList<Cateslot_child> cateslotChildArrayList1 =new ArrayList<>();
        cateslotChildArrayList1.add(new Cateslot_child("test2"));
        cateslotChildArrayList1.add(new Cateslot_child("test3"));
        cateslotChildArrayList1.add(new Cateslot_child("test4"));
        cateslotChildArrayList1.add(new Cateslot_child("test5"));
        cateslot_children.add(cateslotChildArrayList1);

        Cateslot bbb = new Cateslot();
        bbb.setBig("test5");

        ArrayList<Cateslot_child> cateslotChildArrayList2 =new ArrayList<>();
        cateslotChildArrayList2.add(new Cateslot_child("test4"));
        cateslotChildArrayList2.add(new Cateslot_child("test3"));
        cateslotChildArrayList2.add(new Cateslot_child("test2"));
        cateslotChildArrayList2.add(new Cateslot_child("test1"));
        cateslot_children.add(cateslotChildArrayList2);

        cateslots.add(aaa);
        cateslots.add(bbb);
        mainAdapter.setCateslot_children(cateslot_children);
        mainAdapter.setCateslots(cateslots);
        mainAdapter.notifyDataSetChanged();
    }


    void startNext(int i){
        Intent intent = new Intent(MainActivity.this,SuggestResult.class);
        intent.putExtra("id",i);
        Log.d("test", "startNext: "+i);
        startActivity(intent);
    }
}