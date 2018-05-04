package tech.tibor.cities

import android.app.Application
import android.arch.lifecycle.AndroidViewModel

class CitiesViewModel(application: Application) : AndroidViewModel(application) {

    val model = CitiesModel(application.resources)
}