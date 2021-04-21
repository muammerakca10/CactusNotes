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


        signupButton.setOnClickListener {
            var email = textInputEmail.editText!!.text.toString()
            var username = textInputUsername.editText!!.text.toString()
            val password = textInputPassword.editText!!.text.toString()

            val emailValidator = EmailValidator()
            val emailHasError = emailValidator.validateEmail(email) != null
            textInputEmail.isErrorEnabled = emailHasError
            textInputEmail.error =
                if (emailHasError) getString(emailValidator.validateEmail(email)!!) else null

            val usernameValidator = UsernameValidator()
            val usernameHasError = usernameValidator.validateUsername(username) != null
            textInputUsername.isErrorEnabled = usernameHasError
            textInputUsername.error =
                if (usernameHasError) getString(usernameValidator.validateUsername(username)!!) else null

            val passwordValidator = PasswordValidator()
            val passwordHasError = passwordValidator.validatePassword(password) != null
            textInputPassword.isErrorEnabled = passwordHasError
            textInputPassword.error =
                if (passwordHasError) getString(passwordValidator.validatePassword(password)!!) else null

            if (!emailHasError && !usernameHasError && !passwordHasError)
                Toast.makeText(this, getString(R.string.successful), Toast.LENGTH_LONG).show()
        }
    }

    fun validate () {

    }

}