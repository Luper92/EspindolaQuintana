package Barrier;

public class Barrier {
	
	private int tope;

	public Barrier(int cantThreads) {
		this.tope = cantThreads;
	}

	public synchronized void esperar() {
		tope--;
		while (tope != 0){
			try 
			{
				wait();
			} catch (InterruptedException e) {
			}
		}
		notifyAll();
	}
}