package com.example.prof_log_reg.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.prof_log_reg.R
import com.example.prof_log_reg.ui.theme.OrangeCheckbox
import com.example.prof_log_reg.ui.theme.PinkBackground
import com.example.prof_log_reg.ui.theme.PinkTopBar
import com.example.prof_log_reg.ui.theme.ProfLogRegTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AvatarScreen() {
    var showBrow by remember { mutableStateOf(true) }
    var showEye by remember { mutableStateOf(true) }
    var showNose by remember { mutableStateOf(true) }
    var showMouth by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("AvatarApp") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = PinkTopBar,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(PinkBackground)
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Proportional stack: positions/sizes are fractions of the Box
            // so they scale with screen density like the reference.
            // Mapping: 0004=base, 0001=brow, 0003=eye, 0002=nose, 0000=mouth.
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .aspectRatio(0.72f),
                contentAlignment = Alignment.TopCenter
            ) {
                val boxW = maxWidth
                val boxH = maxHeight

                Image(
                    painter = painterResource(id = R.drawable.face_0004),
                    contentDescription = "Base face",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit
                )
                if (showBrow) {
                    Image(
                        painter = painterResource(id = R.drawable.face_0001),
                        contentDescription = "Brow",
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .offset(y = boxH * 0.365f)
                            .width(boxW * 0.68f)
                            .aspectRatio(597f / 59f),
                        contentScale = ContentScale.Fit
                    )
                }
                if (showEye) {
                    Image(
                        painter = painterResource(id = R.drawable.face_0003),
                        contentDescription = "Eye",
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .offset(y = boxH * 0.400f)
                            .width(boxW * 0.62f)
                            .aspectRatio(601f / 174f),
                        contentScale = ContentScale.Fit
                    )
                }
                if (showNose) {
                    Image(
                        painter = painterResource(id = R.drawable.face_0002),
                        contentDescription = "Nose",
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .offset(y = boxH * 0.515f)
                            .width(boxW * 0.185f)
                            .aspectRatio(181f / 126f),
                        contentScale = ContentScale.Fit
                    )
                }
                if (showMouth) {
                    Image(
                        painter = painterResource(id = R.drawable.face_0000),
                        contentDescription = "Mouth",
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .offset(y = boxH * 0.620f)
                            .width(boxW * 0.325f)
                            .aspectRatio(237f / 131f),
                        contentScale = ContentScale.Fit
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                AvatarToggle("Brow", showBrow) { showBrow = it }
                AvatarToggle("Eye", showEye) { showEye = it }
                AvatarToggle("Nose", showNose) { showNose = it }
                AvatarToggle("Mouth", showMouth) { showMouth = it }
            }
        }
    }
}

@Composable
private fun AvatarToggle(
    label: String,
    checked: Boolean,
    onChecked: (Boolean) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checked,
            onCheckedChange = onChecked,
            colors = CheckboxDefaults.colors(
                checkedColor = OrangeCheckbox,
                uncheckedColor = OrangeCheckbox.copy(alpha = 0.6f)
            )
        )
        Text(text = label, style = MaterialTheme.typography.bodyMedium)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun AvatarScreenPreview() {
    ProfLogRegTheme {
        AvatarScreen()
    }
}
