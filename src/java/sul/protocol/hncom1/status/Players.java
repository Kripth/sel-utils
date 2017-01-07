/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom1.xml
 */
package sul.protocol.hncom1.status;

import java.util.UUID;

import sul.protocol.hncom1.types.*;
import sul.utils.*;

class Players extends Packet {

	public final static byte ID = (byte)4;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public int online;
	public int max;

	@Override
	public int length() {
		return Var.Uint.length(online) + Var.Uint.length(max);
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
