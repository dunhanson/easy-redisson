package site.dunhanson.redisson.utils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author dunhanson
 * @date 2020.03.20
 * @description Redisson工具类
 */
@Data
@Slf4j
public class RedissonUtils {
    private static final Config config = getConfig();
    private static final RedissonClient client = Redisson.create(config);

    /**
     * Config
     * @return
     */
    private static Config getConfig() {
        try (InputStream input = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("redisson.yaml")){
            return Config.fromYAML(input);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    /**
     * RedissonClient
     * @return
     */
    public static RedissonClient getRedisClient() {
        return RedissonUtils.client;
    }

}
