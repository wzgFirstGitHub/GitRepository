package c05.dessert;

class MyObject implements Cloneable {
	int i;

	MyObject(int ii) {
		i = ii;
	}

	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("MyObject can't clone");
		}
		return o;
	}

	public String toString() {
		return Integer.toString(i);
	}
}

public class LocalCopy {
	static MyObject g(MyObject v) {
		// Passing a handle, modifies outside object:
		v.i++;
		return v;
	}

	static MyObject f(MyObject v) {
		MyObject vClone = (MyObject) v.clone(); // Local copy
		vClone.i++;
		return vClone;
	}

	public static void main(String[] args) {
		MyObject a = new MyObject(11);
		MyObject b = g(a);
		// Testing handle equivalence,
		// not object equivalence:
		if (a == b)
			System.out.println("a == b");
		else
			System.out.println("a != b");
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		MyObject c = new MyObject(47);
		MyObject d = f(c);
		if (c == d)
			System.out.println("c == d");
		else
			System.out.println("c != d");
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		System.out.println("=========================");
		MyObject m = new MyObject(30);
		MyObject m1 = (MyObject) m.clone();
		m1.i++;
		System.out.println(m.i);
		System.out.println(m1.i);
	}
}