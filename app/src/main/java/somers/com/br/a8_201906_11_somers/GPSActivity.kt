package somers.com.br.a8_201906_11_somers

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.icu.text.UFormat
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.PermissionChecker.PERMISSION_GRANTED
import kotlinx.android.synthetic.main.activity_gps.*
import java.text.ParseException

class GPSActivity : AppCompatActivity() {
    val PERMISSION_REQUEST_CODE = 212

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gps)

        if(!checkGPSPermission()){
            askPermission()
        }else{
            initiLocation()
        }
    }

    @SuppressLint("MissingPermission")
    private fun initiLocation() {

        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val locationProvider = LocationManager.GPS_PROVIDER

        locationManager.requestLocationUpdates(locationProvider,1000L,20F,
                object:LocationListener{
                    override fun onLocationChanged(location: Location?) {
                        textview.text = "Lat: ${location?.latitude} Long: ${location?.longitude}"

                    }

                    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

                    }

                    override fun onProviderEnabled(provider: String?) {

                    }

                    override fun onProviderDisabled(provider: String?) {

                    }

                })


    }

    // permissao de GPS
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults[0] == PERMISSION_GRANTED) {
                initiLocation()
            }

        }
    }

    fun askPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION), PERMISSION_REQUEST_CODE)
    }

    fun checkGPSPermission(): Boolean {
        return checkSelfPermission(ACCESS_FINE_LOCATION) == PERMISSION_GRANTED &&
                checkSelfPermission(ACCESS_COARSE_LOCATION) == PERMISSION_GRANTED
    }

}
