package kg.internlabs.xiomicalculator.viewer.ui.extentions

import android.content.Context
import android.widget.Toast

fun Context.showToast(string: String?){
    Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
}