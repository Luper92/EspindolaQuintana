package Barrier;

public class Thread1 implements Runnable {

	private Barrier barrier1;
	
	public Thread1(Barrier b) {
		barrier1 = b;
	}
	
	@Override
	public void run() {
		 System.out.println('a');
		 barrier1.esperar();
		 System.out.println(1);
	}

}
