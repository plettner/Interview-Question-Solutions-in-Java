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
			ThreadUtils.sleep(1);
		}
	}

}
