package clases;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
	ArrayList datos;
	int capacidad;
	int n;
	//Condition hayEspacio;
	//Condition hayDatos;
	
	public Buffer(int capacidad){
	 datos = new ArrayList();
	 this.capacidad = capacidad;
	 n = 0;
	 
	 	//Lock lock = new ReentrantLock();
	    //hayEspacio = lock.newCondition();
	    //hayDatos = lock.newCondition();
	}
	
public synchronized void producir(int numero){
	while(datos.size() >= capacidad){
		try {
			this.wait();
			//hayEspacio.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	datos.add(numero);
	this.notify();
	//hayDatos.signal();
}

public synchronized int consumir(){
	while(datos.size() < capacidad){
		try{
		this.wait();
		//hayDatos.await();
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	this.notifyAll();
	//hayEspacio.signal();
	int r = (int)datos.get(n);
	n++;
	return r;
}
	
}
