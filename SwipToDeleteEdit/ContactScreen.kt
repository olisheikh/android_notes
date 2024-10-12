package com.example.bankuidesign.screens

import android.R.attr.action
import android.R.attr.name
import android.R.attr.padding
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun ContactScreen() {
    val context = LocalContext.current
    val contacts = remember {
        mutableStateListOf(
            *(1..100).map {
                Contacts(
                    id = it,
                    name = "Contact $it",
                    isOptionRevealed = false
                )
            }.toTypedArray()
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        itemsIndexed(
            items = contacts,
        ) { index, contact ->
            SwipeableItemWithAction(
                isRevealed = contact.isOptionRevealed,
                actions = {
                    ActionIcon(
                        onClick = {
                            contacts.remove(contact)
                            Toast.makeText(context,
                                "Deleted: ${contact.name}",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        backgroundColor = Color.Red,
                        icon = Icons.Default.Delete,
                        modifier = Modifier.fillMaxHeight()
                    )
                    ActionIcon(
                        onClick = {
                            Toast.makeText(context,
                                "Edited",
                                Toast.LENGTH_SHORT).show()
                        },
                        backgroundColor = Color.Yellow,
                        icon = Icons.Default.Edit,
                        modifier = Modifier.fillMaxHeight()
                    )
                    ActionIcon(
                        onClick = {
                            Toast.makeText(
                                context,
                                "Shared",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        backgroundColor = Color.Blue,
                        icon = Icons.Default.Share,
                        modifier = Modifier.fillMaxHeight()
                    )
                },
            ){
                Text(
                    text = "${contact.id}\n${contact.name}",
                    color = Color.White,  // Try changing to ensure visibility
                    modifier = Modifier.padding(10.dp),
                )
            }
        }
    }
}
