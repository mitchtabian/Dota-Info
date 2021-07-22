package com.codingwithmitch.ui_herodetail.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.codingwithmitch.components.DefaultScreenUI
import com.codingwithmitch.dotainfo.hero_domain.Hero
import com.codingwithmitch.dotainfo.hero_domain.maxAttackDmg
import com.codingwithmitch.dotainfo.hero_domain.minAttackDmg
import com.codingwithmitch.ui_herodetail.R
import kotlin.math.round

@ExperimentalAnimationApi
@Composable
fun HeroDetail(
    state: HeroDetailState,
    events: (HeroDetailEvents) -> Unit,
){
    DefaultScreenUI(
        queue = state.errorQueue,
        onRemoveHeadFromQueue = {
            events(HeroDetailEvents.OnRemoveHeadFromQueue)
        },
        progressBarState = state.progressBarState,
    ) {
        state.hero?.let { hero ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colors.background)
                    ){
                        val painter = rememberImagePainter(
                            hero.img,
                            builder = {
                                placeholder(if(isSystemInDarkTheme()) R.drawable.black_background else R.drawable.white_background)
                                error(R.drawable.error_image)
                                fadeIn()
                            }
                        )
                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .defaultMinSize(minHeight = 200.dp)
                            ,
                            painter = painter,
                            contentDescription = hero.localizedName,
                            contentScale = ContentScale.Crop,
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(12.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp)
                                ,
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ){
                                Text(
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
                                        .padding(end = 8.dp)
                                    ,
                                    text = hero.localizedName,
                                    style = MaterialTheme.typography.h1,
                                )
                                val iconPainter = rememberImagePainter(
                                    hero.icon,
                                    builder = {
                                        placeholder(if(isSystemInDarkTheme()) R.drawable.black_background else R.drawable.white_background)
                                        error(R.drawable.error_image)
                                        fadeIn()
                                    }
                                )
                                Image(
                                    modifier = Modifier
                                        .height(30.dp)
                                        .width(30.dp)
                                        .align(Alignment.CenterVertically)
                                    ,
                                    painter = iconPainter,
                                    contentDescription = hero.localizedName,
                                    contentScale = ContentScale.Crop,
                                )
                            }
                            Text(
                                modifier = Modifier
                                    .padding(bottom = 4.dp),
                                text = hero.primaryAttribute.uiValue,
                                style = MaterialTheme.typography.subtitle1,
                            )
                            Text(
                                modifier = Modifier
                                    .padding(bottom = 12.dp),
                                text = hero.attackType.uiValue,
                                style = MaterialTheme.typography.caption,
                            )
                            HeroBaseStats(
                                hero = hero,
                                padding = 10.dp
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            WinPercentages(hero = hero,)
                        }
                    }
                }
            }
        }
    }
}

/**
 * Displays Pro wins % and Turbo wins %
 */
@Composable
fun WinPercentages(
    hero: Hero,
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ){
        // Pro Win %
        Column(
            modifier = Modifier.fillMaxWidth(.5f),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Text(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .align(Alignment.CenterHorizontally)
                ,
                text = "Pro Wins",
                style = MaterialTheme.typography.h2,
            )
            val proWinPercentage = remember {round(hero.proWins.toDouble() / hero.proPick.toDouble() * 100).toInt()}
            Text(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .align(Alignment.CenterHorizontally)
                ,
                text = "${proWinPercentage} %",
                style = MaterialTheme.typography.h2,
                color = if(proWinPercentage > 50) Color(0xFF009a34) else MaterialTheme.colors.error
            )
        }
        // Turbo win %
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Text(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .align(Alignment.CenterHorizontally)
                ,
                text = "Turbo Wins",
                style = MaterialTheme.typography.h2,
            )
            val turboWinPercentage = remember {round(hero.turboWins.toDouble() / hero.turboPicks.toDouble() * 100).toInt()}
            Text(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .align(Alignment.CenterHorizontally)
                ,
                text = "${turboWinPercentage} %",
                style = MaterialTheme.typography.h2,
                color = if(turboWinPercentage > 50) Color(0xFF009a34) else MaterialTheme.colors.error
            )
        }
    }
}

@Composable
fun HeroBaseStats(
    hero: Hero,
    padding: Dp,
){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
    ,
        elevation = 8.dp,
        shape = MaterialTheme.shapes.medium
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
            ,
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
                ,
                text = "Base Stats",
                style = MaterialTheme.typography.h4,
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(end = 20.dp)
                ){ // Str, Agi, Int, Health
                    Row( // STR
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                        ,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            text = "${stringResource(R.string.strength)}:",
                            style = MaterialTheme.typography.body2,
                        )
                        Row {
                            Text(
                                text = "${hero.baseStr}",
                                style = MaterialTheme.typography.body2,
                            )
                            Text(
                                text = " + ${hero.strGain}",
                                style = MaterialTheme.typography.caption,
                            )
                        }
                    }
                    Row( // AGI
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                        ,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            text = "${stringResource(R.string.agility)}:",
                            style = MaterialTheme.typography.body2,
                        )
                        Row{
                            Text(
                                text = "${hero.baseAgi}",
                                style = MaterialTheme.typography.body2,
                            )
                            Text(
                                text = " + ${hero.agiGain}",
                                style = MaterialTheme.typography.caption,
                            )
                        }
                    }
                    Row( // INT
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                        ,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            text = "${stringResource(R.string.intelligence)}:",
                            style = MaterialTheme.typography.body2,
                        )
                        Row{
                            Text(
                                text = "${hero.baseInt}",
                                style = MaterialTheme.typography.body2,
                            )
                            Text(
                                text = " + ${hero.intGain}",
                                style = MaterialTheme.typography.caption,
                            )
                        }
                    }
                    Row( // HP
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                        ,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            text = "${stringResource(R.string.health)}:",
                            style = MaterialTheme.typography.body2,
                        )
                        val health = remember{round(hero.baseHealth + hero.baseStr * 20).toInt()}
                        Text(
                            text = "${health}",
                            style = MaterialTheme.typography.body2,
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ){ // Atk Range, proj speed, move speed, atk dmg
                    Row( // Atk Range
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                            ,
                            text = "${stringResource(R.string.attack_range)}:",
                            style = MaterialTheme.typography.body2,
                        )
                        Text(
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                            ,
                            text = "${hero.attackRange}",
                            style = MaterialTheme.typography.body2,
                        )
                    }
                    Row( // projectile speed
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                            ,
                            text = "${stringResource(R.string.projectile_speed)}:",
                            style = MaterialTheme.typography.body2,
                        )
                        Text(
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                            ,
                            text = "${hero.projectileSpeed}",
                            style = MaterialTheme.typography.body2,
                        )
                    }
                    Row( // Move speed
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                            ,
                            text = "${stringResource(R.string.move_speed)}:",
                            style = MaterialTheme.typography.body2,
                        )
                        Text(
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                            ,
                            text = "${hero.moveSpeed}",
                            style = MaterialTheme.typography.body2,
                        )
                    }
                    Row( // Attack damage
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                            ,
                            text = "${stringResource(R.string.attack_dmg)}:",
                            style = MaterialTheme.typography.body2,
                        )
                        val atkMin = remember{hero.minAttackDmg()}
                        val atkMax = remember{hero.maxAttackDmg()}
                        Text(
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                            ,
                            text = "${atkMin} - ${atkMax}",
                            style = MaterialTheme.typography.body2,
                        )
                    }
                }
            }
        }

    }
}












