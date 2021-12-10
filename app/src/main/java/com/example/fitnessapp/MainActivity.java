package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         button = (Button) findViewById(R.id.btnSteps);
         button.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View v){
                 openSteps();
             }
         });

         button = (Button) findViewById(R.id.btnWeight);
         button.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View v){
                 openWeight();
             }
         });

         button = (Button) findViewById(R.id.btnAPI);
         button.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View v){
                 openAPI();
             }
         });
    }

    public void openAPI() {
        Intent intent = new Intent(this, fitness_api.class);
        startActivity(intent);
    }

    public void openSteps(){
        Intent intent = new Intent(this, Homefrag.class);
        startActivity(intent);
    }

   public void openWeight(){
        Intent intent = new Intent(this, Log.class);
        startActivity(intent);
   }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.nav_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection

        switch (item.getItemId()) {
            case R.id.steps_nav:
                NavController navController = Navigation.findNavController(findViewById(R.id.fragment_profile));
                int currentFragmentId = navController.getCurrentDestination().getId();
                if (currentFragmentId != R.id.homfrag){
                    navController.navigate(R.id.homfrag);
                    return true;
                }
                return super.onOptionsItemSelected(item);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
