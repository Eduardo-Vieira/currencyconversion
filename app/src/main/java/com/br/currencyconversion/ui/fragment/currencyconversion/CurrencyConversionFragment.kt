package com.br.currencyconversion.ui.fragment.currencyconversion


import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController

import com.br.currencyconversion.R
import com.br.currencyconversion.database.model.Historic
import kotlinx.android.synthetic.main.fragment_currency_conversion.*
import org.koin.android.viewmodel.ext.android.viewModel

class CurrencyConversionFragment : Fragment() {

    private val currencyConversionViewModel:CurrencyConversionViewModel by viewModel()

    private var baseConversion:Double = 0.0
    private var labelCurrent:String? = null
    private var labelConversion:String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true)
        this.activity?.title = "Conversão de Moeda"

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_currency_conversion, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()

        converterOnClick()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_currency_conversion, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mnu_historico -> navHistoric()
        }

        return false
    }

    private fun navHistoric(){
        this.findNavController().navigate(
            CurrencyConversionFragmentDirections
                .actionCurrencyConversionFragmentToHistoricFragment())
    }

    private fun configSpinner(ratesKeys: List<String>){
        val adapter = ArrayAdapter<String>(this.context!!,android.R.layout.simple_spinner_dropdown_item,ratesKeys)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp_current_currency.adapter = adapter
        sp_currency_converter.adapter = adapter
        spOnItemSelected()
    }

    private fun initObserver(){
        currencyConversionViewModel.getLatest()
        currencyConversionViewModel.ratesKey.observe(viewLifecycleOwner, Observer {
            configSpinner(it)
        })
        currencyConversionViewModel.erro.observe(viewLifecycleOwner, Observer {
            Toast.makeText(this.context!!,it,Toast.LENGTH_LONG).show()
        })
    }

    private fun spOnItemSelected(){
        sp_current_currency.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                labelCurrent = currencyConversionViewModel.getRatesKey(position)
            }

        }
        sp_currency_converter.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                labelConversion = currencyConversionViewModel.getRatesKey(position)
                baseConversion = currencyConversionViewModel.getRatesValue(position).toDouble()
            }

        }
    }

    private fun converterOnClick(){
        btn_converter.setOnClickListener {
            val currencyConverterValue:Double = input_currency_converter_value.text.toString().toDouble()
            val currentCurrencyValue:Double = input_current_currency_value.text.toString().toDouble()

            val calc = currencyConverterValue * baseConversion
            input_currency_converter_value.setText(calc.toString())

            currencyConversionViewModel.insertHistoricLocal(Historic(null,
                labelCurrent,
                currentCurrencyValue.toBigDecimal(),
                labelConversion,
                currencyConverterValue.toBigDecimal()
                ))
        }
    }

}
