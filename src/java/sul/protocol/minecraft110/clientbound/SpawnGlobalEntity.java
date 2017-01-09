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

class SpawnGlobalEntity extends Packet {

	public final static int ID = (int)2;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// type
	public final static byte THUNDERBOLT = (byte)1;

	public int entityId;
	public byte type;
	public Tuples.DoubleXYZ position;

	@Override
	public int length() {
		return Var.Uint.length(entityId) + position.length() + 1;
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
