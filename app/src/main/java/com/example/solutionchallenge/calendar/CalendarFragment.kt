package com.example.solutionchallenge.calendar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.solutionchallenge.calendar.db.PlanViewModel
import com.example.solutionchallenge.calendar.dialog.CustomDialogInterface
import com.example.solutionchallenge.calendar.dialog.UpdateDialogInterface
import com.example.solutionchallenge.calendar.model.Plan
//import com.myfirstandroidapp.helpcalendar.databinding.FragmentCalendarBinding
import com.example.solutionchallenge.databinding.FragmentCalendarBinding
import com.myfirstandroidapp.helpcalendar.dialog.CustomDialog


class CalendarFragment : Fragment(), CustomDialogInterface, UpdateDialogInterface {

    private var binding: FragmentCalendarBinding? = null
    private val planViewModel: PlanViewModel by viewModels {
        PlanViewModel.Factory(requireActivity().application)
    } // 뷰모델 연결 (수정함******************)
    private val adapter: PlanAdapter by lazy { PlanAdapter(planViewModel) } // 어댑터 선언

    private var year: Int = 0
    private var month: Int = 0
    private var day: Int = 0
    private var thisDate: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 뷰바인딩
        binding = FragmentCalendarBinding.inflate(inflater, container, false)


        // 아이템에 아이디를 설정해줌 (깜빡이는 현상방지)
        adapter.setHasStableIds(true)

        // 아이템을 가로로 하나씩 보여주고 어댑터 연결
        binding!!.calendarRecyclerview.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding!!.calendarRecyclerview.adapter = adapter

        /*
                binding!!.calendarView.setOnDateChangeListener { _, year, month, day ->
                    // 날짜 선택시 그 날의 정보 할당
                    this.year = year
                    this.month = month + 1
                    this.day = day


         */

        // 달력 - 날짜 선택 Listener
        binding!!.calendarView.setOnDateChangedListener { _, date, _ ->
            year = date.year
            month = date.month + 1
            day = date.day

            binding!!.calendarDateText.text = "${this.year}-${this.month}-${this.day}"
            thisDate = "${this.year}-${this.month}-${this.day}"

            // 해당 날짜 데이터를 불러옴 (currentData 변경)
            planViewModel.readDateData(this.year, this.month, this.day) //여기가 잘못됐나1
        }

        // 메모 데이터가 수정되었을 경우 날짜 데이터를 불러옴 (currentData 변경)
        planViewModel.readAllData.observe(viewLifecycleOwner) {
            planViewModel.readDateData(this.year, this.month, this.day)//여기가 잘못됐나2
        }

        // 현재 날짜 데이터 리스트(currentData) 관찰하여 변경시 어댑터에 전달해줌
        planViewModel.currentData.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })

        // Fab 클릭시 다이얼로그 띄움
        binding!!.calendarDialogButton.setOnClickListener {
            if (year == 0) {
                Toast.makeText(activity, "날짜를 선택해주세요.", Toast.LENGTH_SHORT).show()
            } else {

                val selected_date = "${this.year}-${this.month}-${this.day}"
                onFabClicked(selected_date)
            }
        }

        return binding!!.root
    }

    // Fab 클릭시 사용되는 함수
    private fun onFabClicked(selected_date: String) {
        val customDialog = CustomDialog(requireActivity(), this, selected_date)
        customDialog.show()
    }

    // 프래그먼트는 뷰보다 오래 지속 . 프래그먼트의 onDestroyView() 메서드에서 결합 클래스 인스턴스 참조를 정리
    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    override fun onOkButtonClicked1(
        //exerciseId: Int,
        exerciseName: String,
        plannedTime: Int,
        thisDate: String
    ) {

        // 선택된 날짜로 메모를 추가해줌
        val plan = Plan(0, false, exerciseId=0, exerciseName, plannedTime, doneTime = 0, thisDate)
        planViewModel.addPlan(plan)
        Toast.makeText(activity, "추가됨", Toast.LENGTH_SHORT).show()



    }


    override fun onOkButtonClicked2(
        //exerciseId: Int,
        exerciseName: String,
        doneTime: Int,
        thisDate: String
    ) {
        TODO("Not yet implemented")
    }
    /*
        override fun onOkButtonClicked(name: String, time: Int) {
            TODO("Not yet implemented")
        }

     */

}