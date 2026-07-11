package com.example.profilepage

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserProfile(navController: NavController,
viewModel: UserProfileViewModel = hiltViewModel()) {

    val profile by viewModel.info.collectAsState()
    var icon: ImageVector
    var title: String

    Scaffold(
        modifier = Modifier.fillMaxSize(),

        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")

                        Text(
                            "Profile",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )

                        Icon(Icons.Filled.MoreVert, contentDescription = "Menu")
                    }
                }
            )
        }, bottomBar = {
            BottomAppBar() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(
                        modifier = Modifier,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            Icons.Default.AccountBox, contentDescription = "Feed",
                            tint = Color.DarkGray
                        )
                        Text(
                            "Feed",
                            fontSize = 16.sp,
                            color = Color.DarkGray,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }

                    Column(
                        modifier = Modifier,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            Icons.Default.Search, contentDescription = "Search",
                            tint = Color.DarkGray
                        )
                        Text(
                            "Feed",
                            fontSize = 16.sp,
                            color = Color.DarkGray,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }

                    Column(
                        modifier = Modifier,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            Icons.Default.Notifications, contentDescription = "Activity",
                            tint = Color.DarkGray
                        )
                        Text(
                            "Feed",
                            fontSize = 16.sp,
                            color = Color.DarkGray,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }

                    Column(
                        modifier = Modifier,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            Icons.Default.Person, contentDescription = "",
                            tint = Color.DarkGray
                        )
                        Text(
                            "Feed",
                            fontSize = 16.sp,
                            color = Color.DarkGray,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
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
                    UserInfo(navController, profile)
                }
            }
        }
    }
}

@Composable
fun UserInfo(
    navController: NavController,
    profile: Info?
) {

    HorizontalDivider()

    Box() {
        Card(
            modifier = Modifier.fillMaxSize(),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {

            Column(modifier = Modifier.padding(16.dp)) {

                Spacer(Modifier.height(20.dp))

                Text(
                    text="${profile?.name}",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

                Text(
                    "${profile?.username}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

                Spacer(Modifier.height(30.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {


                    PostDetails(
                        title = "142",
                        name = "Posts"
                    )

                    PostDetails(
                        title = "142",
                        name = "Posts"
                    )

                    PostDetails(
                        title = "142",
                        name = "Posts"
                    )
                }

                Spacer(Modifier.height(40.dp))

                Text(
                    text = "${profile?.bio}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal,
                    color = Color.Black
                )

                Spacer(Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {},
                        shape = RectangleShape,
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                        border = BorderStroke(1.dp, color = Color.LightGray)
                    ) {
                        Text(
                            text = "Edit Profile",
                            color = Color.Black,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.clickable{
                                navController.navigate("Screen2")
                            }
                        )
                    }

                    Spacer(Modifier.width(8.dp))

                    Button(
                        onClick = {},
                        shape = RectangleShape,
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                        border = BorderStroke(1.dp, color = Color.LightGray)
                    ) {
                        Text(
                            text = "Share Profile",
                            color = Color.Black,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }

                Spacer(Modifier.height(30.dp))

                Card(
                    modifier = Modifier,
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(1.dp, color = Color.LightGray)
                ) {
                    Details(
                        title = "Email",
                        email = "${profile?.email}"
                    )

                    Details(
                        title = "Phone Number",
                        email = "${profile?.phoneno}"
                    )
                }

                Spacer(Modifier.height(30.dp))

                Card(
                    modifier = Modifier,
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(1.dp, color = Color.LightGray)
                ) {
                    InfoRow(
                        icon = Icons.Default.Person,
                        title = "Account Settings"
                    )

                    InfoRow(
                        icon = Icons.Default.CheckCircle,
                        title = "Privacy & Security"
                    )

                    InfoRow(
                        icon = Icons.Default.Notifications,
                        title = "Notification"
                    )

                    InfoRow(
                        icon = Icons.Default.AddCircle,
                        title = "Data & Storage"
                    )

                    InfoRow(
                        icon = Icons.Default.AccountBox,
                        title = "Help Center"
                    )

                    InfoRow(
                        icon = Icons.Default.ArrowForward,
                        title = "Log Out",
                    )
                }

            }
        }
    }

}

@Composable
fun PostDetails(title: String, name: String) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            title,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )

        Text(
            name,
            fontSize = 12.sp,
            color = Color.DarkGray
        )
    }
}


@Composable
fun Details(title: String, email: String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            Icons.Default.MailOutline, contentDescription = "Email",
            tint = Color.DarkGray
        )

        Spacer(Modifier.width(12.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                fontSize = 14.sp,
                color = Color.DarkGray
            )
            Text(
                text = email,
                fontSize = 16.sp,
                color = Color.Black
            )
        }

    }
    HorizontalDivider()

}

@Composable
fun InfoRow(icon: ImageVector, title: String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = icon, contentDescription = title,
            tint = Color.DarkGray
        )

        Spacer(Modifier.width(12.dp))

        Text(
            text = title,
            fontSize = 14.sp,
            color = Color.DarkGray
        )

        Spacer(Modifier.weight(1f))

        Icon(Icons.Default.KeyboardArrowRight, contentDescription = "")

    }

    HorizontalDivider()

}
