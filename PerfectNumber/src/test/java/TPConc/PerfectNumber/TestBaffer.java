package TPConc.PerfectNumber;

import org.junit.Before;
import org.junit.Test;

import Buffer.Buffer;
import Buffer.Consumidor;
import Buffer.Productor;

public class TestBaffer{
	
	private Buffer b;
	private Productor p;
	private Consumidor c;
	private Consumidor cc2;
	private Consumidor cc3;
	private Consumidor cc4;
	private Consumidor cc5;
	
	@Before
	public void setUp(){
		b = new Buffer(2,1);
		p = new Productor(b);
		c = new Consumidor(b);
		cc2 = new Consumidor(b);
		cc3 = new Consumidor(b);
		cc4 = new Consumidor(b);
		cc5 = new Consumidor(b);
				
		
	}
	
	@Test
	public void testBuffer() {
		Thread c1 = new Thread(c);
		Thread c2 = new Thread(cc2);
		Thread c3 = new Thread(cc3);
		Thread c4 = new Thread(cc4);
		Thread c5 = new Thread(cc5);

		Thread p1 = new Thread(p);
		
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
		p1.start();
	}
	
}
