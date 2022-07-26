package kg.internlabs.xiomicalculator.viewer.ui.lifeViewerFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kg.internlabs.xiomicalculator.controller.LifeCalculatorsController
import kg.internlabs.xiomicalculator.databinding.FragmentLifeBinding
import kg.internlabs.xiomicalculator.viewer.ui.extentions.showToast

class LifeFragment : Fragment() {

    private lateinit var binding: FragmentLifeBinding
    private var calculatorController: LifeCalculatorsController
    init {
        calculatorController = LifeCalculatorsController(viewer = this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLifeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initListeners()
    }

    private fun initListeners() = with(binding) {
        cvAge.setOnClickListener(calculatorController)
        cvBmi.setOnClickListener(calculatorController)
        cvAreaConversion.setOnClickListener(calculatorController)
        cvDataConverter.setOnClickListener(calculatorController)
        cvDiscount.setOnClickListener(calculatorController)
        cvDate.setOnClickListener(calculatorController)
        cvLengthConversion.setOnClickListener(calculatorController)
        cvWeightConversion.setOnClickListener(calculatorController)
        cvRadixConversion.setOnClickListener(calculatorController)
        cvVelocityConversion.setOnClickListener(calculatorController)
        cvTempConversion.setOnClickListener(calculatorController)
        cvTimeConversion.setOnClickListener(calculatorController)
        cvVolumeConversion.setOnClickListener(calculatorController)
    }

    fun update(s : String) {
        requireContext().showToast(s)
    }
}