/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft110.xml
 */
package sul.protocol.minecraft110.login;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

public class EncryptionRequest extends Packet {

	public static final int ID = (int)1;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public String serverId;
	public byte[] publicKey = new byte[0];
	public byte[] verifyToken = new byte[0];

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
		byte[] cvdvsq=serverId.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)cvdvsq.length); this.writeBytes(cvdvsq);
		this.writeVaruint((int)publicKey.length); this.writeBytes(publicKey);
		this.writeVaruint((int)verifyToken.length); this.writeBytes(verifyToken);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bvcvdvsq=this.readVaruint(); serverId=new String(this.readBytes(bvcvdvsq), StandardCharsets.UTF_8);
		int bbyxyte=this.readVaruint(); publicKey=this.readBytes(bbyxyte);
		int bzclerav=this.readVaruint(); verifyToken=this.readBytes(bzclerav);
	}

	public static EncryptionRequest fromBuffer(byte[] buffer) {
		EncryptionRequest ret = new EncryptionRequest();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "EncryptionRequest(serverId: " + this.serverId + ", publicKey: " + Arrays.toString(this.publicKey) + ", verifyToken: " + Arrays.toString(this.verifyToken) + ")";
	}

}
