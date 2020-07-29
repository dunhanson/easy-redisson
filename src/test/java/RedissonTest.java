import org.junit.Test;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import site.dunhanson.redisson.utils.RedissonUtils;
import java.util.concurrent.TimeUnit;

public class RedissonTest {
    @Test
    public void start1() {
        RedissonClient client = RedissonUtils.getRedisClient();
        RLock lock = client.getLock("test");
        lock.lock(1, TimeUnit.SECONDS);
        // do something
        lock.unlock();
    }

    @Test
    public void start2() {
        RedissonClient client = RedissonUtils.getRedisClient();
        RLock lock = client.getLock("test");
        try {
            boolean tryLock = lock.tryLock(3, 10, TimeUnit.SECONDS);
            if(tryLock) {
                // yes do something
            } else {
                // no do something
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
