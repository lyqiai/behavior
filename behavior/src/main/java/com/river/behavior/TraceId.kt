package com.river.behavior

import java.util.*

/**
 * @Author: River
 * @Emial: 1632958163@qq.com
 * @Create: 2021/11/9
 **/
object TraceId {
    /**
     * 生成链路ID
     * @return String
     */
    fun get(): String {
        return UUID.randomUUID().toString()
    }
}