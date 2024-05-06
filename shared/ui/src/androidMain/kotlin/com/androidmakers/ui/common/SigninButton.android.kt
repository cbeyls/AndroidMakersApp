package com.androidmakers.ui.common

import androidmakersapp.shared.ui.generated.resources.Res
import androidmakersapp.shared.ui.generated.resources.signin
import androidmakersapp.shared.ui.generated.resources.signout
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.seiko.imageloader.rememberImagePainter
import fr.androidmakers.domain.model.User
import org.jetbrains.compose.resources.stringResource

@Composable
actual fun SigninButton(
  user: User?,
  callbacks: SigninCallbacks,
) {
  val expandedState = remember { mutableStateOf(false) }

  IconButton(
    onClick = {
      expandedState.value = true
    }
  ) {
    if (user == null) {
      Icon(
        imageVector = Icons.Rounded.AccountCircle,
        contentDescription = stringResource(Res.string.signin)
      )
    } else {
      Image(
        modifier = Modifier.clip(CircleShape),
        painter = rememberImagePainter(user.photoUrl ?: ""),
        contentDescription = stringResource(Res.string.signout)
      )
    }
  }

  DropdownMenu(
    expanded = expandedState.value,
    onDismissRequest = { expandedState.value = false }
  ) {
    if (user == null) {
      DropdownMenuItem(
        text = {
          Text(stringResource(Res.string.signin))
        },
        onClick = {
          expandedState.value = false
          callbacks.signin()
        }
      )
    } else {
      DropdownMenuItem(
        text = {
          Text(stringResource(Res.string.signout))
        },
        onClick = {
          expandedState.value = false
          callbacks.signout()
        }
      )
    }
  }
}
