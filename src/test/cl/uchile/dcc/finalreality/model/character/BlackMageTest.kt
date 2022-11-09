package cl.uchile.dcc.finalreality.model.character

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.haveSameHashCodeAs
import io.kotest.matchers.types.shouldBeSameInstanceAs
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import java.util.concurrent.LinkedBlockingQueue

lateinit var blackmage1: BlackMage
lateinit var blackmage2: BlackMage
lateinit var queue: LinkedBlockingQueue<GameCharacter>

class BlackMageTest : FunSpec({

    beforeEach{
        queue = LinkedBlockingQueue<GameCharacter>()

        blackmage1 = BlackMage(
            "magonegro",
            100,
            100,
            20,
            queue
            )
        blackmage2 = BlackMage(
            "negromago",
            100,
            200,
            10,
            queue
            )
    }
    test("A BlackMage should should be equal to itself") {
        blackmage1 shouldBeSameInstanceAs blackmage1
        blackmage1 shouldBe blackmage1
    }

    test("Two BlackMages should be equal if their stats and name are the same") {
        val blackmage3 = BlackMage(
            "magonegro",
            100,
            100,
            20,
            queue
        )
        blackmage1 shouldNotBeSameInstanceAs blackmage3
        blackmage1 shouldBe blackmage3
    }

    test("Two BlackMages should be different if they have different stats or names") {
        blackmage1 shouldNotBe blackmage2
    }

    test("Two BlackMages with same stats and name should have the same hash code") {
        val blackmage3 = BlackMage(
            "magonegro",
            100,
            100,
            20,
            queue
        )
        blackmage1 should haveSameHashCodeAs(blackmage3)
    }

    test("The string representation of a blackmage should be correct") {
        "$blackmage1" shouldBe "BlackMage { name: magonegro, maxHp: 100, currentHP: 100," +
            " maxMp: 100, currentMP: 100, defense: 20 } "
    }
})