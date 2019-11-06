package Buffer;

import java.math.BigInteger;

public class Productor implements Runnable{

	private final Buffer buffer;
	
	public Productor(Buffer b) {
		buffer = b;
	}
	
	public void run() {
		BigInteger i = new BigInteger("0");
		
		while(true) {
			i.add(new BigInteger("1"));
			BigInteger p = i;
			buffer.escribir(p);
		}
	}
}