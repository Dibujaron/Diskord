package com.jessecorbett.diskord.util

import com.jessecorbett.diskord.api.rest.FileData
import java.io.File
import java.io.FileInputStream
import java.util.*


/**
 * Converts a [File] to a [ByteArray].
 *
 * @return a [ByteArray] version of the file.
 */
fun File.toByteArray() = ByteArray(this.length().toInt()).also { FileInputStream(this).read(it) }

/**
 * Converts a [File] to a base64 encoded [String].
 *
 * @return a base64 encoded version of the file.
 */
fun File.toBase64() = Base64.getEncoder().encodeToString(this.toByteArray())!!

/**
 * Converts a [File] to a [FileData] object.
 *
 * @return the [FileData] representing this file
 */
fun File.toFileData(): FileData {
    TODO()
}
