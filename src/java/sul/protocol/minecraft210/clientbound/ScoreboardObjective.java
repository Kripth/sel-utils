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

class ScoreboardObjective extends Packet {

	public final static int ID = (int)63;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// mode
	public final static byte CREATE = (byte)0;
	public final static byte REMOVE = (byte)1;
	public final static byte UPDATE = (byte)2;

	// type
	public final static String NUMERIC = (String)integer;
	public final static String GRAPHIC = (String)hearts;

	public String name;
	public byte mode;
	public String value;
	public String type;

	@Override
	public int length() {
		return Var.Uint.length(name.getBytes(StandardCharset.UTF_8).length) + name.getBytes(StandardCharset.UTF_8).length + Var.Uint.length(value.getBytes(StandardCharset.UTF_8).length) + value.getBytes(StandardCharset.UTF_8).length + Var.Uint.length(type.getBytes(StandardCharset.UTF_8).length) + type.getBytes(StandardCharset.UTF_8).length + 1;
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
