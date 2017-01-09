/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/raknet8.xml
 */
module sul.protocol.raknet8.control;

import std.bitmanip : write, peek;
import std.conv : to;
import std.system : Endian;
import std.typetuple : TypeTuple;
import std.typecons : Tuple;
import std.uuid : UUID;

import sul.utils.var;

import types = sul.protocol.raknet8.types;

alias Packets = TypeTuple!(Ack, Nack, Encapsulated);

struct Ack {

	public enum ubyte ID = 192;

	public enum bool CLIENTBOUND = true;
	public enum bool SERVERBOUND = true;

	public sul.protocol.raknet8.types.Acknowledge[] packets;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=ID; }
		_buffer.length+=ushort.sizeof; write!(ushort, Endian.bigEndian)(_buffer, packets.length.to!ushort, _buffer.length-ushort.sizeof); foreach(cGFja2V0cw;packets){ cGFja2V0cw.encode(_buffer); }
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; if(_buffer.length>=*_index+ubyte.sizeof){ _id=peek!(ubyte, Endian.bigEndian)(_buffer, _index); } }
		if(_buffer.length>=*_index+ushort.sizeof){ packets.length=peek!(ushort, Endian.bigEndian)(_buffer, _index); } foreach(ref cGFja2V0cw;packets){ cGFja2V0cw.decode(_buffer, _index); }
		return this;
	}

}

struct Nack {

	public enum ubyte ID = 160;

	public enum bool CLIENTBOUND = true;
	public enum bool SERVERBOUND = true;

	public sul.protocol.raknet8.types.Acknowledge[] packets;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=ID; }
		_buffer.length+=ushort.sizeof; write!(ushort, Endian.bigEndian)(_buffer, packets.length.to!ushort, _buffer.length-ushort.sizeof); foreach(cGFja2V0cw;packets){ cGFja2V0cw.encode(_buffer); }
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; if(_buffer.length>=*_index+ubyte.sizeof){ _id=peek!(ubyte, Endian.bigEndian)(_buffer, _index); } }
		if(_buffer.length>=*_index+ushort.sizeof){ packets.length=peek!(ushort, Endian.bigEndian)(_buffer, _index); } foreach(ref cGFja2V0cw;packets){ cGFja2V0cw.decode(_buffer, _index); }
		return this;
	}

}

struct Encapsulated {

	public enum ubyte ID = 132;

	public enum bool CLIENTBOUND = true;
	public enum bool SERVERBOUND = true;

	public int count;
	public sul.protocol.raknet8.types.Encapsulation encapsulation;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=ID; }
		_buffer.length+=3; _buffer[$-3]=count&255; _buffer[$-2]=(count>>8)&255; _buffer[$-1]=(count>>16)&255;
		encapsulation.encode(_buffer);
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; if(_buffer.length>=*_index+ubyte.sizeof){ _id=peek!(ubyte, Endian.bigEndian)(_buffer, _index); } }
		if(_buffer.length>=*_index+3){ count=buffer[*_index]|(buffer[*_index+1]<<8)|(buffer[*_index+2]<<16); *_index+=3; }
		encapsulation.decode(_buffer, _index);
		return this;
	}

}