import org.junit.Test;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import site.dunhanson.redisson.utils.RedissonUtils;
import java.util.concurrent.TimeUnit;

public class RedissonTest {
    @Test
    public void redisson() {
        RedissonClient client = RedissonUtils.getRedisClient();
        RLock lock = client.getLock("test");
        lock.lock(1, TimeUnit.SECONDS);
        //do something
        lock.unlock();
    }
}
