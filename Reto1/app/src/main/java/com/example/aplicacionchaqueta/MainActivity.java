package com.example.aplicacionchaqueta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * Declaracion de variables.
     */
    private MenuItem productos;
    private Button servicioss;
    private Button sucursaless;


    /**
     * inicialización de la pantalla Activity Main.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    /**
     * creación del menu desplegable en la barra superior.
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menuoptions,menu);
        return true;
    }

    /**
     * Acciones de los ítems del menú, que dirigen a sus respectivas pestañas.
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.menu1){
            Intent secondScreen = new Intent(getApplicationContext(),MainActivity2.class);
            startActivity(secondScreen);
            Toast.makeText(this,"Ingreso a Productos", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.menu2){
            Intent secondScreen = new Intent(getApplicationContext(),MainActivity3.class);
            startActivity(secondScreen);
            Toast.makeText(this,"Ingreso a Servicios ", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.menu3){
            Toast.makeText(this,"Ingreso a Sucursales ", Toast.LENGTH_SHORT).show();
            Intent secondScreen = new Intent(getApplicationContext(),MainActivity4.class);
            startActivity(secondScreen);
        }
        return super.onOptionsItemSelected(item);
    }

}
