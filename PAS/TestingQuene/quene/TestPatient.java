package quene;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import NHSsystem.Patient;

public class TestPatient {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void test() {
		Patient p2 = new Patient("Ms", "June", "Campbell", "20 road",
				"Lisburn", "BT23 524", "234 4263", "3234-83", 0, false);
		p2.setTriage(2);
		
		Patient p3 = new Patient("Mr", "Philip", "White", "94 road",
				"Hillsborough", "BT57 254", "234 4543", "0568-283", 0, false);
		p3.setTriage(2);
		
		Patient p4 = new Patient("Mrs", "Mary", "Kelly", "60 road",
				"Moria", "BT57 092", "689 2583", "3452-039", 0, false);
		p4.setTriage(2);
		
		Patient p5 = new Patient("Mr", "Conner", "Lee", "10 road",
				"Anahilt", "BT59 203", "582 9385", "0429-3458", 0, false);
		p5.setTriage(2);
		
		Patient p6 = new Patient("Mrs", "Will", "Goon", "85 road",
				"Kilea", "BT20 578", "098 3490", "0694-3829", 0, false);
		p6.setTriage(2);
		
		
		Patient p7 = new Patient("Mr", "Red", "Wright", "02 road",
				"Belfast", "BT03 039", "485 3020", "9592-2985", 0, false);
		p7.setTriage(2);
		
		Patient p8 = new Patient("Ms", "Kelly", "Goodman", "58 road",
				"Lisburn", "BT28 394", "509 3853", "9837-3029", 0, false);
		p8.setTriage(3);
		
		Patient p9 = new Patient("Mr", "Kevin", "Ken", "95 road",
				"Hillsborough", "BT02 984", "039 3085", "303-59387", 0, false);
		p9.setTriage(3);
		
		Patient p10 = new Patient("Ms", "Rachel", "Lenvine", "03 road",
				"Moria", "BT28 828", "493 03895", "294-3985", 0, false);
		p10.setTriage(3);
		

	}

}
