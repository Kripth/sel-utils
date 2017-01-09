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

class SoundEffect extends Packet {

	public final static int ID = (int)70;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public int soundId;
	public int category;
	public Tuples.IntXYZ position;
	public float volume;
	public float pitch;

	@Override
	public int length() {
		return Var.Uint.length(soundId) + Var.Uint.length(category) + position.length() + 8;
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
