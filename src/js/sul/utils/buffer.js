/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 */
class Buffer {

	constructor() {
		this._buffer = [];
	}

	writeBytes(a) {
		for(var i in a) {
			this._buffer.push(a[i]);
		}
	}

	readBytes(a) {
		var ret = this._buffer.slice(0, a);
		this._buffer = this._buffer.slice(a, this._buffer.length);
		while(ret.length < a) ret.push(0)
		return ret;
	}

	writeBigEndianByte(a) {
		this._buffer.push(a);
	}

	readBigEndianByte(a) {
		return this._buffer.shift();
	}

	writeLittleEndianByte(a) {
		this._buffer.push(a);
	}

	readLittleEndianByte(a) {
		return this._buffer.shift();
	}

	writeBigEndianShort(a) {
		this._buffer.push((a >>> 8) & 255);
		this._buffer.push((a) & 255);
	}

	readBigEndianShort(a) {
		var _ret = 0;
		_ret |= this._buffer.shift() << 8;
		_ret |= this._buffer.shift();
		return _ret;
	}

	writeLittleEndianShort(a) {
		this._buffer.push((a) & 255);
		this._buffer.push((a >>> 8) & 255);
	}

	readLittleEndianShort(a) {
		var _ret = 0;
		_ret |= this._buffer.shift();
		_ret |= this._buffer.shift() << 8;
		return _ret;
	}

	writeBigEndianTriad(a) {
		this._buffer.push((a >>> 16) & 255);
		this._buffer.push((a >>> 8) & 255);
		this._buffer.push((a) & 255);
	}

	readBigEndianTriad(a) {
		var _ret = 0;
		_ret |= this._buffer.shift() << 16;
		_ret |= this._buffer.shift() << 8;
		_ret |= this._buffer.shift();
		return _ret;
	}

	writeLittleEndianTriad(a) {
		this._buffer.push((a) & 255);
		this._buffer.push((a >>> 8) & 255);
		this._buffer.push((a >>> 16) & 255);
	}

	readLittleEndianTriad(a) {
		var _ret = 0;
		_ret |= this._buffer.shift();
		_ret |= this._buffer.shift() << 8;
		_ret |= this._buffer.shift() << 16;
		return _ret;
	}

	writeBigEndianInt(a) {
		this._buffer.push((a >>> 24) & 255);
		this._buffer.push((a >>> 16) & 255);
		this._buffer.push((a >>> 8) & 255);
		this._buffer.push((a) & 255);
	}

	readBigEndianInt(a) {
		var _ret = 0;
		_ret |= this._buffer.shift() << 24;
		_ret |= this._buffer.shift() << 16;
		_ret |= this._buffer.shift() << 8;
		_ret |= this._buffer.shift();
		return _ret;
	}

	writeLittleEndianInt(a) {
		this._buffer.push((a) & 255);
		this._buffer.push((a >>> 8) & 255);
		this._buffer.push((a >>> 16) & 255);
		this._buffer.push((a >>> 24) & 255);
	}

	readLittleEndianInt(a) {
		var _ret = 0;
		_ret |= this._buffer.shift();
		_ret |= this._buffer.shift() << 8;
		_ret |= this._buffer.shift() << 16;
		_ret |= this._buffer.shift() << 24;
		return _ret;
	}

	writeBigEndianLong(a) {
		this._buffer.push((a >>> 56) & 255);
		this._buffer.push((a >>> 48) & 255);
		this._buffer.push((a >>> 40) & 255);
		this._buffer.push((a >>> 32) & 255);
		this._buffer.push((a >>> 24) & 255);
		this._buffer.push((a >>> 16) & 255);
		this._buffer.push((a >>> 8) & 255);
		this._buffer.push((a) & 255);
	}

	readBigEndianLong(a) {
		var _ret = 0;
		_ret |= this._buffer.shift() << 56;
		_ret |= this._buffer.shift() << 48;
		_ret |= this._buffer.shift() << 40;
		_ret |= this._buffer.shift() << 32;
		_ret |= this._buffer.shift() << 24;
		_ret |= this._buffer.shift() << 16;
		_ret |= this._buffer.shift() << 8;
		_ret |= this._buffer.shift();
		return _ret;
	}

	writeLittleEndianLong(a) {
		this._buffer.push((a) & 255);
		this._buffer.push((a >>> 8) & 255);
		this._buffer.push((a >>> 16) & 255);
		this._buffer.push((a >>> 24) & 255);
		this._buffer.push((a >>> 32) & 255);
		this._buffer.push((a >>> 40) & 255);
		this._buffer.push((a >>> 48) & 255);
		this._buffer.push((a >>> 56) & 255);
	}

	readLittleEndianLong(a) {
		var _ret = 0;
		_ret |= this._buffer.shift();
		_ret |= this._buffer.shift() << 8;
		_ret |= this._buffer.shift() << 16;
		_ret |= this._buffer.shift() << 24;
		_ret |= this._buffer.shift() << 32;
		_ret |= this._buffer.shift() << 40;
		_ret |= this._buffer.shift() << 48;
		_ret |= this._buffer.shift() << 56;
		return _ret;
	}

	writeBigEndianFloat(a) {
		this.writeBytes(new Uint8Array(new Float32Array([a]).buffer));
	}

	readBigEndianFloat() {
		return new Float32Array(new Uint8Array(this.readBytes(4)).buffer, 0, 1)[0];
	}

	writeLittleEndianFloat(a) {
		this.writeBytes(new Uint8Array(new Float32Array([a]).buffer));
	}

	readLittleEndianFloat() {
		return new Float32Array(new Uint8Array(this.readBytes(4)).buffer, 0, 1)[0];
	}

	writeBigEndianDouble(a) {
		this.writeBytes(new Uint8Array(new Float64Array([a]).buffer));
	}

	readBigEndianDouble() {
		return new Float64Array(new Uint8Array(this.readBytes(8)).buffer, 0, 1)[0];
	}

	writeLittleEndianDouble(a) {
		this.writeBytes(new Uint8Array(new Float64Array([a]).buffer));
	}

	readLittleEndianDouble() {
		return new Float64Array(new Uint8Array(this.readBytes(8)).buffer, 0, 1)[0];
	}

	writeVarshort(a) {
		this.writeVarushort((a >> 1) | (a << 15));
	}

	readVarshort() {
		var ret = this.readVarushort();
		return (ret << 1) | (ret >> 15);
	}

	writeVarushort(a) {
		this._buffer.push(a & 0x7F);
		while((a & 0x80) != 0) {
			a >>>= 7;
			this._buffer.push(a & 0x7F);
		}
	}

	readVarushort() {
		var limit = 0;
		var ret = 0;
		do {
			ret |= (this._buffer[0] & 0x7F) << (limit * 7);
		} while((this._buffer.shift() & 0x80) != 0 && ++limit < 3);
		return ret;
	}

	writeVarint(a) {
		this.writeVaruint((a >> 1) | (a << 31));
	}

	readVarint() {
		var ret = this.readVaruint();
		return (ret << 1) | (ret >> 31);
	}

	writeVaruint(a) {
		this._buffer.push(a & 0x7F);
		while((a & 0x80) != 0) {
			a >>>= 7;
			this._buffer.push(a & 0x7F);
		}
	}

	readVaruint() {
		var limit = 0;
		var ret = 0;
		do {
			ret |= (this._buffer[0] & 0x7F) << (limit * 7);
		} while((this._buffer.shift() & 0x80) != 0 && ++limit < 5);
		return ret;
	}

	writeVarlong(a) {
		this.writeVarulong((a >> 1) | (a << 63));
	}

	readVarlong() {
		var ret = this.readVarulong();
		return (ret << 1) | (ret >> 63);
	}

	writeVarulong(a) {
		this._buffer.push(a & 0x7F);
		while((a & 0x80) != 0) {
			a >>>= 7;
			this._buffer.push(a & 0x7F);
		}
	}

	readVarulong() {
		var limit = 0;
		var ret = 0;
		do {
			ret |= (this._buffer[0] & 0x7F) << (limit * 7);
		} while((this._buffer.shift() & 0x80) != 0 && ++limit < 10);
		return ret;
	}

	encodeString(string) {
		var conv = unescape(encodeURIComponent(string));
		var ret = [];
		for(var i in conv) ret.push(conv.charCodeAt(i));
		return ret;
	}

	decodeString(array) {
		return decodeURIComponent(escape(String.fromCharCode.apply(null, array)));
	}

}
