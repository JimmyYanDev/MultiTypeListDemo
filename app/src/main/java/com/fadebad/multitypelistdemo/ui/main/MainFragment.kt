package com.fadebad.multitypelistdemo.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
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
    private lateinit var shortCuts: MutableList<ShortCut>

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
        mainAdapter = MainAdapter(shortCuts, viewModel)
        val layoutManager = GridLayoutManager(context, 4)
        mainRecyclerView.adapter = mainAdapter
        mainRecyclerView.layoutManager = layoutManager
    }

    private fun initData() {
        shortCuts.add(ShortCut(0, "Title1", "", 2, 0))
        shortCuts.add(ShortCut(0, "switch1", "", 2, 1))
        shortCuts.add(ShortCut(0, "switch2", "", 2, 1))
        shortCuts.add(ShortCut(0, "switch3", "", 2, 1))
        shortCuts.add(ShortCut(0, "switch4", "", 2, 1))
        shortCuts.add(ShortCut(0, "switch5", "", 2, 1))

        shortCuts.add(ShortCut(0, "divider", "", 2, 3))

        shortCuts.add(ShortCut(0, "Title2", "", 2, 0))
        shortCuts.add(ShortCut(0, "intent1", "", 2, 2))
        shortCuts.add(ShortCut(0, "intent2", "", 2, 2))
        shortCuts.add(ShortCut(0, "intent3", "", 2, 2))
        shortCuts.add(ShortCut(0, "intent4", "", 2, 2))
        shortCuts.add(ShortCut(0, "intent5", "", 2, 2))
    }

    override fun onResume() {
        super.onResume()

    }

}