package kg.internlabs.xiomicalculator.viewer.ui.rootViewerFragment

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import kg.internlabs.xiomicalculator.viewer.ui.financeViewFragment.FinanceFragment
import kg.internlabs.xiomicalculator.viewer.ui.lifeViewerFragment.LifeFragment
import kg.internlabs.xiomicalculator.viewer.ui.simpleCalculatorViewer.SimpleCalculatorViewerFragment

class ScreenSlidePagerAdapter(fa: Fragment) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 3



    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                SimpleCalculatorViewerFragment()
            }
            1 -> {
                LifeFragment()
            }
            else -> {
                FinanceFragment()
            }
        }
    }
}