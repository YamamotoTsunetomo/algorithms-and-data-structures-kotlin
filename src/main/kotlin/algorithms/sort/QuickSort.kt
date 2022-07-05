package algorithms.sort

import structures.array.Item

private fun <T : Comparable<T>> swap(arr: Array<Item<T>>, i: Int, j: Int) {
    val tmp = arr[i]
    arr[i] = arr[j]
    arr[j] = tmp
}

private fun <T : Comparable<T>> partition(
    arr: Array<Item<T>>,
    low: Int,
    high: Int
): Int {
    val pivot = arr[high]

    var i = low - 1
    for (j in low until high) {
        if (arr[j].item!! < pivot.item!!)
            swap(arr, ++i, j)
    }
    swap(arr, i + 1, high)
    return i + 1
}

fun <T : Comparable<T>> quickSort(
    arr: Array<Item<T>>,
    low: Int = 0,
    high: Int = arr.size - 1
) {
    if (low < high) {
        val partitionIndex = partition(arr, low, high)
        quickSort(arr, low, partitionIndex - 1)
        quickSort(arr, partitionIndex + 1, high)
    }
}