import spock.lang.Specification
import spock.lang.Unroll

class AppSpockTest extends Specification {

    @Unroll
    def "#sum 1+1"() {
        setup:
        def int a = 1 + 2

        expect:
        a == 2
    }

}

