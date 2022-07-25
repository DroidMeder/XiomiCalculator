package kg.internlabs.xiomicalculator.viewer.ui.simpleCalculatorViewer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import kg.internlabs.xiomicalculator.R
import kg.internlabs.xiomicalculator.controller.SimpleCalculatorController
import kg.internlabs.xiomicalculator.databinding.FragmentCalculatorBinding


class SimpleCalculatorViewerFragment : Fragment() {
    private lateinit var binding: FragmentCalculatorBinding
    private var calculatorController: SimpleCalculatorController
    init {
        println("******* Cal view constructor started")
        calculatorController = SimpleCalculatorController(viewer = this)
        println("********* I am Cal viewer object")
        println("********* Cal view constructor finished")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCalculatorBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initListeners()
    }

    private fun initListeners() = with(binding) {
        //scroll.fullScroll(View.FOCUS_DOWN)

        root.findViewById<TextView>(R.id.btn_0_s).setOnClickListener(calculatorController)
        root.findViewById<TextView>(R.id.btn_1_s).setOnClickListener(calculatorController)
        root.findViewById<TextView>(R.id.btn_2_s).setOnClickListener(calculatorController)
        root.findViewById<TextView>(R.id.btn_3_s).setOnClickListener(calculatorController)
        root.findViewById<TextView>(R.id.btn_4_s).setOnClickListener(calculatorController)
        root.findViewById<TextView>(R.id.btn_5_s).setOnClickListener(calculatorController)
        root.findViewById<TextView>(R.id.btn_6_s).setOnClickListener(calculatorController)
        root.findViewById<TextView>(R.id.btn_7_s).setOnClickListener(calculatorController)
        root.findViewById<TextView>(R.id.btn_8_s).setOnClickListener(calculatorController)
        root.findViewById<TextView>(R.id.btn_9_s).setOnClickListener(calculatorController)
        root.findViewById<TextView>(R.id.btn_dot_s).setOnClickListener(calculatorController)

        root.findViewById<ImageView>(R.id.btn_c_s).setOnClickListener(calculatorController)
        root.findViewById<ImageView>(R.id.btn_del_s).setOnClickListener(calculatorController)
        root.findViewById<ImageView>(R.id.btn_percent_s).setOnClickListener(calculatorController)
        root.findViewById<ImageView>(R.id.btn_div_s).setOnClickListener(calculatorController)
        root.findViewById<ImageView>(R.id.btn_mul_s).setOnClickListener(calculatorController)
        root.findViewById<ImageView>(R.id.btn_minus_s).setOnClickListener(calculatorController)
        root.findViewById<ImageView>(R.id.btn_plus_s).setOnClickListener(calculatorController)
        root.findViewById<ImageView>(R.id.btn_equal_s).setOnClickListener(calculatorController)

        root.findViewById<ImageView>(R.id.btn_switch).setOnClickListener{
            //TODO
        }

    }

    fun updateResults(inputField: String, outputField: String) = with(binding){
        //scroll.fullScroll(View.FOCUS_DOWN)
        textViewInput.text = inputField
        textViewInput.textSize = 34.5f

        textViewResult.text = outputField
        textViewResult.textSize = 24.5f
        scroll.fullScroll(View.FOCUS_DOWN)
    }

    fun historyOfCalculations(){

    }

    fun thatIsIt(totalTemp: String, result: String) = with(binding) {
        textViewInput.text = totalTemp
        textViewInput.textSize = 24.5f

        textViewResult.text = result
        textViewResult.textSize = 34.5f
        scroll.fullScroll(View.FOCUS_DOWN)
    }
}