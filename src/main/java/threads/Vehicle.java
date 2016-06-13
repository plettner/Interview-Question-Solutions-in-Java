package threads;

public class Vehicle implements Runnable {

	private final boolean running = true;
	private final int vehicleId;

	public Vehicle(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getVehicleId() {
		return this.vehicleId;
	}

	@Override
	public void run() {
		final Intersection intersection = Intersection.getInstance();
		while (this.running) {
			intersection.execute(this.getVehicleId());
			this.sleep(1);
		}
	}

	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (final Exception exception) {
			System.err.println(exception.toString());
		}
	}

}
