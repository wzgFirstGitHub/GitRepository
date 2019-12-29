package c05.dessert;

import java.awt.Container;
import java.awt.TextField;

public class Blocking {

}

class Blockable extends Thread {
	private Peeker peeker;
	protected TextField state = new TextField(40);
	protected int i;

	public Blockable(Container c) {
		c.add(state);
		peeker = new Peeker(this, c);
	}

	public synchronized int read() {
		return i;
	}

	protected synchronized void update() {
		state.setText(getClass().getName() + " state: i = " + i);
	}

	public void stopPeeker() {
		// peeker.stop(); Deprecated in Java 1.2
		peeker.terminate(); // The preferred approach
	}
}

class Peeker extends Thread {
	private Blockable b;
	private int session;
	private TextField status = new TextField(40);
	private boolean stop = false;

	public Peeker(Blockable b, Container c) {
		c.add(status);
		this.b = b;
		start();
	}

	public void terminate() {
		stop = true;
	}

	public void run() {
		while (!stop) {
			status.setText(b.getClass().getName() + " Peeker " + (++session) + "; value = " + b.read());
			try {
				sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}

class Sleeper1 extends Blockable {
	public Sleeper1(Container c) {
		super(c);
	}

	public synchronized void run() {
		while (true) {
			i++;
			update();
			try {
				sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}

class Sleeper2 extends Blockable {
	public Sleeper2(Container c) {
		super(c);
	}

	public void run() {
		while (true) {
			change();
			try {
				sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

	public synchronized void change() {
		i++;
		update();
	}
}
