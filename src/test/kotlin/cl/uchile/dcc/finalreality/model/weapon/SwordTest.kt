package cl.uchile.dcc.finalreality.model.weapon

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.haveSameHashCodeAs
import io.kotest.matchers.types.shouldBeSameInstanceAs
import io.kotest.matchers.types.shouldNotBeSameInstanceAs

class SwordTest : FunSpec(
    {
        lateinit var espada1: Sword
        lateinit var espada2: Sword
        beforeEach {
            espada1 = Sword(
                "espada1",
                20,
                10
            )
            espada2 = Sword(
                "espada2",
                50,
                25
            )
        }
        test("An Sword should be equal to itself") {
            espada1 shouldBeSameInstanceAs espada1
            espada1 shouldBe espada1
        }

        test("Two Swords should be equal if their stats and their names are the same") {
            val espada3 = Sword(
                "espada1",
                20,
                10
            )
            espada1 shouldNotBeSameInstanceAs espada3
            espada1 shouldBe espada3
            espada1 should haveSameHashCodeAs(espada3)
        }

        test("Two Swords should be different if their stats are different") {
            espada1 shouldNotBe espada2
        }

        test("The string representation should be correct") {
            "$espada1" shouldBe "Sword { name: espada1, damage: 20, weight: 10 }"
        }
    })
