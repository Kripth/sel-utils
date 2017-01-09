/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft47.xml
 */
package sul.protocol.minecraft47.clientbound;

import java.util.UUID;

import sul.protocol.minecraft47.types.*;
import sul.utils.*;

class KeepAlive extends Packet {

	public final static int ID = (int)0;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public int id;

	@Override
	public int length() {
		return Var.Uint.length(id);
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
