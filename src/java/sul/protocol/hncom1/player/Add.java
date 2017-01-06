/*
 * This file has been automatically generated by sel-utils and
 * it's released under the GNU General Public License version 3.
 *
 * Repository: https://github.com/sel-project/sel-utils
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * From: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom1.xml
 */
package sul.protocol.hncom1.player;

import java.util.UUID;

import sul.protocol.hncom1.types.*;
import sul.utils.Packet;

class Add : Packet {

	public final static byte ID = (byte)10;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// reason
	public final static byte FIRST_JOIN = (byte)0;
	public final static byte TRANSFERRED = (byte)1;
	public final static byte FORCIBLY_TRANSFERRED = (byte)2;

	public int hubId;
	public byte reason;
	public int protocol;
	public String username;
	public String displayName;
	public Address address;
	public byte game;
	public UUID uuid;
	public Skin skin;
	public int latency;
	public float packetLoss;
	public String language;

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
