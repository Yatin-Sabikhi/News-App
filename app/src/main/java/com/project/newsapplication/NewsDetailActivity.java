package com.project.newsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsDetailActivity extends AppCompatActivity {
    String title, desc, content, imageURL, url;
    private TextView TVNewsHeading, TVSubDesc, TVContent;
    private ImageView IVNews;
    private Button btnReadNews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        title=getIntent().getStringExtra("title");
        content=getIntent().getStringExtra("content");
        desc=getIntent().getStringExtra("desc");
        imageURL=getIntent().getStringExtra("image");
        url=getIntent().getStringExtra("url");
        TVNewsHeading=findViewById(R.id.TVNewsHeading);
        TVSubDesc=findViewById(R.id.TVSubDesc);
        TVContent=findViewById(R.id.TVContent);
        IVNews=findViewById(R.id.IVNews);
        btnReadNews=findViewById(R.id.btnReadNews);
        TVNewsHeading.setText(title);
        TVSubDesc.setText(desc);
        TVContent.setText(content);
        Picasso.get().load(imageURL).into(IVNews);
        btnReadNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}