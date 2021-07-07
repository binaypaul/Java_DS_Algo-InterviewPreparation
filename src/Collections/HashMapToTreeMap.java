package Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class HashMapToTreeMap {

	public static void main(String[] args) {
		Map<Integer, String> hashMap = new HashMap<Integer, String>() {{
			put(1, "one");
			put(2, "two");
			put(3, "three");
		}};
	}
}

class HashMapToTreeMapConverter {
	public <K, V> TreeMap<K, V> convert(HashMap<K, V> hashMap) {
		TreeMap<K, V> treeMap = hashMap.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue(), (oldValue, newValue)->newValue, TreeMap::new));
		return treeMap;
	}
}