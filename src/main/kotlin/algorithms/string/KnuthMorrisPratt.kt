package algorithms.string

import structures.list.LinkedList

fun String.searchPatterns(pattern: String): LinkedList<Int> {
    val result = LinkedList<Int>()
    val patternLength = pattern.length

    val longestPrefixSuffix = Array(patternLength) { 0 }
    computeLongestPrefixSuffixArray(pattern, patternLength, longestPrefixSuffix)

    var i = 0
    var j = 0
    while (i < length) {
        if (pattern[j] == this[i]) {
            i++
            j++
        }
        if (j == patternLength) {
            result.append(i - j)
            j = longestPrefixSuffix[j - 1]
        } else if (i < length && pattern[j] != this[i]) {
            if (j != 0)
                j = longestPrefixSuffix[j - 1]
            else i++
        }
    }

    return result
}

private fun computeLongestPrefixSuffixArray(
    pattern: String,
    patternLength: Int,
    lps: Array<Int>
) {
    var len = 0
    var i = 1

    while (i < patternLength) {
        if (pattern[i] == pattern[len])
            lps[i++] = len++
        else {
            if (len != 0) len = lps[len - 1]
            else lps[i++] = len
        }
    }
}
