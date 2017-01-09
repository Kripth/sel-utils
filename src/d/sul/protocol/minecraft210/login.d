/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
module sul.protocol.minecraft210.login;

import std.bitmanip : write, peek;
import std.conv : to;
import std.system : Endian;
import std.typetuple : TypeTuple;
import std.typecons : Tuple;
import std.uuid : UUID;

import sul.utils.var;

import types = sul.protocol.minecraft210.types;

alias Packets = TypeTuple!(Disconnect, LoginStart, EncryptionRequest, EncryptionResponse, LoginSuccess, SetCompression);

struct Disconnect {

	public enum uint ID = 0;

	public enum bool CLIENTBOUND = true;
	public enum bool SERVERBOUND = false;

	public string reason;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		ubyte[] cmVhc29u=cast(ubyte[])reason; _buffer~=varuint.encode(cmVhc29u.length.to!uint); _buffer~=cmVhc29u;
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		ubyte[] cmVhc29u; cmVhc29u.length=varuint.decode(_buffer, *_index); if(_buffer.length>=*_index+cmVhc29u.length){ cmVhc29u=_buffer[*_index..*_index+cmVhc29u.length].dup; *_index+=cmVhc29u.length; }; reason=cast(string)cmVhc29u;
		return this;
	}

}

struct LoginStart {

	public enum uint ID = 0;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public string username;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		ubyte[] dXNlcm5hbWU=cast(ubyte[])username; _buffer~=varuint.encode(dXNlcm5hbWU.length.to!uint); _buffer~=dXNlcm5hbWU;
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		ubyte[] dXNlcm5hbWU; dXNlcm5hbWU.length=varuint.decode(_buffer, *_index); if(_buffer.length>=*_index+dXNlcm5hbWU.length){ dXNlcm5hbWU=_buffer[*_index..*_index+dXNlcm5hbWU.length].dup; *_index+=dXNlcm5hbWU.length; }; username=cast(string)dXNlcm5hbWU;
		return this;
	}

}

struct EncryptionRequest {

	public enum uint ID = 1;

	public enum bool CLIENTBOUND = true;
	public enum bool SERVERBOUND = false;

	public string serverId;
	public ubyte[] publicKey;
	public ubyte[] verifyToken;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		ubyte[] c2VydmVySWQ=cast(ubyte[])serverId; _buffer~=varuint.encode(c2VydmVySWQ.length.to!uint); _buffer~=c2VydmVySWQ;
		_buffer~=varuint.encode(publicKey.length.to!uint); _buffer~=publicKey;
		_buffer~=varuint.encode(verifyToken.length.to!uint); _buffer~=verifyToken;
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		ubyte[] c2VydmVySWQ; c2VydmVySWQ.length=varuint.decode(_buffer, *_index); if(_buffer.length>=*_index+c2VydmVySWQ.length){ c2VydmVySWQ=_buffer[*_index..*_index+c2VydmVySWQ.length].dup; *_index+=c2VydmVySWQ.length; }; serverId=cast(string)c2VydmVySWQ;
		publicKey.length=varuint.decode(_buffer, *_index); if(_buffer.length>=*_index+publicKey.length){ publicKey=_buffer[*_index..*_index+publicKey.length].dup; *_index+=publicKey.length; }
		verifyToken.length=varuint.decode(_buffer, *_index); if(_buffer.length>=*_index+verifyToken.length){ verifyToken=_buffer[*_index..*_index+verifyToken.length].dup; *_index+=verifyToken.length; }
		return this;
	}

}

struct EncryptionResponse {

	public enum uint ID = 1;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public ubyte[] sharedSecret;
	public ubyte[] verifyToken;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		_buffer~=varuint.encode(sharedSecret.length.to!uint); _buffer~=sharedSecret;
		_buffer~=varuint.encode(verifyToken.length.to!uint); _buffer~=verifyToken;
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		sharedSecret.length=varuint.decode(_buffer, *_index); if(_buffer.length>=*_index+sharedSecret.length){ sharedSecret=_buffer[*_index..*_index+sharedSecret.length].dup; *_index+=sharedSecret.length; }
		verifyToken.length=varuint.decode(_buffer, *_index); if(_buffer.length>=*_index+verifyToken.length){ verifyToken=_buffer[*_index..*_index+verifyToken.length].dup; *_index+=verifyToken.length; }
		return this;
	}

}

struct LoginSuccess {

	public enum uint ID = 2;

	public enum bool CLIENTBOUND = true;
	public enum bool SERVERBOUND = false;

	public string uuid;
	public string username;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		ubyte[] dXVpZA=cast(ubyte[])uuid; _buffer~=varuint.encode(dXVpZA.length.to!uint); _buffer~=dXVpZA;
		ubyte[] dXNlcm5hbWU=cast(ubyte[])username; _buffer~=varuint.encode(dXNlcm5hbWU.length.to!uint); _buffer~=dXNlcm5hbWU;
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		ubyte[] dXVpZA; dXVpZA.length=varuint.decode(_buffer, *_index); if(_buffer.length>=*_index+dXVpZA.length){ dXVpZA=_buffer[*_index..*_index+dXVpZA.length].dup; *_index+=dXVpZA.length; }; uuid=cast(string)dXVpZA;
		ubyte[] dXNlcm5hbWU; dXNlcm5hbWU.length=varuint.decode(_buffer, *_index); if(_buffer.length>=*_index+dXNlcm5hbWU.length){ dXNlcm5hbWU=_buffer[*_index..*_index+dXNlcm5hbWU.length].dup; *_index+=dXNlcm5hbWU.length; }; username=cast(string)dXNlcm5hbWU;
		return this;
	}

}

struct SetCompression {

	public enum uint ID = 3;

	public enum bool CLIENTBOUND = true;
	public enum bool SERVERBOUND = false;

	public uint thresold;

	public ubyte[] encode(bool writeId=true)() {
		ubyte[] _buffer;
		static if(writeId){ _buffer~=varuint.encode(ID); }
		_buffer~=varuint.encode(thresold);
		return _buffer;
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t _index=0) {
		return this.decode!readId(_buffer, &_index);
	}

	public typeof(this) decode(bool readId=true)(ubyte[] _buffer, size_t* _index) {
		static if(readId){ typeof(ID) _id; _id=varuint.decode(_buffer, *_index); }
		thresold=varuint.decode(_buffer, *_index);
		return this;
	}

}
