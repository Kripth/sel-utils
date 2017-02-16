/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft47.xml
 */
/** @module sul/protocol/minecraft47/login */

//import Types from 'types';

const Login = {

	Disconnect: class extends Buffer {

		static get ID(){ return 0; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		constructor(reason="") {
			super();
			this.reason = reason;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeVaruint(0);
			var dhc5zfb4=this.encodeString(this.reason); this.writeVaruint(dhc5zfb4.length); this.writeBytes(dhc5zfb4);
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			var _id=this.readVaruint();
			this.reason=this.decodeString(this.readBytes(this.readVaruint()));
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Login.Disconnect().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Disconnect(reason: " + this.reason + ")";
		}

	},

	LoginStart: class extends Buffer {

		static get ID(){ return 0; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		constructor(username="") {
			super();
			this.username = username;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeVaruint(0);
			var dhc5cvbf=this.encodeString(this.username); this.writeVaruint(dhc5cvbf.length); this.writeBytes(dhc5cvbf);
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			var _id=this.readVaruint();
			this.username=this.decodeString(this.readBytes(this.readVaruint()));
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Login.LoginStart().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "LoginStart(username: " + this.username + ")";
		}

	},

	EncryptionRequest: class extends Buffer {

		static get ID(){ return 1; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		constructor(serverId="", publicKey=[], verifyToken=[]) {
			super();
			this.serverId = serverId;
			this.publicKey = publicKey;
			this.verifyToken = verifyToken;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeVaruint(1);
			var dhc5zjzj=this.encodeString(this.serverId); this.writeVaruint(dhc5zjzj.length); this.writeBytes(dhc5zjzj);
			this.writeVaruint(this.publicKey.length); this.writeBytes(this.publicKey);
			this.writeVaruint(this.verifyToken.length); this.writeBytes(this.verifyToken);
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			var _id=this.readVaruint();
			this.serverId=this.decodeString(this.readBytes(this.readVaruint()));
			var aramcvbl=this.readVaruint(); this.publicKey=this.readBytes(aramcvbl);
			var aramdvaz=this.readVaruint(); this.verifyToken=this.readBytes(aramdvaz);
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Login.EncryptionRequest().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "EncryptionRequest(serverId: " + this.serverId + ", publicKey: " + this.publicKey + ", verifyToken: " + this.verifyToken + ")";
		}

	},

	EncryptionResponse: class extends Buffer {

		static get ID(){ return 1; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		constructor(sharedSecret=[], verifyToken=[]) {
			super();
			this.sharedSecret = sharedSecret;
			this.verifyToken = verifyToken;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeVaruint(1);
			this.writeVaruint(this.sharedSecret.length); this.writeBytes(this.sharedSecret);
			this.writeVaruint(this.verifyToken.length); this.writeBytes(this.verifyToken);
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			var _id=this.readVaruint();
			var aramchcv=this.readVaruint(); this.sharedSecret=this.readBytes(aramchcv);
			var aramdvaz=this.readVaruint(); this.verifyToken=this.readBytes(aramdvaz);
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Login.EncryptionResponse().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "EncryptionResponse(sharedSecret: " + this.sharedSecret + ", verifyToken: " + this.verifyToken + ")";
		}

	},

	LoginSuccess: class extends Buffer {

		static get ID(){ return 2; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		constructor(uuid="", username="") {
			super();
			this.uuid = uuid;
			this.username = username;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeVaruint(2);
			var dhc5dl=this.encodeString(this.uuid); this.writeVaruint(dhc5dl.length); this.writeBytes(dhc5dl);
			var dhc5cvbf=this.encodeString(this.username); this.writeVaruint(dhc5cvbf.length); this.writeBytes(dhc5cvbf);
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			var _id=this.readVaruint();
			this.uuid=this.decodeString(this.readBytes(this.readVaruint()));
			this.username=this.decodeString(this.readBytes(this.readVaruint()));
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Login.LoginSuccess().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "LoginSuccess(uuid: " + this.uuid + ", username: " + this.username + ")";
		}

	},

	SetCompression: class extends Buffer {

		static get ID(){ return 3; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		constructor(thresold=0) {
			super();
			this.thresold = thresold;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeVaruint(3);
			this.writeVaruint(this.thresold);
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			var _id=this.readVaruint();
			this.thresold=this.readVaruint();
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Login.SetCompression().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "SetCompression(thresold: " + this.thresold + ")";
		}

	},

}

//export { Login };
