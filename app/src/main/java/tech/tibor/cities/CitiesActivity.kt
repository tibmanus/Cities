package tech.tibor.cities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

const val EXTRA_MESSAGE = "tibor.tech.City"

class CitiesActivity : AppCompatActivity(), CityListFragment.OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cities)
    }

    override fun onListFragmentInteraction(item: City?) {
        val intent = Intent(this, MapsActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, item)
        }
        startActivity(intent)
    }
}
