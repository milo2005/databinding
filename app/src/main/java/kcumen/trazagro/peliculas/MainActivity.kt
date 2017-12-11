package kcumen.trazagro.peliculas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kcumen.trazagro.peliculas.adapters.MovieAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list.adapter = MovieAdapter()
    }
}
