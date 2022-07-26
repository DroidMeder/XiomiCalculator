package kg.internlabs.xiomicalculator.model

import kg.internlabs.xiomicalculator.model.data.models.History
import kg.internlabs.xiomicalculator.model.rpn.RPN
import kg.internlabs.xiomicalculator.viewer.ui.financeViewFragment.FinanceFragment
import kg.internlabs.xiomicalculator.viewer.ui.lifeViewerFragment.LifeFragment
import kg.internlabs.xiomicalculator.viewer.ui.simpleCalculatorViewer.SimpleCalculatorViewerFragment

class LifeOperationsModel(viewer: LifeFragment) {
    private var lifeViewer: LifeFragment

    init {
        lifeViewer = viewer
    }


    fun doYourJob(values: Char) {
        lifeViewer.update("В процессе разработки...")
    }
}
