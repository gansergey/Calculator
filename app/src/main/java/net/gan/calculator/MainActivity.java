package net.gan.calculator;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

public class MainActivity extends AppCompatActivity {

    TextView txtResult;
    SwitchCompat switchTheme;

    private final static String KEY_CALCULATION = "Calculation";
    private final static String DEFAULT_DISPLAY_NUMBER = "0";
    Calculation calculation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializing();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(KEY_CALCULATION, calculation);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calculation = savedInstanceState.getParcelable(KEY_CALCULATION);
        assert calculation != null;
        txtResult.setText(calculation.getInfo());
    }

    private void initializing() {

        txtResult = findViewById(R.id.txt_result);

        calculation = new Calculation();

        switchTheme = findViewById(R.id.switch_theme);

        switchTheme.setOnClickListener(v -> {
            changeTheme();
        });

        findViewById(R.id.btn_0).setOnClickListener(v -> {
            calculation.numberClick(getString(R.string.txt_0));
            txtResult.setText(calculation.getInfo());
        });

        findViewById(R.id.btn_1).setOnClickListener(v -> {
            calculation.numberClick(getString(R.string.txt_1));
            txtResult.setText(calculation.getInfo());
        });

        findViewById(R.id.btn_2).setOnClickListener(v -> {
            calculation.numberClick(getString(R.string.txt_2));
            txtResult.setText(calculation.getInfo());
        });

        findViewById(R.id.btn_3).setOnClickListener(v -> {
            calculation.numberClick(getString(R.string.txt_3));
            txtResult.setText(calculation.getInfo());
        });

        findViewById(R.id.btn_4).setOnClickListener(v -> {
            calculation.numberClick(getString(R.string.txt_4));
            txtResult.setText(calculation.getInfo());
        });

        findViewById(R.id.btn_5).setOnClickListener(v -> {
            calculation.numberClick(getString(R.string.txt_5));
            txtResult.setText(calculation.getInfo());
        });

        findViewById(R.id.btn_6).setOnClickListener(v -> {
            calculation.numberClick(getString(R.string.txt_6));
            txtResult.setText(calculation.getInfo());
        });

        findViewById(R.id.btn_7).setOnClickListener(v -> {
            calculation.numberClick(getString(R.string.txt_7));
            txtResult.setText(calculation.getInfo());
        });

        findViewById(R.id.btn_8).setOnClickListener(v -> {
            calculation.numberClick(getString(R.string.txt_8));
            txtResult.setText(calculation.getInfo());
        });

        findViewById(R.id.btn_9).setOnClickListener(v -> {
            calculation.numberClick(getString(R.string.txt_9));
            txtResult.setText(calculation.getInfo());
        });

        findViewById(R.id.btn_c).setOnClickListener(v -> {
            calculation.clear();
            txtResult.setText(DEFAULT_DISPLAY_NUMBER);
        });

        findViewById(R.id.btn_dot).setOnClickListener(v -> {
            calculation.numberClick(getString(R.string.btn_dot));
            txtResult.setText(calculation.getInfo());
        });

        findViewById(R.id.btn_multiply).setOnClickListener(v -> {
            calculation.operationClick(getString(R.string.btn_multiply));
            txtResult.setText(calculation.getInfo());
        });

        findViewById(R.id.btn_div).setOnClickListener(v -> {
            calculation.operationClick(getString(R.string.btn_div));
            txtResult.setText(calculation.getInfo());
        });

        findViewById(R.id.btn_minus).setOnClickListener(v -> {
            calculation.operationClick(getString(R.string.btn_minus));
            txtResult.setText(calculation.getInfo());
        });

        findViewById(R.id.btn_plus).setOnClickListener(v -> {
            calculation.operationClick(getString(R.string.btn_plus));
            txtResult.setText(calculation.getInfo());
        });

        findViewById(R.id.btn_result).setOnClickListener(v -> {
            calculation.calculateResult();
            txtResult.setText(calculation.getInfo());
            calculation.clear();
        });
    }

    private void changeTheme() {
        if (switchTheme.isChecked()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}














