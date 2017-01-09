/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft108.xml
 */
package sul.protocol.minecraft108.clientbound;

import java.util.UUID;

import sul.protocol.minecraft108.types.*;
import sul.utils.*;

class Explosion extends Packet {

	public final static int ID = (int)28;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public Tuples.FloatXYZ position;
	public float radius;
	public ExplosionRecords records;
	public Tuples.FloatXYZ motion;

	@Override
	public int length() {
		return position.length() + records.length() + motion.length() + 4;
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
