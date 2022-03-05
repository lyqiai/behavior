package com.river.behavior

/**
 * @Author: River
 * @Emial: 1632958163@qq.com
 * @Create: 2021/11/9
 * @Desc: 标记自定义View事件，要求回调方法中必须包含自定义View，否则注解将不生效,暂不支持KotlinFunction
 **/
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.BINARY)
annotation class BehaviorView(
    //事件名称
    val event: String,
    //方法名称
    val function: String,
    //方法方法签名
    val functionDesc: String,
    //接口全限路径
    val interfaceClz: String,
    //内容ViewId
    val contentViewId: Int = 0,
)
