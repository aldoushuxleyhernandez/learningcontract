package com.example.learningcontract
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            MaterialTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    LearningContractScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


// Data class for each learning contract
data class LearningContract(
    val name: String,
    val subject: String? = null,
    val schedule: String? = null,
    val expectations: List<String> = emptyList(),
    val contributions: List<String> = emptyList(),
    val motivations: List<String> = emptyList(),
    val hindrances: List<String> = emptyList()
)


// Group members and their learning contracts
val contracts = listOf(

    LearningContract(
        name = "Cayboen, Carl A.",
        subject = "Learning Contract",
        schedule = "Monday - Friday",

        expectations = listOf(
            "Understand the lessons clearly",
            "Improve my programming skills",
            "Participate actively in class"
        ),

        contributions = listOf(
            "Share ideas with group members",
            "Help with group activities",
            "Complete assigned tasks"
        ),

        motivations = listOf(
            "Become a better programmer",
            "Finish my studies successfully",
            "Build useful skills for my future career"
        ),

        hindrances = listOf(
            "Difficulty understanding complicated topics",
            "Lack of focus sometimes",
            "Limited time"
        )
    ),

    LearningContract(
        name = "Hernandez, Aldous",
        subject = "Learning Contract",
        schedule = "Monday - Friday",

        expectations = listOf(
            "Learn and understand the lessons",
            "Improve my technical skills",
            "Participate in activities"
        ),

        contributions = listOf(
            "Work together with group members",
            "Share ideas",
            "Finish assigned responsibilities"
        ),

        motivations = listOf(
            "Improve my knowledge",
            "Complete my education",
            "Prepare for my future career"
        ),

        hindrances = listOf(
            "Distractions",
            "Difficult lessons",
            "Time management"
        )
    ),

    LearningContract(
        name = "Moreno, Allan Cedric",
        subject = "Learning Contract",
        schedule = "Monday - Friday",

        expectations = listOf(
            "Understand the subject",
            "Learn new programming concepts",
            "Improve my problem-solving skills"
        ),

        contributions = listOf(
            "Help my group members",
            "Participate in discussions",
            "Complete my assigned work"
        ),

        motivations = listOf(
            "Gain more knowledge",
            "Improve my skills",
            "Prepare for future opportunities"
        ),

        hindrances = listOf(
            "Difficulty with some topics",
            "Distractions",
            "Lack of time"
        )
    )
)


@Composable
fun LearningContractScreen(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {

        Text(
            text = "Learning Contract",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )


        // Group Members
        Text(
            text = "Group Members",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )


        contracts.forEachIndexed { index, contract ->

            Text(
                text = "${index + 1}. ${contract.name}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(vertical = 2.dp)
            )
        }


        Spacer(
            modifier = Modifier.height(28.dp)
        )


        // Learning Contracts
        Text(
            text = "Learning Contracts",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )


        contracts.forEach { contract ->

            ContractCard(contract)

            Spacer(
                modifier = Modifier.height(16.dp)
            )
        }
    }
}


@Composable
fun ContractCard(
    contract: LearningContract
) {

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            Text(
                text = contract.name,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )


            contract.subject?.let {

                Text(
                    text = "Subject: $it",
                    style = MaterialTheme.typography.bodyMedium
                )
            }


            contract.schedule?.let {

                Text(
                    text = "Schedule: $it",
                    style = MaterialTheme.typography.bodyMedium
                )
            }


            Spacer(
                modifier = Modifier.height(8.dp)
            )


            ContractSection(
                title = "Expectations",
                items = contract.expectations
            )


            ContractSection(
                title = "Contributions",
                items = contract.contributions
            )


            ContractSection(
                title = "Motivations",
                items = contract.motivations
            )


            ContractSection(
                title = "Hindrances",
                items = contract.hindrances
            )
        }
    }
}


@Composable
fun ContractSection(
    title: String,
    items: List<String>
) {

    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(top = 8.dp)
    )


    items.forEachIndexed { index, item ->

        Text(
            text = "${index + 1}. $item",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 2.dp)
        )
    }
}


// Preview
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun LearningContractPreview() {

    MaterialTheme {

        LearningContractScreen()
    }
}

