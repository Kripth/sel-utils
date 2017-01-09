/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft108.xml
 */
package sul.protocol.minecraft108.serverbound;

import java.util.UUID;

import sul.protocol.minecraft108.types.*;
import sul.utils.*;

class UpdateSign extends Packet {

	public final static int ID = (int)25;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	public long position;
	public String[4] lines;

	@Override
	public int length() {
		return Var.Uint.length(lines.length) + lines.length() + 8;
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
