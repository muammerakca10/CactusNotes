package com.muammerakca.cactusnotes

class UsernameValidator {

    fun validateUsername(username: String) = when {
        username.isEmpty() -> R.string.username_required
        !username.all { it.isDigit() || it.isLowerCase() || it == '_' } -> R.string.username_only_this_characters
        username.length <= 2 -> R.string.username_short
        username.length >= 20 -> R.string.username_long
        else -> null
    }
}