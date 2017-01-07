/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/raknet8.xml
 */
package sul.protocol.raknet8.control;

import java.util.UUID;

import sul.protocol.raknet8.types.*;
import sul.utils.*;

class Encapsulated extends Packet {

	public final static byte ID = (byte)132;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = true;

	public int count;
	public Encapsulation encapsulation;

	@Override
	public int length() {
		return encapsulation.length() + 3;
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
