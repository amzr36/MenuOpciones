 package com.alejo_zr.menuopciones;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvNombre = (TextView) findViewById(R.id.tvNombre);
        registerForContextMenu(tvNombre);//Se pone el view disponible para que levante el menu de contexto

    }

     @Override
     public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.menu_opciones, menu);
         return true;
     }

     @Override
     public boolean onOptionsItemSelected(MenuItem item) {//Controlar que va  suceder si se selcciona una opción

         switch(item.getItemId()){


             case R.id.mAbout:
                 Intent intenta = new Intent(this,ActivityAbout.class);
                 startActivity(intenta);
                 break;

             case R.id.mSettings:
                 Intent intents = new Intent(this,ActivitySettings.class);
                 startActivity(intents);
                 break;

         }


         return super.onOptionsItemSelected(item);
     }

     @Override
     public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
         super.onCreateContextMenu(menu, v, menuInfo);

         MenuInflater inflater = new MenuInflater(this);
         getMenuInflater().inflate(R.menu.menu_contexto, menu);
     }

     @Override
     public boolean onContextItemSelected(MenuItem item) {//Que item de contexto se ha selecionado

         switch (item.getItemId()){
             case R.id.mEdit:
                 Toast.makeText(this, getResources().getString(R.string.menu_edit), Toast.LENGTH_SHORT).show();
                 break;
             case R.id.mDelete:
                 Toast.makeText(this, getResources().getString(R.string.menu_delete), Toast.LENGTH_SHORT).show();// ( CONTEXTO, Texto a mostrar, Duración del msj)
                 break;
         }

         return super.onContextItemSelected(item);
     }

     public void levantarMenuPopUp(View v){

         final ImageView imagen = (ImageView) findViewById(R.id.imgImagen);
         PopupMenu popupMenu = new PopupMenu(this, v);
         popupMenu.getMenuInflater().inflate(R.menu.menu_popup,popupMenu.getMenu());

         popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
             @Override
             public boolean onMenuItemClick(MenuItem item) {

                 switch(item.getItemId()){

                     case R.id.mView:
                         Snackbar.make(imagen, getResources().getString(R.string.menu_view),Snackbar.LENGTH_SHORT).show();
                         break;
                     case R.id.mViewDetail:
                         Toast.makeText(getBaseContext(), getResources().getString(R.string.menu_view_detail),Toast.LENGTH_LONG).show();
                         break;


                 }

                 return true;
             }
         });

         popupMenu.show();

     }

 }
