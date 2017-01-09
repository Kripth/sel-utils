/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft47.xml
 */
package sul.protocol.minecraft47.login;

import java.util.UUID;

import sul.protocol.minecraft47.types.*;
import sul.utils.*;

class EncryptionRequest extends Packet {

	public final static int ID = (int)1;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public String serverId;
	public byte[] publicKey;
	public byte[] verifyToken;

	@Override
	public int length() {
		return Var.Uint.length(serverId.getBytes(StandardCharset.UTF_8).length) + serverId.getBytes(StandardCharset.UTF_8).length + Var.Uint.length(publicKey.length) + publicKey.length() + Var.Uint.length(verifyToken.length) + verifyToken.length();
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
