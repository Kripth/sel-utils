/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/externalconsole2.xml
 */
/** @module sul/protocol/externalconsole2/login */

//import Types from 'types';

/**
 * Packets used during the authentication process and to exhange the initial server's
 * informations.
 */
const Login = {

	/**
	 * First packet sent by the server when the connection is successfully established.
	 * It contains informations about how the external console shall authenticate itself.
	 */
	AuthCredentials: class extends Buffer {

		static get ID(){ return 0; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		/**
		 * @param protocol
		 *        Protocol used by the server. If the client uses a different one it should close the connection without
		 *        trying to perform authentication.
		 * @param hash
		 *        Whether to perform hashing on the password or not.
		 * @param hashAlgorithm
		 *        Algorithm used by the server to hash the concatenation of the password and the {payload}. The value
		 *        should be sent in lower case without any separation symbol (for example `md5` instead of `MD5`,
		 *        `sha256` instead of `SHA-256`).
		 *        See {Auth.hash} for more details.
		 * @param payload
		 *        Payload to cancatenate to the password before hashing it, as described in the {Auth.hash}'s field
		 *        description.
		 */
		constructor(protocol=0, hash=false, hashAlgorithm="", payload=[]) {
			super();
			this.protocol = protocol;
			this.hash = hash;
			this.hashAlgorithm = hashAlgorithm;
			this.payload = payload;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(0);
			this.writeBigEndianByte(this.protocol);
			this.writeBigEndianByte(this.hash?1:0);
			var dghpcy5oyxnoqwxn=this.encodeString(this.hashAlgorithm); this.writeBigEndianShort(dghpcy5oyxnoqwxn.length); this.writeBytes(dghpcy5oyxnoqwxn);
			this.writeBigEndianShort(this.payload.length); this.writeBytes(this.payload);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			var _id=this.readBigEndianByte();
			this.protocol=this.readBigEndianByte();
			this.hash=this.readBigEndianByte()!==0;
			this.hashAlgorithm=decodeURIComponent(escape(String.fromCharCode.apply(null, this.readBytes(this.readBigEndianShort()))));
			var bhroaxmucgf5bg9h=this.readBigEndianShort(); this.payload=this.readBytes(bhroaxmucgf5bg9h);
			return this;
		}

		static fromBuffer(buffer) {
			return new Login.AuthCredentials().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "AuthCredentials(protocol: " + this.protocol + ", hash: " + this.hash + ", hashAlgorithm: " + this.hashAlgorithm + ", payload: " + this.payload + ")";
		}

	},

	/**
	 * Performs authentication following the instruncions given by the AuthCredentials
	 * packet.
	 */
	Auth: class extends Buffer {

		static get ID(){ return 1; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		/**
		 * @param hash
		 *        Pasword encoded as UTF-8 if {AuthCredentials.hash} is `false` or the hash (specified in {AuthCredentials.hashAlgorithm})
		 *        of the password encoded as UTF-8 concatenated with the bytes from {AuthCredentials.payload}
		 *        if `true`.
		 *        The hash can be done with a function (if hashAlgorithm is `sha1`) in D:
		 */
		constructor(hash=[]) {
			super();
			this.hash = hash;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(1);
			this.writeBigEndianShort(this.hash.length); this.writeBytes(this.hash);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			var _id=this.readBigEndianByte();
			var bhroaxmuagfzaa=this.readBigEndianShort(); this.hash=this.readBytes(bhroaxmuagfzaa);
			return this;
		}

		static fromBuffer(buffer) {
			return new Login.Auth().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Auth(hash: " + this.hash + ")";
		}

	},

	/**
	 * Indicates the status of the authentication process.
	 */
	Welcome: class extends Buffer {

		static get ID(){ return 2; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		constructor(status=0) {
			super();
			this.status = status;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(2);
			this.writeBigEndianByte(this.status);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			var _id=this.readBigEndianByte();
			this.status=this.readBigEndianByte();
			return this;
		}

		static fromBuffer(buffer) {
			return new Login.Welcome().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Welcome(status: " + this.status + ")";
		}

	},

}

//export { Login };
