package com.kushalsharma.kryptostats.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kushalsharma.kryptostats.R
import com.kushalsharma.unsplashphotos.Modals.Coins
import com.kushalsharma.unsplashphotos.Modals.CoinsItem

class HomeAdapter(val context: HomeFragment, val coinItem: CoinsItem) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {

        val viewHolder = HomeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_coin, parent, false)
        )
        return viewHolder
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {

        holder.name.text = coinItem.name.toString()
        holder.rank.text = coinItem.rank.toString()
        holder.type.text = coinItem.type.toString()
        holder.symbol.text = coinItem.symbol.toString()

    }

    override fun getItemCount(): Int {

        val coin = Coins()
        return coin.size
    }

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.coin_name)
        val rank = itemView.findViewById<TextView>(R.id.coin_rank)
        val symbol = itemView.findViewById<TextView>(R.id.coin_symbol)
        val type = itemView.findViewById<TextView>(R.id.coin_type)

    }

}