package kg.internlabs.xiomicalculator.model

import kg.internlabs.xiomicalculator.model.data.models.History
import kg.internlabs.xiomicalculator.model.rpn.RPN
import kg.internlabs.xiomicalculator.viewer.ui.financeViewFragment.FinanceFragment
import kg.internlabs.xiomicalculator.viewer.ui.lifeViewerFragment.LifeFragment
import kg.internlabs.xiomicalculator.viewer.ui.simpleCalculatorViewer.SimpleCalculatorViewerFragment

class FinanceOperationsModel(viewer: FinanceFragment) {
    private var financeViewer: FinanceFragment

    init {
        financeViewer = viewer
    }

    fun doYourJob(values: Char) {
        financeViewer.update("В процессе разработки...")
    }
}
