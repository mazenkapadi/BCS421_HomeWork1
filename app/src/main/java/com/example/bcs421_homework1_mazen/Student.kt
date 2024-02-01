package com.example.bcs421_homework1_mazen

class Student(
    var name: String,
    var major: String,
    var coursesTaken: MutableList<CourseTaken> = mutableListOf()
) {
    // Method to calculate total credits from the list of courses taken
    fun totalCredits(): Int {
        var totalCredits = 0
        for (course in coursesTaken) {
            totalCredits += course.credits
        }
        return totalCredits
    }

}
