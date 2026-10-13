package com.example.simplecounter

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Number of taps collected so far
    var counter = 0

    // How much each tap adds. Starts at 1 and becomes 2 after the upgrade.
    var tapValue = 1

    // Extra challenge: increasingly difficult goals.
    // After the last goal in the list, each new goal is double the previous one.
    private val goals = mutableListOf(10, 50, 100, 250, 500, 1000)
    private var goalIndex = 0
    private var goalsReached = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<ImageButton>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)
        val tapValueTv = findViewById<TextView>(R.id.tapValueTv)
        val upgradeButton = findViewById<Button>(R.id.upgradeBtn)
        val goalTv = findViewById<TextView>(R.id.goalTv)
        val goalsReachedTv = findViewById<TextView>(R.id.goalsReachedTv)

        // Show the first goal when the app starts
        goalTv.text = getString(R.string.goal_text, goals[goalIndex])
        goalsReachedTv.text = getString(R.string.goals_reached_text, goalsReached)

        button.setOnClickListener {
            // Toast.makeText(it.context, "Clicked Button!", Toast.LENGTH_SHORT).show()
            counter += tapValue
            textView.text = counter.toString()

            // Stretch: show the upgrade button once the user reaches 100 taps
            if (counter >= 100 && tapValue == 1) {
                upgradeButton.visibility = View.VISIBLE
            }

            // Extra challenge: check whether the current goal has been reached.
            // A while loop handles the case where one tap passes more than one goal.
            while (counter >= goals[goalIndex]) {
                goalsReached++
                Toast.makeText(
                    it.context,
                    getString(R.string.goal_reached_toast, goals[goalIndex]),
                    Toast.LENGTH_SHORT
                ).show()

                goalIndex++
                if (goalIndex == goals.size) {
                    goals.add(goals.last() * 2)
                }
            }
            goalTv.text = getString(R.string.goal_text, goals[goalIndex])
            goalsReachedTv.text = getString(R.string.goals_reached_text, goalsReached)
        }

        // Stretch: the upgrade makes every tap count as 2 taps from now on
        upgradeButton.setOnClickListener {
            tapValue = 2
            tapValueTv.text = getString(R.string.tap_value_text, tapValue)
            button.contentDescription = getString(R.string.add_2)
            Toast.makeText(it.context, R.string.upgrade_toast, Toast.LENGTH_SHORT).show()

            // Hide the upgrade button again so it can only be bought once
            upgradeButton.visibility = View.INVISIBLE
        }
    }
}
