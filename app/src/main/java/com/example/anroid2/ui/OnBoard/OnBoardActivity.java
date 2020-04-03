package com.example.anroid2.ui.OnBoard;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.anroid2.MainActivity;
import com.example.anroid2.Prefs;
import com.example.anroid2.R;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

public class OnBoardActivity extends AppCompatActivity {
    ViewPagerAdapter adapter;
    ViewPager viewPager;
    WormDotsIndicator wormDotsIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);
        viewPager=findViewById(R.id.view_pager_onBoard);
        wormDotsIndicator =  findViewById(R.id.worm_dots_indicator);
        adapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        wormDotsIndicator.setViewPager(viewPager);
    }

    public void onSkip(View view) {
        Prefs.getInstance(getApplicationContext()).saveShown();
        startActivity(new Intent(OnBoardActivity.this, MainActivity.class));
        finish();
    }


}
