/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft110.xml
 */
package sul.protocol.minecraft110.login;

import java.util.UUID;

import sul.protocol.minecraft110.types.*;
import sul.utils.*;

class LoginStart extends Packet {

	public final static int ID = (int)0;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	public String username;

	@Override
	public int length() {
		return Var.Uint.length(username.getBytes(StandardCharset.UTF_8).length) + username.getBytes(StandardCharset.UTF_8).length;
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
