package com.csulb.apl.assignment1;

public class Microwave implements Runnable {

	static Integer countdownTimer = 0;
	public Thread wave;
	static volatile boolean isdooropen = true;
	static volatile boolean iscooking = false;
	static volatile boolean shutdown = false;
	static volatile boolean pause = false;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (countdownTimer > 0) {
				if (!pause) {

					// updating the countdowntimer in a synchronized way
					Integer value = countdownTimer - 1;
					synchronizedUpdate(value);
					System.out.println(countdownTimer);
					Thread.sleep(1000l);
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block

			System.err.println("Interrupted Exception: " + e.getMessage());
		}
		stop();
	}

	/*
	 * synchronus update of countdownTimer.
	 */
	private void synchronizedUpdate(Integer value) {
		synchronized (countdownTimer) {

			countdownTimer = value;
		}
	}

	/*
	 * Start a single instance of a Thread.
	 */
	public void start() {

		if (iscooking) {
			// updating the countdowntimer in a synchronized way
			synchronizedUpdate(countdownTimer + 60);

			System.out.println(countdownTimer);
		} else {
			// updating the countdowntimer in a synchronized way
			synchronizedUpdate(countdownTimer + 60);
			System.out
					.println("Light is on \nAdded 1 minute of cook time \nPower tube is on... \nBeep!");
			iscooking = true;
			wave = new Thread(this);
			wave.start();

		}

	}

	/*
	 * method to reset the counter
	 */
	public void stop() {
		// shutdown= true;
		countdownTimer = 0;
		System.out.println("Light is off \nBeep! \nBeep! \nBeep!");
		iscooking = false;

	}

	/*
	 * method to toggledoor of the microwave.
	 */
	public void toggledoor() {

		isdooropen = !isdooropen;
		if (isdooropen) {
			// set pause to true to pause the microwave.
			pause = true;
			System.out.println("Door is open");
		} else {
			pause = false;
		}

	}

}
