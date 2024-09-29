package com.example.parcial_1_am_acn4av_toro;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.parcial_1_am_acn4av_toro.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private TextView edit_valor_alquiler;
    private TextView edit_valor_expensas;
    private TextView edit_valor_servicios;
    private TextView edit_valor_Supermercado;
    private TextView edit_valor_hogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_push_pin, R.id.navigation_buscar, R.id.navigation_perfil)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);


        // Funcionalidad para sumar cada categoría.
        edit_valor_alquiler = findViewById(R.id.edit_valor_alquiler);
        edit_valor_expensas = findViewById(R.id.edit_valor_expensas);
        edit_valor_servicios = findViewById(R.id.edit_valor_servicios);
        edit_valor_Supermercado = findViewById(R.id.edit_valor_Supermercado);
        edit_valor_hogar = findViewById(R.id.edit_valor_hogar);

        // Inicializar el total.
        TextView tv_total;
        tv_total = findViewById(R.id.tv_total);

        Button button_Agregar = findViewById(R.id.button_Agregar);
        Button button_cancelar = findViewById(R.id.button_cancelar);
        LinearLayout category_layout = findViewById(R.id.category_layout);

        // Evento del botón 'Agregar'.
        button_Agregar.setOnClickListener(v -> {
            double total = sumarGastos();
            tv_total.setText("Total: $" + total);
        });

        // Evento del botón 'Cancelar'
        button_cancelar.setOnClickListener(v -> {
            TextView[] editTexts = {
                    edit_valor_alquiler,
                    edit_valor_expensas,
                    edit_valor_servicios,
                    edit_valor_Supermercado,
                    edit_valor_hogar
            };
            for (TextView editText : editTexts) {
                editText.setText("");
            }
            tv_total.setText("Total: $0.0");

        });
    }

    // Se suman los gastos para obtener el valor.
    private double sumarGastos() {
        double alquiler = getValor((EditText) edit_valor_alquiler);
        double expensas = getValor((EditText) edit_valor_expensas);
        double servicios = getValor((EditText) edit_valor_servicios);
        double supermercado = getValor((EditText) edit_valor_Supermercado);
        double hogar = getValor((EditText) edit_valor_hogar);

        return alquiler + expensas + servicios + supermercado + hogar;
    }

    private double getValor(EditText editText) {
        String texto = editText.getText().toString();
        if (texto.isEmpty()) {
            return 0;
        }
        return Double.parseDouble(texto);
    }
}

