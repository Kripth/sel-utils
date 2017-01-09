/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft110.xml
 */
package sul.protocol.minecraft110.clientbound;

import java.util.UUID;

import sul.protocol.minecraft110.types.*;
import sul.utils.*;

class DisplayScoreboard extends Packet {

	public final static int ID = (int)56;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// position
	public final static byte LIST = (byte)0;
	public final static byte SIDEBAR = (byte)1;
	public final static byte BELOW_NAME = (byte)2;

	public byte position;
	public String scoreName;

	@Override
	public int length() {
		return Var.Uint.length(scoreName.getBytes(StandardCharset.UTF_8).length) + scoreName.getBytes(StandardCharset.UTF_8).length + 1;
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
