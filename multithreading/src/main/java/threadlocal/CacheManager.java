package threadlocal;


import java.util.HashMap;
import java.util.Map;

// This class maintains a Cache per thread.
public class CacheManager {
    private static ThreadLocal<Map<String,Object>> tlocal = new ThreadLocal<Map<String,Object>> () {
        @Override
        protected Map<String,Object> initialValue() {
            // Create a new cache for first time thread.
            return new HashMap<>();
        }
    };

    public static Object get(String key) {
        // Returns the Cache for current thread.
        Map<String,Object> cache = tlocal.get();
        return cache.get(key);
    }

    public static Object put(String key,Object o) {
        // Returns the Cache for current thread.
        Map<String,Object> cache = tlocal.get();
        return cache.put(key,o);
    }
}