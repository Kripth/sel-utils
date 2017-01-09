/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft315.xml
 */
package sul.protocol.minecraft315.clientbound;

import java.util.UUID;

import sul.protocol.minecraft315.types.*;
import sul.utils.*;

class PlayerPositionAndLook extends Packet {

	public final static int ID = (int)46;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// flags
	public final static byte X = (byte)1;
	public final static byte Y = (byte)2;
	public final static byte Z = (byte)4;
	public final static byte Y_ROTATION = (byte)8;
	public final static byte X_ROTATION = (byte)16;

	public Tuples.DoubleXYZ position;
	public float yaw;
	public float pitch;
	public byte flags;
	public int teleportId;

	@Override
	public int length() {
		return position.length() + Var.Uint.length(teleportId) + 9;
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
