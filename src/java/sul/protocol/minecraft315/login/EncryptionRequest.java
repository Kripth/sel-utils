/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft315.xml
 */
package sul.protocol.minecraft315.login;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class EncryptionRequest extends Packet {

	public static final int ID = (int)1;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	public String serverId;
	public byte[] publicKey;
	public byte[] verifyToken;

	public EncryptionRequest() {}

	public EncryptionRequest(String serverId, byte[] publicKey, byte[] verifyToken) {
		this.serverId = serverId;
		this.publicKey = publicKey;
		this.verifyToken = verifyToken;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(serverId.getBytes(StandardCharsets.UTF_8).length) + serverId.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(publicKey.length) + publicKey.length + Buffer.varuintLength(verifyToken.length) + verifyToken.length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] c2vydmvyswq=serverId.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)c2vydmvyswq.length); this.writeBytes(c2vydmvyswq);
		this.writeVaruint((int)publicKey.length); this.writeBytes(publicKey);
		this.writeVaruint((int)verifyToken.length); this.writeBytes(verifyToken);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bgvuc2vydmvyswq=this.readVaruint(); serverId=new String(this.readBytes(bgvuc2vydmvyswq), StandardCharsets.UTF_8);
		int bhb1ymxpy0tleq=this.readVaruint(); publicKey=this.readBytes(bhb1ymxpy0tleq);
		int bhzlcmlmevrva2vu=this.readVaruint(); verifyToken=this.readBytes(bhzlcmlmevrva2vu);
	}

	public static EncryptionRequest fromBuffer(byte[] buffer) {
		EncryptionRequest ret = new EncryptionRequest();
		ret.decode(buffer);
		return ret;
	}

}
