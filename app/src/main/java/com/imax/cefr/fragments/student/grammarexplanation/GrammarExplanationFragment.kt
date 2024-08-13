package com.imax.cefr.fragments.student.grammarexplanation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.imax.cefr.R
import com.imax.cefr.data.models.ExampleData
import com.imax.cefr.data.models.NormalData
import com.imax.cefr.data.models.TitleData
import com.imax.cefr.databinding.FragmentGrammarExplanationBinding
import com.imax.cefr.fragments.student.adapter.ExplanationAdapter

class GrammarExplanationFragment: Fragment(R.layout.fragment_grammar_explanation) {
    private var _binding: FragmentGrammarExplanationBinding? = null
    private val binding: FragmentGrammarExplanationBinding get() = _binding!!

    private val adapter = ExplanationAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentGrammarExplanationBinding.bind(view)

        binding.recyclerView.adapter = adapter

        val list = mutableListOf<Any>()



        list.add(TitleData(0, "Explanation"))
        list.add(NormalData(0, "We can use the passive voice to change the focus of the sentence."))
        list.add(ExampleData(0, "Aliya Monier directed the film.\n(focus on Aliya Monier)\n\n" +
                "The film was directed by Aliya Monier.\n(focus on The film)"))
        list.add(NormalData(0, "We often use the passive:"))
        list.add(NormalData(0, "•  so that we can start a sentence\n   with the most important or most\n   logical information\n\n•  when we prefer not to mention who\n   or what does the action (for\n   example, it's not known, it's obvious\n   or we don't want to say)\n\n•  in more formal or scientific writing."))
        list.add(TitleData(0, "Be + past participle"))
        list.add(NormalData(0, "The most common way to form the passive is subject + be + past participle."))
        list.add(ExampleData(0, "The new smoke alarm was installed\nyesterday."))

        adapter.models = list
    }
}
