package com.imax.cefr.fragments.student.grammartest

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.imax.cefr.R
import com.imax.cefr.databinding.FragmentGrammarTestBinding
import com.imax.cefr.utils.toastMessage

class GrammarTestFragment: Fragment(R.layout.fragment_grammar_test) {
    private var _binding: FragmentGrammarTestBinding? = null
    private val binding: FragmentGrammarTestBinding get() = _binding!!

    private var selectedOption = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentGrammarTestBinding.bind(view)

        changingOptions()

        binding.btnNext.setOnClickListener {
            if (selectedOption == 0) {
                toastMessage("Select option!")
            } else {
                // Go to next question
            }
        }
    }

    private fun changingOptions() {
        with(binding) {
            tvOption1.setOnClickListener {
                selectedOption = 1
                tvOption1.isSelected = true
                tvOption2.isSelected = false
                tvOption3.isSelected = false
            }
            tvOption2.setOnClickListener {
                selectedOption = 2
                tvOption1.isSelected = false
                tvOption2.isSelected = true
                tvOption3.isSelected = false
            }
            tvOption3.setOnClickListener {
                selectedOption = 3
                tvOption1.isSelected = false
                tvOption2.isSelected = false
                tvOption3.isSelected = true
            }
        }
    }
}
