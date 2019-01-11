package com.inbum.busexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.squareup.otto.Subscribe;

public class MainActivity extends AppCompatActivity {

    TextView tvEventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvEventList = (TextView) findViewById(R.id.tv_event_result);

        BusProvider.getInstance().register(this);
    }

    @Override
    protected void onDestroy() {

        BusProvider.getInstance().unregister(this);
        super.onDestroy();
    }

    @Subscribe
    public void FinishLoad(SampleEvent mSampleEvent){
        // 이벤트 발생한 뒤 수행할 작업
        String resultString = "";

        for(Sample sample : mSampleEvent.getList()){
            resultString += sample.getSampleString();
        }

        tvEventList.setText(resultString);
    }

    public void btnClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
