package com.example.xmlformat.model

import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStream

class XmlParserHandler {

    private var students = ArrayList<Student>()
    private var text: String? = null

    private var studentId: Int = 0
    private lateinit var studentName: String
    private lateinit var studentGrade: String

    fun parse(inputStream: InputStream): ArrayList<Student> {
        try {
            val factory = XmlPullParserFactory.newInstance()
            val parser = factory.newPullParser()
            parser.setInput(inputStream, null)
            var eventType = parser.eventType
            while (eventType != XmlPullParser.END_DOCUMENT) {
                val tagName = parser.name
                when (eventType) {
                    XmlPullParser.TEXT -> text = parser.text
                    XmlPullParser.END_TAG -> when {
                        tagName.equals("id", true) -> {
                            studentId = text!!.toInt()
                        }
                        tagName.equals("name", true) -> {
                            studentName = text.toString()
                        }
                        tagName.equals("grade", true) -> {
                            studentGrade = text!!.toString()
                        }
                        else -> students.add(Student(studentId, studentName, studentGrade))
                    }
                    else -> {}
                }
                eventType = parser.next()
            }
        } catch (e: XmlPullParserException){
            e.printStackTrace()
        } catch (e: IOException){
            e.printStackTrace()
        }
        return students
    }

}