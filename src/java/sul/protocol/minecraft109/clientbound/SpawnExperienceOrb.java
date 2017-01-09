/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft109.xml
 */
package sul.protocol.minecraft109.clientbound;

import java.util.UUID;

import sul.protocol.minecraft109.types.*;
import sul.utils.*;

class SpawnExperienceOrb extends Packet {

	public final static int ID = (int)1;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public int entityId;
	public Tuples.DoubleXYZ position;
	public short count;

	@Override
	public int length() {
		return Var.Uint.length(entityId) + position.length() + 2;
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
