package cn.edu.xidian.fragmenttest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import cn.edu.xidian.fragmenttest.NetworkUtil.HttpUtils;

/**
 * Created by kabuto on 2018/06/03.
 */

public class fragment1 extends Fragment {

    public static String url = "http://192.168.43.15:8123/mine";

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment1, container, false);

        //对控件进行操作
        final Button btn_send = view.findViewById(R.id.btn_send);
        final EditText et_message = view.findViewById(R.id.ed_record);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(et_message.getText().toString().isEmpty())
                {
                    Toast.makeText(getActivity(),"不能发送空的消息!",Toast.LENGTH_LONG).show();
                }else {
//                    new NetConnection(url, HttpMethod.POST, new NetConnection.SuccessCallback() {
//                        @Override
//                        public void onSuccess(String result) {
//                            Toast.makeText(getActivity(), "分享心情成功", Toast.LENGTH_LONG).show();
//                            et_message.setText("");
//                        }
//                    }, new NetConnection.FailCallback() {
//                        @Override
//                        public void onFail() {
//                            Toast.makeText(getActivity(), "分享心情失败", Toast.LENGTH_LONG).show();
//                        }
//                    },"message",et_message.getText().toString());

//                    Map<String, String> params = new HashMap<String,String>();
                    JSONObject params = new JSONObject();
                    try {
                        params.put("message", et_message.getText().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    //服务器请求路径
                    String strResult= HttpUtils.submitPostData(url,params, "utf-8");
                    System.out.println(strResult);
                    if(strResult != "-1"){
                        Toast.makeText(getActivity(), "分享心情成功", Toast.LENGTH_LONG).show();
                        et_message.setText("");
                    }else{
                        Toast.makeText(getActivity(), "分享心情失败", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        return view;
    }

}
