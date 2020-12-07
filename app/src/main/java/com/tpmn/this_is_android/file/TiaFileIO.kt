package com.tpmn.this_is_android.file

import java.io.*
import java.util.stream.Stream

class TiaFileIO {
    /*
    (A-a)Byte: InputStream
    - FileInputStream
    - DataInputStream
    - ObjectInputStream
    - BufferedInputStream

    (A-b)Byte: OutputStream
    - FileOutputStream
    - DataOutpuStream
    - PrintStream
    - BufferedOutputStream

    (B-a)Character: Reader
    - FileReader
    - InputStreamReader
    - BufferedReader

    (B-b)Character: Writer
    - FileWriter
    - OutputStreamWriter
    - PrinterWriter
    - BufferedWriter
    */
    fun readTextFile(fullPath: String): String {
        val file = File(fullPath)
        if (!file.exists()) {
            return ""
        }

        val reader = FileReader(file)
        val buffer = BufferedReader(reader)
        var temp = ""
        val result = StringBuffer()
        while (true) {
            temp = buffer.readLine()
            if (temp == null) break;
            result.append(temp)
        }
        buffer.close()
        return result.toString()
    }

    fun writeTextFile(directory: String, fileName: String, content: String) {
        val dir = File(directory)
        if(!dir.exists()) {
            dir.mkdirs()
        }

        //Caused by: java.io.FileNotFoundException: output/neo.txt: open failed: ENOENT (No such file or directory)
        val writer = FileWriter(directory + "/" + fileName)
        val buffer = BufferedWriter(writer)
        buffer.write(content)
        writer.close()
    }
}