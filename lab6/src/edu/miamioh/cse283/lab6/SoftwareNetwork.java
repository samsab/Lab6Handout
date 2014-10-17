package edu.miamioh.cse283.lab6;

/**
 * @author Sam Bowdler
 * @date 17 October 2014
 */
public class SoftwareNetwork {

	/**
	 * Runs the software network.
	 * 
	 * @param args is an array containing each of the command-line arguments.
	 */
	public static void main(String[] args) {
		SoftwareRouter r1 = new SoftwareRouter();
		SoftwareRouter r2 = new SoftwareRouter();
		
		// build a link from r1->r2 that forwards all traffic:
		r1.addLink(new Link(r2), new Address(0), 0);
				
		// packets sent to r1 should wind up at r2:
		r1.receivePacket(new Packet(new Address(0), new Address(1)));
	}
}
