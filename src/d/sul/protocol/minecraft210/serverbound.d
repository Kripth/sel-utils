/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
module sul.protocol.minecraft210.serverbound;

import std.bitmanip : write, peek;
import std.conv : to;
import std.system : Endian;
import std.typetuple : TypeTuple;
import std.typecons : Tuple;
import std.uuid : UUID;

import sul.utils.var;

import types = sul.protocol.minecraft210.types;

alias Packets = TypeTuple!(TeleportConfirm, TabComplete, ChatMessage, ClientStatus, ClientSettings, ConfirmTransaction, EnchantItem, ClickWindow, CloseWindow, PluginMessage, UseEntity, KeepAlive, PlayerPosition, Position, PlayerLook, Player, VehicleMove, SteerBoat, PlayerAbilities, PlayerDigging, EntityAction, SteerVehicle, ResourcePackStatus, HeldItemChange, CreativeInventoryAction, UpdateSign, Animation, Spectate, PlayerBlockPlacement, UseItem);

struct TeleportConfirm {

	public enum uint ID = 0;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public uint teleportId;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		_buffer~=varuint.encode(teleportId);
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		teleportId=varuint.decode(_buffer, *_index);
		return this;
	}

}

struct TabComplete {

	public enum uint ID = 1;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public string text;
	public bool command;
	public bool hasPosition;
	public ulong block;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		ubyte[] dGV4dA=cast(ubyte[])text; _buffer~=varuint.encode(dGV4dA.length.to!uint); _buffer~=dGV4dA;
		_buffer.length+=bool.sizeof; write!(bool, Endian.bigEndian)(_buffer, command, _buffer.length-bool.sizeof);
		_buffer.length+=bool.sizeof; write!(bool, Endian.bigEndian)(_buffer, hasPosition, _buffer.length-bool.sizeof);
		if(has_position==true){ _buffer.length+=ulong.sizeof; write!(ulong, Endian.bigEndian)(_buffer, block, _buffer.length-ulong.sizeof); }
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		ubyte[] dGV4dA; dGV4dA.length=varuint.decode(_buffer, *_index); if(_buffer.length>=*_index+dGV4dA.length){ dGV4dA=_buffer[*_index..*_index+dGV4dA.length].dup; *_index+=dGV4dA.length; }; text=cast(string)dGV4dA;
		if(_buffer.length>=*_index+bool.sizeof){ command=peek!(bool, Endian.bigEndian)(_buffer, _index); }
		if(_buffer.length>=*_index+bool.sizeof){ hasPosition=peek!(bool, Endian.bigEndian)(_buffer, _index); }
		if(has_position==true){ if(_buffer.length>=*_index+ulong.sizeof){ block=peek!(ulong, Endian.bigEndian)(_buffer, _index); } }
		return this;
	}

}

struct ChatMessage {

	public enum uint ID = 2;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public string text;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		ubyte[] dGV4dA=cast(ubyte[])text; _buffer~=varuint.encode(dGV4dA.length.to!uint); _buffer~=dGV4dA;
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		ubyte[] dGV4dA; dGV4dA.length=varuint.decode(_buffer, *_index); if(_buffer.length>=*_index+dGV4dA.length){ dGV4dA=_buffer[*_index..*_index+dGV4dA.length].dup; *_index+=dGV4dA.length; }; text=cast(string)dGV4dA;
		return this;
	}

}

struct ClientStatus {

	public enum uint ID = 3;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	// action
	public enum uint RESPAWN = 0;
	public enum uint REQUEST_STATS = 1;
	public enum uint OPEN_INVENTORY = 2;

	public uint action;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		_buffer~=varuint.encode(action);
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		action=varuint.decode(_buffer, *_index);
		return this;
	}

}

struct ClientSettings {

	public enum uint ID = 4;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	// chat mode
	public enum uint ENABLED = 0;
	public enum uint COMMANDS_ONLY = 1;
	public enum uint DISABLED = 2;

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
	public uint chatMode;
	public bool chatColors;
	public ubyte displayedSkinParts;
	public ubyte mainHand;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		ubyte[] bGFuZ3VhZ2U=cast(ubyte[])language; _buffer~=varuint.encode(bGFuZ3VhZ2U.length.to!uint); _buffer~=bGFuZ3VhZ2U;
		_buffer~=viewDistance;
		_buffer~=varuint.encode(chatMode);
		_buffer.length+=bool.sizeof; write!(bool, Endian.bigEndian)(_buffer, chatColors, _buffer.length-bool.sizeof);
		_buffer~=displayedSkinParts;
		_buffer~=mainHand;
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		ubyte[] bGFuZ3VhZ2U; bGFuZ3VhZ2U.length=varuint.decode(_buffer, *_index); if(_buffer.length>=*_index+bGFuZ3VhZ2U.length){ bGFuZ3VhZ2U=_buffer[*_index..*_index+bGFuZ3VhZ2U.length].dup; *_index+=bGFuZ3VhZ2U.length; }; language=cast(string)bGFuZ3VhZ2U;
		if(_buffer.length>=*_index+ubyte.sizeof){ viewDistance=peek!(ubyte, Endian.bigEndian)(_buffer, _index); }
		chatMode=varuint.decode(_buffer, *_index);
		if(_buffer.length>=*_index+bool.sizeof){ chatColors=peek!(bool, Endian.bigEndian)(_buffer, _index); }
		if(_buffer.length>=*_index+ubyte.sizeof){ displayedSkinParts=peek!(ubyte, Endian.bigEndian)(_buffer, _index); }
		if(_buffer.length>=*_index+ubyte.sizeof){ mainHand=peek!(ubyte, Endian.bigEndian)(_buffer, _index); }
		return this;
	}

}

struct ConfirmTransaction {

	public enum uint ID = 5;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public ubyte window;
	public ushort action;
	public bool accepted;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		_buffer~=window;
		_buffer.length+=ushort.sizeof; write!(ushort, Endian.bigEndian)(_buffer, action, _buffer.length-ushort.sizeof);
		_buffer.length+=bool.sizeof; write!(bool, Endian.bigEndian)(_buffer, accepted, _buffer.length-bool.sizeof);
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		if(_buffer.length>=*_index+ubyte.sizeof){ window=peek!(ubyte, Endian.bigEndian)(_buffer, _index); }
		if(_buffer.length>=*_index+ushort.sizeof){ action=peek!(ushort, Endian.bigEndian)(_buffer, _index); }
		if(_buffer.length>=*_index+bool.sizeof){ accepted=peek!(bool, Endian.bigEndian)(_buffer, _index); }
		return this;
	}

}

struct EnchantItem {

	public enum uint ID = 6;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public ubyte window;
	public ubyte enchantment;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		_buffer~=window;
		_buffer~=enchantment;
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		if(_buffer.length>=*_index+ubyte.sizeof){ window=peek!(ubyte, Endian.bigEndian)(_buffer, _index); }
		if(_buffer.length>=*_index+ubyte.sizeof){ enchantment=peek!(ubyte, Endian.bigEndian)(_buffer, _index); }
		return this;
	}

}

struct ClickWindow {

	public enum uint ID = 7;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public ubyte window;
	public ushort slot;
	public ubyte button;
	public ushort action;
	public uint mode;
	public sul.protocol.minecraft210.types.Slot clickedItem;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		_buffer~=window;
		_buffer.length+=ushort.sizeof; write!(ushort, Endian.bigEndian)(_buffer, slot, _buffer.length-ushort.sizeof);
		_buffer~=button;
		_buffer.length+=ushort.sizeof; write!(ushort, Endian.bigEndian)(_buffer, action, _buffer.length-ushort.sizeof);
		_buffer~=varuint.encode(mode);
		clickedItem.encode(_buffer);
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		if(_buffer.length>=*_index+ubyte.sizeof){ window=peek!(ubyte, Endian.bigEndian)(_buffer, _index); }
		if(_buffer.length>=*_index+ushort.sizeof){ slot=peek!(ushort, Endian.bigEndian)(_buffer, _index); }
		if(_buffer.length>=*_index+ubyte.sizeof){ button=peek!(ubyte, Endian.bigEndian)(_buffer, _index); }
		if(_buffer.length>=*_index+ushort.sizeof){ action=peek!(ushort, Endian.bigEndian)(_buffer, _index); }
		mode=varuint.decode(_buffer, *_index);
		clickedItem.decode(_buffer, _index);
		return this;
	}

}

struct CloseWindow {

	public enum uint ID = 8;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public ubyte window;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		_buffer~=window;
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		if(_buffer.length>=*_index+ubyte.sizeof){ window=peek!(ubyte, Endian.bigEndian)(_buffer, _index); }
		return this;
	}

}

struct PluginMessage {

	public enum uint ID = 9;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public string channel;
	public ubyte[] data;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		ubyte[] Y2hhbm5lbA=cast(ubyte[])channel; _buffer~=varuint.encode(Y2hhbm5lbA.length.to!uint); _buffer~=Y2hhbm5lbA;
		_buffer~=data;
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		ubyte[] Y2hhbm5lbA; Y2hhbm5lbA.length=varuint.decode(_buffer, *_index); if(_buffer.length>=*_index+Y2hhbm5lbA.length){ Y2hhbm5lbA=_buffer[*_index..*_index+Y2hhbm5lbA.length].dup; *_index+=Y2hhbm5lbA.length; }; channel=cast(string)Y2hhbm5lbA;
		data=_buffer[*_index..$].dup; *_index=buffer.length;
		return this;
	}

}

struct UseEntity {

	public enum uint ID = 10;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	// type
	public enum uint INTERACT = 0;
	public enum uint ATTACK = 1;
	public enum uint INTERACT_AT = 2;

	// hand
	public enum uint MAIN_HAND = 0;
	public enum uint OFF_HAND = 1;

	public uint target;
	public uint type;
	public Tuple!(float, "x", float, "y", float, "z") targetPosition;
	public uint hand;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		_buffer~=varuint.encode(target);
		_buffer~=varuint.encode(type);
		if(type==2){ _buffer.length+=float.sizeof; write!(float, Endian.bigEndian)(_buffer, targetPosition.x, _buffer.length-float.sizeof);_buffer.length+=float.sizeof; write!(float, Endian.bigEndian)(_buffer, targetPosition.y, _buffer.length-float.sizeof);_buffer.length+=float.sizeof; write!(float, Endian.bigEndian)(_buffer, targetPosition.z, _buffer.length-float.sizeof); }
		if(type==2){ _buffer~=varuint.encode(hand); }
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		target=varuint.decode(_buffer, *_index);
		type=varuint.decode(_buffer, *_index);
		if(type==2){ if(_buffer.length>=*_index+float.sizeof){ targetPosition.x=peek!(float, Endian.bigEndian)(_buffer, _index); }if(_buffer.length>=*_index+float.sizeof){ targetPosition.y=peek!(float, Endian.bigEndian)(_buffer, _index); }if(_buffer.length>=*_index+float.sizeof){ targetPosition.z=peek!(float, Endian.bigEndian)(_buffer, _index); } }
		if(type==2){ hand=varuint.decode(_buffer, *_index); }
		return this;
	}

}

struct KeepAlive {

	public enum uint ID = 11;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public uint id;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		_buffer~=varuint.encode(id);
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		id=varuint.decode(_buffer, *_index);
		return this;
	}

}

struct PlayerPosition {

	public enum uint ID = 12;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public Tuple!(double, "x", double, "y", double, "z") position;
	public bool onGround;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		_buffer.length+=double.sizeof; write!(double, Endian.bigEndian)(_buffer, position.x, _buffer.length-double.sizeof);_buffer.length+=double.sizeof; write!(double, Endian.bigEndian)(_buffer, position.y, _buffer.length-double.sizeof);_buffer.length+=double.sizeof; write!(double, Endian.bigEndian)(_buffer, position.z, _buffer.length-double.sizeof);
		_buffer.length+=bool.sizeof; write!(bool, Endian.bigEndian)(_buffer, onGround, _buffer.length-bool.sizeof);
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		if(_buffer.length>=*_index+double.sizeof){ position.x=peek!(double, Endian.bigEndian)(_buffer, _index); }if(_buffer.length>=*_index+double.sizeof){ position.y=peek!(double, Endian.bigEndian)(_buffer, _index); }if(_buffer.length>=*_index+double.sizeof){ position.z=peek!(double, Endian.bigEndian)(_buffer, _index); }
		if(_buffer.length>=*_index+bool.sizeof){ onGround=peek!(bool, Endian.bigEndian)(_buffer, _index); }
		return this;
	}

}

struct Position {

	public enum uint ID = 13;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public Tuple!(double, "x", double, "y", double, "z") position;
	public float yaw;
	public float pitch;
	public bool onGround;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		_buffer.length+=double.sizeof; write!(double, Endian.bigEndian)(_buffer, position.x, _buffer.length-double.sizeof);_buffer.length+=double.sizeof; write!(double, Endian.bigEndian)(_buffer, position.y, _buffer.length-double.sizeof);_buffer.length+=double.sizeof; write!(double, Endian.bigEndian)(_buffer, position.z, _buffer.length-double.sizeof);
		_buffer.length+=float.sizeof; write!(float, Endian.bigEndian)(_buffer, yaw, _buffer.length-float.sizeof);
		_buffer.length+=float.sizeof; write!(float, Endian.bigEndian)(_buffer, pitch, _buffer.length-float.sizeof);
		_buffer.length+=bool.sizeof; write!(bool, Endian.bigEndian)(_buffer, onGround, _buffer.length-bool.sizeof);
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		if(_buffer.length>=*_index+double.sizeof){ position.x=peek!(double, Endian.bigEndian)(_buffer, _index); }if(_buffer.length>=*_index+double.sizeof){ position.y=peek!(double, Endian.bigEndian)(_buffer, _index); }if(_buffer.length>=*_index+double.sizeof){ position.z=peek!(double, Endian.bigEndian)(_buffer, _index); }
		if(_buffer.length>=*_index+float.sizeof){ yaw=peek!(float, Endian.bigEndian)(_buffer, _index); }
		if(_buffer.length>=*_index+float.sizeof){ pitch=peek!(float, Endian.bigEndian)(_buffer, _index); }
		if(_buffer.length>=*_index+bool.sizeof){ onGround=peek!(bool, Endian.bigEndian)(_buffer, _index); }
		return this;
	}

}

struct PlayerLook {

	public enum uint ID = 14;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public float yaw;
	public float pitch;
	public bool onGround;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		_buffer.length+=float.sizeof; write!(float, Endian.bigEndian)(_buffer, yaw, _buffer.length-float.sizeof);
		_buffer.length+=float.sizeof; write!(float, Endian.bigEndian)(_buffer, pitch, _buffer.length-float.sizeof);
		_buffer.length+=bool.sizeof; write!(bool, Endian.bigEndian)(_buffer, onGround, _buffer.length-bool.sizeof);
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		if(_buffer.length>=*_index+float.sizeof){ yaw=peek!(float, Endian.bigEndian)(_buffer, _index); }
		if(_buffer.length>=*_index+float.sizeof){ pitch=peek!(float, Endian.bigEndian)(_buffer, _index); }
		if(_buffer.length>=*_index+bool.sizeof){ onGround=peek!(bool, Endian.bigEndian)(_buffer, _index); }
		return this;
	}

}

struct Player {

	public enum uint ID = 15;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public bool onGround;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		_buffer.length+=bool.sizeof; write!(bool, Endian.bigEndian)(_buffer, onGround, _buffer.length-bool.sizeof);
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		if(_buffer.length>=*_index+bool.sizeof){ onGround=peek!(bool, Endian.bigEndian)(_buffer, _index); }
		return this;
	}

}

struct VehicleMove {

	public enum uint ID = 16;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public Tuple!(double, "x", double, "y", double, "z") position;
	public float yaw;
	public float pitch;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		_buffer.length+=double.sizeof; write!(double, Endian.bigEndian)(_buffer, position.x, _buffer.length-double.sizeof);_buffer.length+=double.sizeof; write!(double, Endian.bigEndian)(_buffer, position.y, _buffer.length-double.sizeof);_buffer.length+=double.sizeof; write!(double, Endian.bigEndian)(_buffer, position.z, _buffer.length-double.sizeof);
		_buffer.length+=float.sizeof; write!(float, Endian.bigEndian)(_buffer, yaw, _buffer.length-float.sizeof);
		_buffer.length+=float.sizeof; write!(float, Endian.bigEndian)(_buffer, pitch, _buffer.length-float.sizeof);
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		if(_buffer.length>=*_index+double.sizeof){ position.x=peek!(double, Endian.bigEndian)(_buffer, _index); }if(_buffer.length>=*_index+double.sizeof){ position.y=peek!(double, Endian.bigEndian)(_buffer, _index); }if(_buffer.length>=*_index+double.sizeof){ position.z=peek!(double, Endian.bigEndian)(_buffer, _index); }
		if(_buffer.length>=*_index+float.sizeof){ yaw=peek!(float, Endian.bigEndian)(_buffer, _index); }
		if(_buffer.length>=*_index+float.sizeof){ pitch=peek!(float, Endian.bigEndian)(_buffer, _index); }
		return this;
	}

}

struct SteerBoat {

	public enum uint ID = 17;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public bool rightPaddleTurning;
	public bool leftPaddleTurning;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		_buffer.length+=bool.sizeof; write!(bool, Endian.bigEndian)(_buffer, rightPaddleTurning, _buffer.length-bool.sizeof);
		_buffer.length+=bool.sizeof; write!(bool, Endian.bigEndian)(_buffer, leftPaddleTurning, _buffer.length-bool.sizeof);
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		if(_buffer.length>=*_index+bool.sizeof){ rightPaddleTurning=peek!(bool, Endian.bigEndian)(_buffer, _index); }
		if(_buffer.length>=*_index+bool.sizeof){ leftPaddleTurning=peek!(bool, Endian.bigEndian)(_buffer, _index); }
		return this;
	}

}

struct PlayerAbilities {

	public enum uint ID = 18;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	// flags
	public enum ubyte CREATIVE_MODE = 1;
	public enum ubyte FLYING = 2;
	public enum ubyte ALLOW_FLYING = 4;
	public enum ubyte INVINCIBLE = 8;

	public ubyte flags;
	public float flyingSpeed;
	public float walkingSpeed;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		_buffer~=flags;
		_buffer.length+=float.sizeof; write!(float, Endian.bigEndian)(_buffer, flyingSpeed, _buffer.length-float.sizeof);
		_buffer.length+=float.sizeof; write!(float, Endian.bigEndian)(_buffer, walkingSpeed, _buffer.length-float.sizeof);
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		if(_buffer.length>=*_index+ubyte.sizeof){ flags=peek!(ubyte, Endian.bigEndian)(_buffer, _index); }
		if(_buffer.length>=*_index+float.sizeof){ flyingSpeed=peek!(float, Endian.bigEndian)(_buffer, _index); }
		if(_buffer.length>=*_index+float.sizeof){ walkingSpeed=peek!(float, Endian.bigEndian)(_buffer, _index); }
		return this;
	}

}

struct PlayerDigging {

	public enum uint ID = 19;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	// status
	public enum uint START_DIGGING = 0;
	public enum uint CANCEL_DIGGING = 1;
	public enum uint FINISH_DIGGING = 2;
	public enum uint DROP_ITEM_STACK = 3;
	public enum uint DROP_ITEM = 4;
	public enum uint SHOOT_ARROW = 5;
	public enum uint FINISH_EATING = 5;
	public enum uint SWAP_ITEM_IN_HAND = 6;

	public uint status;
	public ulong position;
	public ubyte face;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		_buffer~=varuint.encode(status);
		_buffer.length+=ulong.sizeof; write!(ulong, Endian.bigEndian)(_buffer, position, _buffer.length-ulong.sizeof);
		_buffer~=face;
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		status=varuint.decode(_buffer, *_index);
		if(_buffer.length>=*_index+ulong.sizeof){ position=peek!(ulong, Endian.bigEndian)(_buffer, _index); }
		if(_buffer.length>=*_index+ubyte.sizeof){ face=peek!(ubyte, Endian.bigEndian)(_buffer, _index); }
		return this;
	}

}

struct EntityAction {

	public enum uint ID = 20;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	// action
	public enum uint START_SNEAKING = 0;
	public enum uint STOP_SNEAKING = 1;
	public enum uint LEAVE_BED = 2;
	public enum uint START_SPRINTING = 3;
	public enum uint STOP_SPRINTING = 4;
	public enum uint START_HORSE_JUMP = 5;
	public enum uint STOP_HORSE_JUMP = 6;
	public enum uint OPEN_HORSE_INVENTORY = 7;
	public enum uint START_ELYTRA_FLYING = 8;

	public uint entityId;
	public uint action;
	public uint jumpBoost;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		_buffer~=varuint.encode(entityId);
		_buffer~=varuint.encode(action);
		if(action==5){ _buffer~=varuint.encode(jumpBoost); }
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		entityId=varuint.decode(_buffer, *_index);
		action=varuint.decode(_buffer, *_index);
		if(action==5){ jumpBoost=varuint.decode(_buffer, *_index); }
		return this;
	}

}

struct SteerVehicle {

	public enum uint ID = 21;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	// flags
	public enum ubyte JUMP = 1;
	public enum ubyte UNMOUNT = 2;

	public float sideways;
	public float forward;
	public ubyte flags;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		_buffer.length+=float.sizeof; write!(float, Endian.bigEndian)(_buffer, sideways, _buffer.length-float.sizeof);
		_buffer.length+=float.sizeof; write!(float, Endian.bigEndian)(_buffer, forward, _buffer.length-float.sizeof);
		_buffer~=flags;
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		if(_buffer.length>=*_index+float.sizeof){ sideways=peek!(float, Endian.bigEndian)(_buffer, _index); }
		if(_buffer.length>=*_index+float.sizeof){ forward=peek!(float, Endian.bigEndian)(_buffer, _index); }
		if(_buffer.length>=*_index+ubyte.sizeof){ flags=peek!(ubyte, Endian.bigEndian)(_buffer, _index); }
		return this;
	}

}

struct ResourcePackStatus {

	public enum uint ID = 22;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	// result
	public enum uint LOADED = 0;
	public enum uint DECLINED = 1;
	public enum uint FAILED = 2;
	public enum uint ACCEPTED = 3;

	public uint result;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		_buffer~=varuint.encode(result);
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		result=varuint.decode(_buffer, *_index);
		return this;
	}

}

struct HeldItemChange {

	public enum uint ID = 23;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public ushort slot;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		_buffer.length+=ushort.sizeof; write!(ushort, Endian.bigEndian)(_buffer, slot, _buffer.length-ushort.sizeof);
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		if(_buffer.length>=*_index+ushort.sizeof){ slot=peek!(ushort, Endian.bigEndian)(_buffer, _index); }
		return this;
	}

}

struct CreativeInventoryAction {

	public enum uint ID = 24;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public ushort slot;
	public sul.protocol.minecraft210.types.Slot clickedItem;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		_buffer.length+=ushort.sizeof; write!(ushort, Endian.bigEndian)(_buffer, slot, _buffer.length-ushort.sizeof);
		clickedItem.encode(_buffer);
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		if(_buffer.length>=*_index+ushort.sizeof){ slot=peek!(ushort, Endian.bigEndian)(_buffer, _index); }
		clickedItem.decode(_buffer, _index);
		return this;
	}

}

struct UpdateSign {

	public enum uint ID = 25;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public ulong position;
	public string[4] lines;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		_buffer.length+=ulong.sizeof; write!(ulong, Endian.bigEndian)(_buffer, position, _buffer.length-ulong.sizeof);
		foreach(bGluZXM;lines){ ubyte[] YkdsdVpYTQ=cast(ubyte[])bGluZXM; _buffer~=varuint.encode(YkdsdVpYTQ.length.to!uint); _buffer~=YkdsdVpYTQ; }
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		if(_buffer.length>=*_index+ulong.sizeof){ position=peek!(ulong, Endian.bigEndian)(_buffer, _index); }
		foreach(ref bGluZXM;lines){ ubyte[] YkdsdVpYTQ; YkdsdVpYTQ.length=varuint.decode(_buffer, *_index); if(_buffer.length>=*_index+YkdsdVpYTQ.length){ YkdsdVpYTQ=_buffer[*_index..*_index+YkdsdVpYTQ.length].dup; *_index+=YkdsdVpYTQ.length; }; bGluZXM=cast(string)YkdsdVpYTQ; }
		return this;
	}

}

struct Animation {

	public enum uint ID = 26;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	// hand
	public enum uint MAIN_HAND = 0;
	public enum uint OFF_HAND = 1;

	public uint hand;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		_buffer~=varuint.encode(hand);
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		hand=varuint.decode(_buffer, *_index);
		return this;
	}

}

struct Spectate {

	public enum uint ID = 27;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public UUID player;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		_buffer~=player.data;
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		if(_buffer.length>=*_index+16){ ubyte[16] cGxheWVy=buffer[*_index..*_index+16].dup; *_index+=16; player=UUID(cGxheWVy); }
		return this;
	}

}

struct PlayerBlockPlacement {

	public enum uint ID = 28;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	// hand
	public enum uint MAIN_HAND = 0;
	public enum uint OFF_HAND = 1;

	public ulong position;
	public uint face;
	public uint hand;
	public Tuple!(ubyte, "x", ubyte, "y", ubyte, "z") cursorPosition;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		_buffer.length+=ulong.sizeof; write!(ulong, Endian.bigEndian)(_buffer, position, _buffer.length-ulong.sizeof);
		_buffer~=varuint.encode(face);
		_buffer~=varuint.encode(hand);
		_buffer~=cursorPosition.x;_buffer~=cursorPosition.y;_buffer~=cursorPosition.z;
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		if(_buffer.length>=*_index+ulong.sizeof){ position=peek!(ulong, Endian.bigEndian)(_buffer, _index); }
		face=varuint.decode(_buffer, *_index);
		hand=varuint.decode(_buffer, *_index);
		if(_buffer.length>=*_index+ubyte.sizeof){ cursorPosition.x=peek!(ubyte, Endian.bigEndian)(_buffer, _index); }if(_buffer.length>=*_index+ubyte.sizeof){ cursorPosition.y=peek!(ubyte, Endian.bigEndian)(_buffer, _index); }if(_buffer.length>=*_index+ubyte.sizeof){ cursorPosition.z=peek!(ubyte, Endian.bigEndian)(_buffer, _index); }
		return this;
	}

}

struct UseItem {

	public enum uint ID = 29;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	// hand
	public enum uint MAIN_HAND = 0;
	public enum uint OFF_HAND = 1;

	public uint hand;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		_buffer~=varuint.encode(hand);
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		hand=varuint.decode(_buffer, *_index);
		return this;
	}

}
