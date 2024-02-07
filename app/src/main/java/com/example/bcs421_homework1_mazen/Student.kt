package com.example.bcs421_homework1_mazen

class Student(
    // Properties representing details of a student
    var name: String,                    // Name of the student
    var major: String,                   // Major of the student
    var coursesTaken: MutableList<CourseTaken> = mutableListOf()  // List to store courses taken by the student
) {
    // Method to calculate the total credits from the list of courses taken
    fun totalCredits(): Int {
        var totalCredits = 0
        // Loop through each course in the list of coursesTaken and sum up the credits
        for (course in coursesTaken) {
            totalCredits += course.credits
        }
        // Return the total credits
        return totalCredits
    }
}
