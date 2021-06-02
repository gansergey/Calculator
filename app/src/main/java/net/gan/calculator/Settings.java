package net.gan.calculator;

public class Settings {

    private final String prefName;
    private final String KEY_THEME;
    private final String KEY_VALUE_DARK_THEME;
    private final String KEY_VALUE_LIGHT_THEME;

    public Settings() {
        this.prefName = "Setting.pref";
        this.KEY_THEME = "theme";
        this.KEY_VALUE_DARK_THEME = "dark";
        this.KEY_VALUE_LIGHT_THEME = "light";

    }

    public String getPrefName() {
        return prefName;
    }

    public String getKEY_THEME() {
        return KEY_THEME;
    }

    public String getKEY_VALUE_DARK_THEME() {
        return KEY_VALUE_DARK_THEME;
    }

    public String getKEY_VALUE_LIGHT_THEME() {
        return KEY_VALUE_LIGHT_THEME;
    }
}