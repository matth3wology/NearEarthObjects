package com.alpha.myapplication.api

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.alpha.myapplication.R
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest

class NearEarthObjects(ctx: Context) : NasaAPI(ctx) {

    private val apiURL : String = "https://api.nasa.gov/neo/rest/v1/feed?start_date=2015-09-07&end_date=2015-09-08&api_key=${getAPIKey()}"
    private val layoutInflater = LayoutInflater.from(ctx)

    /**
     * This method takes in a LinearLayout as an argument and fetches near earth
     * objects from the NASA API. It then populates the LinearLayout with the
     * data it has retrieved.
     */
    companion object fun populateObjectsToView(parent: LinearLayout) {
        val request = JsonObjectRequest(Request.Method.GET, apiURL, null, { response ->
            // Get the Near Earth Objects into a json blob
            val nearEarthObjects = response.getJSONObject("near_earth_objects")

            // Look at the different date keys in the json blob
            for (nearObjectsDate in nearEarthObjects.keys()) {

                val currentNearEarthObjects = nearEarthObjects.getJSONArray(nearObjectsDate)

                // Iterate through all objects that are within this date
                for (i in 0 until currentNearEarthObjects.length()) {

                    // The current earth object, this could be an asteroid, etc..
                    val currentEarthObject = currentNearEarthObjects.getJSONObject(i)

                    // Get the earth layout, this is similar to a row that will be placed inside the parent
                    val earthLayout = layoutInflater.inflate(R.layout.earth_object, parent, false) as LinearLayout

                    // Set the Row name
                    val name = earthLayout.getChildAt(0) as TextView
                    name.text = currentEarthObject.getString("name")

                    // Set the Row Date
                    val date = earthLayout.getChildAt(1) as TextView
                    date.text = nearObjectsDate

                    // Add a row to the LinearLayout
                    parent.addView(earthLayout)
                }
            }
        }, { error -> println(error) })

        addQueue(request)
    }
}