/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import java.util.Arrays;

import sul.utils.*;

public class ClientboundMapItemData extends Packet {

	public static final byte ID = (byte)66;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// action
	public static final byte UPDATE = 4;
	public static final byte FULL = 6;

	public long mapId;
	public int unknown1;
	public int unknown2;
	public long unknown3;
	public byte action;
	public int unknown5;
	public int unknown6;
	public byte unknown7;
	public byte unknown8;
	public boolean showIcons;
	public Tuples.IntXZ[] icons = new Tuples.IntXZ[0];
	public int direction;
	public Tuples.IntXZ position;
	public int columns;
	public int rows;
	public Tuples.IntXZ offset;
	public byte[] data = new byte[0];

	public ClientboundMapItemData() {}

	public ClientboundMapItemData(long mapId, int unknown1, int unknown2, long unknown3, byte action, int unknown5, int unknown6, byte unknown7, byte unknown8, boolean showIcons, Tuples.IntXZ[] icons, int direction, Tuples.IntXZ position, int columns, int rows, Tuples.IntXZ offset, byte[] data) {
		this.mapId = mapId;
		this.unknown1 = unknown1;
		this.unknown2 = unknown2;
		this.unknown3 = unknown3;
		this.action = action;
		this.unknown5 = unknown5;
		this.unknown6 = unknown6;
		this.unknown7 = unknown7;
		this.unknown8 = unknown8;
		this.showIcons = showIcons;
		this.icons = icons;
		this.direction = direction;
		this.position = position;
		this.columns = columns;
		this.rows = rows;
		this.offset = offset;
		this.data = data;
	}

	@Override
	public int length() {
		int length=Buffer.varlongLength(mapId) + Buffer.varuintLength(unknown1) + Buffer.varuintLength(unknown2) + Buffer.varlongLength(unknown3) + Buffer.varuintLength(unknown5) + Buffer.varintLength(unknown6) + Buffer.varuintLength(icons.length) + Buffer.varintLength(direction) + Buffer.varintLength(position.x) + Buffer.varintLength(position.z) + Buffer.varintLength(columns) + Buffer.varintLength(rows) + Buffer.varintLength(offset.x) + Buffer.varintLength(offset.z) + Buffer.varuintLength(data.length) + data.length + 5; for(Tuples.IntXZ anbm:icons){ length+=Buffer.varintLength(anbm.x)+Buffer.varintLength(anbm.z); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarlong(mapId);
		this.writeVaruint(unknown1);
		this.writeVaruint(unknown2);
		this.writeVarlong(unknown3);
		this.writeBigEndianByte(action);
		this.writeVaruint(unknown5);
		this.writeVarint(unknown6);
		this.writeBigEndianByte(unknown7);
		this.writeBigEndianByte(unknown8);
		this.writeBool(showIcons);
		this.writeVaruint((int)icons.length); for(Tuples.IntXZ anbm:icons){ this.writeVarint(anbm.x); this.writeVarint(anbm.z); }
		this.writeVarint(direction);
		this.writeVarint(position.x); this.writeVarint(position.z);
		this.writeVarint(columns);
		this.writeVarint(rows);
		this.writeVarint(offset.x); this.writeVarint(offset.z);
		this.writeVaruint((int)data.length); this.writeBytes(data);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		mapId=this.readVarlong();
		unknown1=this.readVaruint();
		unknown2=this.readVaruint();
		unknown3=this.readVarlong();
		action=readBigEndianByte();
		unknown5=this.readVaruint();
		unknown6=this.readVarint();
		unknown7=readBigEndianByte();
		unknown8=readBigEndianByte();
		showIcons=this.readBool();
		int blb5=this.readVaruint(); icons=new Tuples.IntXZ[blb5]; for(int anbm=0;anbm<icons.length;anbm++){ icons[anbm]=new Tuples.IntXZ(); icons[anbm].x=this.readVarint(); icons[anbm].z=this.readVarint(); }
		direction=this.readVarint();
		position=new Tuples.IntXZ(); position.x=this.readVarint(); position.z=this.readVarint();
		columns=this.readVarint();
		rows=this.readVarint();
		offset=new Tuples.IntXZ(); offset.x=this.readVarint(); offset.z=this.readVarint();
		int brde=this.readVaruint(); data=this.readBytes(brde);
	}

	public static ClientboundMapItemData fromBuffer(byte[] buffer) {
		ClientboundMapItemData ret = new ClientboundMapItemData();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ClientboundMapItemData(mapId: " + this.mapId + ", unknown1: " + this.unknown1 + ", unknown2: " + this.unknown2 + ", unknown3: " + this.unknown3 + ", action: " + this.action + ", unknown5: " + this.unknown5 + ", unknown6: " + this.unknown6 + ", unknown7: " + this.unknown7 + ", unknown8: " + this.unknown8 + ", showIcons: " + this.showIcons + ", icons: " + Arrays.deepToString(this.icons) + ", direction: " + this.direction + ", position: " + this.position.toString() + ", columns: " + this.columns + ", rows: " + this.rows + ", offset: " + this.offset.toString() + ", data: " + Arrays.toString(this.data) + ")";
	}

}
