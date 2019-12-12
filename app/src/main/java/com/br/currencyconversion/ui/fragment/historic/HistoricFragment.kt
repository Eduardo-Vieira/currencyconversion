package com.br.currencyconversion.ui.fragment.historic

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.br.currencyconversion.R
import com.br.currencyconversion.ui.fragment.historic.adapter.ListHistoricAdapter
import kotlinx.android.synthetic.main.fragment_historic.*
import org.koin.android.viewmodel.ext.android.viewModel

class HistoricFragment : Fragment() {

    private val historicViewModel:HistoricViewModel by viewModel()

    private val adapter by lazy {
        ListHistoricAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        this.activity?.title = "Histórico"

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_historic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        confRecycleView()
        initObserver()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_historic, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    fun confRecycleView(){
        val itemDecoration = DividerItemDecoration(context, LinearLayout.VERTICAL)
        recycleViewHistoric.addItemDecoration(itemDecoration)
        recycleViewHistoric.adapter = adapter
    }

    private fun initObserver(){
        historicViewModel.getHistoricList()
        historicViewModel.historicList.observe(viewLifecycleOwner, Observer {
            adapter.update(it)
        })
    }

}
