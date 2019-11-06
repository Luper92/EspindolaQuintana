package Buffer;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
	
	private int capacidad;
	private Queue<BigInteger> lista;
		
	public Buffer(int capacidad) {
		this.capacidad = capacidad;
		this.lista = new LinkedList<BigInteger>();
	}
	
	public synchronized void escribir(BigInteger n) {
		while( lista.size()==capacidad ){
			try
			{
				wait();
			} catch (InterruptedException e) {}
		}
		//escribo n
		lista.add(n);
	//	System.out.println("escribi "+ n);
		notify();
	}
	
	public synchronized BigInteger leer() {
		while(lista.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		
		BigInteger temp = lista.poll();
		//lei temp
	//	System.out.println("lei "+ temp);
		notifyAll();
		return temp;
	}
}