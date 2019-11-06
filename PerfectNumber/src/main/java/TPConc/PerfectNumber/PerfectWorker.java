package TPConc.PerfectNumber;

import java.math.BigInteger;

import Barrier.Barrier;
import Buffer.Buffer;

public class PerfectWorker extends Thread {

	private Barrier barrierT;
	private Buffer buffer;
	private int id;
	
	public PerfectWorker(Buffer b, Barrier barrier, int i) {
		this.buffer = b;
		this.barrierT = barrier;
		this.id = i;
	}
	
	public void run() {
		while(true){
			BigInteger num = buffer.leer();
			if((num.compareTo(new BigInteger("0"))) < 0) {
				//termina thread id
				barrierT.esperar();
				break;
			}else {
				esPerfecto(num);
			}
		}
	}

	private void esPerfecto(BigInteger n) {
		BigInteger ceroBI = new BigInteger("0");
		BigInteger unoBI = new BigInteger("1");
		BigInteger sumas = new BigInteger("0");
		BigInteger cant = new BigInteger("1");
		
		while(cant.compareTo(n) == -1) {
			if((n.mod(cant).compareTo(ceroBI)) == 0) {
				sumas = sumas.add(cant);
			}
			cant = cant.add(unoBI);
		}
		
	    if(sumas.compareTo(n) == 0) {
	    		barrierT.agregar(n);
	        	System.out.println("es perfecto "+ n);
	    }
	}
}