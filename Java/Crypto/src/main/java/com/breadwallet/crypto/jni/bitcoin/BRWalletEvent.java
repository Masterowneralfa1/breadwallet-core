package com.breadwallet.crypto.jni.bitcoin;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Union;
import java.util.Arrays;
import java.util.List;
/**
 * <i>native declaration : bitcoin/BRWalletManager.h:61</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class BRWalletEvent extends Structure {
	/**
	 * @see BRWalletEventType<br>
	 * C type : BRWalletEventType
	 */
	public int type;
	/** C type : u_union */
	public u_union u;
	/** <i>native declaration : bitcoin/BRWalletManager.h:60</i> */
	public static class u_union extends Union {
		/** C type : balance_struct */
		public balance_struct balance;
		/** C type : submitted_struct */
		public submitted_struct submitted;
		/** <i>native declaration : bitcoin/BRWalletManager.h:54</i> */
		public static class balance_struct extends Structure {
			public long satoshi;
			public balance_struct() {
				super();
			}
			protected List<String> getFieldOrder() {
				return Arrays.asList("satoshi");
			}
			public balance_struct(long satoshi) {
				super();
				this.satoshi = satoshi;
			}
			public balance_struct(Pointer peer) {
				super(peer);
			}
			public static class ByReference extends balance_struct implements Structure.ByReference {
				
			};
			public static class ByValue extends balance_struct implements Structure.ByValue {
				
			};
		};
		/** <i>native declaration : bitcoin/BRWalletManager.h:59</i> */
		public static class submitted_struct extends Structure {
			/** C type : BRTransaction* */
			public BRTransaction.ByReference transaction;
			/** 0 on success */
			public int error;
			public submitted_struct() {
				super();
			}
			protected List<String> getFieldOrder() {
				return Arrays.asList("transaction", "error");
			}
			/**
			 * @param transaction C type : BRTransaction*<br>
			 * @param error 0 on success
			 */
			public submitted_struct(BRTransaction.ByReference transaction, int error) {
				super();
				this.transaction = transaction;
				this.error = error;
			}
			public submitted_struct(Pointer peer) {
				super(peer);
			}
			public static class ByReference extends submitted_struct implements Structure.ByReference {
				
			};
			public static class ByValue extends submitted_struct implements Structure.ByValue {
				
			};
		};
		public u_union() {
			super();
		}
		/** @param balance C type : balance_struct */
		public u_union(balance_struct balance) {
			super();
			this.balance = balance;
			setType(balance_struct.class);
		}
		/** @param submitted C type : submitted_struct */
		public u_union(submitted_struct submitted) {
			super();
			this.submitted = submitted;
			setType(submitted_struct.class);
		}
		public u_union(Pointer peer) {
			super(peer);
		}
		public static class ByReference extends u_union implements Structure.ByReference {
			
		};
		public static class ByValue extends u_union implements Structure.ByValue {
			
		};
	};
	public BRWalletEvent() {
		super();
	}
	protected List<String> getFieldOrder() {
		return Arrays.asList("type", "u");
	}
	/**
	 * @param type @see BRWalletEventType<br>
	 * C type : BRWalletEventType<br>
	 * @param u C type : u_union
	 */
	public BRWalletEvent(int type, u_union u) {
		super();
		this.type = type;
		this.u = u;
	}
	public BRWalletEvent(Pointer peer) {
		super(peer);
	}
	public static class ByReference extends BRWalletEvent implements Structure.ByReference {
		
	};
	public static class ByValue extends BRWalletEvent implements Structure.ByValue {
		
	};

	@Override
	public void read() {
		super.read();
		switch (type){
			case BRWalletEventType.BITCOIN_WALLET_BALANCE_UPDATED:
				u.setType(u_union.balance_struct.class);
				u.read();
				break;
			case BRWalletEventType.BITCOIN_WALLET_TRANSACTION_SUBMITTED:
				u.setType(u_union.submitted_struct.class);
				u.read();
				break;
		}
	}
}
