package hyperion.callcenter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private ActionBar actionBar;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.fragmentManager = getSupportFragmentManager();
        this.actionBar = getSupportActionBar();

        changeFragment(new CenterListFragment());
    }

    @Override
    public void onBackPressed() {
        if (fragmentManager.getBackStackEntryCount() == 1)
            finish();
        else
            super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void changeFragment(Fragment fragment) {
        fragmentManager.beginTransaction().replace(R.id.container, fragment).addToBackStack(null).commit();
    }

    public void setToolbar(String title, boolean backButton) {
        actionBar.setTitle(title);
        actionBar.setDisplayHomeAsUpEnabled(backButton);
    }
}