package Buffer;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
	
	private int capacidad;
	Queue<BigInteger> lista;
	int agregados = 0;
		
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
		if(n.compareTo(new BigInteger("-1")) != 0)
			this.agregados++;
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

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public Queue<BigInteger> getLista() {
		return lista;
	}

	public void setLista(Queue<BigInteger> lista) {
		this.lista = lista;
	}

	public int getAgregados() {
		return agregados;
	}

	public void setAgregados(int agregados) {
		this.agregados = agregados;
	}
	
	
	
}