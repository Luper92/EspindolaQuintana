package clases;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Barrier {
int threadsEsperando;
Condition estanTodos;
int maxThreads;
	
	
	public Barrier(int maxThreads){
		threadsEsperando = 0;
		//Lock lock = new ReentrantLock();
	    //estanTodos = lock.newCondition();
	    this.maxThreads = maxThreads;
	}
	
	public synchronized void esperar(){
		threadsEsperando++;
		while(threadsEsperando < this.maxThreads){
			try {
				//estanTodos.await();
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//estanTodos.signalAll();
		this.notifyAll();
	}
}
