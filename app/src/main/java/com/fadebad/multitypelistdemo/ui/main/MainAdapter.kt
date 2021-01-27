package com.fadebad.multitypelistdemo.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fadebad.multitypelistdemo.R
import com.fadebad.multitypelistdemo.logic.main.model.ShortCut

/**
 * Created by MichealYan on 2021/1/26.
 * Email: 956462326@qq.com
 * Describe:
 **/
class MainAdapter(private val mainViewModel: MainViewModel)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TITLE_VIEw = 0
        const val SWITCH_VIEw = 1
        const val INTENT_VIEw = 2
        const val DIVIDER_VIEw = 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            TITLE_VIEw -> {
                TitleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.main_title_recycle_item, parent, false))
            }
            SWITCH_VIEw -> {
                SwitchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.main_switch_recycle_item, parent, false))
            }
            INTENT_VIEw -> {
                IntentViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.main_intent_recycle_item, parent, false))
            }
            else -> {
                DividerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.main_divider_recycle_item, parent, false))
            }
        }


    override fun getItemCount() = mainViewModel.shortCuts.value!!.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = mainViewModel.shortCuts.value!![position]
        when (holder) {
            is TitleViewHolder -> {
                holder.titleText.text = data.label
            }
            is SwitchViewHolder -> {
                holder.shortCutLabel.text = data.label
            }
            is IntentViewHolder -> {
                holder.shortCutLabel.text = data.label
            }
            else -> {

            }
        }
    }

    override fun getItemViewType(position: Int) = mainViewModel.shortCuts.value!![position].type

    class SwitchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val shortCutIcon = itemView.findViewById<ImageView>(R.id.shortCutIcon)
        val shortCutLabel = itemView.findViewById<TextView>(R.id.shortCutLabel)
        val shortCutSwitch = itemView.findViewById<Switch>(R.id.shortCutSwitch)
    }

    class IntentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val shortCutIcon = itemView.findViewById<ImageView>(R.id.shortCutIcon)
        val shortCutLabel = itemView.findViewById<TextView>(R.id.shortCutLabel)

    }

    class TitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleText = itemView.findViewById<TextView>(R.id.titleText)

    }

    class DividerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}