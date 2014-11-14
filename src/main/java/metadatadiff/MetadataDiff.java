package metadatadiff;

import java.util.Map;

public class MetadataDiff {

	Map<String, Integer> a;
	Map<String, Integer> b;
	Map<String, Integer> c;
	Map<Integer, String> d;

	public MetadataDiff(Map<String, Integer> a,
			Map<String, Integer> b, Map<String, Integer> c,
			Map<Integer, String> d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;

	}
}
