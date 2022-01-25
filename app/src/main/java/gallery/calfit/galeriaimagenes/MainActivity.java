package gallery.calfit.galeriaimagenes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.calfit.galeriaimagenes.R;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.Objects;

public class  MainActivity extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;
    private Button button_showG, button_showG2;
    private AdView mAdView;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_showG = (Button) findViewById(R.id.button_showG);
        button_showG2 = (Button) findViewById(R.id.button_showG2);


        MobileAds.initialize(this, initializationStatus -> createPersonalizedAd());

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        button_showG.setOnClickListener(v -> {
            if (mInterstitialAd != null) {
                mInterstitialAd.show(MainActivity.this);
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.");
                Intent intent = new Intent(MainActivity.this, Recyclerv1.class);
                startActivity(intent);
            }
        });
        button_showG2.setOnClickListener(v -> {
            if (mInterstitialAd != null) {
                mInterstitialAd.show(MainActivity.this);
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.");
                Intent intent = new Intent(MainActivity.this, Recyclerv1.class);
                startActivity(intent);
            }
        });
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

    }        // Aca termina el código on create


    private void createPersonalizedAd () {
        AdRequest adRequest = new AdRequest.Builder().build();

        createInterstitialAd(adRequest);
        createInterstitialAd2(adRequest);

    }
    private void createInterstitialAd (AdRequest adRequest) {
        InterstitialAd.load(this,"", adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded (@NonNull InterstitialAd interstitialAd) {
                // The mInterstitialAd reference will be null until
                // an ad is loaded.
                mInterstitialAd = interstitialAd;
                Log.d("---AdMob", "onAdLoaded");

                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    @Override
                    public void onAdDismissedFullScreenContent () {
                        // Called when fullscreen content is dismissed.
                        Log.d("TAG", "The ad was dismissed.");

                        Intent intent = new Intent(MainActivity.this, Recyclerv1.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent (AdError adError) {
                        // Called when fullscreen content failed to show.
                        Log.d("TAG", "The ad failed to show.");
                    }

                    @Override
                    public void onAdShowedFullScreenContent () {
                        // Called when fullscreen content is shown.
                        // Make sure to set your reference to null so you don't
                        // show it a second time.
                        mInterstitialAd = null;
                        Log.d("TAG", "The ad was shown.");
                    }
                });

            }

            @Override
            public void onAdFailedToLoad (@NonNull LoadAdError loadAdError){
                // Handle the error
                Log.d("---AdMob", loadAdError.getMessage());
                mInterstitialAd = null;
            }
        });


    }
    private void createInterstitialAd2 (AdRequest adRequest) {
        InterstitialAd.load(this,"ca-app-pub-6166270378015046/9637500808", adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded (@NonNull InterstitialAd interstitialAd) {
                // The mInterstitialAd reference will be null until
                // an ad is loaded.
                mInterstitialAd = interstitialAd;
                Log.d("---AdMob", "onAdLoaded");

                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    @Override
                    public void onAdDismissedFullScreenContent () {
                        // Called when fullscreen content is dismissed.
                        Log.d("TAG", "The ad was dismissed.");

                        Intent intent2 = new Intent(MainActivity.this, Recyclerv1.class);
                        startActivity(intent2);
                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent (AdError adError) {
                        // Called when fullscreen content failed to show.
                        Log.d("TAG", "The ad failed to show.");
                    }

                    @Override
                    public void onAdShowedFullScreenContent () {
                        // Called when fullscreen content is shown.
                        // Make sure to set your reference to null so you don't
                        // show it a second time.
                        mInterstitialAd = null;
                        Log.d("TAG", "The ad was shown.");
                    }
                });

            }

            @Override
            public void onAdFailedToLoad (@NonNull LoadAdError loadAdError){
                // Handle the error
                Log.d("---AdMob", loadAdError.getMessage());
                mInterstitialAd = null;
            }
        });


    }
}
