package com.muammerakca.cactusnotes

class PasswordValidator {

    fun String.passwordHasDigit() = any { it.isDigit() }

    fun String.passwordHasUpperCase() = any { it.isUpperCase() }

    fun String.passwordHasLowerCase() = any { it.isLowerCase() }

    fun String.passwordHasSpecialCharacters() = any { !it.isLetterOrDigit() }

    fun validatePassword(password: String) = when {
        password.isEmpty() -> R.string.password_required
        !password.passwordHasDigit()
                || !password.passwordHasUpperCase()
                || !password.passwordHasLowerCase()
                || !password.passwordHasSpecialCharacters() -> R.string.password_must_contains_character
        password.length < 8 -> R.string.password_short
        password.length >= 40 -> R.string.password_long
        password.contains(" ") -> R.string.password_cannot_space
        else -> null
    }

}