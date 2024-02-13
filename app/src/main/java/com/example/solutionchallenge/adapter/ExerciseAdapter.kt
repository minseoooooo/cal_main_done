package com.example.solutionchallenge.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.solutionchallenge.ExerciseDiffCallback
import com.example.solutionchallenge.RecommendationDetailDialog
import com.example.solutionchallenge.databinding.ItemRecommendationBinding
import com.example.solutionchallenge.databinding.RecommendationDetailDialogBinding
import com.example.solutionchallenge.datamodel.Exercise
import com.example.solutionchallenge.viewmodel.ExerciseViewModel


class ExerciseAdapter(private val recommendationViewModel: ExerciseViewModel, private val isBookmarkVisible: Boolean)
    : RecyclerView.Adapter<ExerciseAdapter.MyViewHolder>() {

    private var recommendationList = emptyList<Exercise>()

    inner class MyViewHolder(private val binding: ItemRecommendationBinding) : RecyclerView.ViewHolder(binding.root) {

        lateinit var exercise: Exercise
        lateinit var exerciseViewModel: ExerciseViewModel

        fun bind(currentExercise: Exercise, exerciseViewModel: ExerciseViewModel) {
            binding.exercise = currentExercise
            this.exerciseViewModel = recommendationViewModel

            //즐찾버튼 숨김/보임
            if (!isBookmarkVisible) {
                binding.BookmarkCheckButton.visibility = View.GONE
            } else {
                binding.BookmarkCheckButton.visibility = View.VISIBLE
            }


            binding.BookmarkCheckButton.setOnCheckedChangeListener(null)


            // 메모 체크 시 체크 데이터 업데이트 -- 에러 있음
            binding.BookmarkCheckButton.setOnCheckedChangeListener { _, check ->
                if (check) {
                    exercise = Exercise(
                        currentExercise.id,
                        currentExercise.name,
                        currentExercise.time,
                        currentExercise.difficulty,
                        currentExercise.description,
                        currentExercise.caution,
                        currentExercise.reference,
                        true
                    )
                    this.exerciseViewModel.addExercise(exercise)



                } else {
                    exercise = Exercise(
                        currentExercise.id,
                        currentExercise.name,
                        currentExercise.time,
                        currentExercise.difficulty,
                        currentExercise.description,
                        currentExercise.caution,
                        currentExercise.reference,
                        false
                    )
                    this.exerciseViewModel.deleteExercise(exercise)

                }

                Log.d("BookmarkStatus", "Bookmark status ${exercise.bookmarked} =? $check  for item ${currentExercise.name}")
            }

            binding.ToRecommendationDetailDialogButton.setOnClickListener{
                exercise = currentExercise
                val recommendationDialog = RecommendationDetailDialog(binding.root.context, currentExercise)
                recommendationDialog.show()

            }

        }



    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemRecommendationBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return recommendationList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(recommendationList[position],recommendationViewModel)

    }

    fun setData(newRecommendations: List<Exercise>) {
        val diffResult = DiffUtil.calculateDiff(ExerciseDiffCallback(recommendationList, newRecommendations))
        recommendationList = newRecommendations
        diffResult.dispatchUpdatesTo(this)
    }



    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


}


