package com.neosoft.myapplication

import android.R
import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log
import java.util.*


class MyJobService :JobService() {
    private var mRandomNumber = 0
    private var mIsRandomGeneratorOn = false

    private val MIN = 0
    private val MAX = 100
    override fun onStartJob(p0: JobParameters?): Boolean {
        doBackgroundWork();
        return true;
    }

    override fun onStopJob(p0: JobParameters?): Boolean {
        Log.i("service_demo_tag","onStopJob");
        return false;
    }


    private fun doBackgroundWork() {
        Thread {
            mIsRandomGeneratorOn = true
            startRandomNumberGenerator()
        }.start()
    }

    private fun startRandomNumberGenerator() {
        while (mIsRandomGeneratorOn) {
            try {
                Thread.sleep(1000)
                if (mIsRandomGeneratorOn) {
                    mRandomNumber = Random().nextInt(MAX) + MIN
                    Log.i(
                        "service_demo_tag",
                        "Thread id: " + Thread.currentThread().id + ", Random Number: " + mRandomNumber
                    )
                }
            } catch (e: InterruptedException) {
                Log.i("service_demo_tag", "Thread Interrupted")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mIsRandomGeneratorOn=false;
        Log.i("service_demo_tag","Stop service"+ ", thread Id: "+Thread.currentThread().getId());
    }

}