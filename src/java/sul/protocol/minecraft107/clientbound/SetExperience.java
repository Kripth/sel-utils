/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.clientbound;

import java.util.UUID;

import sul.protocol.minecraft107.types.*;
import sul.utils.*;

class SetExperience extends Packet {

	public final static int ID = (int)61;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public float experience;
	public int level;
	public int totalExperience;

	@Override
	public int length() {
	}

	@Override
	public byte[] encode() {
		this.buffer = new byte[this.length()];
		this.index = 0;
		this.writeVaruint(ID);
		this.writeFloatB(experience);
		this.writeVaruint(level);
		this.writeVaruint(totalExperience);
		return this.buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this.buffer = buffer;
		this.index = 0;
	}

}