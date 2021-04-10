package com.imah.laporan.anak.main.feature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.imah.laporan.anak.databinding.ActivityMainBinding
import com.imah.laporan.anak.main.feature.splash.SplashFragment
import com.imah.laporan.anak.main.util.extension.doTransaction

class MainActivity : AppCompatActivity(), MainAction {

    private lateinit var bindings: ActivityMainBinding

    private var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindings = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindings.root)
        presenter = MainPresenter()
        presenter?.attachView(this)
        // do
        presenter?.doSomething()
    }

    override fun doSomething() {
        doTransaction<SplashFragment>("splash_fragment") {
//            navigateWithOrBackstack()
        }
    }
}