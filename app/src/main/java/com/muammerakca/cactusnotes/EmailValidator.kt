package com.muammerakca.cactusnotes

class EmailValidator {

    fun validateEmail(email: String ) = when {
        email.isEmpty() -> R.string.email_required
        !email.contains(".") || !email.contains("@") || email.length <= 5 || email.length >= 50 -> R.string.email_invalid
        email.contains(" ") -> R.string.email_cannot_space
        else -> null
    }
}