package TPConc.PerfectNumber;

import java.util.LinkedList;

import Barrier.Barrier;
import Buffer.Buffer;
import printer.Contador;
import printer.Printer;

public class ThreadPool {
	
	int numerosAAnalizar = 0;
	
	public Barrier barrierT;
	int threads;
	LinkedList<Thread> list = new LinkedList<Thread>();
	Printer p;
	Buffer b;
	Contador contador;
	
	

	public ThreadPool(int cantThreads, Buffer b) {
		
		contador = new Contador(cantThreads);
		//p.setCantidadInicial(b.getCapacidad());
		
		this.barrierT = new Barrier(cantThreads);
		p = new Printer(barrierT, b);
		barrierT.setPrinter(p);
		
		this.threads = cantThreads;
		
		for(int i=0; i<cantThreads; i++) {
			//creo PerfecWorker
			Thread t = new PerfectWorker(b, barrierT, i, contador);
			list.add(t);
		}
		runThreads();
	}
	
	
	

	//inicializo los thread creados
	public void runThreads() {
		list.forEach(t-> t.start());
	}
	

	public int getNumerosAAnalizar() {
		return numerosAAnalizar;
	}

	public void setNumerosAAnalizar(int numerosAAnalizar) {
		this.numerosAAnalizar = numerosAAnalizar;
	}
	
	public Contador getContador() {
		return contador;
	}

	public void setContador(Contador contador) {
		this.contador = contador;
	}




}
