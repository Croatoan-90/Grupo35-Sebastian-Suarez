package com.example.aplicacionchaqueta.Controlador;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.aplicacionchaqueta.R;
import com.example.aplicacionchaqueta.Vista.FragmentMain;
import com.example.aplicacionchaqueta.Vista.Fragment_Favoritos;
import com.example.aplicacionchaqueta.Vista.Fragment_Productos;
import com.example.aplicacionchaqueta.Vista.Fragment_Servicios;
import com.example.aplicacionchaqueta.Vista.Fragment_ShoppingCar;
import com.example.aplicacionchaqueta.Vista.Fragment_Sucursales;

public class MainActivity extends AppCompatActivity {

    /**
     * Declaracion de variables.
     */
    private Fragment mainScreen;
    private Fragment prod;
    private Fragment serv;
    private Fragment suc;
    private Fragment fav;
    private Fragment shoppingCar;
    private FragmentTransaction change;

    /**
     * inicialización de la pantalla Activity Main.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainScreen = new FragmentMain();
        prod = new Fragment_Productos();
        serv = new Fragment_Servicios();
        suc = new Fragment_Sucursales();
        fav = new Fragment_Favoritos();
        shoppingCar = new Fragment_ShoppingCar();

        getSupportFragmentManager().beginTransaction().add(R.id.containerFragment,mainScreen).commit();

    }
    //--------------------------MENU OPCIONES-------------------------------

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
            change = getSupportFragmentManager().beginTransaction();
            change.replace(R.id.containerFragment,prod).commit();

        }
        if(id == R.id.menu2){
            change = getSupportFragmentManager().beginTransaction();
            change.replace(R.id.containerFragment,serv).commit();

        }
        if(id == R.id.menu3){
            change = getSupportFragmentManager().beginTransaction();
            change.replace(R.id.containerFragment,suc).commit();

        }
        if(id == R.id.iconB){
            change = getSupportFragmentManager().beginTransaction();
            change.replace(R.id.containerFragment,mainScreen).commit();

        }
        if(id == R.id.icon2_B){
            change = getSupportFragmentManager().beginTransaction();
            change.replace(R.id.containerFragment,fav).commit();

        }
        if(id == R.id.icon3_B){
            change = getSupportFragmentManager().beginTransaction();
            change.replace(R.id.containerFragment,shoppingCar).commit();

        }
        return super.onOptionsItemSelected(item);
    }
    //-------------------------------------------------------------------------------------

}
