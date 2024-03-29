package com.example.quiz_master
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.quiz_master.QuizViewModel
import com.example.quiz_master.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var viewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Initialize the Shared Activity ViewModel
        viewModel = ViewModelProviders.of(activity as AppCompatActivity).get(QuizViewModel::class.java)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnCreateQuestion.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_createQuizFragment) }
        btnStartQuiz.setOnClickListener {
            if (viewModel.isQuestionCreated()) {
                findNavController().navigate(R.id.action_homeFragment_to_quizFragment)
            } else {
                Toast.makeText(context, "Please create a question before starting the quiz.", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
