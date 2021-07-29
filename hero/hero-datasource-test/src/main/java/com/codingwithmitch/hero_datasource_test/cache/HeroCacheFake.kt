package com.codingwithmitch.hero_datasource_test.cache

import com.codingwithmitch.hero_datasource.cache.HeroCache
import com.codingwithmitch.hero_domain.Hero
import com.codingwithmitch.hero_domain.HeroRole

class HeroCacheFake(
    private val db: HeroDatabaseFake
) : HeroCache {

    override suspend fun getHero(id: Int): Hero? {
        return db.heros.find { it.id == id }
    }

    override suspend fun removeHero(id: Int) {
        db.heros.removeIf { it.id == id }
    }

    override suspend fun selectAll(): List<Hero> {
        return db.heros
    }

    override suspend fun insert(hero: Hero) {
        if(db.heros.isNotEmpty()){
            var didInsert = false
            for(h in db.heros){
                if(h.id == hero.id){
                    db.heros.remove(h)
                    db.heros.add(hero)
                    didInsert = true
                    break
                }
            }
            if(!didInsert){
                db.heros.add(hero)
            }
        }
        else{
            db.heros.add(hero)
        }
    }

    override suspend fun insert(heros: List<Hero>) {
        if(db.heros.isNotEmpty()){
            for(hero in heros){
                if(db.heros.contains(hero)){
                    db.heros.remove(hero)
                    db.heros.add(hero)
                }
            }
        }
        else{
            db.heros.addAll(heros)
        }
    }

    override suspend fun searchByName(localizedName: String): List<Hero> {
        return db.heros.find { it.localizedName == localizedName }?.let {
            listOf(it)
        }?: listOf()
    }

    override suspend fun searchByAttr(primaryAttr: String): List<Hero> {
        return db.heros.filter { it.primaryAttribute.uiValue == primaryAttr }
    }

    override suspend fun searchByAttackType(attackType: String): List<Hero> {
        return db.heros.filter { it.attackType.uiValue == attackType }
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
        val heros: MutableList<Hero> = mutableListOf()
        if(carry){
            heros.addAll(db.heros.filter { it.roles.contains(HeroRole.Carry) })
        }
        if(escape){
            heros.addAll(db.heros.filter { it.roles.contains(HeroRole.Escape) })
        }
        if(nuker){
            heros.addAll(db.heros.filter { it.roles.contains(HeroRole.Nuker) })
        }
        if(initiator){
            heros.addAll(db.heros.filter { it.roles.contains(HeroRole.Initiator) })
        }
        if(durable){
            heros.addAll(db.heros.filter { it.roles.contains(HeroRole.Durable) })
        }
        if(disabler){
            heros.addAll(db.heros.filter { it.roles.contains(HeroRole.Disabler) })
        }
        if(jungler){
            heros.addAll(db.heros.filter { it.roles.contains(HeroRole.Jungler) })
        }
        if(support){
            heros.addAll(db.heros.filter { it.roles.contains(HeroRole.Support) })
        }
        if(pusher){
            heros.addAll(db.heros.filter { it.roles.contains(HeroRole.Pusher) })
        }
        return heros.distinctBy { it.id }
    }
}













