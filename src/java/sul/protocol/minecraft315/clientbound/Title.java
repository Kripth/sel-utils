/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft315.xml
 */
package sul.protocol.minecraft315.clientbound;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class Title extends Packet {

	public static final int ID = (int)69;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int action;

	public Title() {}

	public Title(int action) {
		this.action = action;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(action);
	}

	@Override
	public byte[] encode() {
		return this.encodeImpl();
	}

	private byte[] encodeImpl() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(action);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		action=this.readVaruint();
	}

	private byte[] remainingBuffer() {
		return java.util.Arrays.copyOfRange(this._buffer, this._index, this._buffer.length);
	}

	public static Title fromBuffer(byte[] buffer) {
		Title ret = new Title();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Title(action: " + this.action + ")";
	}

	public class SetTitle extends Packet {

		public static final int ACTION = (int)0;

		@Override
		public int getId() {
			return ID;
		}

		public String text;

		public SetTitle() {}

		public SetTitle(String text) {
			this.text = text;
		}

		@Override
		public int length() {
			return Buffer.varuintLength(text.getBytes(StandardCharsets.UTF_8).length) + text.getBytes(StandardCharsets.UTF_8).length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			byte[] dvd=text.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dvd.length); this.writeBytes(dvd);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bvdvd=this.readVaruint(); text=new String(this.readBytes(bvdvd), StandardCharsets.UTF_8);
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "Title.SetTitle(text: " + this.text + ")";
		}

	}

	public class SetSubtitle extends Packet {

		public static final int ACTION = (int)1;

		@Override
		public int getId() {
			return ID;
		}

		public String text;

		public SetSubtitle() {}

		public SetSubtitle(String text) {
			this.text = text;
		}

		@Override
		public int length() {
			return Buffer.varuintLength(text.getBytes(StandardCharsets.UTF_8).length) + text.getBytes(StandardCharsets.UTF_8).length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			byte[] dvd=text.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dvd.length); this.writeBytes(dvd);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bvdvd=this.readVaruint(); text=new String(this.readBytes(bvdvd), StandardCharsets.UTF_8);
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "Title.SetSubtitle(text: " + this.text + ")";
		}

	}

	public class SetActionBar extends Packet {

		public static final int ACTION = (int)2;

		@Override
		public int getId() {
			return ID;
		}

		public String text;

		public SetActionBar() {}

		public SetActionBar(String text) {
			this.text = text;
		}

		@Override
		public int length() {
			return Buffer.varuintLength(text.getBytes(StandardCharsets.UTF_8).length) + text.getBytes(StandardCharsets.UTF_8).length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			byte[] dvd=text.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dvd.length); this.writeBytes(dvd);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bvdvd=this.readVaruint(); text=new String(this.readBytes(bvdvd), StandardCharsets.UTF_8);
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "Title.SetActionBar(text: " + this.text + ")";
		}

	}

	public class SetTimings extends Packet {

		public static final int ACTION = (int)3;

		@Override
		public int getId() {
			return ID;
		}

		public int fadeIn;
		public int stay;
		public int fadeOut;

		public SetTimings() {}

		public SetTimings(int fadeIn, int stay, int fadeOut) {
			this.fadeIn = fadeIn;
			this.stay = stay;
			this.fadeOut = fadeOut;
		}

		@Override
		public int length() {
			return 12;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeBigEndianInt(fadeIn);
			this.writeBigEndianInt(stay);
			this.writeBigEndianInt(fadeOut);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			fadeIn=readBigEndianInt();
			stay=readBigEndianInt();
			fadeOut=readBigEndianInt();
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "Title.SetTimings(fadeIn: " + this.fadeIn + ", stay: " + this.stay + ", fadeOut: " + this.fadeOut + ")";
		}

	}

	public class Hide extends Packet {

		public static final int ACTION = (int)4;

		@Override
		public int getId() {
			return ID;
		}

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

		@Override
		public String toString() {
			return "Title.Hide()";
		}

	}

	public class Reset extends Packet {

		public static final int ACTION = (int)5;

		@Override
		public int getId() {
			return ID;
		}

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

		@Override
		public String toString() {
			return "Title.Reset()";
		}

	}

}
