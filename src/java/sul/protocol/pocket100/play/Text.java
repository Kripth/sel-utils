/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class Text extends Packet {

	public static final byte ID = (byte)10;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = true;

	public byte type;

	public Text() {}

	public Text(byte type) {
		this.type = type;
	}

	@Override
	public int length() {
		return 2;
	}

	@Override
	public byte[] encode() {
		return this.encodeImpl();
	}

	private byte[] encodeImpl() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianByte(type);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		type=readBigEndianByte();
	}

	private byte[] remainingBuffer() {
		return java.util.Arrays.copyOfRange(this._buffer, this._index, this._buffer.length);
	}

	public static Text fromBuffer(byte[] buffer) {
		Text ret = new Text();
		ret.decode(buffer);
		return ret;
	}

	public class Raw extends Packet {

		public static final byte TYPE = (byte)0;

		public String message;

		public Raw() {}

		public Raw(String message) {
			this.message = message;
		}

		@Override
		public int length() {
			return Buffer.varuintLength(message.getBytes(StandardCharsets.UTF_8).length) + message.getBytes(StandardCharsets.UTF_8).length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			byte[] bwvzc2fnzq=message.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bwvzc2fnzq.length); this.writeBytes(bwvzc2fnzq);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bgvubwvzc2fnzq=this.readVaruint(); message=new String(this.readBytes(bgvubwvzc2fnzq), StandardCharsets.UTF_8);
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

	}

	public class Chat extends Packet {

		public static final byte TYPE = (byte)1;

		public String sender;
		public String message;

		public Chat() {}

		public Chat(String sender, String message) {
			this.sender = sender;
			this.message = message;
		}

		@Override
		public int length() {
			return Buffer.varuintLength(sender.getBytes(StandardCharsets.UTF_8).length) + sender.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(message.getBytes(StandardCharsets.UTF_8).length) + message.getBytes(StandardCharsets.UTF_8).length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			byte[] c2vuzgvy=sender.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)c2vuzgvy.length); this.writeBytes(c2vuzgvy);
			byte[] bwvzc2fnzq=message.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bwvzc2fnzq.length); this.writeBytes(bwvzc2fnzq);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bgvuc2vuzgvy=this.readVaruint(); sender=new String(this.readBytes(bgvuc2vuzgvy), StandardCharsets.UTF_8);
			int bgvubwvzc2fnzq=this.readVaruint(); message=new String(this.readBytes(bgvubwvzc2fnzq), StandardCharsets.UTF_8);
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

	}

	public class Translation extends Packet {

		public static final byte TYPE = (byte)2;

		public String message;
		public String[] parameters;

		public Translation() {}

		public Translation(String message, String[] parameters) {
			this.message = message;
			this.parameters = parameters;
		}

		@Override
		public int length() {
			int length=Buffer.varuintLength(message.getBytes(StandardCharsets.UTF_8).length) + message.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(parameters.length) + 0; for(String cgfyyw1ldgvycw:parameters){ length+=Buffer.varuintLength(cgfyyw1ldgvycw.getBytes(StandardCharsets.UTF_8).length)+cgfyyw1ldgvycw.getBytes(StandardCharsets.UTF_8).length; } return length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			byte[] bwvzc2fnzq=message.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bwvzc2fnzq.length); this.writeBytes(bwvzc2fnzq);
			this.writeVaruint((int)parameters.length); for(String cgfyyw1ldgvycw:parameters){ byte[] y2dmexl3mwxkz3z5=cgfyyw1ldgvycw.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)y2dmexl3mwxkz3z5.length); this.writeBytes(y2dmexl3mwxkz3z5); }
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bgvubwvzc2fnzq=this.readVaruint(); message=new String(this.readBytes(bgvubwvzc2fnzq), StandardCharsets.UTF_8);
			int bhbhcmftzxrlcnm=this.readVaruint(); parameters=new String[bhbhcmftzxrlcnm]; for(int cgfyyw1ldgvycw=0;cgfyyw1ldgvycw<parameters.length;cgfyyw1ldgvycw++){ int bgvucgfyyw1ldgvy=this.readVaruint(); parameters[cgfyyw1ldgvycw]=new String(this.readBytes(bgvucgfyyw1ldgvy), StandardCharsets.UTF_8); }
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

	}

	public class Popup extends Packet {

		public static final byte TYPE = (byte)3;

		public String title;
		public String subtitle;

		public Popup() {}

		public Popup(String title, String subtitle) {
			this.title = title;
			this.subtitle = subtitle;
		}

		@Override
		public int length() {
			return Buffer.varuintLength(title.getBytes(StandardCharsets.UTF_8).length) + title.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(subtitle.getBytes(StandardCharsets.UTF_8).length) + subtitle.getBytes(StandardCharsets.UTF_8).length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			byte[] dgl0bgu=title.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dgl0bgu.length); this.writeBytes(dgl0bgu);
			byte[] c3vidgl0bgu=subtitle.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)c3vidgl0bgu.length); this.writeBytes(c3vidgl0bgu);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bgvudgl0bgu=this.readVaruint(); title=new String(this.readBytes(bgvudgl0bgu), StandardCharsets.UTF_8);
			int bgvuc3vidgl0bgu=this.readVaruint(); subtitle=new String(this.readBytes(bgvuc3vidgl0bgu), StandardCharsets.UTF_8);
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

	}

	public class Tip extends Packet {

		public static final byte TYPE = (byte)4;

		public String message;

		public Tip() {}

		public Tip(String message) {
			this.message = message;
		}

		@Override
		public int length() {
			return Buffer.varuintLength(message.getBytes(StandardCharsets.UTF_8).length) + message.getBytes(StandardCharsets.UTF_8).length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			byte[] bwvzc2fnzq=message.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bwvzc2fnzq.length); this.writeBytes(bwvzc2fnzq);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bgvubwvzc2fnzq=this.readVaruint(); message=new String(this.readBytes(bgvubwvzc2fnzq), StandardCharsets.UTF_8);
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

	}

	public class System extends Packet {

		public static final byte TYPE = (byte)5;

		public String message;

		public System() {}

		public System(String message) {
			this.message = message;
		}

		@Override
		public int length() {
			return Buffer.varuintLength(message.getBytes(StandardCharsets.UTF_8).length) + message.getBytes(StandardCharsets.UTF_8).length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			byte[] bwvzc2fnzq=message.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bwvzc2fnzq.length); this.writeBytes(bwvzc2fnzq);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bgvubwvzc2fnzq=this.readVaruint(); message=new String(this.readBytes(bgvubwvzc2fnzq), StandardCharsets.UTF_8);
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

	}

	public class Whisper extends Packet {

		public static final byte TYPE = (byte)6;

		public String sender;
		public String message;

		public Whisper() {}

		public Whisper(String sender, String message) {
			this.sender = sender;
			this.message = message;
		}

		@Override
		public int length() {
			return Buffer.varuintLength(sender.getBytes(StandardCharsets.UTF_8).length) + sender.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(message.getBytes(StandardCharsets.UTF_8).length) + message.getBytes(StandardCharsets.UTF_8).length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			byte[] c2vuzgvy=sender.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)c2vuzgvy.length); this.writeBytes(c2vuzgvy);
			byte[] bwvzc2fnzq=message.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bwvzc2fnzq.length); this.writeBytes(bwvzc2fnzq);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bgvuc2vuzgvy=this.readVaruint(); sender=new String(this.readBytes(bgvuc2vuzgvy), StandardCharsets.UTF_8);
			int bgvubwvzc2fnzq=this.readVaruint(); message=new String(this.readBytes(bgvubwvzc2fnzq), StandardCharsets.UTF_8);
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

	}

}
