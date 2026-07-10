package com.example.profilepage

import android.util.Patterns
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfile(
    viewModel: UserProfileViewModel = hiltViewModel()
) {

    val profilelist by viewModel.info.collectAsState()
    val nameInput by viewModel.nameInput.collectAsState()
    val usernameInput by viewModel.usernameInput.collectAsState()
    val bioInput by viewModel.bioInput.collectAsState()
    val emailInput by viewModel.emailInput.collectAsState()
    val phonenoInput by viewModel.phonenoInput.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Cancel",
                            fontSize = 16.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            "Edit Profile",
                            fontSize = 20.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            "Save",
                            fontSize = 16.sp,
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .clickable {
                                    viewModel.saveProfile()
                                }
                        )
                    }
                }
            )

        },
        bottomBar = {
            BottomAppBar() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BottomBar(
                        icon = Icons.Default.Home,
                        name = "Feed"
                    )

                    BottomBar(
                        icon = Icons.Default.Search,
                        name = "Search"
                    )

                    BottomBar(
                        icon = Icons.Default.AccountCircle,
                        name = "Network"
                    )

                    BottomBar(
                        icon = Icons.Default.Person,
                        name = "Profile"
                    )
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            LazyColumn() {
                item {
                    EditInfo(
                        viewModel
                    )
                }
            }
        }
    }
}

@Composable
fun BottomBar(icon: ImageVector, name: String) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon, contentDescription = name,
            tint = Color.DarkGray
        )
        Text(
            name,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = Color.DarkGray
        )
    }
}

@Composable
fun EditInfo(
    viewModel: UserProfileViewModel
) {

    var name by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var bio by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneno by remember { mutableStateOf("") }
    var nameError by remember { mutableStateOf("") }
    var usernameError by remember { mutableStateOf("") }
    var bioError by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf("") }
    var phonenoError by remember { mutableStateOf("") }
    HorizontalDivider()
    Box() {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Text(
                "Public Information",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray
            )

            Spacer(Modifier.height(20.dp))

            Text(
                "Name",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            OutlinedTextField(
                value = name,
                onValueChange = {
                    name = it
                    viewModel.updateName(it)
                },
                label = {


                        Text(
                            "Name",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray,
                            maxLines = 1
                        )
                },
                isError = nameError.isNotEmpty(),
                modifier = Modifier.fillMaxWidth(),
                supportingText = {
                    if (name.any{it.isDigit()}){
                        Text("xyz")
                        }
                }

            )

            if (nameError.isNotEmpty()) {
                Text(
                    text = nameError,
                    color = Color.Red,
                    fontSize = 12.sp
                )
            }

            Spacer(Modifier.height(10.dp))

            Text(
                "Username",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            OutlinedTextField(
                value = username,
                onValueChange = {
                    username = it
                    viewModel.updateUserName(it)
                },
                label = {
                    Text(
                        "username",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray,
                        maxLines = 1
                    )
                },
                isError = nameError.isNotEmpty(),
                modifier = Modifier.fillMaxWidth()
            )

            if (usernameError.isNotEmpty()) {
                Text(
                    text = usernameError,
                    color = Color.Red,
                    fontSize = 12.sp
                )
            }

            Spacer(Modifier.height(10.dp))

            Text(
                "Bio",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                maxLines = 1
            )

            OutlinedTextField(
                value = bio,
                onValueChange = {
                    bio = it
                    viewModel.updateBio(it)
                },
                label = {
                    Text(
                        "Bio",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray,
                        minLines = 4,
                        maxLines = 6,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                    )
                },
                isError = bioError.isNotEmpty(),
                modifier = Modifier.fillMaxWidth()
            )
            if (bioError.isNotEmpty()) {
                Text(
                    text = bioError,
                    color = Color.Red,
                    fontSize = 12.sp
                )
            }

            Spacer(Modifier.height(20.dp))

            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    "Private Information",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(Modifier.width(8.dp))

                Icon(
                    Icons.Default.Lock, contentDescription = "",
                    modifier = Modifier.size(15.dp)
                )
            }

            Spacer(Modifier.height(20.dp))

            Text(
                "Email",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )

            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                    viewModel.updateEmail(it)
                },
                label = {
                    if (email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        Text(
                            "Email",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray,
                            maxLines = 1
                        )
                    }
                },
                isError = emailError.isNotEmpty(),
                modifier = Modifier.fillMaxWidth()
            )
            if (emailError.isNotEmpty()) {
                Text(
                    text = emailError,
                    color = Color.Red,
                    fontSize = 12.sp
                )
            }

            Spacer(Modifier.height(20.dp))

            Text(
                "Phone Number",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            OutlinedTextField(
                value = phoneno,
                onValueChange = {
                    phoneno = it
                    viewModel.updatePhoneno(it)
                },
                label = {
                    Text(
                        "+1 (415) 555-0123",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray,
                        maxLines = 1
                    )
                },
                isError = phonenoError.isNotEmpty(),
                modifier = Modifier.fillMaxWidth()
            )
            if (phonenoError.isNotEmpty()) {
                Text(
                    text = phonenoError,
                    color = Color.Red,
                    fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            HorizontalDivider()

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                "Deactivate Account",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Red
            )

            Spacer(Modifier.height(3.dp))

            Text(
                "Permanently remove your account and data from the network.",
                fontSize = 14.sp,
                color = Color.Gray
            )

        }
    }
}