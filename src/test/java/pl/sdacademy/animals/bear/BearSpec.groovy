package pl.sdacademy.animals.bear

import org.joda.time.DateTime
import org.joda.time.Duration
import pl.sdacademy.clock.Clock
import spock.lang.Specification


class BearSpec extends Specification {

    def "Bear should be alive if has eaten within 10 days"() {
        given:
        Bear bear = testBear
        bear.eat()

        when:
        def result = bear.isAlive()

        then:
        result == true

        where:
        testBear << [new BlackBear(5), new PolarBear(20)]
    }

    def "Feeding bear should set the date of the last meal for now"() {
        given:
        Bear bear = new BlackBear(1)
        bear.eat()

        when:
        def result = bear.getLastMealTime()

        then:
        new Duration(result, DateTime.now()).isShorterThan(Duration.standardSeconds(1))
    }

    def "Bear should not be alive if it has not eaten for more than 10 days"() {
        given:
        Bear bear = new BlackBear(1, new TestClock())

        when:
        def result = bear.isAlive()

        then:
        result == false
    }

    def "Bear ate something"(){
        given:
        Bear bear = new BlackBear(1)
        bear.eat(4)

        when:
        def result=bear.getWeight()

        then:
        result == 5
    }

    def "Bear drunk somtething"(){
        given:
        Bear bear = new BlackBear(1)
        bear.drink(1)

        when:
        def result=bear.getWeight()

        then:
        result == 1.75
    }

    def "Bear after pooping"(){
        given:
        Bear bear = new BlackBear(1)
        bear.poop()

        when:
        def result =bear.getWeight()

        then:
        result == 0.95
    }

}
