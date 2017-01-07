/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/externalconsole1.xml
 */
package sul.protocol.externalconsole1.status;

import java.util.UUID;

import sul.protocol.externalconsole1.types.*;
import sul.utils.*;

class UpdateNodes extends Packet {

	public final static byte ID = (byte)1;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// action
	public final static byte ADD = (byte)0;
	public final static byte REMOVE = (byte)1;

	public byte action;
	public String node;

	@Override
	public int length() {
		return node.length() + 1;
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
