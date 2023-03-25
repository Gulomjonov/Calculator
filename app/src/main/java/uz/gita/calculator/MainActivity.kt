package uz.gita.calculator

import android.app.ActivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val bindingClass: ActivityMainBinding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindingClass.btnC.setOnClickListener {
            bindingClass.textView.setText("")
            bindingClass.bottomTextView.setText("")
        }
        bindingClass.exit.setOnClickListener {
            val text = bindingClass.textView.text.toString()
            if (text.isEmpty()) {
                bindingClass.textView.text = text.drop(1)
            } else {
                bindingClass.textView.text = text.dropLast(1)
                bindingClass.bottomTextView.text = text.dropLast(1)
            }
        }
    }
    var isNewOp = true
    var dot = false
    fun buNumberEvent(view: View) {
        if(isNewOp){
            bindingClass.textView.setText("")
        }
        isNewOp = false

        val Value = view as Button
        var clickValue : String = bindingClass.textView.text.toString()
        when(Value.id) {
            bindingClass.BTN0.id -> {
                bindingClass.textView.text = clickValue.plus("0")
            }
            bindingClass.BTN1.id -> {
                bindingClass.textView.text = clickValue.plus("1")
            }
            bindingClass.BTN2.id -> {
                bindingClass.textView.text = clickValue.plus("2")
            }
            bindingClass.BTN3.id -> {
                bindingClass.textView.text = clickValue.plus("3")
            }
            bindingClass.BTN4.id -> {
                bindingClass.textView.text = clickValue.plus("4")
            }
            bindingClass.BTN5.id -> {
                bindingClass.textView.text = clickValue.plus("5")
            }
            bindingClass.BTN6.id -> {
                bindingClass.textView.text = clickValue.plus("6")
            }
            bindingClass.BTN7.id -> {
                bindingClass.textView.text = clickValue.plus("7")
            }
            bindingClass.BTN8.id -> {
                bindingClass.textView.text = clickValue.plus("8")
            }
            bindingClass.BTN9.id -> {
                bindingClass.textView.text = clickValue.plus("9")
            }
            bindingClass.btn2.id->{
                if(dot==false){
                    bindingClass.textView.text = clickValue.plus(",")
                }
                dot=true
            }
            bindingClass.btn.id -> {
                bindingClass.textView.text = clickValue.plus("-") + clickValue
            }
        }
    }
    var op = "*"
    var oldnumber = ""
    fun buOpEvent(view: View) {
        val valueof = view as Button
        when(valueof.id){
            bindingClass.btnUmnojeniye.id->{
                op = "*"
            }
            bindingClass.btnDeleniye.id->{
                op="/"
            }
            bindingClass.btnPlus.id->{
                op="+"
            }
            bindingClass.btnMinus.id->{
                op="-"
            }
        }
        oldnumber = bindingClass.textView.text.toString()
        isNewOp=true
        dot=false
    }
    fun buEqualEvent(view: View) {
        val numberValue = bindingClass.textView.text.toString()
        var finalNumber : Double? = null
        when(op){
            "*"->{
                finalNumber = oldnumber.toDouble() * numberValue.toDouble()
            }
            "/"->{
                finalNumber = oldnumber.toDouble() / numberValue.toDouble()
            }
            "+"->{
                finalNumber = oldnumber.toDouble() + numberValue.toDouble()
            }
            "-"->{
                finalNumber = oldnumber.toDouble() - numberValue.toDouble()
            }
        }
        bindingClass.textView.setText("")
        bindingClass.bottomTextView.setText(finalNumber.toString())
    }
    fun buPercentEvent(view: View) {
        val number = (bindingClass.textView.text.toString().toDouble()) / 100
        bindingClass.textView.setText(number.toString())
        isNewOp=true
    }
    var bracketSwitch = false
    fun Skobka(view: View) {

    }

}