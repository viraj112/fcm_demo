package com.neosoft.myapplication

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_job_schedulers.*


class JobSchedulersActivity : AppCompatActivity() {
    private val myService: MyJobService? = null
    var jobScheduler: JobScheduler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_schedulers)
        jobScheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler

        btn_start.setOnClickListener {

            startJob()
        }

        btn_stop.setOnClickListener {
            stopJob()
        }


    }


    private fun startJob() {
        val componentName = ComponentName(this, MyJobService::class.java)
        val jobInfo = JobInfo.Builder(101, componentName)
            .setRequiredNetworkType(JobInfo.NETWORK_TYPE_CELLULAR)
            .setPeriodic((15 * 60 * 1000).toLong())
            .setRequiresCharging(false)
            .setPersisted(true)
            .build()
        if (jobScheduler!!.schedule(jobInfo) == JobScheduler.RESULT_SUCCESS) {
            Log.i(
                "service_demo_tag",
                "MainActivity thread id: " + Thread.currentThread().id + ", job successfully scheduled"
            )
        } else {
            Log.i(
                "service_demo_tag",
                "MainActivity thread id: " + Thread.currentThread().id + ", job could not be scheduled"
            )
        }
    }


    private fun stopJob() {
        jobScheduler!!.cancel(101)
    }

}