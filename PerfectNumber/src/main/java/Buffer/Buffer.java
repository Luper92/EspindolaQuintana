package Buffer;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
	
	private int capacidad;
	private int cantThreads;
	private Queue<BigInteger> lista;
	private LinkedList<BigInteger> listaRes;
	private boolean puedeImprimir;
		
	public Buffer(int capacidad, int cantThreads) {
		this.capacidad = capacidad;
		this.cantThreads = cantThreads;
		this.lista = new LinkedList<BigInteger>();
		this.listaRes = new LinkedList<BigInteger>();
		this.puedeImprimir = true;
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

	public void agregar(BigInteger n) {
		listaRes.add(n);
	}

	public synchronized void imprimirLista() {
		cantThreads--;
		while (cantThreads != 0) {
			try 
			{
				wait();
			} catch (InterruptedException e) {
			}
		}
		
		if(puedeImprimir) {
			imprimir();
		}
		
		notifyAll();
	}

	//imprime la lista con todos los numeros Perfectos
	private void imprimir() {
		System.out.println("buffer lisyta "+ listaRes.size());
		puedeImprimir = false;
	}
}
