package com.example.novelreader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.UnsupportedEncodingException;

public class SearchActivity extends AppCompatActivity {
    private Button mBtnSearch;
    private EditText mEditKeyword;
    private SharedPreferences mSpf;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        textView=(TextView)this.findViewById(R.id.result) ;
        mEditKeyword=(EditText)this.findViewById(R.id.et);
        mBtnSearch=(Button) this.findViewById(R.id.search1);
        mSpf=super.getSharedPreferences("test",MODE_PRIVATE);
    }
    public static String getString(InputStream inputStream, String keyword) {
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "gbk");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(inputStreamReader);
        StringBuffer sb = new StringBuffer("");
        String line;
        Integer TIMES=0;
        try {
            while ((line = reader.readLine()) != null) {
                Integer index=0;
                Integer next=0;
                Integer times=0;
                while ((index=line.indexOf(keyword,next))!=-1){
                    next=index+keyword.length();
                    times++;
                }
                TIMES=TIMES+times;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return TIMES.toString();
    }
    public void readInfo(View view){
        SharedPreferences.Editor editor=mSpf.edit();
        editor.putString("name",mEditKeyword.getText().toString());
        editor.commit();

        String info=mSpf.getString("name","");
        InputStream inputStream=getResources().openRawResource(R.raw.pap);
        textView.setText("The word ["+info+"] has been used "+getString(inputStream,info)+" times in the whole book.");
    }
}
