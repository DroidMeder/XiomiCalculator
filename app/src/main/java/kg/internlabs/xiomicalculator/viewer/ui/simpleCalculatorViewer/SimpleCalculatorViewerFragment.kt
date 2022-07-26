package kg.internlabs.xiomicalculator.viewer.ui.simpleCalculatorViewer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kg.internlabs.xiomicalculator.R
import kg.internlabs.xiomicalculator.controller.SimpleCalculatorController
import kg.internlabs.xiomicalculator.databinding.FragmentCalculatorBinding
import kg.internlabs.xiomicalculator.model.data.models.History
import kg.internlabs.xiomicalculator.viewer.ui.extentions.showToast


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
        scroll.fullScroll(View.FOCUS_DOWN)

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
            requireContext().showToast("В процессе разработки...")
        }

        scroll.fullScroll(View.FOCUS_DOWN)


    }

    fun updateResults(inputField: String, outputField: String) = with(binding){
        //scroll.fullScroll(View.FOCUS_DOWN)
        textViewInput.text = inputField
        textViewInput.textSize = 34.5f

        textViewResult.text = outputField
        textViewResult.textSize = 24.5f
        scroll.fullScroll(View.FOCUS_DOWN)
    }

    private fun historyOfCalculations(history: List<History>) = with(binding)  {
        recyclerCalculatorResult.layoutManager = LinearLayoutManager(requireContext())
        recyclerCalculatorResult.adapter = HistoryAdapter(history)
    }

    fun thatIsIt(totalTemp: String, result: String, list: List<History>) = with(binding) {
        textViewInput.text = totalTemp
        textViewInput.textSize = 24.5f


        textViewResult.text = result
        textViewResult.textSize = 34.5f

        historyOfCalculations(list)
        scroll.fullScroll(View.FOCUS_DOWN)
        scroll.fullScroll(View.FOCUS_DOWN)
        scroll.fullScroll(View.FOCUS_DOWN)
        scroll.fullScroll(View.FOCUS_DOWN)
        scroll.fullScroll(View.FOCUS_DOWN)
    }
}