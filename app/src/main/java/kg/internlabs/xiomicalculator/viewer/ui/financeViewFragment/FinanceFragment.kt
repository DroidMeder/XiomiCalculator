package kg.internlabs.xiomicalculator.viewer.ui.financeViewFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kg.internlabs.xiomicalculator.controller.FinanceCalculatorsController
import kg.internlabs.xiomicalculator.databinding.FragmentFinanceBinding
import kg.internlabs.xiomicalculator.viewer.ui.extentions.showToast

class FinanceFragment : Fragment() {
    private lateinit var binding: FragmentFinanceBinding
    private var calculatorController: FinanceCalculatorsController
    init {
        calculatorController = FinanceCalculatorsController(viewer = this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFinanceBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initListeners()
    }

    private fun initListeners() = with(binding) {
        cvCurrencyConversion.setOnClickListener(calculatorController)
        cvInvestConversion.setOnClickListener(calculatorController)
        cvGstConversion.setOnClickListener(calculatorController)
        cvLoanConversion.setOnClickListener(calculatorController)
    }


    fun update(s : String) {
        requireContext().showToast(s)
    }

}