import org.junit.Test;
import org.junit.runner.RunWith;
import org.machina.App;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author alopez@wombatsecurity.com on 1/26/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class AppTests {

    private static Logger log = LoggerFactory.getLogger(AppTests.class);

    @Test
    public void testConfiguration(){
        log.info("testConfiguration::");
    }
}
