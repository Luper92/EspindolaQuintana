package TPConc.PerfectNumber;

import org.junit.Before;
import org.junit.Test;

import Barrier.Barrier;
import Barrier.Thread1;
import Barrier.Thread2;
import Barrier.Thread3;


public class TestBarrier {
	
	private Barrier miBarrera;
	private Thread t1;
	private Thread t2;
	private Thread t3;
	
	@Before
	public void setUp(){
		miBarrera = new Barrier(3);
		
		t1 = new Thread(new Thread1(miBarrera));
		t2 = new Thread(new Thread2(miBarrera));
		t3 = new Thread(new Thread3(miBarrera));
	}
	
	@Test
	public void testBarrier() {	
		t1.start();
		t2.start();
		t3.start();
	}

}
