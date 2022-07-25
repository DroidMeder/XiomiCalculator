package kg.internlabs.xiomicalculator.viewer.ui.rootViewerFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import kg.internlabs.xiomicalculator.R
import kg.internlabs.xiomicalculator.databinding.FragmentRootBinding


class RootFragment : Fragment() {

    private lateinit var binding : FragmentRootBinding
    private lateinit var pagerAdapter: ScreenSlidePagerAdapter
    private var pagerPosition = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentRootBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pagerAdapter = ScreenSlidePagerAdapter(this)
        binding.pager.adapter = pagerAdapter

        pager()
        initListeners()
    }

    private fun initListeners() {

        binding.root.findViewById<ImageView>(R.id.ic_cal_more).setOnClickListener {
            if (pagerPosition == 0){
                binding.settingMenu.root.isVisible = !binding.settingMenu.root.isVisible

            } else {
                println("go to hell")
            }
        }

        binding.root.findViewById<RelativeLayout>(R.id.rl_tab_cal).setOnClickListener{
            binding.pager.currentItem = 0
        }
        binding.root.findViewById<RelativeLayout>(R.id.rl_tab_life).setOnClickListener{
            binding.pager.currentItem = 1
        }
        binding.root.findViewById<RelativeLayout>(R.id.rl_tab_finance).setOnClickListener{
            binding.pager.currentItem = 2
        }
    }

    private fun pager() {
        binding.pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when(position){
                    0 -> {
                        binding.root.findViewById<ImageView>(R.id.ic_float_btn).isVisible = true
                        binding.root.findViewById<ImageView>(R.id.iv_tab_cal).setImageResource(R.drawable.tab_ic_calculator_selected)
                        binding.root.findViewById<ImageView>(R.id.iv_tab_life).setImageResource(R.drawable.tab_ic_life)
                        binding.root.findViewById<ImageView>(R.id.iv_tab_finance).setImageResource(R.drawable.tab_ic_finance)
                        pagerPosition = 0
                    }
                    1 -> {
                        println("111111")
                        binding.root.findViewById<ImageView>(R.id.ic_float_btn).isVisible = false
                        binding.root.findViewById<ImageView>(R.id.iv_tab_cal).setImageResource(R.drawable.tab_ic_calculator)
                        binding.root.findViewById<ImageView>(R.id.iv_tab_life).setImageResource(R.drawable.tab_ic_life_selected)
                        binding.root.findViewById<ImageView>(R.id.iv_tab_finance).setImageResource(R.drawable.tab_ic_finance)
                        pagerPosition = 1
                    }
                    2 -> {
                        println("2222222")
                        binding.root.findViewById<ImageView>(R.id.ic_float_btn).isVisible = false
                        binding.root.findViewById<ImageView>(R.id.iv_tab_cal).setImageResource(R.drawable.tab_ic_calculator)
                        binding.root.findViewById<ImageView>(R.id.iv_tab_life).setImageResource(R.drawable.tab_ic_life)
                        binding.root.findViewById<ImageView>(R.id.iv_tab_finance).setImageResource(R.drawable.tab_ic_finance_selected)
                        pagerPosition = 2
                    }
                }
            }
        })
    }
}