package TPConc.PerfectNumber;

import java.util.LinkedList;

import Barrier.Barrier;
import Buffer.Buffer;

public class ThreadPool {
	
	Barrier barrierT;
	int threads;
	LinkedList<Thread> list = new LinkedList<Thread>();
	
	public ThreadPool(int cantThreads, Buffer b) {
		this.barrierT = new Barrier(cantThreads);
		this.threads = cantThreads;
		
		for(int i=0; i<cantThreads; i++){
			//creo PerfecWorker
			Thread t = new PerfectWorker(b, barrierT, i);
			list.add(t);
		}
		runThreads();
	}

	//inicializo los thread creados
	public void runThreads(){
		list.forEach(t-> t.start());
	}

}
