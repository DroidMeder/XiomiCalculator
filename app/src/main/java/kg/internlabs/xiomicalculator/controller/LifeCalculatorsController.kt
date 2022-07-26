package kg.internlabs.xiomicalculator.controller

import android.view.View
import kg.internlabs.xiomicalculator.R
import kg.internlabs.xiomicalculator.model.LifeOperationsModel
import kg.internlabs.xiomicalculator.viewer.ui.financeViewFragment.FinanceFragment
import kg.internlabs.xiomicalculator.viewer.ui.lifeViewerFragment.LifeFragment

class LifeCalculatorsController(viewer: LifeFragment) : View.OnClickListener{
    private val lifeOperationsModel: LifeOperationsModel

    init {
        lifeOperationsModel = LifeOperationsModel(viewer = viewer)
    }



    override fun onClick(v: View) {
        var values = '0'
        when(v.id){
            R.id.btn_0_s -> values = '0'
            R.id.btn_1_s -> values = '1'
            R.id.btn_2_s -> values = '2'
            R.id.btn_3_s -> values = '3'
            R.id.btn_4_s -> values = '4'
            R.id.btn_5_s -> values = '5'
            R.id.btn_6_s -> values = '6'
            R.id.btn_7_s -> values = '7'
            R.id.btn_8_s -> values = '8'
            R.id.btn_9_s -> values = '9'
            R.id.btn_dot_s -> values = '.'
            R.id.btn_c_s -> values = 'c'
            R.id.btn_del_s -> values = 'd'
            R.id.btn_percent_s -> values = '%'
            R.id.btn_div_s -> values = '/'
            R.id.btn_mul_s -> values = '*'
            R.id.btn_minus_s -> values = '-'
            R.id.btn_plus_s -> values = '+'
            R.id.btn_equal_s -> values = '='
        }
        lifeOperationsModel.doYourJob(values)
    }
}