/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import java.util.UUID;

import sul.protocol.pocket100.types.*;
import sul.utils.*;

class MoveEntity extends Packet {

	public final static byte ID = (byte)19;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public long entityId;
	public Tuples.FloatXYZ position;
	public float pitch;
	public float headYaw;
	public float yaw;

	@Override
	public int length() {
		return Var.Long.length(entity_id) + position.length() + 12;
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
