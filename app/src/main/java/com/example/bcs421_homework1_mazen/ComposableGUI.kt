package com.example.bcs421_homework1_mazen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun displayHeading(heading: String) {
    Text(
        text = heading,
        color = MaterialTheme.colorScheme.primary,
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.headlineMedium
    )
}

@Composable
fun displayNormalText(text: String) {
    Text(
        text = text,
        color = Color.Magenta,
        style = MaterialTheme.typography.bodyLarge
    )
}


@Composable
fun displayCourseInfo(course: CourseTaken) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 30.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            displayNormalText("Start Time:${course.courseName} ${course.startTime} ${course.endTime} ${course.days} ${course.credits}")
        }
    }
}

@Composable
fun displayStudentInfo(student: Student) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 30.dp
    ) {
        Column(
        ) {
            displayHeading("Student Information")
            Spacer(modifier = Modifier.height(8.dp))
            displayNormalText("Name: ${student.name()}") // Replace with actual student name
            displayNormalText("Total Credits: ${student.totalCredits()}")
        }


    }
}

@Composable
fun displayStudentSchd(student: Student) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 30.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            displayHeading("Student Schedule")
            Spacer(modifier = Modifier.height(8.dp))

            // Display each individual course taken using a function
            student.coursesTaken.forEach { course ->
                displayCourseInfo(course)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

    }

}
/*
@Composable
fun displayButtons(student: Student) {
    Surface(
        modifier = Modifier
            .padding(20.dp),
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 30.dp
    ) {
        Row(
            modifier = Modifier.padding(20.dp)
        ) {
            Button(
                onClick = {
                    val totalCredits = student.totalCredits()
                    showToast("Total Credits: $totalCredits")
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Total Credits")
            }

            Button(
                onClick = {
                    val optimalStudyHours = student.totalCredits() * 2
                    showToast("Optimal Study Hours: $optimalStudyHours")
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Optimal Study Hours")
            }
        }
    }
}

@Composable
*/


@Composable
fun MainScreen() {
    val student = Student(
        coursesTaken = mutableListOf(
            CourseTaken("BCS 421", "10:00", "11:00", "MW", 3),
            CourseTaken("CSC 343", "11:00", "12:00", "TR", 3),
            CourseTaken("CSC 321", "12:00", "1:00", "MW", 3),
            CourseTaken("CSC 363", "1:00", "2:00", "TR", 3),
            CourseTaken("ECO 380", "2:00", "3:00", "MW", 3),
            CourseTaken("ECO 365", "3:00", "4:00", "TR", 3)
        )
    )

    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        displayStudentInfo(student)

        displayStudentSchd(student)
    }
}
