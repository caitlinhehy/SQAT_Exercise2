import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void test_f() {
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)");	
		assertEquals("(0,2,N)",explorer.executeCommand("ff"));
	}
	
	@Test
	public void test_b() {
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)");	
		assertEquals("(0,0,N)",explorer.executeCommand("fb"));
	}
	
	@Test
	public void test_l() {
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)");	
		assertEquals("(0,0,W)",explorer.executeCommand("l"));
	}
	
	@Test
	public void test_r() {
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)");	
		assertEquals("(0,0,E)",explorer.executeCommand("r"));
	}
	
	@Test
	public void test_PrimaryCombo() {
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)");	
		assertEquals("(1,2,E)",explorer.executeCommand("ffrf"));
	}
	
	@Test
	public void test_pos_yBelow0() {
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)");	
		assertEquals("(0,99,N)",explorer.executeCommand("b"));
	}
	
	@Test
	public void test_pos_xBelow0() {
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)");	
		assertEquals("(99,0,W)",explorer.executeCommand("lf"));
	}
	
	@Test
	public void test_N_obstacles() {
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(0,1)");	
		assertEquals("(0,0,N)",explorer.executeCommand("f"));
	}
	
	@Test
	public void test_E_obstacles() {
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(1,0)");	
		assertEquals("(0,0,E)",explorer.executeCommand("rf"));
	}
	
	@Test
	public void test_S_obstacles() {
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(0,99)");	
		assertEquals("(0,0,S)",explorer.executeCommand("rrf"));
	}
	
}
