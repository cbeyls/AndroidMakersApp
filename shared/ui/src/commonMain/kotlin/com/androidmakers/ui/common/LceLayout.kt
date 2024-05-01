package com.androidmakers.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshContainer
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults
import androidx.compose.material3.pulltorefresh.PullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.androidmakers.ui.model.Lce
import dev.icerock.moko.resources.compose.stringResource
import fr.paug.androidmakers.ui.MR

@Composable
fun LoadingLayout() {
  Box(
      modifier = Modifier
          .fillMaxWidth()
          .fillMaxHeight(),
      contentAlignment = Alignment.Center
  ) {
    CircularProgressIndicator()
  }
}

@Composable
fun <T> LceLayout(
    lce: Lce<T>,
    onRetry: (() -> Unit)? = null,
    isRefreshing: Boolean = false,
    content: @Composable (T) -> Unit
) {
  when (lce) {
    is Lce.Loading -> LoadingLayout()
    is Lce.Content -> content(lce.content)
    is Lce.Error -> ErrorLayout(
        enabled = !isRefreshing,
        onClick = onRetry
    )
  }
}

@Composable
fun ErrorLayout(
    enabled: Boolean,
    onClick: (() -> Unit)? = null
) {
  Box(
      modifier = Modifier
          .fillMaxWidth()
          .fillMaxHeight(),
      contentAlignment = Alignment.Center
  ) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Text(
          text = stringResource(MR.strings.ohno),
          textAlign = TextAlign.Center
      )
      if (onClick != null) {
        Box(modifier = Modifier.height(16.dp))
        Button(
            onClick = onClick,
            enabled = enabled
        ) {
          Text(text = stringResource(MR.strings.retry))
        }
      }
    }
  }
}


@Composable
fun EmptyLayout(modifier: Modifier = Modifier) {
  Box(
      modifier = modifier
          .fillMaxWidth()
          .fillMaxHeight()
          .padding(16.dp),
      contentAlignment = Alignment.Center
  ) {
    Text(
        text = stringResource(MR.strings.empty_events),
        textAlign = TextAlign.Center
    )
  }
}

@Composable
fun <T> ButtonRefreshableLceLayout(
    viewModel: LceViewModel<T>,
    content: @Composable (T) -> Unit
) {
  val isRefreshing = viewModel.isRefreshing.collectAsState()
  val lce = viewModel.values.collectAsState()

  LceLayout(
      lce = lce.value,
      onRetry = { viewModel.refresh() },
      isRefreshing = isRefreshing.value
  ) {
    content(it)
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> SwipeRefreshableLceLayout(
    viewModel: LceViewModel<T>,
    content: @Composable (T) -> Unit
) {
  val isRefreshingState = viewModel.isRefreshing.collectAsState()
  val lce = viewModel.values.collectAsState()

  val pullToRefreshState = rememberPullToRefreshState(
      isRefreshing = isRefreshingState.value,
      onRefresh = { viewModel.refresh() }
  )

  PullToRefreshLayout(
      state = pullToRefreshState,
      modifier = Modifier
          .fillMaxSize()
          .nestedScroll(pullToRefreshState.nestedScrollConnection)
  ) {
    LceLayout(
        lce = lce.value,
    ) {
      content(it)
    }
  }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun rememberPullToRefreshState(
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    positionalThreshold: Dp = PullToRefreshDefaults.PositionalThreshold,
    enabled: () -> Boolean = { true }
): PullToRefreshState {
  val density = LocalDensity.current
  val positionalThresholdPx = with(density) { positionalThreshold.toPx() }
  val delegate = remember(positionalThresholdPx, enabled) {
    PullToRefreshState(
      positionalThresholdPx = positionalThresholdPx,
      initialRefreshing = isRefreshing,
      enabled = enabled
    )
  }

  // Sync state
  if (isRefreshing != delegate.isRefreshing) {
    if (isRefreshing) {
      delegate.startRefresh()
    } else {
      delegate.endRefresh()
    }
  }

  return remember(delegate, onRefresh) {
    object : PullToRefreshState by delegate {
      override fun startRefresh() {
        delegate.startRefresh()
        onRefresh()
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PullToRefreshLayout(
    state: PullToRefreshState,
    modifier: Modifier = Modifier,
    flipped: Boolean = false,
    indicator: @Composable (PullToRefreshState) -> Unit = { pullRefreshState ->
      PullToRefreshDefaults.Indicator(state = pullRefreshState)
    },
    content: @Composable () -> Unit
) {
  Box(
      modifier = modifier.clipToBounds()
  ) {
    val indicatorAlignment = if (flipped) Alignment.BottomCenter else Alignment.TopCenter

    content()

    PullToRefreshContainer(
        state = state,
        modifier = Modifier.align(indicatorAlignment),
        indicator = indicator
    )
  }
}
