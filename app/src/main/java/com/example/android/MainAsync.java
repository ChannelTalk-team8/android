package com.example.android;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

//
public class MainAsync extends AsyncTask<Void, String, Bundle> {
    //
//
    private MyListener listener;

    ////    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
////    SimpleDateFormat sdf_out = new SimpleDateFormat("yyyy.MM.dd", Locale.KOREA);
////    SimpleDateFormat sdf_parse = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.KOREA);
////    String[] hangueldays = {"월","화","수","목","금","토","일"};
//
    public MainAsync() {
        super();
    }


    //
//
//
    public void setListener(MyListener listener) {
        this.listener = listener;
    }

    @Override
    protected Bundle doInBackground(Void... voids) {
//
////        String str_date = strings[0];
////        Date date = new Date();
////        try {
////            date = sdf.parse(str_date);
////        } catch (ParseException e) {
////            e.printStackTrace();
////        }
        Bundle bundle = new Bundle();
//        listener.onSuccess(arrayList);
        return bundle;
    }

    //
//    private ArrayList<GoutData> Procescore(Date proc_date) {
//        JsonArray jsonArray = networkhandling("https://dcstest.insurz.co.kr/getGoingOut", sdf.format(proc_date));
//        ArrayList<GoutData> arrayList = new ArrayList<>();
//        SimpleDateFormat sdf_time = new SimpleDateFormat("HH:mm",Locale.KOREA);
//        for(JsonElement jele : jsonArray){
//            JsonObject jobj = jele.getAsJsonObject();
//            String raw_date = jobj.get("created_at").getAsString();
//            Date date = new Date();
//            try {
//                date = sdf_parse.parse(raw_date);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            Calendar cal = Calendar.getInstance();
//            cal.setTime(date);
//            String str_front = sdf_out.format(date)+"."+hangueldays[(int)cal.get(Calendar.DAY_OF_WEEK)];
//            String str_back = sdf_time.format(date);
//            GoutData goutData = new GoutData(str_front,str_back);
//            arrayList.add(goutData);
//        }
//        return arrayList;
//    }
//
//    @Override
//    protected void onPostExecute(ArrayList<GoutData> arrayList) {
//        super.onPostExecute(arrayList);
//        listener.onSuccess(arrayList);
//    }
//
    protected JsonArray networkhandling(String str_url, String str_date) {
        HashMap<String, String> amap = new HashMap<>();
//        amap.put("date",str_date);
        amap.put("user_id", "1234");

        Gson gson = new Gson();
        String jsonstr = gson.toJson(amap);
//        Log.d("123", "networkhandling: jsonstr - "+jsonstr);
        String buf = "";
        JsonArray jsonArray = null;
        try {
            String str_return = "";
            URL url = new URL(str_url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            connection.connect();
            OutputStream os = connection.getOutputStream();
            byte[] request_data = jsonstr.getBytes(StandardCharsets.UTF_8);
            os.write(request_data);
            os.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(), "UTF-8"));
            while ((buf = br.readLine()) != null) {
                str_return += buf;
            }
            Log.d("123", "networkhandling: " + str_return);
            jsonArray = new JsonParser().parse(str_return).getAsJsonArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }
}
//
//    interface MyListener{
//        void onSuccess(ArrayList<GoutData> arrayList);
//    }
//
//}
//
//
//
