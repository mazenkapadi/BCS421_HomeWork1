package com.example.bcs421_homework1_mazen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

// Display a heading with specified styling
@Composable
fun DisplayHeading(heading: String) {
    Text(
        text = heading,
        color = MaterialTheme.colorScheme.primary,
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.headlineMedium,
    )
}

// Display normal text with specified styling
@Composable
fun DisplayNormalText(text: String) {
    Text(
        text = text,
        color = Color.Magenta,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.padding(4.dp)
    )
}

// Display student information in a Surface
@Composable
fun DisplayStudentInfo(student: Student) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 30.dp
    ) {
        Column {
            DisplayHeading("Student Name and Credits")
            DisplayNormalText(student.name)
            DisplayNormalText(student.totalCredits().toString())
        }
    }
}

// Display course information in a Column
@Composable
fun DisplayCourseInfo(course: CourseTaken) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        DisplayNormalText("${course.courseName} ${course.days} ${course.startTime} ${course.endTime}")
    }
}

// Display a student's schedule in a Surface
@Composable
fun DisplayStudentSchedule(student: Student) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 30.dp
    ) {
        Column {
            DisplayHeading("Student Schedule")

            // Display each course in a list
            for (course in student.coursesTaken) {
                DisplayCourseInfo(course)
            }
        }
    }
}

// Display buttons for actions related to student information
@Composable
fun DisplayButtons(student: Student) {
    val context = LocalContext.current

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 30.dp
    ) {
        Row {
            // Button to display total credits
            Button(
                onClick = {
                    Toast.makeText(
                        context,
                        "Total Credits: ${student.totalCredits()}",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                modifier = Modifier.padding(4.dp)
            ) {
                Text("Total Credits")
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Button to display optimal study hours
            Button(
                onClick = {
                    val optimalStudyHours = 2 * student.totalCredits()
                    Toast.makeText(
                        context,
                        "Optimal Study Hours: $optimalStudyHours",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                modifier = Modifier.padding(4.dp)
            ) {
                Text("Optimal Study Hours")
            }
        }
    }
}

// Main screen composition
@Composable
fun MainScreen() {
    val student = Student("Mazen Kapadi", "Computer Science")
    // Adding courses to the student's schedule
    student.coursesTaken.add(CourseTaken("BCS 421", "10:50", "12:05", "MW", 3))
    student.coursesTaken.add(CourseTaken("CSC 321", "08:00", "09:25", "MW", 3))
    student.coursesTaken.add(CourseTaken("CSC 343", "13:40", "14:55", "T", 3))
    student.coursesTaken.add(CourseTaken("CSC 363", "12:15", "13:30", "TR", 3))
    student.coursesTaken.add(CourseTaken("ECO 365", "09:25", "10:40", "W", 3))
    student.coursesTaken.add(CourseTaken("ECO 380", "09:25", "10:40", "T", 3))

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
    ) {
        // Display student information
        DisplayStudentInfo(student)

        // Display student schedule
        DisplayStudentSchedule(student)
        // Display action buttons
        DisplayButtons(student)
    }
}
