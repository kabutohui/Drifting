package cn.edu.xidian.fragmenttest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cn.edu.xidian.fragmenttest.NetworkUtil.HttpUtils;

/**
 * Created by kabuto on 2018/06/03.
 */

public class fragment4 extends Fragment {

    private String[] data;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment4, container, false);

        //对控件进行操作
        final Button btn_four_read = view.findViewById(R.id.btn_four_read);
        final ListView lv = view.findViewById(R.id.list_four);
        final TextView tv = view.findViewById(R.id.tv_four);
        final String url = "http://192.168.43.15:8123/chain";

        btn_four_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JSONObject params = new JSONObject();
                try {
                    params.put("chain", "all");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //服务器请求路径
                String strResult= HttpUtils.submitPostData(url,params, "utf-8");

                if (strResult == "-1"){
                    Toast.makeText(getActivity(),"获取回忆失败，但是别担心，它一定还在!",Toast.LENGTH_LONG).show();
                }else {

                    try {
                        JSONObject jsonObjSplit = new JSONObject(strResult );
                        int len  = (int) jsonObjSplit.get("length");
                        tv.setText(len-1 +"");
                        JSONArray ja = jsonObjSplit.getJSONArray("chain");
                        data = new String[len-1];

                        for (int i = 1; i < ja.length(); i++) {
                            JSONObject jo = (JSONObject) ja.get(i);
                            System.out.print(jo.get("message")+"    ");
                            data[i-1] = jo.get("message")+"";
                        }

                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                                getContext(), android.R.layout.simple_list_item_1, data);
                        lv.setVisibility(View.VISIBLE);
                        lv.setAdapter(adapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }
        });
        return view;
    }

}
