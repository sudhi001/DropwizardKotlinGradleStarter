package `in`.sudhi.webapp.utils

import com.github.f4b6a3.ulid.UlidCreator
import java.security.KeyPair
import java.security.KeyPairGenerator


class ID {
    companion object {
        // Utility function to generate ULID
        fun generateID(): String {
            return UlidCreator.getMonotonicUlid().toString()
        }
         fun generateKeyPair(): KeyPair? {
            return try {
                val keyPairGenerator = KeyPairGenerator.getInstance("RSA")
                keyPairGenerator.initialize(2048) // Key size, you can choose an appropriate size
                keyPairGenerator.generateKeyPair()
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
    }
}

