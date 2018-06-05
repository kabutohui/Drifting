package cn.edu.xidian.fragmenttest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by kabuto on 2018/06/03.
 */

public class fragment2 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment2, container, false);

        final Button btn_confirm = view.findViewById(R.id.btn_second_confirm);
        final Button btn_get = view.findViewById(R.id.btn_second_get);
        final String[] pos = {""};
        final LinearLayout ll = view.findViewById(R.id.ll_second_throw);
        final TextView tv = view.findViewById(R.id.tv_second_letter);
        final String message[] = {"你好，今天天气真好！","我说今晚月光那么美，你说是的","埋骨何须桑梓地，人生何处不青山","好累啊","How are you"};
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        Spinner sp = (Spinner) view.findViewById(R.id.spinner);
        //final TextView tv_spinner = view.findViewById(R.id.tv_spinnner);

        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<String> adapter = (ArrayAdapter<String>) parent.getAdapter();
             // tv_spinner.setText(adapter.getItem(position));
                pos[0] = adapter.getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"已经成功抛出"+ pos[0]+"个漂流瓶",Toast.LENGTH_LONG).show();
                ll.setVisibility(View.GONE);
                btn_get.setVisibility(View.VISIBLE);
            }
        });

        btn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int j = rand.nextInt(message.length);
                tv.setVisibility(View.VISIBLE);
                tv.setText(message[j]);
            }
        });
        return view;
    }

}
