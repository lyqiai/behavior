package com.river.behavior

import android.app.Application
import java.lang.Exception

/**
 * @Author liuyanqi
 * @Date 2021/6/17 0017 上午 9:36
 */
object AppGlobals {
    private var application: Application? = null

    fun get(): Application {
        if (application == null) {
            try {
                application = Class.forName("android.app.ActivityThread")
                    .getMethod("currentApplication")
                    .invoke(null) as Application
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
        return application!!
    }
}