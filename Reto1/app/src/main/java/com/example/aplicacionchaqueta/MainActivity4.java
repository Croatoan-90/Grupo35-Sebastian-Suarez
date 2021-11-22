package com.example.aplicacionchaqueta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity implements View.OnClickListener{

    private TextView tel1;
    private TextView tel2;
    private TextView tel3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        tel1 = (TextView) findViewById(R.id.tel1);
        tel2 = (TextView) findViewById(R.id.tel2);
        tel3 = (TextView) findViewById(R.id.tel3);

        tel1.setOnClickListener(this);
        tel2.setOnClickListener(this);
        tel3.setOnClickListener(this);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menuoptions2,menu);
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
        if(id == R.id.menu2){
            Toast.makeText(this,"Ingreso a Servicio ", Toast.LENGTH_SHORT).show();
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

            case R.id.tel1:
                Toast.makeText(this,"Llama a la sucursal 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tel2:
                Toast.makeText(this,"Llama a la sucursal 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tel3:
                Toast.makeText(this,"Llama a la sucursal 3", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}