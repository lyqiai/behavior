package com.river.behavior

import android.content.res.Resources
import android.os.Build
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.children
import java.text.SimpleDateFormat
import java.util.*

/**
 * 事件字段构建帮助类
 */
object BehaviorHelper {
    /**
     * 获取自定义View内容
     * @param view View
     * @param customView String
     * @param id Int
     * @return String
     */
    fun customViewContent(view: View, customView: String, id: Int): String {
        val rootView = findCustomRootView(view, customView) ?: return ""
        val textView = rootView.findViewById<TextView>(id)
        return textView.text.toString()
    }

    /**
     * 获取自定义ViewID
     * @param view View
     * @param customView String
     * @return String
     */
    fun customRootViewIdName(view: View, customView: String): String {
        val rootView = findCustomRootView(view, customView) ?: return ""
        return getIdName(rootView)
    }

    /**
     * 查找自定义View
     * @param view View
     * @param customView String
     * @return View
     */
    fun findCustomRootView(view: View, customView: String): View? {
        var parent: View? = view
        while (parent != null) {
            val clzName = parent.javaClass.canonicalName.replace('.', '/')
            if (clzName == customView) {
                return parent
            }
            parent = parent.parent as View?
        }

        return null
    }

    /**
     * 查找链路
     */
    fun findParentTraceNode(view: View): TraceNode {
        var parent: View? = view

        while (parent != null && parent is View) {
            var parentTraceNode = parent.getTag(R.id.asm_trace_node_data) as TraceNode?
            if (parentTraceNode != null) {
                return parentTraceNode
            }
            parentTraceNode = parent.getTag(R.id.asm_trace_node) as TraceNode?
            if (parentTraceNode != null) {
                view.setTag(R.id.asm_trace_node_data, parentTraceNode)
                return parentTraceNode
            }
            parent = parent.parent as View?
        }

        return TraceNode("", "unknow")
    }

    /**
     * 尝试获取view的text
     * @param view View
     * @return String
     */
    fun getViewText(view: View): String {
        if (view is ViewGroup) {
            view.children.forEach {
                return getViewText(it)
            }
        } else if (view is TextView) {
            return view.text.toString()
        }

        return ""
    }

    /**
     * 获取ID资源的name
     * @param id Int
     * @return String
     */
    fun getIdName(view: View): String {
        try {
            return view.resources.getResourceEntryName(view.id)
        } catch (e: Resources.NotFoundException) {
        }
        return ""
    }

    /**
     * 获取系统语言
     * @return String
     */
    fun getSystemLanguage(): String {
        return Locale.getDefault().language
    }

    /**
     * 获取系统版本
     * @return String
     */
    fun getSystemVersion(): String {
        return Build.VERSION.RELEASE
    }

    /**
     * 获取型号
     * @return String
     */
    fun getSystemModel(): String {
        return Build.MODEL
    }

    /**
     * 获取厂商
     * @return String
     */
    fun getDeviceBrand(): String {
        return Build.BRAND
    }

    /**
     * 当前时间
     * @return String
     */
    fun getTime(): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return formatter.format(Date())
    }
}