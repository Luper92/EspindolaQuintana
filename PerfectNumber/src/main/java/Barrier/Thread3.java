package Barrier;

public class Thread3 implements Runnable {

	private Barrier barrier3;
	
	public Thread3(Barrier b) {
		barrier3 = b;
	}
	
	@Override
	public void run() {
		 System.out.println('c');
		 barrier3.esperar();
		 System.out.println(3);
	}

}
