package com.tian.composeuml

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.tian.composeuml.node.Qualifier
import com.tian.composeuml.ui.Class
import com.tian.composeuml.ui.Field
import com.tian.composeuml.ui.Method
import com.tian.composeuml.ui.Package
import com.tian.composeuml.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        runComposeUml(lifecycleScope) {
            val shouldShowMyThought = remember {
                mutableStateOf(false)
            }
            Package("Hello") {
                Class("Xun") {
                    Field("Son", "Person", Qualifier.Public)
                    Field("Daughter", "Person", Qualifier.Public)
                    if (shouldShowMyThought.value) {
                        Method("wantMoreMoney", Qualifier.Private)
                    }
                }
            }
            binding.buttonFirst.setOnClickListener {
                shouldShowMyThought.value = true
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}