/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
module sul.protocol.minecraft107.types;

import std.bitmanip : write, peek;
import std.conv : to;
import std.system : Endian;
import std.typecons : Tuple;
import std.uuid : UUID;

import sul.utils.buffer;
import sul.utils.var;

struct Statistic {

	public string name;
	public uint value;

	public pure nothrow @safe void encode(Buffer buffer) {
		with(buffer) {
			writeBytes(varuint.encode(cast(uint)name.length)); writeString(name);
			writeBytes(varuint.encode(value));
		}
	}

	public pure nothrow @safe void decode(Buffer buffer) {
		with(buffer) {
			uint bmftzq=varuint.decode(_buffer, &_index); name=readString(bmftzq);
			value=varuint.decode(_buffer, &_index);
		}
	}

}

struct BlockChange {

	public ubyte xz;
	public ubyte y;
	public uint block;

	public pure nothrow @safe void encode(Buffer buffer) {
		with(buffer) {
			writeBigEndianUbyte(xz);
			writeBigEndianUbyte(y);
			writeBytes(varuint.encode(block));
		}
	}

	public pure nothrow @safe void decode(Buffer buffer) {
		with(buffer) {
			xz=readBigEndianUbyte();
			y=readBigEndianUbyte();
			block=varuint.decode(_buffer, &_index);
		}
	}

}

struct Slot {

	public short id;
	public ubyte count;
	public ushort damage;
	public ubyte[] nbt;

	public pure nothrow @safe void encode(Buffer buffer) {
		with(buffer) {
			writeBigEndianShort(id);
			if(id>0){ writeBigEndianUbyte(count); }
			if(id>0){ writeBigEndianUshort(damage); }
			if(id>0){ writeBytes(nbt); }
		}
	}

	public pure nothrow @safe void decode(Buffer buffer) {
		with(buffer) {
			id=readBigEndianShort();
			if(id>0){ count=readBigEndianUbyte(); }
			if(id>0){ damage=readBigEndianUshort(); }
			if(id>0){ nbt=_buffer[_index..$].dup; _index=_buffer.length; }
		}
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

	public ubyte directionAndType;
	public Tuple!(ubyte, "x", ubyte, "z") position;

	public pure nothrow @safe void encode(Buffer buffer) {
		with(buffer) {
			writeBigEndianUbyte(directionAndType);
			writeBigEndianUbyte(position.x);writeBigEndianUbyte(position.z);
		}
	}

	public pure nothrow @safe void decode(Buffer buffer) {
		with(buffer) {
			directionAndType=readBigEndianUbyte();
			position.x=readBigEndianUbyte();position.z=readBigEndianUbyte();
		}
	}

}

struct Property {

	public string name;
	public string value;
	public bool signed;
	public string signature;

	public pure nothrow @safe void encode(Buffer buffer) {
		with(buffer) {
			writeBytes(varuint.encode(cast(uint)name.length)); writeString(name);
			writeBytes(varuint.encode(cast(uint)value.length)); writeString(value);
			writeBigEndianBool(signed);
			if(signed==true){ writeBytes(varuint.encode(cast(uint)signature.length)); writeString(signature); }
		}
	}

	public pure nothrow @safe void decode(Buffer buffer) {
		with(buffer) {
			uint bmftzq=varuint.decode(_buffer, &_index); name=readString(bmftzq);
			uint dmfsdwu=varuint.decode(_buffer, &_index); value=readString(dmfsdwu);
			signed=readBigEndianBool();
			if(signed==true){ uint c2lnbmf0dxjl=varuint.decode(_buffer, &_index); signature=readString(c2lnbmf0dxjl); }
		}
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
	public sul.protocol.minecraft107.types.Property[] properties;
	public uint gamemode;
	public uint latency;
	public bool hasDisplayName;
	public string displayName;

	public pure nothrow @safe void encode(Buffer buffer) {
		with(buffer) {
			writeBytes(uuid.data);
			writeBytes(varuint.encode(cast(uint)name.length)); writeString(name);
			writeBytes(varuint.encode(cast(uint)properties.length)); foreach(chjvcgvydgllcw;properties){ chjvcgvydgllcw.encode(bufferInstance); }
			writeBytes(varuint.encode(gamemode));
			writeBytes(varuint.encode(latency));
			writeBigEndianBool(hasDisplayName);
			if(hasDisplayName==true){ writeBytes(varuint.encode(cast(uint)displayName.length)); writeString(displayName); }
		}
	}

	public pure nothrow @safe void decode(Buffer buffer) {
		with(buffer) {
			if(_buffer.length>=_index+16){ ubyte[16] dxvpza=_buffer[_index.._index+16].dup; _index+=16; uuid=UUID(dxvpza); }
			uint bmftzq=varuint.decode(_buffer, &_index); name=readString(bmftzq);
			properties.length=varuint.decode(_buffer, &_index); foreach(ref chjvcgvydgllcw;properties){ chjvcgvydgllcw.decode(bufferInstance); }
			gamemode=varuint.decode(_buffer, &_index);
			latency=varuint.decode(_buffer, &_index);
			hasDisplayName=readBigEndianBool();
			if(hasDisplayName==true){ uint zglzcgxheu5hbwu=varuint.decode(_buffer, &_index); displayName=readString(zglzcgxheu5hbwu); }
		}
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

	public pure nothrow @safe void encode(Buffer buffer) {
		with(buffer) {
			writeBytes(uuid.data);
			writeBytes(varuint.encode(gamemode));
		}
	}

	public pure nothrow @safe void decode(Buffer buffer) {
		with(buffer) {
			if(_buffer.length>=_index+16){ ubyte[16] dxvpza=_buffer[_index.._index+16].dup; _index+=16; uuid=UUID(dxvpza); }
			gamemode=varuint.decode(_buffer, &_index);
		}
	}

}

struct ListUpdateLatency {

	public UUID uuid;
	public uint latency;

	public pure nothrow @safe void encode(Buffer buffer) {
		with(buffer) {
			writeBytes(uuid.data);
			writeBytes(varuint.encode(latency));
		}
	}

	public pure nothrow @safe void decode(Buffer buffer) {
		with(buffer) {
			if(_buffer.length>=_index+16){ ubyte[16] dxvpza=_buffer[_index.._index+16].dup; _index+=16; uuid=UUID(dxvpza); }
			latency=varuint.decode(_buffer, &_index);
		}
	}

}

struct ListUpdateDisplayName {

	public UUID uuid;
	public bool hasDisplayName;
	public string displayName;

	public pure nothrow @safe void encode(Buffer buffer) {
		with(buffer) {
			writeBytes(uuid.data);
			writeBigEndianBool(hasDisplayName);
			if(hasDisplayName==true){ writeBytes(varuint.encode(cast(uint)displayName.length)); writeString(displayName); }
		}
	}

	public pure nothrow @safe void decode(Buffer buffer) {
		with(buffer) {
			if(_buffer.length>=_index+16){ ubyte[16] dxvpza=_buffer[_index.._index+16].dup; _index+=16; uuid=UUID(dxvpza); }
			hasDisplayName=readBigEndianBool();
			if(hasDisplayName==true){ uint zglzcgxheu5hbwu=varuint.decode(_buffer, &_index); displayName=readString(zglzcgxheu5hbwu); }
		}
	}

}
