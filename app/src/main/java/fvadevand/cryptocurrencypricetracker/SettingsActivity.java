package fvadevand.cryptocurrencypricetracker;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Vladimir on 18.12.2017.
 */

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
    }

    public static class CryptocurrencyPreferenceFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener {

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_main);

            Preference rank = findPreference(getString(R.string.settings_min_rank_key));
            Preference numberOfRecords = findPreference(getString(R.string.settings_number_of_records_key));
            bindPreferenceSummaryToValue(rank);
            bindPreferenceSummaryToValue(numberOfRecords);
        }

        @Override
        public boolean onPreferenceChange(Preference preference, Object value) {
            String stringValue = value.toString();
            preference.setSummary(stringValue);
            return true;
        }

        private void bindPreferenceSummaryToValue(Preference preference) {
            preference.setOnPreferenceChangeListener(this);
            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(preference.getContext());
            String preferenceString = sharedPref.getString(preference.getKey(), "");
            onPreferenceChange(preference, preferenceString);
        }
    }
}

