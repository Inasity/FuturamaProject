package com.example.android.futuramaproject.ui.futuramaquotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.android.futuramaproject.databinding.FragmentQuotesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuotesFragment : Fragment() {

    private val viewModel: QuotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentQuotesBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        setHasOptionsMenu(true)

        binding.quoteListRecyclerview.adapter = QuoteAdapter()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getQuotes()
    }
}
