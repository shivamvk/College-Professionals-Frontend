package com.example.shivamvk.collegeprofessionals;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

import java.net.URL;
import java.net.URLEncoder;

public class HomeActivity extends AppCompatActivity {

    private TextView mUserName;
    private TextView mUserEmail;
    private ImageView mUserImage;
    private Button mLogoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mUserName = findViewById(R.id.tv_user_name);
        mUserEmail = findViewById(R.id.tv_user_email);
        mUserImage = findViewById(R.id.profile_image);
        mLogoutButton = findViewById(R.id.bt_log_out);

        String username = getIntent().getStringExtra("username");
        String useremail = getIntent().getStringExtra("useremail");
        String photourl = getIntent().getStringExtra("photourl");

        Picasso.get()
                .load(photourl)
                .resize(50, 50)
                .placeholder(R.drawable.icon_profile_empty)
                .centerCrop()
                .into(mUserImage);

        mUserName.setText(username);
        mUserEmail.setText(useremail);

        mLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(HomeActivity.this, SplashScreen.class));
            }
        });

    }
}
