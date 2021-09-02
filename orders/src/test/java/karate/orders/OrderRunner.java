package karate.orders;

import com.intuit.karate.junit5.Karate;

class OrderRunner {

    @Karate.Test
    Karate testAll() {
        return Karate.run().relativeTo(getClass());
    }
}