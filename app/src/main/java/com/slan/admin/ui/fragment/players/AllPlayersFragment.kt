package com.slan.admin.ui.fragment.players

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import com.slan.admin.R
import com.slan.admin.data.model.AllPlayerListData
import com.slan.admin.data.source.local.AllPlayerDataSource
import com.slan.admin.databinding.FragmentAllPlayersBinding
import com.slan.admin.ui.adapters.players_a.AllPlayersRVAdapter

class AllPlayersFragment : Fragment() {

    companion object {
        fun newInstance() = AllPlayersFragment()
    }

    private lateinit var viewModel: AllPlayersViewModel
    private lateinit var binding: FragmentAllPlayersBinding
    private var allPlayerAdapter = AllPlayersRVAdapter()
    private var originalPlayerList: List<AllPlayerListData> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllPlayersBinding.inflate(inflater , container , false)

        setHasOptionsMenu(true)
        return binding.root
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(AllPlayersViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)

        binding.rvAllPlayers.adapter = allPlayerAdapter

        val dataSource = AllPlayerDataSource()
        originalPlayerList = dataSource.loadAllPlayersDataSource()
        allPlayerAdapter.submitList(originalPlayerList)




    }

    override fun onCreateOptionsMenu(menu: Menu , inflater: MenuInflater) {
        inflater.inflate(R.menu.all_player_search_menu , menu)
        val searchItem = menu.findItem(R.id.nav_search)
        val searchView = searchItem.actionView as? SearchView

        searchView?.queryHint = "Search"
        searchView?.isIconified = false

        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    searchPlayer(it)
                }
                return true
            }
        })

        // Handle the click event of the search menu item
        searchItem.setOnMenuItemClickListener {
            // Expand the SearchView when the search icon is clicked
            searchView?.onActionViewExpanded()
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.nav_search -> {
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun searchPlayer(query: String) {
        val filterPlayer =originalPlayerList.filter { player ->
            player.playerName.contains(query , ignoreCase = true) ||
                    player.playerNumber.contains(query , ignoreCase =true)

        }
        allPlayerAdapter.submitList(filterPlayer)

    }


}