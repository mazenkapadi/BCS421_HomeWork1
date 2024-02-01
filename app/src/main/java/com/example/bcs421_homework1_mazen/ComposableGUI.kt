package com.example.bcs421_homework1_mazen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
@Composable
fun displayHeading(heading: String) {
    Text(
        text = heading,
        color = MaterialTheme.colorScheme.primary,
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.headlineMedium,
        modifier = Modifier
            .fillMaxWidth()


    )
}

@Composable
fun displayNormalText(text: String) {
    Text(
        text = text,
        color = Color.Magenta,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.padding(6.dp)
    )
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
        Column {
            displayHeading("Student Name and Credits")
            displayNormalText(student.name)
            displayNormalText(student.totalCredits().toString())
        }
    }
}

@Composable
fun displayCourseInfo(course: CourseTaken) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        displayNormalText("${course.courseName} ${course.days} ${course.startTime} ${course.endTime}")
    }
}


@Composable
fun displayStudentSchedule(student: Student) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 30.dp
    ) {
        Column {
            displayHeading("Student Schedule")

            // Display each course in a list
            for (course in student.coursesTaken) {
                displayCourseInfo(course)

            }
        }
    }
}


@Composable
fun displayButtons(Student: Student) {

    val context = LocalContext.current

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 30.dp
    ){
        Row {
            Button(
                onClick = {
                    Toast.makeText(context,"Total Credits: ${Student.totalCredits()}", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier.padding(4.dp)
            ){
                Text("Total Credits")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {
                    val optimalStudyHours = 2 * Student.totalCredits()
                    Toast.makeText(context,"Optimal Study Hours $optimalStudyHours", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier.padding(4.dp)
            ){
                Text("Optimal Study Hours")
            }
        }
    }
}


@Composable
fun MainScreen() {
    val student = Student("Mazen", "Computer Science")
    student.coursesTaken.add(CourseTaken("BCS 421", "10:00", "11:00", "MWF", 3))
    student.coursesTaken.add(CourseTaken("BCS 370", "11:00", "12:00", "MWF", 3))
    student.coursesTaken.add(CourseTaken("BCS 230", "12:00", "13:00", "MWF", 3))
    student.coursesTaken.add(CourseTaken("BCS 320", "13:00", "14:00", "MWF", 3))

    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        displayStudentInfo(student)
        Spacer(
            modifier = Modifier
                .padding(20.dp)
        ) // Add a Spacer for some separation
        displayStudentSchedule(student)
        displayButtons(student)
    }
}
