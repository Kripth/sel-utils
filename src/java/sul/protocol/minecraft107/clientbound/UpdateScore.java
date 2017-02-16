/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.clientbound;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class UpdateScore extends Packet {

	public static final int ID = (int)66;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// action
	public static final byte UPDATE = 0;
	public static final byte REMOVE = 1;

	public String scoreName;
	public byte action;
	public String objectiveName;
	public int value;

	public UpdateScore() {}

	public UpdateScore(String scoreName, byte action, String objectiveName, int value) {
		this.scoreName = scoreName;
		this.action = action;
		this.objectiveName = objectiveName;
		this.value = value;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(scoreName.getBytes(StandardCharsets.UTF_8).length) + scoreName.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(objectiveName.getBytes(StandardCharsets.UTF_8).length) + objectiveName.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(value) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] cncvy1=scoreName.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)cncvy1.length); this.writeBytes(cncvy1);
		this.writeBigEndianByte(action);
		byte[] bjznaztf=objectiveName.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bjznaztf.length); this.writeBytes(bjznaztf);
		if(action==0){ this.writeVaruint(value); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bvcncvy1=this.readVaruint(); scoreName=new String(this.readBytes(bvcncvy1), StandardCharsets.UTF_8);
		action=readBigEndianByte();
		int bvbjznaz=this.readVaruint(); objectiveName=new String(this.readBytes(bvbjznaz), StandardCharsets.UTF_8);
		if(action==0){ value=this.readVaruint(); }
	}

	public static UpdateScore fromBuffer(byte[] buffer) {
		UpdateScore ret = new UpdateScore();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "UpdateScore(scoreName: " + this.scoreName + ", action: " + this.action + ", objectiveName: " + this.objectiveName + ", value: " + this.value + ")";
	}

}
