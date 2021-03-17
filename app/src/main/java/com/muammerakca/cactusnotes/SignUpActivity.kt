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

        //-------------------------------------------------------------------------------------------

        //Email Control Start
        fun emailNullEmptyControl(email: String): Boolean {
            return !email.isEmpty()
        }

        fun emailContainDotControl(email: String): Boolean {
            return email.contains(".")
        }

        fun emailCannotContainSpaceControl(email: String): Boolean {
            return !email.contains(" ")
        }

        fun emailContainAtControl(email: String): Boolean {
            return email.contains("@")
        }

        fun emailMinCharacterControl(email: String): Boolean {
            return email.length > 5
        }

        fun emailMaxCharacterControl(email: String): Boolean {
            return email.length < 50
        } // Email Control End

        //Email Error Messages Start
        fun emailErrorMessages(email: String) = when {
            !emailNullEmptyControl(email) -> "Email is required."
            !emailContainDotControl(email) -> "Email is invalid."
            !emailContainAtControl(email) -> "Email is invalid."
            !emailMinCharacterControl(email) -> "Email is invalid."
            !emailMaxCharacterControl(email) -> "Email is invalid."
            !emailCannotContainSpaceControl(email) -> "Email cannot contain space"
            else -> null
        } //Email Error Messages Finish

        //-------------------------------------------------------------------------------------------

        //Username Controls Start
        fun usernameNullEmptyControl(username: String): Boolean {
            return !username.isEmpty()
        }

        fun usernameEligibleCharactersControl(username: String): Boolean {
            return username.all { it.isDigit() || it.isLowerCase() || it == '_' }
            //username!!.contains("[a-z][0-9]_") seklinde de yazilabilir mi?
        }

        fun usernameMinCharacterControl(username: String): Boolean {
            return username.length > 2
        }

        fun usernameMaxCharacterControl(username: String): Boolean {
            return username.length < 20
        } //Username Controls Finish

        //Username Error Messages Start
        fun usernameErrorMessages(username: String) = when {
            !usernameNullEmptyControl(username) -> "Username is required."
            !usernameEligibleCharactersControl(username) -> "Username can only include a-z, 0-9 and _ characters."
            !usernameMinCharacterControl(username) -> "Username is too short."
            !usernameMaxCharacterControl(username) -> "Username is too long."
            else -> null

        } //Username Error Messages Finish

        //-------------------------------------------------------------------------------------------

        //Password Controls Start
        fun passwordNullOrEmptyControl(password: String): Boolean {
            return !password.isNullOrEmpty()
        }

        fun passwordDigitControl(password: String): Boolean {
            return password.any { it.isDigit() }
        }

        fun passwordUpperCaseControl(password: String): Boolean {
            return password.any { it.isUpperCase() }
        }

        fun passwordLowerCaseControl(password: String): Boolean {
            return password.any { it.isLowerCase() }
        }

        fun passwordLetterOrDigitCharacterControl(password: String): Boolean {
            return password.any { it.isLetterOrDigit() }
        }

        fun passwordMinCharacterControl(password: String): Boolean {
            return password.length > 7
        }

        fun passwordMaxCharacterControl(password: String): Boolean {
            return password.length < 40
        }

        fun passwordSpaceControl(password: String): Boolean {
            return !password.contains(" ")
        } //Password Controls Finish

        //Password Error Messages Start
        fun passwordErrorMessages(password: String) = when {
            !passwordNullOrEmptyControl(password) -> "Password is required."
            !passwordDigitControl(password) -> "Password must contain one digit, one uppercase letter, one lowercase letter and one special character."
            !passwordUpperCaseControl(password) -> "Password must contain one digit, one uppercase letter, one lowercase letter and one special character."
            !passwordLowerCaseControl(password) -> "Password must contain one digit, one uppercase letter, one lowercase letter and one special character."
            !passwordLetterOrDigitCharacterControl(password) -> "Password must contain one digit, one uppercase letter, one lowercase letter and one special character."
            !passwordMinCharacterControl(password) -> "Password is too short."
            !passwordMaxCharacterControl(password) -> "Password is too long."
            !passwordSpaceControl(password) -> "Password cannot contain space."
            else -> null
        } //Password Error Messages Finish

        //-------------------------------------------------------------------------------------------

        //Button Click Start
        signupButton.setOnClickListener() {
            var email =
                textInputEmail.editText!!.text.toString() //bosluklara hassasiyeti artirmak icin trimleri kaldirdim

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
                Toast.makeText(this, "Successful", Toast.LENGTH_LONG).show()
        } //Button Click End
    }
}