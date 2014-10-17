package edu.miamioh.cse283.lab6;

import java.util.*;

/**
 * @author Sam Bowdler
 * with help from my colleague Kyle Richardson
 * @date 17 October 2014
 */
public class SoftwareRouter {
	
	// data structure to store entries for the forwarding table
	// inner class? to hold (link, network address, subnet mask)
	// calculate longest prefix match:
	//   1) does a network address match a packet's address?
	//      do the subnet_mask # of bits of a network's address == the subnet mask # of bits of a packet's address?
	//   2) calculate the maximum prefix == greatest subnet mask of matched networks
	
	// add link: adds an entry to the forwarding table (link, network, subnet mask)
	// remove link: remove a link from the table
	// receive packet: calculate LPM; send packet on that link 					LPM = longest prefix match
	
	protected Hashtable<Integer, Link>[] h = new Hashtable[32];

	/**public Address find(Link link) {
		Iterator iter = h.iterator();
		Address a = (Address)iter.next();
		while (h. != link) {
			
		}
	}**/
	
	/**
	 * Adds the given link and (network, subnet mask) to this router's routing table.
	 * 
	 * @param link is the link that packets should be forwarded to.
	 * @param network_address is the network address for this link.
	 * @param subnet_mask is the number of bits for the network prefix. 
	 */
	public void addLink(Link link, Address network_address, int subnet_mask) {
		h[subnet_mask].put(network_address.getIP(), link);
	}
	
	/**
	 * Removes the given link from this router's routing table.
	 * 
	 * @param link is the link to be removed from this router's routing table.
	 */
	public void removeLink(Link link) {
		for (Hashtable x : h) {
			if (x.contains(link)) {
				Set<Integer> keys = x.keySet();
				for (Integer i : keys)
					if (x.get(i) == link)
						x.remove(i);
			}
		}
	}
	
	/**
	 * Packets that are received in this method are to be forwarded to the correct outgoing link.
	 * 
	 * @param pkt is the packet that needs to be forwarded.
	 */
	public void receivePacket(Packet pkt) throws NullPointerException {
		// once the correct outgoing link has been identified, call link.send(pkt, this); 
		for (int i = 31; i >= 0; i--) {
			if ((pkt.getDestination().getIP() & h[i].get(32 - i).getIP()) == 0) {
				try {
					h[i].get(pkt.getDestination().getIP()).send(pkt);
				} catch(NullPointerException e) {
					return;
				}
			}
		}
	}
}
