package kcumen.trazagro.peliculas.adapters


import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kcumen.trazagro.peliculas.R
import kcumen.trazagro.peliculas.model.Movie
import kcumen.trazagro.peliculas.util.inflate
import kotlinx.android.synthetic.main.template_movie.view.*
import java.text.SimpleDateFormat
import java.util.*

class MovieAdapter:RecyclerView.Adapter<MovieHolder>(){

    var data:List<Movie> = emptyList()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder =
            MovieHolder(parent.inflate(R.layout.template_movie))

    override fun getItemCount(): Int = data.size

}

class MovieHolder(view: View): RecyclerView.ViewHolder(view) {

    val dateFormat:SimpleDateFormat = SimpleDateFormat("yyyy/MM/dd",Locale.getDefault())
    val context: Context = view.context

    fun bind(movie: Movie){
        itemView.name.text = movie.name
        itemView.duration.text = context.getString(R.string.duration, movie.duration)
        itemView.release.text = dateFormat.format(movie.releaseDate)
        Picasso.with(context)
                .load(Uri.parse(movie.img))
                .into(itemView.img)

    }
}