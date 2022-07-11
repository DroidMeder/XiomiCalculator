package kg.internlabs.xiomicalculator

import android.os.Bundle
import android.view.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kg.internlabs.xiomicalculator.databinding.FragmentRootBinding


class RootFragment : Fragment() {
    private lateinit var binding : FragmentRootBinding
    private lateinit var pagerAdapter: ScreenSlidePagerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentRootBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pagerAdapter = ScreenSlidePagerAdapter(this)
        binding.pager.adapter = pagerAdapter

      /*  binding.tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when(tab.position){
                    0 -> tab.setIcon(R.drawable.tab_ic_calculator_selected)
                    1 -> tab.setIcon(R.drawable.tab_ic_life_selected)
                    2 -> tab.setIcon(R.drawable.tab_ic_finance_selected)
                }
                // change icon here
            }

            override fun onTabReselected(tab: TabLayout.Tab) {}
            override fun onTabUnselected(tab: TabLayout.Tab) {
                when(tab.position){
                    0 -> tab.setIcon(R.drawable.tab_ic_calculator)
                    1 -> tab.setIcon(R.drawable.tab_ic_life)
                    2 -> tab.setIcon(R.drawable.tab_ic_finance)
                }
            }
        })*/
        mediator()
        //pager()
    }

    private fun mediator() {
        TabLayoutMediator(binding.tabLayout,
            binding.pager
        ) { tab: TabLayout.Tab, position: Int ->
            when(position){
                0 -> {
                    if (tab.isSelected) {
                        tab.text = "One"
                        tab.setIcon(R.drawable.tab_ic_calculator_selected)
                    } else {
                        tab.setIcon(R.drawable.tab_ic_calculator)
                    }
                }
                1 -> {
                    if (tab.isSelected) {
                        tab.setIcon(R.drawable.tab_ic_life_selected)
                    } else {
                        tab.setIcon(R.drawable.tab_ic_life)
                    }
                }
                2 -> {
                    if (tab.isSelected) {
                        tab.setIcon(R.drawable.tab_ic_finance_selected)
                    } else {
                        tab.setIcon(R.drawable.tab_ic_finance)
                    }
                }
            }
        }.attach()
        pager()
    }

    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_history -> true
            R.id.item_info -> true
            else -> super.onOptionsItemSelected(item)
        }
    }*/

    private fun pager() {
        binding.pager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.ivWidget.isVisible = position == 0
            }
        })
    }
}