package com.jayplabs.search

import com.sun.xml.internal.fastinfoset.util.StringArray

private fun search(elements: IntArray, key: Int): Int {
    return elements.indices.firstOrNull { key == elements[it] }
            ?: -1
}

fun main(args: Array<String>) {
    var elements = intArrayOf(56,3,249,518,7,26,94,651,23,9)
    println(search(elements, 2490))
}