package net.gan.calculator;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

public class SettingsActivity extends AppCompatActivity {

    Settings settings;
    SwitchCompat switchTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        settings = new Settings();
        switchTheme = findViewById(R.id.switch_theme);

        setSwitchState();

        switchTheme.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                saveThemeMode(settings.getKEY_VALUE_DARK_THEME());
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                saveThemeMode(settings.getKEY_VALUE_LIGHT_THEME());
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });
    }

    private void saveThemeMode(String theme) {
        getSharedPreferences(settings.getPrefName(), MODE_PRIVATE)
                .edit().putString(settings.getKEY_THEME(), theme).apply();
    }

    private void setSwitchState() {
        switch (getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) {
            case Configuration.UI_MODE_NIGHT_YES:
                switchTheme.setText(R.string.switch_dark_mode);
                switchTheme.setChecked(true);
                break;
            case Configuration.UI_MODE_NIGHT_NO:
                switchTheme.setText(R.string.switch_light_mode);
                switchTheme.setChecked(false);
                break;
        }
    }

}













