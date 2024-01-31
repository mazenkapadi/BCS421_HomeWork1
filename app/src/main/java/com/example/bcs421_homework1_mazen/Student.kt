package com.example.bcs421_homework1_mazen

class Student (
    var coursesTaken: MutableList<CourseTaken> = mutableListOf()
){
    //Methods
    fun name(): String {
        return "Mazen"
    }
    fun totalCredits(): Int {
        var totalCredits = 0
        for (course in coursesTaken) {

            totalCredits += course.credits
        }
        return totalCredits
    }
}