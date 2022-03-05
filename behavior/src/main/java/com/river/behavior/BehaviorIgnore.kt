package com.river.behavior

/**
 * @Author: River
 * @Emial: 1632958163@qq.com
 * @Create: 2021/11/9
 * @Desc: 标注类后将不再对该类进行任何注入处理
 **/
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.BINARY)
annotation class BehaviorIgnore
