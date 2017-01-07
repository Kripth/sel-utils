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

class MovePlayer extends Packet {

	public final static byte ID = (byte)20;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = true;

	// animation
	public final static byte FULL = (byte)0;
	public final static byte NONE = (byte)1;
	public final static byte ROTATION = (byte)2;

	public long entityId;
	public Tuples.FloatXYZ position;
	public float pitch;
	public float headYaw;
	public float yaw;
	public byte animation;
	public boolean onGround;

	@Override
	public int length() {
		return Var.Long.length(entity_id) + position.length() + 14;
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
