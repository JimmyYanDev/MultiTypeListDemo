package com.fadebad.multitypelistdemo.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import androidx.recyclerview.widget.RecyclerView
import com.fadebad.multitypelistdemo.R
import com.fadebad.multitypelistdemo.logic.main.model.ShortCut
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var mainRecyclerView: RecyclerView
    private lateinit var mainAdapter: MainAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val root = inflater.inflate(R.layout.main_fragment, container, false)
        mainRecyclerView = root.findViewById(R.id.mainRecyclerView)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        initData()
        mainAdapter = MainAdapter(viewModel)
        val layoutManager = GridLayoutManager(context, 3)
        mainRecyclerView.adapter = mainAdapter
        mainRecyclerView.layoutManager = layoutManager
        layoutManager.spanSizeLookup = object : SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when(viewModel.shortCuts.value!![position].type) {
                    0 -> 3
                    1 -> 1
                    2 -> 1
                    else -> 3
                }
            }

        }
    }

    private fun initData() {
        viewModel.getShortCuts()
    }

    override fun onResume() {
        super.onResume()

    }

}