package com.ismynr.myintentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_move_for_result.*

class MoveForResultActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var BtnChoose: Button
    private lateinit var RgNumber: RadioGroup
    private lateinit var TvErrorValidate: TextView

    companion object{
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_for_result)

        BtnChoose = findViewById(R.id.btn_choose)
        RgNumber = findViewById(R.id.rg_number)

        BtnChoose.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if(v.id == R.id.btn_choose){
            if(rg_number.checkedRadioButtonId > 0){
                var value = 0

                when(rg_number.checkedRadioButtonId){
                    R.id.rb_50  -> value = 50
                    R.id.rb_100 -> value = 100
                    R.id.rb_150 -> value = 150
                    R.id.rb_200 -> value = 200
                }

                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
                setResult(RESULT_CODE, resultIntent)
                finish() // TUTUP ACTIVITY, KEMBALI KE AKTIVITY SEBELUMNYA
            }
            else{
                val text = "Select Item!"
                rb_50.error = text
                rb_100.error = text
                rb_150.error = text
                rb_200.error = text
                tv_error_validate.visibility = View.VISIBLE
                tv_error_validate.text = text
            }
        }
    }
}