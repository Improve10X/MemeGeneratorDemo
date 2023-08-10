package com.improve10x.memegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private Spinner templatesSp;
    private EditText topTextTxt;
    private EditText bottomTextTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setupSpinner();
        handleGenerateClick();
    }

    private void setupSpinner() {
        String [] templateNames = getResources().getStringArray(R.array.templates);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, templateNames);
        templatesSp.setAdapter(adapter);
    }

    private void initView() {
        templatesSp = findViewById(R.id.templatesp);
        topTextTxt = findViewById(R.id.topTextTxt);
        bottomTextTxt = findViewById(R.id.bottomTextTxt);
    }

    @SuppressLint("IntentWithNullActionLaunch")
    private void handleGenerateClick() {
        Button generateBtn = findViewById(R.id.generateBtn);
        generateBtn.setOnClickListener(v -> {
            String memeUrl = generateMemeUrl(getTemplateText(), getTopText(), getBottomText());
            Intent intent = new Intent(this, MemeActivity.class);
            intent.putExtra(MemeActivity.URL_EXTRA, memeUrl);
            startActivity(intent);
        });
    }

    private String getBottomText() {
        return bottomTextTxt.getText().toString();
    }

    private String getTopText() {
        return topTextTxt.getText().toString();
    }

    private String getTemplateText() {
        return templatesSp.getSelectedItem().toString();
    }

    private String generateMemeUrl(String template, String topText, String bottomText) {
        return "https://apimeme.com/meme?meme="+template+"&top="+topText+"&bottom=" + bottomText;
    }
}