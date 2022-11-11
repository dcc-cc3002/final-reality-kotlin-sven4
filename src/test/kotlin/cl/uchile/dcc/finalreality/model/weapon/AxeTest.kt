package cl.uchile.dcc.finalreality.model.weapon

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.haveSameHashCodeAs
import io.kotest.matchers.types.shouldBeSameInstanceAs
import io.kotest.matchers.types.shouldNotBeSameInstanceAs

class AxeTest : FunSpec(
    {
        lateinit var hacha1: Axe
        lateinit var hacha2: Axe
        beforeEach {
            hacha1 = Axe(
                "hacha1",
                20,
                10
            )
            hacha2 = Axe(
                "hacha2",
                50,
                25
            )
        }
        test("An Axe should be equal to itself") {
            hacha1 shouldBeSameInstanceAs hacha1
            hacha1 shouldBe hacha1
        }

        test("Two Axes should be equal if their stats and their names are the same") {
            val hacha3 = Axe(
                "hacha1",
                20,
                10
            )
            hacha1 shouldNotBeSameInstanceAs hacha3
            hacha1 shouldBe hacha3
            hacha1 should haveSameHashCodeAs(hacha3)
        }

        test("Two Axes should be different if their stats are different") {
            hacha1 shouldNotBe hacha2
        }

        test("The string representation should be correct") {
            "$hacha1" shouldBe "Axe { name: hacha1, damage: 20, weight: 10 }"
        }
    })
