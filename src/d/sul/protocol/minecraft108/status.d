/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft108.xml
 */
module sul.protocol.minecraft108.status;

import std.bitmanip : write, peek;
import std.conv : to;
import std.system : Endian;
import std.typetuple : TypeTuple;
import std.typecons : Tuple;
import std.uuid : UUID;

import sul.utils.var;

import types = sul.protocol.minecraft108.types;

alias Packets = TypeTuple!(Handshake, Request, Response, Latency);

struct Handshake {

	public enum uint ID = 0;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	// next
	public enum uint STATUS = 1;
	public enum uint LOGIN = 2;

	public uint protocol;
	public string serverAddress;
	public ushort serverPort;
	public uint next;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		_buffer~=varuint.encode(protocol);
		ubyte[] c2VydmVyQWRkcmVz=cast(ubyte[])serverAddress; _buffer~=varuint.encode(c2VydmVyQWRkcmVz.length.to!uint); _buffer~=c2VydmVyQWRkcmVz;
		_buffer.length+=ushort.sizeof; write!(ushort, Endian.bigEndian)(_buffer, serverPort, _buffer.length-ushort.sizeof);
		_buffer~=varuint.encode(next);
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		protocol=varuint.decode(_buffer, *_index);
		ubyte[] c2VydmVyQWRkcmVz; c2VydmVyQWRkcmVz.length=varuint.decode(_buffer, *_index); if(_buffer.length>=*_index+c2VydmVyQWRkcmVz.length){ c2VydmVyQWRkcmVz=_buffer[*_index..*_index+c2VydmVyQWRkcmVz.length].dup; *_index+=c2VydmVyQWRkcmVz.length; }; serverAddress=cast(string)c2VydmVyQWRkcmVz;
		if(_buffer.length>=*_index+ushort.sizeof){ serverPort=peek!(ushort, Endian.bigEndian)(_buffer, _index); }
		next=varuint.decode(_buffer, *_index);
		return this;
	}

}

struct Request {

	public enum uint ID = 0;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		return this;
	}

}

struct Response {

	public enum uint ID = 0;

	public enum bool CLIENTBOUND = true;
	public enum bool SERVERBOUND = false;

	public string json;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		ubyte[] anNvbg=cast(ubyte[])json; _buffer~=varuint.encode(anNvbg.length.to!uint); _buffer~=anNvbg;
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		ubyte[] anNvbg; anNvbg.length=varuint.decode(_buffer, *_index); if(_buffer.length>=*_index+anNvbg.length){ anNvbg=_buffer[*_index..*_index+anNvbg.length].dup; *_index+=anNvbg.length; }; json=cast(string)anNvbg;
		return this;
	}

}

struct Latency {

	public enum uint ID = 1;

	public enum bool CLIENTBOUND = true;
	public enum bool SERVERBOUND = true;

	public long id;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		_buffer.length+=long.sizeof; write!(long, Endian.bigEndian)(_buffer, id, _buffer.length-long.sizeof);
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		if(_buffer.length>=*_index+long.sizeof){ id=peek!(long, Endian.bigEndian)(_buffer, _index); }
		return this;
	}

}
