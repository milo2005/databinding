package kcumen.trazagro.peliculas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kcumen.trazagro.peliculas.adapters.MovieAdapter
import kcumen.trazagro.peliculas.model.Movie
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val adapter:MovieAdapter = MovieAdapter()
    val data:MutableList<Movie> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list.adapter = adapter
        adapter.onMovieSelcted = this::goToDetail
        adapter.onFavoriteSelcted = this::saveFavorite
        loadData()
    }


    fun loadData(){
        data.add(Movie("http://www.incorrectas.com/wp-content/uploads/2017/10/el-nuevo-trailer-de-star-wars-the-last-jedi-es-alucinante.jpg",
                "StarWars Episodio VIII", 170, Date(), ""))
        data.add(Movie("https://cdn.movieweb.com/img.news.tops/NEvQAF8mTk2Qzv_1_b/Justice-League-Movie-Runtime-Shortest-Dceu-Movie.jpg",
                "Justice League", 120, Date(), ""))
        data.add(Movie("https://i.ytimg.com/vi/zNCz4mQzfEI/maxresdefault.jpg",
                null, 110, Date(), ""))
        adapter.data = data
    }


    fun goToDetail(position:Int){
        Toast.makeText(this, "Pelicula : ${data[position].name}", Toast.LENGTH_SHORT)
                .show()
    }

    fun saveFavorite(position:Int){
        Toast.makeText(this, "Favorito : ${data[position].name}", Toast.LENGTH_SHORT)
                .show()
    }
}
