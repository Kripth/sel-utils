/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom1.xml
 */
package sul.protocol.hncom1.player;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

import sul.utils.*;

/**
 * Adds a player to the node.
 */
public class Add extends Packet {

	public static final byte ID = (byte)11;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	// reason
	public static final byte FIRST_JOIN = 0;
	public static final byte TRANSFERRED = 1;
	public static final byte FORCIBLY_TRANSFERRED = 2;

	/**
	 * A unique identifier given by the hub that is never changed while the player is connected.
	 */
	public int hubId;

	/**
	 * Reason why the player has joined the node.
	 */
	public byte reason;

	/**
	 * Game of the client, which could either be Minecraft or Minecraft: Pocket Edition.
	 */
	public byte type;

	/**
	 * Version of the protocol used by the client.
	 */
	public int protocol;

	/**
	 * Username of the player.
	 */
	public String username;

	/**
	 * Display name of the player, which can contain formatting codes. It can be updated
	 * by the node.
	 */
	public String displayName;
	public byte dimension;
	public sul.protocol.hncom1.types.Address address;
	public UUID uuid;
	public sul.protocol.hncom1.types.Skin skin;
	public int latency;
	public String language;

	public Add() {}

	public Add(int hubId, byte reason, byte type, int protocol, String username, String displayName, byte dimension, sul.protocol.hncom1.types.Address address, UUID uuid, sul.protocol.hncom1.types.Skin skin, int latency, String language) {
		this.hubId = hubId;
		this.reason = reason;
		this.type = type;
		this.protocol = protocol;
		this.username = username;
		this.displayName = displayName;
		this.dimension = dimension;
		this.address = address;
		this.uuid = uuid;
		this.skin = skin;
		this.latency = latency;
		this.language = language;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(hubId) + Buffer.varuintLength(protocol) + Buffer.varuintLength(username.getBytes(StandardCharsets.UTF_8).length) + username.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(displayName.getBytes(StandardCharsets.UTF_8).length) + displayName.getBytes(StandardCharsets.UTF_8).length + address.length() + skin.length() + Buffer.varuintLength(latency) + Buffer.varuintLength(language.getBytes(StandardCharsets.UTF_8).length) + language.getBytes(StandardCharsets.UTF_8).length + 20;
	}

	@Override
	public byte[] encode() {
		return this.encodeImpl();
	}

	private byte[] encodeImpl() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVaruint(hubId);
		this.writeBigEndianByte(reason);
		this.writeBigEndianByte(type);
		this.writeVaruint(protocol);
		byte[] dxnlcm5hbwu=username.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dxnlcm5hbwu.length); this.writeBytes(dxnlcm5hbwu);
		byte[] zglzcgxheu5hbwu=displayName.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)zglzcgxheu5hbwu.length); this.writeBytes(zglzcgxheu5hbwu);
		if(reason!=0){ this.writeBigEndianByte(dimension); }
		this.writeBytes(address.encode());
		this.writeBigEndianLong(uuid.getLeastSignificantBits()); this.writeBigEndianLong(uuid.getMostSignificantBits());
		this.writeBytes(skin.encode());
		this.writeVaruint(latency);
		byte[] bgfuz3vhz2u=language.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bgfuz3vhz2u.length); this.writeBytes(bgfuz3vhz2u);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		hubId=this.readVaruint();
		reason=readBigEndianByte();
		type=readBigEndianByte();
		protocol=this.readVaruint();
		int bgvudxnlcm5hbwu=this.readVaruint(); username=new String(this.readBytes(bgvudxnlcm5hbwu), StandardCharsets.UTF_8);
		int bgvuzglzcgxheu5h=this.readVaruint(); displayName=new String(this.readBytes(bgvuzglzcgxheu5h), StandardCharsets.UTF_8);
		if(reason!=0){ dimension=readBigEndianByte(); }
		address=new sul.protocol.hncom1.types.Address(); address._index=this._index; address.decode(this._buffer); this._index=address._index;
		long bxv1awq=readBigEndianLong(); long bhv1awq=readBigEndianLong(); uuid=new UUID(bxv1awq,bhv1awq);
		skin=new sul.protocol.hncom1.types.Skin(); skin._index=this._index; skin.decode(this._buffer); this._index=skin._index;
		latency=this.readVaruint();
		int bgvubgfuz3vhz2u=this.readVaruint(); language=new String(this.readBytes(bgvubgfuz3vhz2u), StandardCharsets.UTF_8);
	}

	private byte[] remainingBuffer() {
		return java.util.Arrays.copyOfRange(this._buffer, this._index, this._buffer.length);
	}

	public static Add fromBuffer(byte[] buffer) {
		Add ret = new Add();
		ret.decode(buffer);
		return ret;
	}

	public class Pocket extends Packet {

		public static final byte TYPE = (byte)1;

		public long xuid;
		public boolean edu;
		public float packetLoss;

		public Pocket() {}

		public Pocket(long xuid, boolean edu, float packetLoss) {
			this.xuid = xuid;
			this.edu = edu;
			this.packetLoss = packetLoss;
		}

		@Override
		public int length() {
			return Buffer.varlongLength(xuid) + 5;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeVarlong(xuid);
			this._buffer[this._index++]=(byte)(edu?1:0);
			this.writeBigEndianFloat(packetLoss);
			return this._buffer;
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			xuid=this.readVarlong();
			edu=this._index<this._buffer.length&&this._buffer[this._index++]!=0;
			packetLoss=readBigEndianFloat();
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

	}

	public class Minecraft extends Packet {

		public static final byte TYPE = (byte)2;

		@Override
		public int length() {
			return 0;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			return this._buffer;
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

	}

}
