package com.muammerakca.cactusnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val textInputEmail: TextInputLayout = findViewById(R.id.textInputEmail)
        val textInputUsername: TextInputLayout = findViewById(R.id.textInputUsername)
        val textInputPassword: TextInputLayout = findViewById(R.id.textInputPassword)
        val signupButton: MaterialButton = findViewById(R.id.signupButton)
        val alreadySignButton: Button = findViewById(R.id.alreadySignButton)

        //Email Error Messages Start
        fun emailErrorMessages(email: String) = when {
            email.isEmpty() -> getString(R.string.email_required)
            !email.contains(".") || !email.contains("@") || email.length <= 5 || email.length >= 50 -> getString(R.string.email_invalid)
            email.contains(" ") -> getString(R.string.email_cannot_space)
            else -> null
        } //Email Error Messages Finish

        //Username Error Messages Start
        fun usernameErrorMessages(username: String) = when {
            username.isEmpty() -> getString(R.string.username_required)
            !username.all { it.isDigit() || it.isLowerCase() || it == '_' } -> getString(R.string.username_only_this_characters)
            username.length <= 2 -> getString(R.string.username_short)
            username.length >= 20 -> getString(R.string.username_long)
            else -> null
        } //Username Error Messages Finish

        //Password Error Messages Start
        fun passwordErrorMessages(password: String) = when {
            password.isEmpty() -> getString(R.string.password_required)
            !password.any { it.isDigit() } || !password.any { it.isDigit() } || !password.any { it.isLowerCase() } || !password.any { it.isLetterOrDigit() } -> getString(R.string.password_must_contains_character)
            password.length < 8 -> getString(R.string.password_short)
            password.length >= 40 -> getString(R.string.password_long)
            password.contains(" ") -> getString(R.string.password_cannot_space)
            else -> null
        } //Password Error Messages Finish

        //Button Click Start
        signupButton.setOnClickListener {
            var email =
                textInputEmail.editText!!.text.toString()

            var username = textInputUsername.editText!!.text.toString()
            val password = textInputPassword.editText!!.text.toString()

            val emailHasError = emailErrorMessages(email) != null
            textInputEmail.isErrorEnabled = emailHasError
            textInputEmail.error = emailErrorMessages(email)

            val usernameHasError = usernameErrorMessages(username) != null
            textInputUsername.isErrorEnabled = usernameHasError
            textInputUsername.error = usernameErrorMessages(username)

            val passwordHasError = passwordErrorMessages(password) != null
            textInputPassword.isErrorEnabled = passwordHasError
            textInputPassword.error = passwordErrorMessages(password)

            if (!emailHasError && !usernameHasError && !passwordHasError)
                Toast.makeText(this, getString(R.string.successful), Toast.LENGTH_LONG).show()
        } //Button Click End
    }
}