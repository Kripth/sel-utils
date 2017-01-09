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

class Map extends Packet {

	public final static int ID = (int)36;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public int mapId;
	public byte scale;
	public boolean showIcons;
	public Icon[] icons;
	public byte colums;
	public byte rows;
	public Tuples.ByteXZ offset;
	public byte[] data;

	@Override
	public int length() {
		return Var.Uint.length(mapId) + Var.Uint.length(icons.length) + icons.length() + offset.length() + Var.Uint.length(data.length) + data.length() + 4;
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
