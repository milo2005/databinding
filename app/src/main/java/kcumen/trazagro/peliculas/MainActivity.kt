package kcumen.trazagro.peliculas

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kcumen.trazagro.peliculas.adapters.MovieAdapter
import kcumen.trazagro.peliculas.model.Movie
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
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
                null, 110, Date(), "dsadasdsa"))
        adapter.data = data
    }


    fun goToDetail(position:Int){
        /*val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("movie", 2)
        startActivity(intent)*/
        startActivity<DetailActivity>("movie" to data[position])
    }

    fun saveFavorite(position:Int){
        toast("Favorite: ${data[position].name}")
    }
}
