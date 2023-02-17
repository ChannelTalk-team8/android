package com.example.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SuggestAdapter extends BaseAdapter {
    ArrayList<SuggestData> suggestDataArrayList;
    Context mcontext;
    LayoutInflater mlayoutinflater;

    public SuggestAdapter(Context context) {
        mcontext = context;
        mlayoutinflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setSuggestDataArrayList(ArrayList<SuggestData> suggestDataArrayList){
        this.suggestDataArrayList = suggestDataArrayList;
    }

    public ArrayList<SuggestData> getSuggestDataArrayList() {
        return suggestDataArrayList;
    }

    @Override
    public int getCount() {
        return suggestDataArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return suggestDataArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = mlayoutinflater.inflate(R.layout.item_suggest_result,null);

        TextView txv_name = v.findViewById(R.id.suggest_name);
        TextView txv_ratehuman = v.findViewById(R.id.suggest_ratehuman);
        TextView txv_propri = v.findViewById(R.id.suggest_propri);
        ImageView img_person = v.findViewById(R.id.personpic);
        if(i==0)
            img_person.setImageResource(R.drawable.monogram_a);
        if(i==1)
            img_person.setImageResource(R.drawable.monogram_b);
        if(i==2)
            img_person.setImageResource(R.drawable.monogram_c);
        txv_name.setText(suggestDataArrayList.get(i).getName());
        txv_ratehuman.setText("★"+suggestDataArrayList.get(i).getRate()+"("+suggestDataArrayList.get(i).getHuman()+")");
        txv_propri.setText(suggestDataArrayList.get(i).getProduct()+"\n"+suggestDataArrayList.get(i).getPrice());
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
}
