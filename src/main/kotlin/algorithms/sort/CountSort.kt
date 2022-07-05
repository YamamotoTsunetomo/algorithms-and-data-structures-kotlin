package algorithms.sort

fun countSort(arr: Array<Int>) {
    if (arr.isEmpty())
        return

    val n = arr.size

    var max = arr[0]
    for (m in arr) if (m > max) max = m

    val count = Array(max) { 0 }
    for(m in arr) ++count[m]

    var m = 0
    while (m < n) {
        if (count[m] == 0) m++
        else arr[m] = count[m++]--
    }
}