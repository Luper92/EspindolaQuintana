package TPConc.PerfectNumber;

import java.math.BigInteger;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import Buffer.Buffer;

public class TestMain {
	
	private Buffer b;
	ThreadPool tpool;
	BigInteger cuatroBI;
	BigInteger cincoBI;
	BigInteger seisBI;
	BigInteger sieteBI;
	BigInteger diezBI;
	BigInteger veintiOchoBI;
	BigInteger numPerfectoBI3;
	BigInteger numPerfectoBI4;
	BigInteger numPerfectoBI5;
	BigInteger numPerfectoBI6;
	BigInteger numPerfectoBI7;
	BigInteger menosNueveBI;
	BigInteger menosSieteBI;
	
	
	@Before
	public void setUp(){
		b = new Buffer(60,2);
		tpool = new ThreadPool(2, b);
		cuatroBI = new BigInteger("4");
    	cincoBI = new BigInteger("5");
    	seisBI = new BigInteger("6");
    	sieteBI = new BigInteger("7");
    	diezBI = new BigInteger("10");
    	veintiOchoBI = new BigInteger("28");
    	numPerfectoBI3 = new BigInteger("496");
    	numPerfectoBI4 = new BigInteger("8128");
    	numPerfectoBI5 = new BigInteger("33550336");
    	numPerfectoBI6 = new BigInteger("8589869056");
    	numPerfectoBI7 = new BigInteger("137438691328");
    	menosNueveBI = new BigInteger("-1");
    	menosSieteBI = new BigInteger("-7");
	}
	
	@Test
	public void testBuffer() {
		
		//b.escribir(seisBI);
		/*
    	b.escribir(cuatroBI);
    	b.escribir(cincoBI);
    	b.escribir(seisBI);
    	b.escribir(veintiOchoBI);
    	b.escribir(numPerfectoBI3);
    	b.escribir(numPerfectoBI4);
    	b.escribir(numPerfectoBI5);
    	b.escribir(numPerfectoBI6);
    	*/
    	b.escribir(numPerfectoBI6);
    	b.escribir(menosNueveBI);
   		b.escribir(menosSieteBI);

	}
}
