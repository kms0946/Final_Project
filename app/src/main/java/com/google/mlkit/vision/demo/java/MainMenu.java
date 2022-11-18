package com.google.mlkit.vision.demo.java;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.mlkit.vision.demo.R;
import com.google.mlkit.vision.demo.kotlin.ChooserActivity;
import com.google.mlkit.vision.demo.kotlin.posedetector.PoseDetectorProcessor;

public class MainMenu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    String username;
    TextView user_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        CardView cameraview,cameraview2,prac_view;
        username = ((LoginActivity)LoginActivity.context_main).username;
        user_name = (TextView)findViewById(R.id.userId);
        user_name.setText(username);
        cameraview = (CardView) findViewById(R.id.cameraSwing);
        prac_view = (CardView) findViewById(R.id.pracNoteBtn);
        cameraview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, ChooserActivity.class);
                intent.putExtra("REQUEST_CAMERA",2);
                startActivity(intent);
                finish();
            }
        });
        cameraview2 = (CardView) findViewById(R.id.gallery);
        cameraview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, ChooserActivity.class);
                intent.putExtra("REQUEST_CAMERA",2);
                startActivity(intent);
                finish();
            }
        });
        prac_view = (CardView)findViewById(R.id.pracNoteBtn);
        prac_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, SecondActivity.class);
                startActivity(intent);
                finish();
            }
        });

        navigationView = findViewById(R.id.navView);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(MainMenu.this);

        findViewById(R.id.navBtn).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        //아이디 변경

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.Logout) {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            final CharSequence[] items = {"예", "취소",
            };
            builder1.setTitle("로그아웃 하시겠습니까?");
            builder1.setItems(items, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int item) {
                    if (items[item].equals("예")) {
                        Intent intent = new Intent(MainMenu.this, submain.class);
                        startActivity(intent);
                        finish();
                    } else if (items[item].equals("취소")) {
                        dialog.dismiss();
                    }
                }
            });
            AlertDialog alertDialog2 = builder1.create();
            builder1.show();
        }

        //Drawer를 닫기...
        drawerLayout.closeDrawer(navigationView);

        return true;
    }

    public void onBackPressed(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("로그아웃 하시겠습니까?");
        builder.setCancelable(false);//화면 밖 터치 방지
        builder.setPositiveButton("아니요",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which){ }
        });

        builder.setNegativeButton("예",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                exit();
            }
        });
        builder.show();
    }
    public void exit(){
        super.onBackPressed();
        Intent intent=new Intent(MainMenu.this, submain.class);
        startActivity(intent);
        finish();

    }

}