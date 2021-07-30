package com.codingwithmitch.ui_herodetail.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberImagePainter
import com.codingwithmitch.ui_herodetail.R

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
                        // TODO(Hero Stats)
                        // TODO(Hero Win %'s)
                    }
                }
            }
        }
    }
}