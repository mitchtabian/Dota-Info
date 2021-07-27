package com.codingwithmitch.dotainfo.hero_interactors.datasource.network

sealed class HeroServiceResponseType{

    object EmptyList: HeroServiceResponseType()

    object MalformedData: HeroServiceResponseType()

    object GoodData: HeroServiceResponseType()

    object Http404: HeroServiceResponseType()
}
