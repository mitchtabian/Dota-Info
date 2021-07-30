package com.codingwithmitch.ui_herodetail.ui

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberImagePainter
import com.codingwithmitch.hero_domain.Hero
import com.codingwithmitch.hero_domain.maxAttackDmg
import com.codingwithmitch.hero_domain.minAttackDmg
import com.codingwithmitch.ui_herodetail.R
import kotlin.math.round

@Composable
fun HeroDetail(
    state: HeroDetailState,
    imageLoader: ImageLoader,
) {
    state.hero?.let{ hero ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ) {
            item {
                Column {
                    val painter = rememberImagePainter(
                        hero.img,
                        imageLoader = imageLoader,
                        builder = {
                            placeholder(if (isSystemInDarkTheme()) R.drawable.black_background else R.drawable.white_background)
                        }
                    )
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .defaultMinSize(minHeight = 200.dp),
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
                                .padding(bottom = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .padding(end = 8.dp),
                                text = hero.localizedName,
                                style = MaterialTheme.typography.h1,
                            )
                            val iconPainter = rememberImagePainter(
                                hero.icon,
                                imageLoader = imageLoader,
                                builder = {
                                    placeholder(if (isSystemInDarkTheme()) R.drawable.black_background else R.drawable.white_background)
                                }
                            )
                            Image(
                                modifier = Modifier
                                    .height(30.dp)
                                    .width(30.dp)
                                    .align(Alignment.CenterVertically),
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
                            padding = 10.dp,
                        )
                        // TODO(Hero Win %'s)
                    }
                }
            }
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