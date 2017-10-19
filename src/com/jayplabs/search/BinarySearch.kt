package com.jayplabs.search

fun binarySearch(data: Array<Int>, target: Int, low: Int, high: Int): Boolean {
    return if (low > high) false                                                    // interval empty; no match
    else {
        val mid = (low + high) / 2
        return when {
            target == data[mid] -> true                                             // found match
            target < data[mid] -> binarySearch(data, target, low, mid-1)      // recur left of the middle
            else -> binarySearch(data, target, mid+1, high)                    // recur right of the middle
        }
    }
}

fun main(args: Array<String>) {
    val input = arrayOf(2,4,5,7,8,9,12,14,17,19,22,25,27,28,33,37)
    print(binarySearch(input, 22, 0, input.size))
}
