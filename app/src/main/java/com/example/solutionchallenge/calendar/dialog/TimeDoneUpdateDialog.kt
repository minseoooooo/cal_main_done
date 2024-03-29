package com.example.solutionchallenge.calendar.dialog


import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
//import com.myfirstandroidapp.helpcalendar.R
import com.example.solutionchallenge.R

class TimeDoneUpdateDialog(context: Context, updateDialogInterface: UpdateDialogInterface, selected_date: String) :
    Dialog(context) {

    // 액티비티에서 인터페이스를 받아옴
    private var updateDialogInterface: UpdateDialogInterface = updateDialogInterface
    val thisDate = selected_date

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_dialog)

        var okButton: Button = findViewById(R.id.okButton)
        var cancelButton: Button = findViewById(R.id.cancelButton)
        var nameEditView: EditText = findViewById(R.id.NameEditView)
        var timeEditView: EditText = findViewById(R.id.TimeEditView)


        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        okButton.setOnClickListener {
            val exerciseName= nameEditView.text.toString()
            val timeStr = timeEditView.text.toString()
            val doneTime = timeStr.toIntOrNull()
            val exerciseId = 5
            // 입력하지 않았을 때
            if (TextUtils.isEmpty(exerciseName) || doneTime == null) {
                Toast.makeText(context, "수정할 내용을 모두 입력해주세요.", Toast.LENGTH_SHORT).show()
            }

            // 입력 창이 비어 있지 않을 때
            else {
                // 메모를 수정해줌
                updateDialogInterface.onOkButtonClicked2(exerciseName, doneTime, thisDate)
                dismiss()
            }
        }


        // 취소 버튼 클릭 시 종료
        cancelButton.setOnClickListener { dismiss() }
    }
}