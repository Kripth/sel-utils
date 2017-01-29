/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft108.xml
 */
package sul.protocol.minecraft108.status;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class Handshake extends Packet {

	public static final int ID = (int)0;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	// next
	public static final int STATUS = 1;
	public static final int LOGIN = 2;

	public int protocol;
	public String serverAddress;
	public short serverPort;
	public int next;

	public Handshake() {}

	public Handshake(int protocol, String serverAddress, short serverPort, int next) {
		this.protocol = protocol;
		this.serverAddress = serverAddress;
		this.serverPort = serverPort;
		this.next = next;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(protocol) + Buffer.varuintLength(serverAddress.getBytes(StandardCharsets.UTF_8).length) + serverAddress.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(next) + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(protocol);
		byte[] c2vydmvyqwrkcmvz=serverAddress.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)c2vydmvyqwrkcmvz.length); this.writeBytes(c2vydmvyqwrkcmvz);
		this.writeBigEndianShort(serverPort);
		this.writeVaruint(next);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		protocol=this.readVaruint();
		int bgvuc2vydmvyqwrk=this.readVaruint(); serverAddress=new String(this.readBytes(bgvuc2vydmvyqwrk), StandardCharsets.UTF_8);
		serverPort=readBigEndianShort();
		next=this.readVaruint();
	}

	public static Handshake fromBuffer(byte[] buffer) {
		Handshake ret = new Handshake();
		ret.decode(buffer);
		return ret;
	}

}
