package ThreadSafeCache.ByHashMap;

public class CacheObject {
	
    public long lastAccessed = System.currentTimeMillis();
    public String value;
    
    protected CacheObject(String value) {
        this.value = value;
    }

}
