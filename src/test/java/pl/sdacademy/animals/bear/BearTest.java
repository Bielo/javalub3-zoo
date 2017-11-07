package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;


class BearTest {

    @Test
    void bearShouldBeAliveIfHasEatenWithin10Days() {
        Bear bear = new BlackBear(1);
        bear.eat(0);

       assertThat(bear.isAlive()).isTrue();
    }
    @Test
    void feedingBearShouldSetTheDateOfTheLastMealForNow(){
        Bear bear = new BlackBear(1);

        DateTime result = bear.getLastMealTime();

        assertTrue(new Duration(result, DateTime.now()).isShorterThan(Duration.standardSeconds(1)));
    }

    @Test
    void bearShouldNotBeAliveIfItHasNotEatenForMoreThan10Days(){
        Bear bear = new BlackBear(1, new TestClock());

        assertThat(bear.isAlive()).isTrue();

    }
    @Test
    void afterEating(){
        Bear bear = new BlackBear(1);
        bear.eat(4);

        assertThat(bear.getWeight() == 5).isTrue();
    }

    @Test
    void afterdrinking(){
        Bear bear = new BlackBear(1);
        bear.drink(1);

        assertThat(bear.getWeight() == 1.75).isTrue();
    }

    @Test
    void afterpooping(){
        Bear bear = new BlackBear(1);
        bear.poop();

        assertThat(bear.getWeight() == 0.95).isTrue();
    }

    @Test
    void hibernatingTimeForBlackBear(){
        Bear bear = new BlackBear(1);
        bear.isHibernating();

        assertThat()

    }

}
