package com.github.fhaustt.yggdrasil.ai

import com.badlogic.gdx.ai.btree.LeafTask
import com.badlogic.gdx.ai.btree.Task

abstract class Condition : LeafTask<AiEntity>() {
    val entity: AiEntity
        get() = `object`


    abstract fun condition():Boolean

    override fun execute(): Status {
        return when{
            condition() -> Status.SUCCEEDED
            else -> Status.FAILED
        }

    }
    override fun copyTo(task: Task<AiEntity>) = task
}

class CanAttack: Condition(){
    override fun condition()= entity.canAttack()


}

class IsEnemyNearby:Condition(){
    override fun condition(): Boolean {
        return entity.hasEnemyNearby()
    }
}