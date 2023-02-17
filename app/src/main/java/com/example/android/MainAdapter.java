package com.example.android;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainAdapter extends BaseExpandableListAdapter {

    Context mcontext;
    LayoutInflater mlayoutinflater;
    ArrayList<Cateslot> cateslots = new ArrayList<>();
    ArrayList<ArrayList<Cateslot_child>> cateslot_children = new ArrayList<>();

    public MainAdapter(Context context){
        mcontext = context;
//        mlayoutinflater = LayoutInflater.from(mcontext);
        mlayoutinflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setCateslots(ArrayList<Cateslot> cateslots) {
        this.cateslots = cateslots;
    }

    public void setCateslot_children(ArrayList<ArrayList<Cateslot_child>> cateslot_children){
        this.cateslot_children = cateslot_children;
    }

    @Override
    public int getGroupCount() {
        return cateslots.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return cateslot_children.get(i).size();
    }

    @Override
    public Object getGroup(int i) {
        return cateslots.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return cateslot_children.get(i).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        View v = mlayoutinflater.inflate(R.layout.item_maincate,viewGroup,false);

        TextView txv_main1 = v.findViewById(R.id.maincate_main1);
//        TextView txv_sub1 = view.findViewById(R.id.maincate_sub1);
//        TextView txv_sub2 = view.findViewById(R.id.maincate_sub2);
//        TextView txv_sub3 = view.findViewById(R.id.maincate_sub3);
//        TextView txv_sub4 = view.findViewById(R.id.maincate_sub4);

        txv_main1.setText(cateslots.get(i).getBig());
//        txv_sub1.setText(cateslots.get(i).getSmall1());
//        txv_sub2.setText(cateslots.get(i).getSmall2());
//        txv_sub3.setText(cateslots.get(i).getSmall3());
//        txv_sub4.setText(cateslots.get(i).getSmall4());


//        txv_main1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(txv_sub1.getVisibility()==View.GONE){
//        txv_sub1.setVisibility(View.VISIBLE);
//        txv_sub2.setVisibility(View.VISIBLE);
//        txv_sub3.setVisibility(View.VISIBLE);
//        txv_sub4.setVisibility(View.VISIBLE);
//                    Log.d("testtest", "onClick: kk");
//                }
//                else{
//                    txv_sub1.setVisibility(View.GONE);
//                    txv_sub2.setVisibility(View.GONE);
//                    txv_sub3.setVisibility(View.GONE);
//                    txv_sub4.setVisibility(View.GONE);
//                }

//            }
//        });

//        view.setLayoutParams(new RelativeLayout.LayoutParams());
        return v;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        View v = mlayoutinflater.inflate(R.layout.item_maincate_child,null);

//        TextView txv_main1 = view.findViewById(R.id.maincate_main1);
        TextView txv_sub1 = v.findViewById(R.id.maincate_sub);
//        TextView txv_sub2 = view.findViewById(R.id.maincate_sub2);
//        TextView txv_sub3 = view.findViewById(R.id.maincate_sub3);
//        TextView txv_sub4 = view.findViewById(R.id.maincate_sub4);

//        txv_main1.setText(cateslots.get(i).getBig());
        txv_sub1.setText(cateslot_children.get(i).get(i1).getSmall1());
//        txv_sub2.setText(cateslots.get(i).getSmall2());
//        txv_sub3.setText(cateslots.get(i).getSmall3());
//        txv_sub4.setText(cateslots.get(i).getSmall4());


//        txv_main1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(txv_sub1.getVisibility()==View.GONE){
//        txv_sub1.setVisibility(View.VISIBLE);
//        txv_sub2.setVisibility(View.VISIBLE);
//        txv_sub3.setVisibility(View.VISIBLE);
//        txv_sub4.setVisibility(View.VISIBLE);
//                    Log.d("testtest", "onClick: kk");
//                }
//                else{
//                    txv_sub1.setVisibility(View.GONE);
//                    txv_sub2.setVisibility(View.GONE);
//                    txv_sub3.setVisibility(View.GONE);
//                    txv_sub4.setVisibility(View.GONE);
//                }

//            }
//        });

//        view.setLayoutParams(new RelativeLayout.LayoutParams());
        return v;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
