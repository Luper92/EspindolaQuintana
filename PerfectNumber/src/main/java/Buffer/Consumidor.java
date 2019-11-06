package Buffer;

import java.math.BigInteger;

public class Consumidor implements Runnable {

	private final Buffer buffer;
	
	public Consumidor(Buffer b) {
		buffer = b;
	}

	public void run() {
		while (true) {
			BigInteger p = buffer.leer();
		}
	}
}