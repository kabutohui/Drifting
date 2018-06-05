package cn.edu.xidian.fragmenttest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

import cn.edu.xidian.fragmenttest.FloatView.FloatBackground;
import cn.edu.xidian.fragmenttest.FloatView.FloatBitmap;

/**
 * Created by kabuto on 2018/06/03.
 */

public class fragment3 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment3, container, false);

        final int node_num = 2;
        final int picture[] = { R.drawable.star4_100,R.drawable.star5_100,R.drawable.star6_100,
                                R.drawable.star4_120,R.drawable.star5_100,R.drawable.star6_120,};

        //对控件进行操作
        final FloatBackground floatBackground = (FloatBackground) view.findViewById(R.id.float_view);
        final LinearLayout ll = view.findViewById(R.id.ll_third_tv) ;
        final TextView tv = view.findViewById(R.id.tv_third_nodenum);
        final Button start = (Button) view.findViewById(R.id.start);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start.setVisibility(View.GONE);
                ll.setVisibility(View.VISIBLE);
                tv.setText(node_num+"");
                floatBackground.startFloat();
            }
        });

          for(int i = 0;i < node_num;i++)
          {
              Random rand = new Random();
              int j = rand.nextInt(picture.length);
              floatBackground.addFloatView(new FloatBitmap( getActivity(), 0.2f, 0.3f, picture[j]));
          }

        return view;
    }

}
