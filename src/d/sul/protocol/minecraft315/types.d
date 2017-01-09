/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft315.xml
 */
module sul.protocol.minecraft315.types;

import std.bitmanip : write, peek;
import std.conv : to;
import std.system : Endian;
import std.typecons : Tuple;
import std.uuid : UUID;

import sul.utils.var;

struct Statistic {

	public string name;
	public uint value;

	public ubyte[] encode() {
		ubyte[] _buffer;
		this.encode(_buffer);
		return _buffer;
	}

	public ubyte[] encode(ref ubyte[] _buffer) {
		ubyte[] bmFtZQ=cast(ubyte[])name; _buffer~=varuint.encode(bmFtZQ.length.to!uint); _buffer~=bmFtZQ;
		_buffer~=varuint.encode(value);
		return _buffer;
	}

	public typeof(this) decode(ubyte[] _buffer, size_t* _index) {
		ubyte[] bmFtZQ; bmFtZQ.length=varuint.decode(_buffer, *_index); if(_buffer.length>=*_index+bmFtZQ.length){ bmFtZQ=_buffer[*_index..*_index+bmFtZQ.length].dup; *_index+=bmFtZQ.length; }; name=cast(string)bmFtZQ;
		value=varuint.decode(_buffer, *_index);
		return this;
	}

}

struct BlockChange {

	public ubyte xz;
	public ubyte y;
	public uint block;

	public ubyte[] encode() {
		ubyte[] _buffer;
		this.encode(_buffer);
		return _buffer;
	}

	public ubyte[] encode(ref ubyte[] _buffer) {
		_buffer~=xz;
		_buffer~=y;
		_buffer~=varuint.encode(block);
		return _buffer;
	}

	public typeof(this) decode(ubyte[] _buffer, size_t* _index) {
		if(_buffer.length>=*_index+ubyte.sizeof){ xz=peek!(ubyte, Endian.bigEndian)(_buffer, _index); }
		if(_buffer.length>=*_index+ubyte.sizeof){ y=peek!(ubyte, Endian.bigEndian)(_buffer, _index); }
		block=varuint.decode(_buffer, *_index);
		return this;
	}

}

struct Slot {

	public short id;
	public ubyte count;
	public ushort damage;
	public ubyte[] nbt;

	public ubyte[] encode() {
		ubyte[] _buffer;
		this.encode(_buffer);
		return _buffer;
	}

	public ubyte[] encode(ref ubyte[] _buffer) {
		_buffer.length+=short.sizeof; write!(short, Endian.bigEndian)(_buffer, id, _buffer.length-short.sizeof);
		if(id>0){ _buffer~=count; }
		if(id>0){ _buffer.length+=ushort.sizeof; write!(ushort, Endian.bigEndian)(_buffer, damage, _buffer.length-ushort.sizeof); }
		if(id>0){ _buffer~=nbt; }
		return _buffer;
	}

	public typeof(this) decode(ubyte[] _buffer, size_t* _index) {
		if(_buffer.length>=*_index+short.sizeof){ id=peek!(short, Endian.bigEndian)(_buffer, _index); }
		if(id>0){ if(_buffer.length>=*_index+ubyte.sizeof){ count=peek!(ubyte, Endian.bigEndian)(_buffer, _index); } }
		if(id>0){ if(_buffer.length>=*_index+ushort.sizeof){ damage=peek!(ushort, Endian.bigEndian)(_buffer, _index); } }
		if(id>0){ nbt=_buffer[*_index..$].dup; *_index=buffer.length; }
		return this;
	}

}

struct Icon {

	// direction and type
	public enum ubyte WHITE_ARROW = 0;
	public enum ubyte GREEN_ARROW = 1;
	public enum ubyte RED_ARROW = 2;
	public enum ubyte BLUE_ARROW = 3;
	public enum ubyte WHITE_CROSS = 4;
	public enum ubyte RED_POINTER = 5;
	public enum ubyte WHITE_CIRCLE = 6;
	public enum ubyte SMALL_WHITE_CIRCLE = 7;
	public enum ubyte MANSION = 8;
	public enum ubyte TEMPLE = 9;

	public ubyte directionAndType;
	public Tuple!(ubyte, "x", ubyte, "z") position;

	public ubyte[] encode() {
		ubyte[] _buffer;
		this.encode(_buffer);
		return _buffer;
	}

	public ubyte[] encode(ref ubyte[] _buffer) {
		_buffer~=directionAndType;
		_buffer~=position.x;_buffer~=position.z;
		return _buffer;
	}

	public typeof(this) decode(ubyte[] _buffer, size_t* _index) {
		if(_buffer.length>=*_index+ubyte.sizeof){ directionAndType=peek!(ubyte, Endian.bigEndian)(_buffer, _index); }
		if(_buffer.length>=*_index+ubyte.sizeof){ position.x=peek!(ubyte, Endian.bigEndian)(_buffer, _index); }if(_buffer.length>=*_index+ubyte.sizeof){ position.z=peek!(ubyte, Endian.bigEndian)(_buffer, _index); }
		return this;
	}

}

struct Property {

	public string name;
	public string value;
	public bool signed;
	public string signature;

	public ubyte[] encode() {
		ubyte[] _buffer;
		this.encode(_buffer);
		return _buffer;
	}

	public ubyte[] encode(ref ubyte[] _buffer) {
		ubyte[] bmFtZQ=cast(ubyte[])name; _buffer~=varuint.encode(bmFtZQ.length.to!uint); _buffer~=bmFtZQ;
		ubyte[] dmFsdWU=cast(ubyte[])value; _buffer~=varuint.encode(dmFsdWU.length.to!uint); _buffer~=dmFsdWU;
		_buffer.length+=bool.sizeof; write!(bool, Endian.bigEndian)(_buffer, signed, _buffer.length-bool.sizeof);
		if(signed==true){ ubyte[] c2lnbmF0dXJl=cast(ubyte[])signature; _buffer~=varuint.encode(c2lnbmF0dXJl.length.to!uint); _buffer~=c2lnbmF0dXJl; }
		return _buffer;
	}

	public typeof(this) decode(ubyte[] _buffer, size_t* _index) {
		ubyte[] bmFtZQ; bmFtZQ.length=varuint.decode(_buffer, *_index); if(_buffer.length>=*_index+bmFtZQ.length){ bmFtZQ=_buffer[*_index..*_index+bmFtZQ.length].dup; *_index+=bmFtZQ.length; }; name=cast(string)bmFtZQ;
		ubyte[] dmFsdWU; dmFsdWU.length=varuint.decode(_buffer, *_index); if(_buffer.length>=*_index+dmFsdWU.length){ dmFsdWU=_buffer[*_index..*_index+dmFsdWU.length].dup; *_index+=dmFsdWU.length; }; value=cast(string)dmFsdWU;
		if(_buffer.length>=*_index+bool.sizeof){ signed=peek!(bool, Endian.bigEndian)(_buffer, _index); }
		if(signed==true){ ubyte[] c2lnbmF0dXJl; c2lnbmF0dXJl.length=varuint.decode(_buffer, *_index); if(_buffer.length>=*_index+c2lnbmF0dXJl.length){ c2lnbmF0dXJl=_buffer[*_index..*_index+c2lnbmF0dXJl.length].dup; *_index+=c2lnbmF0dXJl.length; }; signature=cast(string)c2lnbmF0dXJl; }
		return this;
	}

}

struct ListAddPlayer {

	// gamemode
	public enum uint SURVIVAL = 0;
	public enum uint CREATIVE = 1;
	public enum uint ADVENTURE = 2;
	public enum uint SPECTATOR = 3;

	public UUID uuid;
	public string name;
	public sul.protocol.minecraft315.types.Property[] properties;
	public uint gamemode;
	public uint latency;
	public bool hasDisplayName;
	public string displayName;

	public ubyte[] encode() {
		ubyte[] _buffer;
		this.encode(_buffer);
		return _buffer;
	}

	public ubyte[] encode(ref ubyte[] _buffer) {
		_buffer~=uuid.data;
		ubyte[] bmFtZQ=cast(ubyte[])name; _buffer~=varuint.encode(bmFtZQ.length.to!uint); _buffer~=bmFtZQ;
		_buffer~=varuint.encode(properties.length.to!uint); foreach(cHJvcGVydGllcw;properties){ cHJvcGVydGllcw.encode(_buffer); }
		_buffer~=varuint.encode(gamemode);
		_buffer~=varuint.encode(latency);
		_buffer.length+=bool.sizeof; write!(bool, Endian.bigEndian)(_buffer, hasDisplayName, _buffer.length-bool.sizeof);
		if(has_display_name==true){ ubyte[] ZGlzcGxheU5hbWU=cast(ubyte[])displayName; _buffer~=varuint.encode(ZGlzcGxheU5hbWU.length.to!uint); _buffer~=ZGlzcGxheU5hbWU; }
		return _buffer;
	}

	public typeof(this) decode(ubyte[] _buffer, size_t* _index) {
		if(_buffer.length>=*_index+16){ ubyte[16] dXVpZA=buffer[*_index..*_index+16].dup; *_index+=16; uuid=UUID(dXVpZA); }
		ubyte[] bmFtZQ; bmFtZQ.length=varuint.decode(_buffer, *_index); if(_buffer.length>=*_index+bmFtZQ.length){ bmFtZQ=_buffer[*_index..*_index+bmFtZQ.length].dup; *_index+=bmFtZQ.length; }; name=cast(string)bmFtZQ;
		properties.length=varuint.decode(_buffer, *_index); foreach(ref cHJvcGVydGllcw;properties){ cHJvcGVydGllcw.decode(_buffer, _index); }
		gamemode=varuint.decode(_buffer, *_index);
		latency=varuint.decode(_buffer, *_index);
		if(_buffer.length>=*_index+bool.sizeof){ hasDisplayName=peek!(bool, Endian.bigEndian)(_buffer, _index); }
		if(has_display_name==true){ ubyte[] ZGlzcGxheU5hbWU; ZGlzcGxheU5hbWU.length=varuint.decode(_buffer, *_index); if(_buffer.length>=*_index+ZGlzcGxheU5hbWU.length){ ZGlzcGxheU5hbWU=_buffer[*_index..*_index+ZGlzcGxheU5hbWU.length].dup; *_index+=ZGlzcGxheU5hbWU.length; }; displayName=cast(string)ZGlzcGxheU5hbWU; }
		return this;
	}

}

struct ListUpdateGamemode {

	// gamemode
	public enum uint SURVIVAL = 0;
	public enum uint CREATIVE = 1;
	public enum uint ADVENTURE = 2;
	public enum uint SPECTATOR = 3;

	public UUID uuid;
	public uint gamemode;

	public ubyte[] encode() {
		ubyte[] _buffer;
		this.encode(_buffer);
		return _buffer;
	}

	public ubyte[] encode(ref ubyte[] _buffer) {
		_buffer~=uuid.data;
		_buffer~=varuint.encode(gamemode);
		return _buffer;
	}

	public typeof(this) decode(ubyte[] _buffer, size_t* _index) {
		if(_buffer.length>=*_index+16){ ubyte[16] dXVpZA=buffer[*_index..*_index+16].dup; *_index+=16; uuid=UUID(dXVpZA); }
		gamemode=varuint.decode(_buffer, *_index);
		return this;
	}

}

struct ListUpdateDisplayName {

	public UUID uuid;
	public bool hasDisplayName;
	public string displayName;

	public ubyte[] encode() {
		ubyte[] _buffer;
		this.encode(_buffer);
		return _buffer;
	}

	public ubyte[] encode(ref ubyte[] _buffer) {
		_buffer~=uuid.data;
		_buffer.length+=bool.sizeof; write!(bool, Endian.bigEndian)(_buffer, hasDisplayName, _buffer.length-bool.sizeof);
		if(has_display_name==true){ ubyte[] ZGlzcGxheU5hbWU=cast(ubyte[])displayName; _buffer~=varuint.encode(ZGlzcGxheU5hbWU.length.to!uint); _buffer~=ZGlzcGxheU5hbWU; }
		return _buffer;
	}

	public typeof(this) decode(ubyte[] _buffer, size_t* _index) {
		if(_buffer.length>=*_index+16){ ubyte[16] dXVpZA=buffer[*_index..*_index+16].dup; *_index+=16; uuid=UUID(dXVpZA); }
		if(_buffer.length>=*_index+bool.sizeof){ hasDisplayName=peek!(bool, Endian.bigEndian)(_buffer, _index); }
		if(has_display_name==true){ ubyte[] ZGlzcGxheU5hbWU; ZGlzcGxheU5hbWU.length=varuint.decode(_buffer, *_index); if(_buffer.length>=*_index+ZGlzcGxheU5hbWU.length){ ZGlzcGxheU5hbWU=_buffer[*_index..*_index+ZGlzcGxheU5hbWU.length].dup; *_index+=ZGlzcGxheU5hbWU.length; }; displayName=cast(string)ZGlzcGxheU5hbWU; }
		return this;
	}

}
