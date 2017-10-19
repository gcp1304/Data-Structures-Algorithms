package com.jayplabs.sorting

private fun insertionSort(array: IntArray) {
    val len = array.size

    for (i in 0 until len) {
        val key = array[i]
        var j = i-1

        while (j>=0 && array[j] > key) {
            array[j+1] = array[j]
            j--
        }
        array[j+1] = key
    }
}

fun main(args: Array<String>) {
    val arr = intArrayOf(1, -5, 7, 3, -2, 4, 6)

    println("Given Array")
    arr.forEach { number: Int -> print("$number ") }

    insertionSort(arr)

    println("\nSorted array")
    arr.forEach { number: Int -> print("$number ") }
}