package com.android.td2.td2_android;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_relative);

        Button btnSubmit = (Button) findViewById(R.id.button);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtLogin = (EditText) findViewById(R.id.editText);
                if (txtLogin.getText().toString().isEmpty()) {
                    txtLogin.setError("Erreur, champ vide!!");
                    return;
                }
                Intent intentPicker = new Intent(MainActivity.this, PickerActivity.class);
                startActivity(intentPicker);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        /*
        restoreActionBar();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
        */
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_settings:
//faites un toast !
                Intent intentGallery = new Intent(MainActivity.this, GalleryAndroidActivity.class);
                startActivity(intentGallery);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
