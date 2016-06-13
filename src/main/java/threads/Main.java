package threads;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates a bunch of threads of "vehicle" objects that need to go through the
 * intersection. If you remove the synchronized block from the Intersection
 * class, you'll see that the vehicles enter the method whenever they way.
 * Replacing the synchornized block will ensure that any car that starts through
 * the intersection gets all the way through it before another car can go.
 */
public class Main {

	private static final int MAX_VEHICLES = 10;

	public static void main(String[] args) {

		final List<Thread> vehicles = new ArrayList<>(Main.MAX_VEHICLES);

		for (int index = 0; index < Main.MAX_VEHICLES; index++) {
			vehicles.add(new Thread(new Vehicle(index)));
		}

		for (final Thread thread : vehicles) {
			thread.start();
		}

	}
}
