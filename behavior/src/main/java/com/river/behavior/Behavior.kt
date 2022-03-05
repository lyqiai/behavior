package com.river.behavior

/**
 * 埋点实体
 * @property event String
 * @property data String
 * @property elementId String
 * @property elementType String
 * @property elementContent String
 * @property context String
 * @property systemLanguage String
 * @property systemVersion String
 * @property systemModel String
 * @property deviceBrand String
 * @property time String
 * @property traceId String
 * @property parentTraceId String?
 * @constructor
 */
data class Behavior(
    //事件类型
    val event: String,
    //事件数据
    val data: String = "",
    //触发viewID
    val elementId: String = "",
    //触发view类型
    val elementType: String = "",
    //触发view内容
    val elementContent: String = "",
    //上下文
    val context: String,
    //语言
    val systemLanguage: String = BehaviorHelper.getSystemLanguage(),
    //版本
    val systemVersion: String = BehaviorHelper.getSystemVersion(),
    //型号
    val systemModel: String = BehaviorHelper.getSystemModel(),
    //厂商
    val deviceBrand: String = BehaviorHelper.getDeviceBrand(),
    //时间
    val time: String = BehaviorHelper.getTime(),
    //链路ID
    val traceId: String,
    //链路父ID
    val parentTraceId: String?,
)