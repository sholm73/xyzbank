package suits;

import customerTest.CustomerTest;
import loginTest.LoginTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTest.class,
        CustomerTest.class
})

public class Smoke {

}
