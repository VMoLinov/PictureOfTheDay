package molinov.pictureoftheday.system

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import molinov.pictureoftheday.databinding.FragmentSystemBinding
import molinov.pictureoftheday.picture.Data

class SystemFragment : Fragment() {

    private var _binding: FragmentSystemBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arrayListOf(
            Pair(Data("Mars", ""), false)
        )
        data.add(0, Pair(Data("Header"), false))
        val adapter = SystemRecyclerAdapter(
            object : SystemRecyclerAdapter.OnListItemClickListener {
                override fun onItemClick(data: Data) {
                    Toast.makeText(context, data.someText, Toast.LENGTH_SHORT).show()
                }
            },
            data
        )
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )
        binding.recyclerFAB.setOnClickListener { adapter.appendItem() }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSystemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun newInstance() = SystemFragment()
    }
}
