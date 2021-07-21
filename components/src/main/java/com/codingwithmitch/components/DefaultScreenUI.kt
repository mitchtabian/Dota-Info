package com.codingwithmitch.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.codingwithmitch.core.domain.Queue
import com.codingwithmitch.core.domain.UIComponent
import com.codingwithmitch.util.toSnackbarDuration
import kotlinx.coroutines.launch

/**
 * @param queue: Dialogs, Snackbars and Toasts.
 * @param content: The content of the UI.
 */
@Composable
fun DefaultScreenUI(
    queue: Queue<UIComponent> = Queue(mutableListOf()),
    content: @Composable () -> Unit,
){
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState
    ){
        Box(modifier = Modifier.fillMaxSize()){
            content()
            DefaultSnackbar(
                snackbarHostState = scaffoldState.snackbarHostState,
                onDismiss = {
                    scaffoldState.snackbarHostState.currentSnackbarData?.dismiss()
                },
                modifier = Modifier.align(Alignment.BottomCenter)
            )
            // process the queue
            if(!queue.isEmpty()){
                scope.launch {
                    when(queue.peek()){
                        is UIComponent.Dialog -> {

                        }
                        is UIComponent.SnackBar -> {
                            scaffoldState.snackbarHostState.showSnackbar(
                                message = (queue.peek() as UIComponent.SnackBar).text,
                                duration = (queue.peek() as UIComponent.SnackBar).duration.value.toSnackbarDuration()
                            )
                        }
                        is UIComponent.Toast -> {

                        }
                    }
                }
            }
        }
    }
}