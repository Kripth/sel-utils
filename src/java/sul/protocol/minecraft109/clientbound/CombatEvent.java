/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft109.xml
 */
package sul.protocol.minecraft109.clientbound;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class CombatEvent extends Packet {

	public static final int ID = (int)44;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	public byte eventId;

	public CombatEvent() {}

	public CombatEvent(byte eventId) {
		this.eventId = eventId;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + 1;
	}

	@Override
	public byte[] encode() {
		return this.encodeImpl();
	}

	private byte[] encodeImpl() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianByte(eventId);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		eventId=readBigEndianByte();
	}

	private byte[] remainingBuffer() {
		return java.util.Arrays.copyOfRange(this._buffer, this._index, this._buffer.length);
	}

	public static CombatEvent fromBuffer(byte[] buffer) {
		CombatEvent ret = new CombatEvent();
		ret.decode(buffer);
		return ret;
	}

	public class EnterCombat extends Packet {

		public static final byte EVENT_ID = (byte)0;

		@Override
		public int length() {
			return 0;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

	}

	public class EndCombat extends Packet {

		public static final byte EVENT_ID = (byte)1;

		public int duration;
		public int entityId;

		public EndCombat() {}

		public EndCombat(int duration, int entityId) {
			this.duration = duration;
			this.entityId = entityId;
		}

		@Override
		public int length() {
			return Buffer.varuintLength(duration) + 4;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeVaruint(duration);
			this.writeBigEndianInt(entityId);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			duration=this.readVaruint();
			entityId=readBigEndianInt();
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

	}

	public class EntityDead extends Packet {

		public static final byte EVENT_ID = (byte)2;

		public int playerId;
		public int entityId;
		public String message;

		public EntityDead() {}

		public EntityDead(int playerId, int entityId, String message) {
			this.playerId = playerId;
			this.entityId = entityId;
			this.message = message;
		}

		@Override
		public int length() {
			return Buffer.varuintLength(playerId) + Buffer.varuintLength(message.getBytes(StandardCharsets.UTF_8).length) + message.getBytes(StandardCharsets.UTF_8).length + 4;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeVaruint(playerId);
			this.writeBigEndianInt(entityId);
			byte[] bwvzc2fnzq=message.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bwvzc2fnzq.length); this.writeBytes(bwvzc2fnzq);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			playerId=this.readVaruint();
			entityId=readBigEndianInt();
			int bgvubwvzc2fnzq=this.readVaruint(); message=new String(this.readBytes(bgvubwvzc2fnzq), StandardCharsets.UTF_8);
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

	}

}
