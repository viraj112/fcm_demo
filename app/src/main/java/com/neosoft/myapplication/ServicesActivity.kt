package com.neosoft.myapplication

import android.app.ActivityManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_services.*


class ServicesActivity : AppCompatActivity() {

    var mService: BoundService? = null
    var mServiceIntent: Intent? = null
    private var mSensorService: BoundService? = null
    // Boolean to check if our activity is bound to service or not
    var mIsBound: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)
        mSensorService = BoundService()
        mServiceIntent = Intent(this, mSensorService!!.javaClass)
        if (!isMyServiceRunning(mSensorService!!.javaClass)) {
            startService(mServiceIntent)
        }
        btn_start.setOnClickListener {
            // startService(Intent(this,StarServices::class.java))


            //bindService()
        }

        btn_stop.setOnClickListener {
            //stopService(Intent(this,StarServices::class.java))
//            if (mIsBound == true) {
//                unbindService()
//                mIsBound = false
//            }
            mSensorService = BoundService()
            mServiceIntent = Intent(this, mSensorService!!.javaClass)
            if (isMyServiceRunning(mSensorService!!.javaClass)) {
                //stopService(mServiceIntent)
                mSensorService?.stopService(mServiceIntent)

            }

        }
    }

    private fun isMyServiceRunning(serviceClass: Class<*>): Boolean {
        val manager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
        for (service in manager.getRunningServices(Int.MAX_VALUE)) {
            if (serviceClass.name == service.service.className) {
                Log.i("isMyServiceRunning?", true.toString() + "")
                return true
            }
        }
        Log.i("isMyServiceRunning?", false.toString() + "")
        return false
    }
    private fun getRandomNumberFromService() {
        mService?.randomNumberLiveData?.observe(this, Observer {
            resulttext?.text = "Random number from service: $it"
        })
    }

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName, iBinder: IBinder) {
            Log.d("mTAG", "ServiceConnection: connected to service.")
            // We've bound to MyService, cast the IBinder and get MyBinder instance
            val binder = iBinder as BoundService.MyBinder
            mService = binder.service
            mIsBound = true
            getRandomNumberFromService() // return a random number from the service
        }

        override fun onServiceDisconnected(arg0: ComponentName) {
            Log.d("mTAG", "ServiceConnection: disconnected from service.")
            mIsBound = false
        }
    }

    private fun bindService() {
        /*boundedSerices*/
        Intent(this, BoundService::class.java).also { intent ->
            bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
        }

    }

    /**
     * Used to unbind and stop our service class
     */
    private fun unbindService() {
        /*boundServices*/

        Intent(this, BoundService::class.java).also { intent ->
            unbindService(serviceConnection)
        }



    }

    override fun onDestroy() {
        stopService(mServiceIntent);
        Log.i("MAINACT", "onDestroy!");
        super.onDestroy()

    }


}