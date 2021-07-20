package com.codingwithmitch.dotainfo.hero_interactors

import com.codingwithmitch.dotainfo.hero_datasource.cache.HeroCache
import com.codingwithmitch.dotainfo.hero_datasource.network.HeroService

class GetHeros(
    private val cache: HeroCache,
    private val service: HeroService,
) {

}
