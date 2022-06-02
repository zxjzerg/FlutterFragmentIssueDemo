package com.example.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.demo.databinding.ActivityMainBinding
import io.flutter.embedding.android.FlutterFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHideFlutterFragment.setOnClickListener {
            val fragmentTransaction = supportFragmentManager.beginTransaction()

            // hide flutter fragment if exist
            val flutterFragment = supportFragmentManager.findFragmentByTag(FLUTTER_FRAGMENT_TAG)
            if (flutterFragment != null && !flutterFragment.isHidden) fragmentTransaction.hide(flutterFragment)

            fragmentTransaction.commit()
        }

        // show the flutter fragment
        supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, FlutterFragment.createDefault(), FLUTTER_FRAGMENT_TAG)
                .commit()
    }

    companion object {
        const val FLUTTER_FRAGMENT_TAG = "flutter_fragment"
    }
}