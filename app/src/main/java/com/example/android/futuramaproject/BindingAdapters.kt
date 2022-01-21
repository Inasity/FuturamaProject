package com.example.android.futuramaproject

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.android.futuramaproject.network.data.CharQuote
import com.example.android.futuramaproject.network.data.FuturamaCharacter
import com.example.android.futuramaproject.ui.futuramacharacters.CharactersAdapter
import com.example.android.futuramaproject.ui.futuramaquotes.QuoteAdapter

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    if(imgUrl != null) {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https")?.build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                .override(500, 500)
                .fitCenter()
                .placeholder(R.drawable.loading_animation))
            .into(imgView)
    }
    else {
        Glide.with(imgView.context)
            .load(R.drawable.error_image)
            .apply(
                RequestOptions()
                .override(500, 500)
                .fitCenter())
            .into(imgView)
    }

}

@BindingAdapter("listFuturamaQuotes")
fun bindRecyclerViewQuotes(recyclerView: RecyclerView, data: List<CharQuote>?) {
    val adapter = recyclerView.adapter as QuoteAdapter
    adapter.submitList(data)
}

@BindingAdapter("listFuturamaCharacters")
fun bindRecyclerViewCharacters(recyclerView: RecyclerView, data: List<FuturamaCharacter>?) {
    val adapter = recyclerView.adapter as CharactersAdapter
    adapter.submitList(data)
}

@BindingAdapter("characterProfession")
fun bindCharacterProfession(textView: TextView, profession: String?)
{
    profession?.let {
        val charProfession = "Profession: $profession"
        textView.text = charProfession
    }
}

@BindingAdapter("characterAge")
fun bindCharacterAge(textView: TextView, age: String?)
{
    age?.let {
        val charAge = "Age: $age"
        textView.text = charAge
    }
}


