package com.river.behavior

/**
 * 链路节点
 * @property traceId String 当前ID
 * @property parentTraceId String? 父ID
 * @constructor
 */
data class TraceNode(
    val traceId: String,
    val parentTraceId: String?
)