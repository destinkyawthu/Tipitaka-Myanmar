package mm.pndaza.tipitakamyanmar.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePref {

    private static final String PREF_FILENAME = "setting";
    private static final String PREF_FIRST_TIME = "FirstTime";
    private static final String PREF_DB_COPY = "DBCopy";
    private static final String PREF_DB_VERSION = "DBVersion";
    private static final String PREF_FONT_SIZE = "FontSize";
    private static final String PREF_NIGHT_MODE = "NightMode";

    private Context context;
    private static SharePref prefInstance;
    protected SharedPreferences sharedPreferences;
    protected SharedPreferences.Editor editor;

    public SharePref(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_FILENAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static synchronized SharePref getInstance(Context Context) {
        if (prefInstance == null) {
            prefInstance = new SharePref(Context);
        }
        return prefInstance;
    }

    public boolean isFirstTime() {
        return sharedPreferences.getBoolean(PREF_FIRST_TIME, true);
    }

    public void noLongerFirstTime() {

        editor.putBoolean(PREF_FIRST_TIME, false);
    }

    public void setPrefFontSize(String fontSize){
        editor.putString(PREF_FONT_SIZE, fontSize);
        editor.apply();
    }

    public String getPrefFontSize(){
        String fontsize = sharedPreferences.getString(PREF_FONT_SIZE, "normal");
        return fontsize;
    }

    public void setPrefNightModeState(boolean state){
        editor.putBoolean(PREF_NIGHT_MODE, state);
        editor.apply();
    }

    public boolean getPrefNightModeState(){
        Boolean state = sharedPreferences.getBoolean(PREF_NIGHT_MODE, false);
        return state;
    }

    public void setDbCopyState(boolean state){
        editor.putBoolean(PREF_DB_COPY, state);
        editor.apply();
    }

    public boolean isDatabaseCopyed(){
        return sharedPreferences.getBoolean(PREF_DB_COPY, true);
    }
    public int getDatabaseVersion(){
        return sharedPreferences.getInt(PREF_DB_VERSION,1);
    }

    public void setDatabaseVersion(int version){
        editor.putInt(PREF_DB_VERSION, version);
    }

    public void saveDefault(){
        editor.putBoolean(PREF_DB_COPY, false);
        editor.putString(PREF_FONT_SIZE, "normal");
        editor.putBoolean(PREF_NIGHT_MODE, false);
        editor.apply();
    }

}
