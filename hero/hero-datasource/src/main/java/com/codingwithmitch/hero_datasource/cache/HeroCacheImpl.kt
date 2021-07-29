package com.codingwithmitch.hero_datasource.cache

import com.codingwithmitch.hero_datasource.cache.model.toHero
import com.codingwithmitch.hero_domain.Hero
import com.codingwithmitch.hero_domain.HeroRole
import com.codingwithmitch.herodatasource.cache.HeroDbQueries


class HeroCacheImpl(
    private val heroDatabase: HeroDatabase,
): HeroCache {

    private var queries: HeroDbQueries = heroDatabase.heroDbQueries

    override suspend fun getHero(id: Int): Hero {
        return queries.getHero(id.toLong()).executeAsOne().toHero()
    }

    override suspend fun removeHero(id: Int) {
        queries.removeHero(id.toLong())
    }

    override suspend fun selectAll(): List<Hero> {
        return queries.selectAll().executeAsList().map { it.toHero() }
    }

    override suspend fun insert(hero: Hero) {
        return hero.run {
            queries.insertHero(
                id = id.toLong(),
                localizedName = localizedName,
                primaryAttribute = primaryAttribute.abbreviation,
                attackType = attackType.uiValue,
                roleCarry = if(roles.contains(HeroRole.Carry)) 1L else 0L,
                roleEscape = if(roles.contains(HeroRole.Escape)) 1L else 0L,
                roleNuker = if(roles.contains(HeroRole.Nuker)) 1L else 0L,
                roleInitiator = if(roles.contains(HeroRole.Initiator)) 1L else 0L,
                roleDurable = if(roles.contains(HeroRole.Durable)) 1L else 0L,
                roleDisabler = if(roles.contains(HeroRole.Disabler)) 1L else 0L,
                roleJungler = if(roles.contains(HeroRole.Jungler)) 1L else 0L,
                roleSupport = if(roles.contains(HeroRole.Support)) 1L else 0L,
                rolePusher = if(roles.contains(HeroRole.Pusher)) 1L else 0L,
                img = img,
                icon = icon,
                baseHealth = baseHealth.toDouble(),
                baseHealthRegen = baseHealthRegen?.toDouble(),
                baseMana = baseMana.toDouble(),
                baseManaRegen = baseManaRegen?.toDouble(),
                baseArmor = baseArmor.toDouble(),
                baseMoveRate = baseMoveRate.toDouble(),
                baseAttackMin = baseAttackMin.toDouble(),
                baseAttackMax = baseAttackMax.toDouble(),
                baseStr = baseStr.toLong(),
                baseAgi = baseAgi.toLong(),
                baseInt = baseInt.toLong(),
                strGain = strGain.toDouble(),
                agiGain = agiGain.toDouble(),
                intGain = intGain.toDouble(),
                attackRange = attackRange.toLong(),
                projectileSpeed = projectileSpeed.toLong(),
                attackRate = attackRate.toDouble(),
                moveSpeed = moveSpeed.toLong(),
                turnRate = turnRate?.toDouble(),
                legs = legs.toLong(),
                turboPicks = turboPicks.toLong(),
                turboWins = turboWins.toLong(),
                proWins = proWins.toLong(),
                proPick = proPick.toLong(),
                firstPick = firstPick.toLong(),
                firstWin = firstWin.toLong(),
                secondPick = secondPick.toLong(),
                secondWin = secondWin.toLong(),
                thirdPick = thirdPick.toLong(),
                thirdWin = thirdWin.toLong(),
                fourthPick = fourthPick.toLong(),
                fourthWin = fourthWin.toLong(),
                fifthPick = fifthPick.toLong(),
                fifthWin = fifthWin.toLong(),
                sixthPick = sixthPick.toLong(),
                sixthWin = sixthWin.toLong(),
                seventhPick = seventhPick.toLong(),
                seventhWin = seventhWin.toLong(),
                eighthWin = eighthWin.toLong(),
                eighthPick = eighthPick.toLong(),
            )
        }
    }

    override suspend fun insert(heros: List<Hero>) {
        for(hero in heros){
            try { insert(hero) }catch (e: Exception){
                e.printStackTrace()
                // if one has an error just continue with others
            }
        }
    }

    override suspend fun searchByName(localizedName: String): List<Hero> {
        return queries.searchHeroByName(localizedName).executeAsList().map { it.toHero() }
    }

    override suspend fun searchByAttr(primaryAttr: String): List<Hero> {
        return queries.searchHeroByAttr(primaryAttr).executeAsList().map { it.toHero() }
    }

    override suspend fun searchByAttackType(attackType: String): List<Hero> {
        return queries.searchHeroByAttackType(attackType).executeAsList().map { it.toHero() }
    }

    override suspend fun searchByRole(
        carry: Boolean,
        escape: Boolean,
        nuker: Boolean,
        initiator: Boolean,
        durable: Boolean,
        disabler: Boolean,
        jungler: Boolean,
        support: Boolean,
        pusher: Boolean
    ): List<Hero> {
        return queries.searchHeroByRole(
            roleCarry = if(carry) 1L else 0L,
            roleEscape = if(escape) 1L else 0L,
            roleNuker = if(nuker) 1L else 0L,
            roleInitiator = if(initiator) 1L else 0L,
            roleDurable = if(durable) 1L else 0L,
            roleDisabler = if(disabler) 1L else 0L,
            roleJungler = if(jungler) 1L else 0L,
            roleSupport = if(support) 1L else 0L,
            rolePusher = if(pusher) 1L else 0L,
        ).executeAsList().map { it.toHero() }
    }
}

