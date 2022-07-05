package algorithms.sort

import structures.array.Item

private fun <T : Comparable<T>> heapify(
    arr: Array<Item<T>>,
    n: Int,
    i: Int
) {
    var max = i
    val l = 2 * i + 1
    val r = 2 * i + 2

    if (l < n && arr[l].item!! > arr[max].item!!)
        max = l

    if (r < n && arr[r].item!! > arr[max].item!!)
        max = r

    if (max != i) {
        val tmp = arr[i]
        arr[i] = arr[max]
        arr[max] = tmp
        heapify(arr, n, max)
    }

}

fun <T : Comparable<T>> heapSort(arr: Array<Item<T>>) {
    val n = arr.size

    var i = n / 2 - 1
    while (i >= 0) {
        heapify(arr, n, i)
        i--
    }

    i = n - 1
    while (i > 0) {
        val tmp = arr[0]
        arr[0] = arr[i]
        arr[i] = tmp
        heapify(arr, i, 0)
        i--
    }
}