package queue;

import NHSsystem.OnCallTeam;

public class OnCallTeamThread implements Runnable {
	
	/**
	 * Instance var
	 */
	OnCallTeam onCallTeam;

	/**
	 * Get properties from on call team
	 * 
	 * @param onCallTeam
	 */
	public OnCallTeamThread(OnCallTeam onCallTeam) {
		this.onCallTeam = onCallTeam;
	}

	/**
	 * Counts the time since team called upon
	 */
	@Override
	public void run() {

		int loop = 0;

		do {
			this.onCallTeam.setCountTimer(loop);
			loop++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				System.out.println("Interrupted");
			}
		} while (loop != 900);// 15 minutes

	}

}
