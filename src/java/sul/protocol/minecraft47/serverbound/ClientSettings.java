/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft47.xml
 */
package sul.protocol.minecraft47.serverbound;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class ClientSettings extends Packet {

	public static final int ID = (int)21;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	// chat mode
	public static final byte ENABLED = 0;
	public static final byte COMMANDS_ONLY = 1;
	public static final byte DISABLED = 2;

	// displayed skin parts
	public static final byte CAPE = 1;
	public static final byte JACKET = 2;
	public static final byte LEFT_SLEEVE = 4;
	public static final byte RIGHT_SLEEVE = 8;
	public static final byte LEFT_PANTS = 16;
	public static final byte RIGHT_PANTS = 32;
	public static final byte HAT = 64;

	// main hand
	public static final byte RIGHT = 0;
	public static final byte LEFT = 1;

	public String language;
	public byte viewDistance;
	public byte chatMode;
	public boolean chatColors;
	public byte displayedSkinParts;
	public byte mainHand;

	public ClientSettings() {}

	public ClientSettings(String language, byte viewDistance, byte chatMode, boolean chatColors, byte displayedSkinParts, byte mainHand) {
		this.language = language;
		this.viewDistance = viewDistance;
		this.chatMode = chatMode;
		this.chatColors = chatColors;
		this.displayedSkinParts = displayedSkinParts;
		this.mainHand = mainHand;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(language.getBytes(StandardCharsets.UTF_8).length) + language.getBytes(StandardCharsets.UTF_8).length + 5;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] bfzvzu=language.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bfzvzu.length); this.writeBytes(bfzvzu);
		this.writeBigEndianByte(viewDistance);
		this.writeBigEndianByte(chatMode);
		this.writeBool(chatColors);
		this.writeBigEndianByte(displayedSkinParts);
		this.writeBigEndianByte(mainHand);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bvbfzvzu=this.readVaruint(); language=new String(this.readBytes(bvbfzvzu), StandardCharsets.UTF_8);
		viewDistance=readBigEndianByte();
		chatMode=readBigEndianByte();
		chatColors=this.readBool();
		displayedSkinParts=readBigEndianByte();
		mainHand=readBigEndianByte();
	}

	public static ClientSettings fromBuffer(byte[] buffer) {
		ClientSettings ret = new ClientSettings();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ClientSettings(language: " + this.language + ", viewDistance: " + this.viewDistance + ", chatMode: " + this.chatMode + ", chatColors: " + this.chatColors + ", displayedSkinParts: " + this.displayedSkinParts + ", mainHand: " + this.mainHand + ")";
	}

}
