package kcumen.trazagro.peliculas

import android.databinding.DataBindingUtil
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.graphics.Palette
import android.view.MenuItem
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kcumen.trazagro.peliculas.databinding.ActivityDetailBinding
import kcumen.trazagro.peliculas.model.Movie
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), Callback {

    lateinit var binding:ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        val movie: Movie = intent.extras.getParcelable("movie")
        binding.movie = movie

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        Picasso.with(this)
                .load(Uri.parse(movie.img))
                .into(img, this)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

    override fun onSuccess() {
        val drawable = img.drawable as BitmapDrawable
        val palette = Palette.from(drawable.bitmap).generate()

        val primaryColor = ContextCompat.getColor(this, R.color.colorPrimary)
        val vibrantColor = palette.getVibrantColor(primaryColor)

        collpasingToolbar.setContentScrimColor(vibrantColor)


    }

    override fun onError() {
    }
}
