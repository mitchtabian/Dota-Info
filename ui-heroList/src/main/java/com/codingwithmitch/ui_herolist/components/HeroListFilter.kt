package com.codingwithmitch.ui_herolist.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.codingwithmitch.core.domain.SqlFilterOrder
import com.codingwithmitch.dotainfo.hero_domain.HeroAttribute
import com.codingwithmitch.ui_herolist.util.HeroFilter

@ExperimentalAnimationApi
@Composable
fun HeroListFilter(
    heroFilter: HeroFilter,
    onUpdateHeroFilter: (HeroFilter) -> Unit,
    onCloseDialog: () -> Unit,
){
    AlertDialog(
        onDismissRequest = {
            onCloseDialog()
        },
        title = {
            Text(
                text = "Filter",
                style = MaterialTheme.typography.h2,
            )
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ){

                // Spacer isn't working for some reason so use Row to create space
                EmptyRow()

                // Hero Filter
                HeroFilterSelector(
                    filterOnHero = {
                        onUpdateHeroFilter(HeroFilter.Hero())
                    },
                    isEnabled = heroFilter is HeroFilter.Hero,
                    order = if(heroFilter is HeroFilter.Hero) heroFilter.order else null,
                    orderDesc = {
                        onUpdateHeroFilter(
                            HeroFilter.Hero(
                                order = SqlFilterOrder.Descending
                            )
                        )
                    },
                    orderAsc = {
                        onUpdateHeroFilter(
                            HeroFilter.Hero(
                                order = SqlFilterOrder.Ascending
                            )
                        )
                    }
                )


                // Pro Win Rate Filter
                ProWinsFilterSelector(
                    filterOnProWins = {
                        onUpdateHeroFilter(
                            HeroFilter.ProWins()
                        )
                    },
                    isEnabled = heroFilter is HeroFilter.ProWins,
                    order = if(heroFilter is HeroFilter.ProWins) heroFilter.order else null,
                    orderDesc = {
                        onUpdateHeroFilter(
                            HeroFilter.ProWins(
                                order = SqlFilterOrder.Descending
                            )
                        )
                    },
                    orderAsc = {
                        onUpdateHeroFilter(
                            HeroFilter.ProWins(
                                order = SqlFilterOrder.Ascending
                            )
                        )
                    },
                )

                // Primary Attribute Filter
                PrimaryAttrFilterSelector(
                    filterOnPrimaryAttr = {
                        onUpdateHeroFilter(HeroFilter.PrimaryAttribute())
                    },
                    isEnabled = heroFilter is HeroFilter.PrimaryAttribute,
                    attribute = if(heroFilter is HeroFilter.PrimaryAttribute) heroFilter.attribute else null,
                    orderStr = {
                        onUpdateHeroFilter(
                            HeroFilter.PrimaryAttribute(
                                attribute = HeroAttribute.Strength
                            )
                        )
                    },
                    orderAgi = {
                        onUpdateHeroFilter(
                            HeroFilter.PrimaryAttribute(
                                attribute = HeroAttribute.Agility
                            )
                        )
                    },
                    orderInt = {
                        onUpdateHeroFilter(
                            HeroFilter.PrimaryAttribute(
                                attribute = HeroAttribute.Intelligence
                            )
                        )
                    },
                )
            }
        },
        buttons = {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Row( // make the icon larger so it's easier to click
                    modifier = Modifier
                        .align(Alignment.End)
                        .clickable {
                            onCloseDialog()
                        }
                    ,
                ){
                    Icon(
                        modifier = Modifier
                            .padding(10.dp)
                        ,
                        imageVector = Icons.Default.Check,
                        contentDescription = "Done",
                        tint = Color(0xFF009a34)
                    )
                }

            }
        }
    )
}

/**
 * @param filterOnPrimaryAttr: Set the HeroFilter to 'PrimaryAttribute'
 * @param isEnabled: Is the PrimaryAttribute filter the selected 'HeroFilter'
 * @param attribute: Is the current attribute Strength, Agility or Intelligence?
 * @param orderStr: Set the order to Strength.
 * @param orderAgi: Set the order to Agility.
 * @param orderInt: Set the order to Intelligence.
 */
@ExperimentalAnimationApi
@Composable
fun PrimaryAttrFilterSelector(
    filterOnPrimaryAttr: () -> Unit,
    isEnabled: Boolean,
    attribute: HeroAttribute? = null,
    orderStr: () -> Unit,
    orderAgi: () -> Unit,
    orderInt: () -> Unit,
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ){
        Row(
            modifier = Modifier
                .padding(bottom = 12.dp)
                .fillMaxWidth()
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null, // disable the highlight
                    enabled = true,
                    onClick = {
                        filterOnPrimaryAttr()
                    },
                )
            ,
        ){
            Checkbox(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .align(Alignment.CenterVertically)
                ,
                checked = isEnabled,
                onCheckedChange = {
                    filterOnPrimaryAttr()
                },
                colors = CheckboxDefaults.colors(MaterialTheme.colors.primary)
            )
            Text(
                text = HeroFilter.PrimaryAttribute().uiValue,
                style = MaterialTheme.typography.h3,
            )
        }

        PrimaryAttrSelector(
            isEnabled = isEnabled,
            isStr = isEnabled && attribute is HeroAttribute.Strength,
            isAgi = isEnabled && attribute is HeroAttribute.Agility,
            isInt = isEnabled && attribute is HeroAttribute.Intelligence,
            onUpdateHeroFilterStr = {
                orderStr()
            },
            onUpdateHeroFilterAgi = {
                orderAgi()
            },
            onUpdateHeroFilterInt = {
                orderInt()
            }
        )
    }
}

/**
 * @param filterOnProWins: Set the HeroFilter to 'ProWins'
 * @param isEnabled: Is the ProWins filter the selected 'HeroFilter'
 * @param order: Ascending or Descending?
 * @param orderDesc: Set the order to descending.
 * @param orderAsc: Set the order to ascending.
 */
@ExperimentalAnimationApi
@Composable
fun ProWinsFilterSelector(
    filterOnProWins: () -> Unit,
    isEnabled: Boolean,
    order: SqlFilterOrder? = null,
    orderDesc: () -> Unit,
    orderAsc: () -> Unit,
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ){
        Row(
            modifier = Modifier
                .padding(bottom = 12.dp)
                .fillMaxWidth()
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null, // disable the highlight
                    enabled = true,
                    onClick = {
                        filterOnProWins()
                    },
                )
            ,
        ){
            Checkbox(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .align(Alignment.CenterVertically)
                ,
                checked = isEnabled,
                onCheckedChange = {
                    filterOnProWins()
                },
                colors = CheckboxDefaults.colors(MaterialTheme.colors.primary)
            )
            Text(
                text = HeroFilter.ProWins().uiValue,
                style = MaterialTheme.typography.h3,
            )
        }

        OrderSelector(
            descString = "100% - 0%",
            ascString = "0% - 100%",
            isEnabled = isEnabled,
            isDescSelected = isEnabled && order is SqlFilterOrder.Descending,
            isAscSelected = isEnabled && order is SqlFilterOrder.Ascending,
            onUpdateHeroFilterDesc = {
                orderDesc()
            },
            onUpdateHeroFilterAsc = {
                orderAsc()
            },
        )
    }
}

/**
 * @param filterOnHero: Set the HeroFilter to 'Hero'
 * @param isEnabled: Is the Hero filter the selected 'HeroFilter'
 * @param order: Ascending or Descending?
 * @param orderDesc: Set the order to descending.
 * @param orderAsc: Set the order to ascending.
 */
@ExperimentalAnimationApi
@Composable
fun HeroFilterSelector(
    filterOnHero: () -> Unit,
    isEnabled: Boolean,
    order: SqlFilterOrder? = null,
    orderDesc: () -> Unit,
    orderAsc: () -> Unit,
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null, // disable the highlight
                    enabled = true,
                    onClick = {
                        filterOnHero()
                    },
                )
            ,
        ){
            Checkbox(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .align(Alignment.CenterVertically)
                ,
                checked = isEnabled,
                onCheckedChange = {
                    filterOnHero()
                },
                colors = CheckboxDefaults.colors(MaterialTheme.colors.primary)
            )
            Text(
                text = HeroFilter.Hero().uiValue,
                style = MaterialTheme.typography.h3,
            )
        }

        OrderSelector(
            descString = "z -> a",
            ascString = "a -> z",
            isEnabled = isEnabled,
            isDescSelected = isEnabled && order is SqlFilterOrder.Descending,
            isAscSelected = isEnabled && order is SqlFilterOrder.Ascending,
            onUpdateHeroFilterDesc = {
                orderDesc()
            },
            onUpdateHeroFilterAsc = {
                orderAsc()
            },
        )
    }
}

/**
 * @param isEnabled: Is this HeroFilter currently the selected HeroFilter?
 * @param isStr: Is the selected attribute strength?
 * @param isAgi: Is the selected attribute Agility?
 * @param isInt: Is the selected attribute Intelligence?
 * @param onUpdateHeroFilterStr: Update the filter to Strength
 * @param onUpdateHeroFilterAgi: Update the filter to Agility
 * @param onUpdateHeroFilterInt: Update the filter to Intelligence
 */
@ExperimentalAnimationApi
@Composable
fun PrimaryAttrSelector(
    isEnabled: Boolean,
    isStr: Boolean = false,
    isAgi: Boolean = false,
    isInt: Boolean = false,
    onUpdateHeroFilterStr: () -> Unit,
    onUpdateHeroFilterAgi: () -> Unit,
    onUpdateHeroFilterInt: () -> Unit,
){
    // Strength
    AnimatedVisibility(visible = isEnabled) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, bottom = 8.dp)
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null, // disable the highlight
                    enabled = isEnabled,
                    onClick = {
                        onUpdateHeroFilterStr()
                    },
                )
            ,
        ){
            Checkbox(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .align(Alignment.CenterVertically)
                ,
                enabled= isEnabled,
                checked = isEnabled && isStr,
                onCheckedChange = {
                    onUpdateHeroFilterStr()
                },
                colors = CheckboxDefaults.colors(MaterialTheme.colors.primary)
            )
            Text(
                text = HeroAttribute.Strength.uiValue,
                style = MaterialTheme.typography.body1,
            )
        }
    }

    // Agility
    AnimatedVisibility(visible = isEnabled) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, bottom = 8.dp)
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null, // disable the highlight
                    enabled = isEnabled,
                    onClick = {
                        onUpdateHeroFilterAgi()
                    },
                )
            ,
        ){
            Checkbox(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .align(Alignment.CenterVertically)
                ,
                enabled= isEnabled,
                checked = isEnabled && isAgi,
                onCheckedChange = {
                    onUpdateHeroFilterAgi()
                },
                colors = CheckboxDefaults.colors(MaterialTheme.colors.primary)
            )
            Text(
                text = HeroAttribute.Agility.uiValue,
                style = MaterialTheme.typography.body1,
            )
        }
    }

    // Intelligence
    AnimatedVisibility(visible = isEnabled) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, bottom = 8.dp)
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null, // disable the highlight
                    enabled = isEnabled,
                    onClick = {
                        onUpdateHeroFilterInt()
                    },
                )
            ,
        ){
            Checkbox(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .align(Alignment.CenterVertically)
                ,
                enabled= isEnabled,
                checked = isEnabled && isInt,
                onCheckedChange = {
                    onUpdateHeroFilterInt()
                },
                colors = CheckboxDefaults.colors(MaterialTheme.colors.primary)
            )
            Text(
                text = HeroAttribute.Intelligence.uiValue,
                style = MaterialTheme.typography.body1,
            )
        }
    }
}

/**
 * @param descString: String displayed in the "descending" checkbox
 * @param ascString: String displayed in the "ascending" checkbox
 * @param isEnabled: Is this HeroFilter currently the selected HeroFilter?
 * @param isDescSelected: Is the "descending" checkbox selected?
 * @param isAscSelected: Is the "ascending" checkbox selected?
 * @param onUpdateHeroFilterDesc: Set the filter to Descending.
 * @param onUpdateHeroFilterAsc: Set the filter to Ascending.
 */
@ExperimentalAnimationApi
@Composable
fun OrderSelector(
    descString: String,
    ascString: String,
    isEnabled: Boolean,
    isDescSelected: Boolean,
    isAscSelected: Boolean,
    onUpdateHeroFilterDesc: () -> Unit,
    onUpdateHeroFilterAsc: () -> Unit,
){
    // Descending Order
    AnimatedVisibility(visible = isEnabled) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, bottom = 8.dp)
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null, // disable the highlight
                    enabled = isEnabled,
                    onClick = {
                        onUpdateHeroFilterDesc()
                    },
                )
            ,
        ){
            Checkbox(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .align(Alignment.CenterVertically)
                ,
                enabled= isEnabled,
                checked = isEnabled && isDescSelected,
                onCheckedChange = {
                    onUpdateHeroFilterDesc()
                },
                colors = CheckboxDefaults.colors(MaterialTheme.colors.primary)
            )
            Text(
                text = descString,
                style = MaterialTheme.typography.body1,
            )
        }
    }

    // Ascending Order
    AnimatedVisibility(visible = isEnabled) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, bottom = 8.dp)
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null, // disable the highlight
                    enabled = isEnabled,
                    onClick = {
                        onUpdateHeroFilterAsc()
                    },
                )
            ,
        ){
            Checkbox(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .align(Alignment.CenterVertically)
                ,
                enabled= isEnabled,
                checked = isEnabled && isAscSelected,
                onCheckedChange = {
                    onUpdateHeroFilterAsc()
                },
                colors = CheckboxDefaults.colors(MaterialTheme.colors.primary)
            )
            Text(
                text = ascString,
                style = MaterialTheme.typography.body1,
            )
        }
    }
}

@Composable
fun EmptyRow(){
    Row(
        modifier = Modifier
            .padding(bottom = 0.dp)
            .fillMaxWidth()
        ,
    ){
        Text(
            text = "",
            style = MaterialTheme.typography.h4,
        )
    }
}















