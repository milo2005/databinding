package kcumen.trazagro.peliculas.adapters


import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kcumen.trazagro.peliculas.R
import kcumen.trazagro.peliculas.databinding.TemplateMovieBinding
import kcumen.trazagro.peliculas.model.Movie
import kcumen.trazagro.peliculas.util.inflate

class MovieAdapter:RecyclerView.Adapter<MovieHolder>(){

    var onMovieSelcted:((position:Int)->Unit)? = null
    var onFavoriteSelcted:((position:Int)->Unit)? = null

    var data:List<Movie> = emptyList()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(data[position], position, this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder =
            MovieHolder(parent.inflate(R.layout.template_movie))

    override fun getItemCount(): Int = data.size

    fun onClickFavorite(position: Int){
        onFavoriteSelcted?.invoke(position)
    }

    fun onClickMovie(position:Int){
        onMovieSelcted?.invoke(position)
    }

}

class MovieHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding:TemplateMovieBinding = DataBindingUtil.bind(view)

    fun bind(movie: Movie, position:Int, handler:MovieAdapter){
        binding.movie = movie
        binding.position = position
        binding.handler = handler
    }
}