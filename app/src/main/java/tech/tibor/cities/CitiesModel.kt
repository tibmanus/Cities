package tech.tibor.cities

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.res.Resources
import android.os.AsyncTask
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStream

class CitiesModel(resources: Resources) {

    private val stream : InputStream = resources.openRawResource(R.raw.cities)

    private val data = MutableLiveData<List<City>?>()

    val cities : LiveData<List<City>?>
        get() = data

    init {
        Parser().execute()
    }

    inner class Parser : AsyncTask<Void, Void, List<City>>() {
        override fun doInBackground(vararg params: Void?): List<City> {

            val json = stream.bufferedReader().use { it.readText() }
            val listType = object : TypeToken<ArrayList<City>>() {}.type
            val list : ArrayList<City> = Gson().fromJson(json, listType)
//            return list.sortedWith(compareBy({ it.name }, {it.country}))
            return list.sortedWith(compareBy { it.name })
        }

        override fun onPostExecute(result: List<City>?) {
            super.onPostExecute(result)
            data.value = result
        }

    }

    fun filterFor(string: String?) {
        if (string == null) {
            return;
        }

//        data.value.apply {  }
    }
}