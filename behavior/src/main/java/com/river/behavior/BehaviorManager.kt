package com.river.behavior

import android.app.Application

/**
 * 对外提供埋点事件回调
 */
object BehaviorManager {
    private lateinit var app: Application
    private var listener: BehaviorListener? = null

    fun init(application: Application): BehaviorManager {
        app = application

        return this
    }

    fun setBehaviorListener(listener: BehaviorListener): BehaviorManager {
        this.listener = listener
        return this
    }

    fun sendBehavior(behavior: Behavior) {
        listener?.onBehavior(behavior)
    }
}