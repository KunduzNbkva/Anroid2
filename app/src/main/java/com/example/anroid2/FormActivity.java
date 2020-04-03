package com.example.anroid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {
    EditText editTitle,editDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        editTitle=findViewById(R.id.edit_title);
        editDesc=findViewById(R.id.edit_desc);

    }

    public void onClick(View view) {
        String title=editTitle.getText().toString().trim();
        if(title==null){
            Toast.makeText(this, "Please fill the fields", Toast.LENGTH_SHORT).show();
        }
        String desc=editDesc.getText().toString().trim();
        Intent intent=new Intent();
        intent.putExtra("title",title);
        intent.putExtra("desc",desc);
        setResult(RESULT_OK,intent);
        finish();
    }
}
