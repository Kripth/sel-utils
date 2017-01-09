/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
package sul.protocol.minecraft210.clientbound;

import java.util.UUID;

import sul.protocol.minecraft210.types.*;
import sul.utils.*;

class SpawnMob extends Packet {

	public final static int ID = (int)3;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public int entityId;
	public UUID uuid;
	public byte type;
	public Tuples.DoubleXYZ position;
	public byte yaw;
	public byte pitch;
	public byte headPitch;
	public Tuples.ShortXYZ velocity;
	public Metadata metadata;

	@Override
	public int length() {
		return Var.Uint.length(entityId) + position.length() + velocity.length() + metadata.length() + 20;
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
