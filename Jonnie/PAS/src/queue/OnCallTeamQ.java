package queue;

import NHSsystem.OnCallTeam;

/**
 * Class that represents the on-call team
 * 
 * @author Jonnie Leathem
 *
 */
public class OnCallTeamQ implements Runnable {

	/**
	 * Instance var
	 */
	OnCallTeam onCallTeam;

	/**
	 * Get properties from on call team
	 * 
	 * @param onCallTeam
	 */
	public OnCallTeamQ(OnCallTeam onCallTeam) {
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
