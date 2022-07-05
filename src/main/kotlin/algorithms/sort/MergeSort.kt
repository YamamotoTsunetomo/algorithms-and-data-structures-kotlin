package algorithms.sort

import structures.array.Item

private fun <T : Comparable<T>> merge(
    arr: Array<Item<T>>,
    low: Int,
    mid: Int,
    high: Int
) {
    val n1 = mid - low + 1
    val n2 = high - mid

    val left = Array(n1) { Item<T>(null) }
    val right = Array(n2) { Item<T>(null) }

    for (i in 0 until n1) left[i] = arr[low + i]
    for (i in 0 until n2) right[i] = arr[mid + 1 + i]

    var i = 0
    var j = 0
    var k = low

    while (i < n1 && j < n2) {
        if (left[i].item!! <= right[j].item!!)
            arr[k] = left[i++]
        else arr[k] = right[j++]
        k++
    }

    while (i < n1) arr[k++] = left[i++]
    while (j < n2) arr[k++] = right[j++]
}

fun <T : Comparable<T>> mergeSort(
    arr: Array<Item<T>>,
    low: Int = 0,
    high: Int = arr.size - 1
) {
    if (low < high) {
        val mid = low + (high - low) / 2

        mergeSort(arr, low, mid)
        mergeSort(arr, mid + 1, high)

        merge(arr, low, mid, high)
    }
}