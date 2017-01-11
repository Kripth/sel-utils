/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft47.xml
 */
module sul.protocol.minecraft47.serverbound;

import std.bitmanip : write, peek;
import std.conv : to;
import std.system : Endian;
import std.typetuple : TypeTuple;
import std.typecons : Tuple;
import std.uuid : UUID;

import sul.utils.buffer;
import sul.utils.var;

static import sul.protocol.minecraft47.types;

alias Packets = TypeTuple!(KeepAlive, ChatMessage, UseEntity, Player, PlayerPosition, PlayerLook, PlayerPositionAndLook, PlayerDigging, PlayerBlockPlacement, HeldItemChange, Animation, EntityAction, SteerVehicle, CloseWindow, ClickWindow, ConfirmTransaction, CreativeInventoryAction, EnchantItem, UpdateSign, PlayerAbilities, TabComplete, ClientSettings, ClientStatus, PluginMessage, Spectate, ResourcePackStatus);

class KeepAlive : Buffer {

	public enum uint ID = 0;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["id"];

	public uint id;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(uint id) {
		this.id = id;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBytes(varuint.encode(id));
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		id=varuint.decode(_buffer, &_index);
	}

	public static pure nothrow @safe KeepAlive fromBuffer(bool readId=true)(ubyte[] buffer) {
		KeepAlive ret = new KeepAlive();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

class ChatMessage : Buffer {

	public enum uint ID = 1;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["text"];

	public string text;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(string text) {
		this.text = text;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBytes(varuint.encode(cast(uint)text.length)); writeString(text);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		uint dgv4da=varuint.decode(_buffer, &_index); text=readString(dgv4da);
	}

	public static pure nothrow @safe ChatMessage fromBuffer(bool readId=true)(ubyte[] buffer) {
		ChatMessage ret = new ChatMessage();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

class UseEntity : Buffer {

	public enum uint ID = 2;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["target", "type", "targetPosition"];

	// type
	public enum uint INTERACT = 0;
	public enum uint ATTACK = 1;
	public enum uint INTERACT_AT = 2;

	public uint target;
	public uint type;
	public Tuple!(float, "x", float, "y", float, "z") targetPosition;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(uint target, uint type=uint.init, Tuple!(float, "x", float, "y", float, "z") targetPosition=Tuple!(float, "x", float, "y", float, "z").init) {
		this.target = target;
		this.type = type;
		this.targetPosition = targetPosition;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBytes(varuint.encode(target));
		writeBytes(varuint.encode(type));
		if(type==2){ writeBigEndianFloat(targetPosition.x);writeBigEndianFloat(targetPosition.y);writeBigEndianFloat(targetPosition.z); }
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		target=varuint.decode(_buffer, &_index);
		type=varuint.decode(_buffer, &_index);
		if(type==2){ targetPosition.x=readBigEndianFloat();targetPosition.y=readBigEndianFloat();targetPosition.z=readBigEndianFloat(); }
	}

	public static pure nothrow @safe UseEntity fromBuffer(bool readId=true)(ubyte[] buffer) {
		UseEntity ret = new UseEntity();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

class Player : Buffer {

	public enum uint ID = 3;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["onGround"];

	public bool onGround;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(bool onGround) {
		this.onGround = onGround;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBigEndianBool(onGround);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		onGround=readBigEndianBool();
	}

	public static pure nothrow @safe Player fromBuffer(bool readId=true)(ubyte[] buffer) {
		Player ret = new Player();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

class PlayerPosition : Buffer {

	public enum uint ID = 4;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["position", "onGround"];

	public Tuple!(double, "x", double, "y", double, "z") position;
	public bool onGround;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(Tuple!(double, "x", double, "y", double, "z") position, bool onGround=bool.init) {
		this.position = position;
		this.onGround = onGround;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBigEndianDouble(position.x);writeBigEndianDouble(position.y);writeBigEndianDouble(position.z);
		writeBigEndianBool(onGround);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		position.x=readBigEndianDouble();position.y=readBigEndianDouble();position.z=readBigEndianDouble();
		onGround=readBigEndianBool();
	}

	public static pure nothrow @safe PlayerPosition fromBuffer(bool readId=true)(ubyte[] buffer) {
		PlayerPosition ret = new PlayerPosition();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

class PlayerLook : Buffer {

	public enum uint ID = 5;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["yaw", "pitch", "onGround"];

	public float yaw;
	public float pitch;
	public bool onGround;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(float yaw, float pitch=float.init, bool onGround=bool.init) {
		this.yaw = yaw;
		this.pitch = pitch;
		this.onGround = onGround;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBigEndianFloat(yaw);
		writeBigEndianFloat(pitch);
		writeBigEndianBool(onGround);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		yaw=readBigEndianFloat();
		pitch=readBigEndianFloat();
		onGround=readBigEndianBool();
	}

	public static pure nothrow @safe PlayerLook fromBuffer(bool readId=true)(ubyte[] buffer) {
		PlayerLook ret = new PlayerLook();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

class PlayerPositionAndLook : Buffer {

	public enum uint ID = 6;

	public enum bool CLIENTBOUND = true;
	public enum bool SERVERBOUND = false;

	public enum string[] FIELDS = ["position", "yaw", "pitch", "onGround"];

	public Tuple!(double, "x", double, "y", double, "z") position;
	public float yaw;
	public float pitch;
	public bool onGround;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(Tuple!(double, "x", double, "y", double, "z") position, float yaw=float.init, float pitch=float.init, bool onGround=bool.init) {
		this.position = position;
		this.yaw = yaw;
		this.pitch = pitch;
		this.onGround = onGround;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBigEndianDouble(position.x);writeBigEndianDouble(position.y);writeBigEndianDouble(position.z);
		writeBigEndianFloat(yaw);
		writeBigEndianFloat(pitch);
		writeBigEndianBool(onGround);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		position.x=readBigEndianDouble();position.y=readBigEndianDouble();position.z=readBigEndianDouble();
		yaw=readBigEndianFloat();
		pitch=readBigEndianFloat();
		onGround=readBigEndianBool();
	}

	public static pure nothrow @safe PlayerPositionAndLook fromBuffer(bool readId=true)(ubyte[] buffer) {
		PlayerPositionAndLook ret = new PlayerPositionAndLook();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

class PlayerDigging : Buffer {

	public enum uint ID = 7;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["status", "position", "face"];

	// status
	public enum ubyte START_DIGGING = 0;
	public enum ubyte CANCEL_DIGGING = 1;
	public enum ubyte FINISH_DIGGING = 2;
	public enum ubyte DROP_ITEM_STACK = 3;
	public enum ubyte DROP_ITEM = 4;
	public enum ubyte SHOOT_ARROW = 5;
	public enum ubyte FINISH_EATING = 5;

	public ubyte status;
	public ulong position;
	public ubyte face;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(ubyte status, ulong position=ulong.init, ubyte face=ubyte.init) {
		this.status = status;
		this.position = position;
		this.face = face;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBigEndianUbyte(status);
		writeBigEndianUlong(position);
		writeBigEndianUbyte(face);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		status=readBigEndianUbyte();
		position=readBigEndianUlong();
		face=readBigEndianUbyte();
	}

	public static pure nothrow @safe PlayerDigging fromBuffer(bool readId=true)(ubyte[] buffer) {
		PlayerDigging ret = new PlayerDigging();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

class PlayerBlockPlacement : Buffer {

	public enum uint ID = 8;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["position", "face", "heldItem", "cursorPosition"];

	public ulong position;
	public ubyte face;
	public sul.protocol.minecraft47.types.Slot heldItem;
	public Tuple!(ubyte, "x", ubyte, "y", ubyte, "z") cursorPosition;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(ulong position, ubyte face=ubyte.init, sul.protocol.minecraft47.types.Slot heldItem=sul.protocol.minecraft47.types.Slot.init, Tuple!(ubyte, "x", ubyte, "y", ubyte, "z") cursorPosition=Tuple!(ubyte, "x", ubyte, "y", ubyte, "z").init) {
		this.position = position;
		this.face = face;
		this.heldItem = heldItem;
		this.cursorPosition = cursorPosition;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBigEndianUlong(position);
		writeBigEndianUbyte(face);
		heldItem.encode(bufferInstance);
		writeBigEndianUbyte(cursorPosition.x);writeBigEndianUbyte(cursorPosition.y);writeBigEndianUbyte(cursorPosition.z);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		position=readBigEndianUlong();
		face=readBigEndianUbyte();
		heldItem.decode(bufferInstance);
		cursorPosition.x=readBigEndianUbyte();cursorPosition.y=readBigEndianUbyte();cursorPosition.z=readBigEndianUbyte();
	}

	public static pure nothrow @safe PlayerBlockPlacement fromBuffer(bool readId=true)(ubyte[] buffer) {
		PlayerBlockPlacement ret = new PlayerBlockPlacement();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

class HeldItemChange : Buffer {

	public enum uint ID = 9;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["slot"];

	public ushort slot;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(ushort slot) {
		this.slot = slot;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBigEndianUshort(slot);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		slot=readBigEndianUshort();
	}

	public static pure nothrow @safe HeldItemChange fromBuffer(bool readId=true)(ubyte[] buffer) {
		HeldItemChange ret = new HeldItemChange();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

class Animation : Buffer {

	public enum uint ID = 10;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = [];

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
	}

	public static pure nothrow @safe Animation fromBuffer(bool readId=true)(ubyte[] buffer) {
		Animation ret = new Animation();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

class EntityAction : Buffer {

	public enum uint ID = 11;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["entityId", "action", "jumpBoost"];

	// action
	public enum uint START_SNEAKING = 0;
	public enum uint STOP_SNEAKING = 1;
	public enum uint LEAVE_BED = 2;
	public enum uint START_SPRINTING = 3;
	public enum uint STOP_SPRINTING = 4;
	public enum uint START_HORSE_JUMP = 5;
	public enum uint STOP_HORSE_JUMP = 6;

	public uint entityId;
	public uint action;
	public uint jumpBoost;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(uint entityId, uint action=uint.init, uint jumpBoost=uint.init) {
		this.entityId = entityId;
		this.action = action;
		this.jumpBoost = jumpBoost;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBytes(varuint.encode(entityId));
		writeBytes(varuint.encode(action));
		if(action==5){ writeBytes(varuint.encode(jumpBoost)); }
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		entityId=varuint.decode(_buffer, &_index);
		action=varuint.decode(_buffer, &_index);
		if(action==5){ jumpBoost=varuint.decode(_buffer, &_index); }
	}

	public static pure nothrow @safe EntityAction fromBuffer(bool readId=true)(ubyte[] buffer) {
		EntityAction ret = new EntityAction();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

class SteerVehicle : Buffer {

	public enum uint ID = 12;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["sideways", "forward", "flags"];

	// flags
	public enum ubyte JUMP = 1;
	public enum ubyte UNMOUNT = 2;

	public float sideways;
	public float forward;
	public ubyte flags;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(float sideways, float forward=float.init, ubyte flags=ubyte.init) {
		this.sideways = sideways;
		this.forward = forward;
		this.flags = flags;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBigEndianFloat(sideways);
		writeBigEndianFloat(forward);
		writeBigEndianUbyte(flags);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		sideways=readBigEndianFloat();
		forward=readBigEndianFloat();
		flags=readBigEndianUbyte();
	}

	public static pure nothrow @safe SteerVehicle fromBuffer(bool readId=true)(ubyte[] buffer) {
		SteerVehicle ret = new SteerVehicle();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

class CloseWindow : Buffer {

	public enum uint ID = 13;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["window"];

	public ubyte window;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(ubyte window) {
		this.window = window;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBigEndianUbyte(window);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		window=readBigEndianUbyte();
	}

	public static pure nothrow @safe CloseWindow fromBuffer(bool readId=true)(ubyte[] buffer) {
		CloseWindow ret = new CloseWindow();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

class ClickWindow : Buffer {

	public enum uint ID = 14;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["window", "slot", "button", "action", "mode", "clickedItem"];

	public ubyte window;
	public ushort slot;
	public ubyte button;
	public ushort action;
	public uint mode;
	public sul.protocol.minecraft47.types.Slot clickedItem;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(ubyte window, ushort slot=ushort.init, ubyte button=ubyte.init, ushort action=ushort.init, uint mode=uint.init, sul.protocol.minecraft47.types.Slot clickedItem=sul.protocol.minecraft47.types.Slot.init) {
		this.window = window;
		this.slot = slot;
		this.button = button;
		this.action = action;
		this.mode = mode;
		this.clickedItem = clickedItem;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBigEndianUbyte(window);
		writeBigEndianUshort(slot);
		writeBigEndianUbyte(button);
		writeBigEndianUshort(action);
		writeBytes(varuint.encode(mode));
		clickedItem.encode(bufferInstance);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		window=readBigEndianUbyte();
		slot=readBigEndianUshort();
		button=readBigEndianUbyte();
		action=readBigEndianUshort();
		mode=varuint.decode(_buffer, &_index);
		clickedItem.decode(bufferInstance);
	}

	public static pure nothrow @safe ClickWindow fromBuffer(bool readId=true)(ubyte[] buffer) {
		ClickWindow ret = new ClickWindow();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

class ConfirmTransaction : Buffer {

	public enum uint ID = 15;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["window", "action", "accepted"];

	public ubyte window;
	public ushort action;
	public bool accepted;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(ubyte window, ushort action=ushort.init, bool accepted=bool.init) {
		this.window = window;
		this.action = action;
		this.accepted = accepted;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBigEndianUbyte(window);
		writeBigEndianUshort(action);
		writeBigEndianBool(accepted);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		window=readBigEndianUbyte();
		action=readBigEndianUshort();
		accepted=readBigEndianBool();
	}

	public static pure nothrow @safe ConfirmTransaction fromBuffer(bool readId=true)(ubyte[] buffer) {
		ConfirmTransaction ret = new ConfirmTransaction();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

class CreativeInventoryAction : Buffer {

	public enum uint ID = 16;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["slot", "clickedItem"];

	public ushort slot;
	public sul.protocol.minecraft47.types.Slot clickedItem;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(ushort slot, sul.protocol.minecraft47.types.Slot clickedItem=sul.protocol.minecraft47.types.Slot.init) {
		this.slot = slot;
		this.clickedItem = clickedItem;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBigEndianUshort(slot);
		clickedItem.encode(bufferInstance);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		slot=readBigEndianUshort();
		clickedItem.decode(bufferInstance);
	}

	public static pure nothrow @safe CreativeInventoryAction fromBuffer(bool readId=true)(ubyte[] buffer) {
		CreativeInventoryAction ret = new CreativeInventoryAction();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

class EnchantItem : Buffer {

	public enum uint ID = 17;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["window", "enchantment"];

	public ubyte window;
	public ubyte enchantment;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(ubyte window, ubyte enchantment=ubyte.init) {
		this.window = window;
		this.enchantment = enchantment;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBigEndianUbyte(window);
		writeBigEndianUbyte(enchantment);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		window=readBigEndianUbyte();
		enchantment=readBigEndianUbyte();
	}

	public static pure nothrow @safe EnchantItem fromBuffer(bool readId=true)(ubyte[] buffer) {
		EnchantItem ret = new EnchantItem();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

class UpdateSign : Buffer {

	public enum uint ID = 18;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["position", "lines"];

	public ulong position;
	public string[4] lines;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(ulong position, string[4] lines=(string[4]).init) {
		this.position = position;
		this.lines = lines;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBigEndianUlong(position);
		foreach(bgluzxm;lines){ writeBytes(varuint.encode(cast(uint)bgluzxm.length)); writeString(bgluzxm); }
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		position=readBigEndianUlong();
		foreach(ref bgluzxm;lines){ uint ymdsdxp4bq=varuint.decode(_buffer, &_index); bgluzxm=readString(ymdsdxp4bq); }
	}

	public static pure nothrow @safe UpdateSign fromBuffer(bool readId=true)(ubyte[] buffer) {
		UpdateSign ret = new UpdateSign();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

class PlayerAbilities : Buffer {

	public enum uint ID = 19;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["flags", "flyingSpeed", "walkingSpeed"];

	// flags
	public enum ubyte CREATIVE_MODE = 1;
	public enum ubyte FLYING = 2;
	public enum ubyte ALLOW_FLYING = 4;
	public enum ubyte INVINCIBLE = 8;

	public ubyte flags;
	public float flyingSpeed;
	public float walkingSpeed;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(ubyte flags, float flyingSpeed=float.init, float walkingSpeed=float.init) {
		this.flags = flags;
		this.flyingSpeed = flyingSpeed;
		this.walkingSpeed = walkingSpeed;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBigEndianUbyte(flags);
		writeBigEndianFloat(flyingSpeed);
		writeBigEndianFloat(walkingSpeed);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		flags=readBigEndianUbyte();
		flyingSpeed=readBigEndianFloat();
		walkingSpeed=readBigEndianFloat();
	}

	public static pure nothrow @safe PlayerAbilities fromBuffer(bool readId=true)(ubyte[] buffer) {
		PlayerAbilities ret = new PlayerAbilities();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

class TabComplete : Buffer {

	public enum uint ID = 20;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["text", "hasPosition", "block"];

	public string text;
	public bool hasPosition;
	public ulong block;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(string text, bool hasPosition=bool.init, ulong block=ulong.init) {
		this.text = text;
		this.hasPosition = hasPosition;
		this.block = block;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBytes(varuint.encode(cast(uint)text.length)); writeString(text);
		writeBigEndianBool(hasPosition);
		if(hasPosition==true){ writeBigEndianUlong(block); }
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		uint dgv4da=varuint.decode(_buffer, &_index); text=readString(dgv4da);
		hasPosition=readBigEndianBool();
		if(hasPosition==true){ block=readBigEndianUlong(); }
	}

	public static pure nothrow @safe TabComplete fromBuffer(bool readId=true)(ubyte[] buffer) {
		TabComplete ret = new TabComplete();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

class ClientSettings : Buffer {

	public enum uint ID = 21;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["language", "viewDistance", "chatMode", "chatColors", "displayedSkinParts", "mainHand"];

	// chat mode
	public enum ubyte ENABLED = 0;
	public enum ubyte COMMANDS_ONLY = 1;
	public enum ubyte DISABLED = 2;

	// displayed skin parts
	public enum ubyte CAPE = 1;
	public enum ubyte JACKET = 2;
	public enum ubyte LEFT_SLEEVE = 4;
	public enum ubyte RIGHT_SLEEVE = 8;
	public enum ubyte LEFT_PANTS = 16;
	public enum ubyte RIGHT_PANTS = 32;
	public enum ubyte HAT = 64;

	// main hand
	public enum ubyte RIGHT = 0;
	public enum ubyte LEFT = 1;

	public string language;
	public ubyte viewDistance;
	public ubyte chatMode;
	public bool chatColors;
	public ubyte displayedSkinParts;
	public ubyte mainHand;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(string language, ubyte viewDistance=ubyte.init, ubyte chatMode=ubyte.init, bool chatColors=bool.init, ubyte displayedSkinParts=ubyte.init, ubyte mainHand=ubyte.init) {
		this.language = language;
		this.viewDistance = viewDistance;
		this.chatMode = chatMode;
		this.chatColors = chatColors;
		this.displayedSkinParts = displayedSkinParts;
		this.mainHand = mainHand;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBytes(varuint.encode(cast(uint)language.length)); writeString(language);
		writeBigEndianUbyte(viewDistance);
		writeBigEndianUbyte(chatMode);
		writeBigEndianBool(chatColors);
		writeBigEndianUbyte(displayedSkinParts);
		writeBigEndianUbyte(mainHand);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		uint bgfuz3vhz2u=varuint.decode(_buffer, &_index); language=readString(bgfuz3vhz2u);
		viewDistance=readBigEndianUbyte();
		chatMode=readBigEndianUbyte();
		chatColors=readBigEndianBool();
		displayedSkinParts=readBigEndianUbyte();
		mainHand=readBigEndianUbyte();
	}

	public static pure nothrow @safe ClientSettings fromBuffer(bool readId=true)(ubyte[] buffer) {
		ClientSettings ret = new ClientSettings();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

class ClientStatus : Buffer {

	public enum uint ID = 22;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["action"];

	// action
	public enum uint RESPAWN = 0;
	public enum uint REQUEST_STATS = 1;
	public enum uint OPEN_INVENTORY = 2;

	public uint action;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(uint action) {
		this.action = action;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBytes(varuint.encode(action));
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		action=varuint.decode(_buffer, &_index);
	}

	public static pure nothrow @safe ClientStatus fromBuffer(bool readId=true)(ubyte[] buffer) {
		ClientStatus ret = new ClientStatus();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

class PluginMessage : Buffer {

	public enum uint ID = 23;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["channel", "data"];

	public string channel;
	public ubyte[] data;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(string channel, ubyte[] data=(ubyte[]).init) {
		this.channel = channel;
		this.data = data;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBytes(varuint.encode(cast(uint)channel.length)); writeString(channel);
		writeBytes(data);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		uint y2hhbm5lba=varuint.decode(_buffer, &_index); channel=readString(y2hhbm5lba);
		data=_buffer[_index..$].dup; _index=_buffer.length;
	}

	public static pure nothrow @safe PluginMessage fromBuffer(bool readId=true)(ubyte[] buffer) {
		PluginMessage ret = new PluginMessage();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

class Spectate : Buffer {

	public enum uint ID = 24;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["player"];

	public UUID player;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(UUID player) {
		this.player = player;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBytes(player.data);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		if(_buffer.length>=_index+16){ ubyte[16] cgxhewvy=_buffer[_index.._index+16].dup; _index+=16; player=UUID(cgxhewvy); }
	}

	public static pure nothrow @safe Spectate fromBuffer(bool readId=true)(ubyte[] buffer) {
		Spectate ret = new Spectate();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}

class ResourcePackStatus : Buffer {

	public enum uint ID = 25;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["hash", "result"];

	// result
	public enum uint LOADED = 0;
	public enum uint DECLINED = 1;
	public enum uint FAILED = 2;
	public enum uint ACCEPTED = 3;

	public string hash;
	public uint result;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(string hash, uint result=uint.init) {
		this.hash = hash;
		this.result = result;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBytes(varuint.encode(cast(uint)hash.length)); writeString(hash);
		writeBytes(varuint.encode(result));
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		uint agfzaa=varuint.decode(_buffer, &_index); hash=readString(agfzaa);
		result=varuint.decode(_buffer, &_index);
	}

	public static pure nothrow @safe ResourcePackStatus fromBuffer(bool readId=true)(ubyte[] buffer) {
		ResourcePackStatus ret = new ResourcePackStatus();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

}
