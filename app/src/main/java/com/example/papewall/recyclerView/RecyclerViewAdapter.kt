package com.example.papewall.recyclerView


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.example.papewall.R
import com.example.papewall.databinding.ItemRecyclerViewBinding
import com.example.papewall.model.domain.Data
import com.example.papewall.utils.BlurHashDecoder


class RecyclerViewAdapter(private val listener: WallInteractionListener) :
    PagingDataAdapter<Data, RecyclerViewAdapter.MyViewHolder>(DiffUtilCallBack()) {

    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {

        holder.bind(getItem(position)!!)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.MyViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
        return MyViewHolder(inflater)
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemRecyclerViewBinding.bind(view)


        fun bind(data: Data) {
            val blurHashAsDrawable = BlurHashDecoder.blurHashBitmap(itemView.resources, data)

            Glide.with(itemView.context)
                .asBitmap()
                .load(data.smallImageUrl)
                .placeholder(blurHashAsDrawable)
                .centerCrop()
                .transition(BitmapTransitionOptions.withCrossFade(80))
                .error(blurHashAsDrawable)
                .into(binding.imageView)


            itemView.setOnClickListener {
                listener.onClickItem(data, it)
            }
        }

    }


    class DiffUtilCallBack : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.blurHash == newItem.blurHash

        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem

        }
    }
}


