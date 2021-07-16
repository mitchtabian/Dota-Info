package com.codingwithmitch.dotainfo.herosPresentation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.codingwithmitch.dotainfo.herosBusiness.HeroData

@Composable
fun HeroScreen(){
    Text(HeroData().name())
}