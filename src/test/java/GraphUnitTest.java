import java.io.IOException;

import org.junit.*;
import static org.junit.Assert.*;
import com.medina.toolbox.graphs.Graph;


public class GraphUnitTest  {

	private static Graph g;
	private static String fileName = "data/graph01.txt";
	
	@BeforeClass	
	public static void oneTimeSetUp() {
		g = new Graph(100, false);
		try {
			g.readFromFile(fileName);
		} catch (IOException e) {
			e.printStackTrace();
			assertEquals(true, false);
		}
	}
	
}
