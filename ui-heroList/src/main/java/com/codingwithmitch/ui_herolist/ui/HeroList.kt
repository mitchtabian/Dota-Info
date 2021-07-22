package com.codingwithmitch.ui_herolist.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.codingwithmitch.components.DefaultScreenUI
import com.codingwithmitch.core.domain.UIComponentState
import com.codingwithmitch.ui_herolist.components.HeroListFilter
import com.codingwithmitch.ui_herolist.components.HeroListItem
import com.codingwithmitch.ui_herolist.components.HeroListToolbar

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun HeroList(
    state: HeroListState,
    events: (HeroListEvents) -> Unit,
    navigateToDetailScreen: (Int) -> Unit,
){
    DefaultScreenUI(
        queue = state.errorQueue,
        onRemoveHeadFromQueue = {
            events(HeroListEvents.OnRemoveHeadFromQueue)
        },
        progressBarState = state.progressBarState,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ){
            Column(
                modifier = Modifier
                    .clickable {
                        events(HeroListEvents.UpdateFilterDialogState(UIComponentState.Hide))
                    }
            ){
                HeroListToolbar(
                    heroName = state.heroName,
                    onHeroNameChanged = { heroName ->
                        events(HeroListEvents.UpdateHeroName(heroName))
                    },
                    onExecuteSearch = {
                        events(HeroListEvents.FilterHeros)
                    },
                    onShowFilterDialog = {
                        events(HeroListEvents.UpdateFilterDialogState(UIComponentState.Show))
                    }
                )
                AnimatedVisibility(visible = state.filteredHeros.isNotEmpty()) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 8.dp)
                    ) {
                        items(state.filteredHeros){ hero ->
                            HeroListItem(
                                hero = hero,
                                onSelectHero = navigateToDetailScreen
                            )
                        }
                    }
                }
            }
            if(state.filterDialogState is UIComponentState.Show){
                HeroListFilter(
                    heroFilter = state.heroFilter,
                    onUpdateHeroFilter = { heroFilter ->
                         events(HeroListEvents.UpdateHeroFilter(heroFilter))
                    },
                    attributeFilter = state.primaryAttrFilter,
                    onUpdateAttributeFilter = { attribute ->
                          events(HeroListEvents.UpdateAttributeFilter(attribute))
                    },
                    onCloseDialog = {
                        events(HeroListEvents.UpdateFilterDialogState(UIComponentState.Hide))
                    }
                )
            }
        }
    }
}








