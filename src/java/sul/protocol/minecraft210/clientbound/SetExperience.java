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

class SetExperience extends Packet {

	public final static int ID = (int)61;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public float experience;
	public int level;
	public int totalExperience;

	@Override
	public int length() {
		return Var.Uint.length(level) + Var.Uint.length(totalExperience) + 4;
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
