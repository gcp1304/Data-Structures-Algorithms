package com.jayplabs.sorting

// Merges two subarrays of arr[].
// First subarray is arr[l..m]
// Second subarray is arr[m+1..r]
fun merge(arr: IntArray, l: Int, m: Int, r: Int) {

    // Find sizes of two subarrays to be merged
    val lSize = m - l
    val rSize = r - m + 1

    /* Create temp arrays */
    val left = IntArray(lSize)
    val right = IntArray(rSize)

    /*Copy data to temp arrays*/
    System.arraycopy(arr, l, left, 0, lSize)
    System.arraycopy(arr, m, right, 0, rSize)

    /* Merge the temp arrays */

    // Initial indexes of first and second subarrays and Initial index of merged subarry array
    var (x, y, z) = arrayOf(0, 0, l)
    while (x < lSize && y < rSize) arr[z++] = if (left[x] <= right[y]) left[x++] else right[y++]

    /* Copy remaining elements of left[] if any */
    while (x < lSize) arr[z++] = left[x++]

    /* Copy remaining elements of right[] if any */
    while (y < rSize) arr[z++] = right[y++]
}

fun sort(arr: IntArray, l: Int, r: Int) {
    if (l < r) {
        val m = (l + r + 1) / 2
        sort(arr, l, m - 1)
        sort(arr, m, r)
        merge(arr, l, m, r)
    }
}


fun main(args: Array<String>) {
    val arr = intArrayOf(1, -5, 7, 3, -2, 4, 6)

    println("Given Array")
    arr.forEach { number: Int -> print("$number ") }

    sort(arr, 0, arr.size - 1)

    println("\nSorted array")
    arr.forEach { number: Int -> print("$number ") }
}

