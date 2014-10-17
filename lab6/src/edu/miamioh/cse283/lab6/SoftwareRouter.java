package edu.miamioh.cse283.lab6;

/**
 * @author Sam Bowdler
 * @date 17 October 2014
 */
public class SoftwareRouter {

	/**
	 * Adds the given link and (network, subnet mask) to this router's routing table.
	 * 
	 * @param link is the link that packets should be forwarded to.
	 * @param network_address is the network address for this link.
	 * @param subnet_mask is the number of bits for the network prefix. 
	 */
	public void addLink(Link link, Address network_address, int subnet_mask) {
	}
	
	/**
	 * Removes the given link from this router's routing table.
	 * 
	 * @param link is the link to be removed from this router's routing table.
	 */
	public void removeLink(Link link) {
	}
	
	/**
	 * Packets that are received in this method are to be forwarded to the correct outgoing link.
	 * 
	 * @param pkt is the packet that needs to be forwarded.
	 */
	public void receivePacket(Packet pkt) {
		// once the correct outgoing link has been identified, call link.send(pkt, this); 
	}
}
