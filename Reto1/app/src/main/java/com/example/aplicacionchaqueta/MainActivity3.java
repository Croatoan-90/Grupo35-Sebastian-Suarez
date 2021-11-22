package com.example.aplicacionchaqueta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {

    private ImageView buy;
    private ImageView clean;
    private ImageView change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        buy = (ImageView) findViewById(R.id.buy);
        clean = (ImageView) findViewById(R.id.clean);
        change = (ImageView) findViewById(R.id.change);

        buy.setOnClickListener(this);
        clean.setOnClickListener(this);
        change.setOnClickListener(this);

        };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menuoptions3,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.menu1){
            Toast.makeText(this,"Ingreso a Productos ", Toast.LENGTH_SHORT).show();
            Intent secondScreen = new Intent(getApplicationContext(),MainActivity2.class);
            startActivity(secondScreen);
        }
        if(id == R.id.menu3){
            Toast.makeText(this,"Ingreso a Sucursales ", Toast.LENGTH_SHORT).show();
            Intent secondScreen = new Intent(getApplicationContext(),MainActivity4.class);
            startActivity(secondScreen);
        }
        if(id== R.id.icon){
            Intent secondScreen = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(secondScreen);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){

            case R.id.buy:
                Toast.makeText(this, "entras a realizar una compra", Toast.LENGTH_SHORT).show();
                break;

            case R.id.clean:
                Toast.makeText(this, "entras a enviar la chaqueta a lavar", Toast.LENGTH_SHORT).show();
                break;

            case R.id.change:
                Toast.makeText(this, "entras a intercambiar la chaqueta", Toast.LENGTH_SHORT).show();
        }

    }
}