
package pers.sxp.areablock;

import java.util.Date;

/**
 * 区块链类块
 * @author Bryce
 * 时间:2018年4月15日下午8:16:09
 */
public class Block {
	/**
	 * 本区块的的hash
	 */
	public String hash;
	
	/**
	 * 前一个区块的hash值
	 */
	public String previousHash;	
	
	/**
	 * 数据是一个简单的消息
	 */
	private String data;
	
	/**
	 * 当前时间戳
	 */
	private long timeStamp;
	/**
	 * 工作量
	 */
    private int nonce;
	
	/**
	 * Block Constructor
	 * @param data
	 * @param previousHash
	 */
	public Block(String data, String previousHash){
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = System.currentTimeMillis();
		this.hash = calculateHash();	//写入我们计算出来的hash值
	}
	
	/**
	 * 计算hash值，我们计算的hash值应该包括区块中
	 * 所有我们不希望被恶意篡改的数据
	 * @return
	 */
	public String calculateHash(){
		String calculatedhash = StringUtil.applySha256(
				previousHash + 
				Integer.toString(nonce) +
				Long.toString(timeStamp) + data);
		return calculatedhash;
	}
	
	/**
	 * 获取挖矿工作量
	 * @param difficulty 难度
	 */
	public void mineBlock(int difficulty){
		String target = new String(new char[difficulty]).replace('\0', '0');
		while (!hash.substring(0, difficulty).equals(target)) {
			nonce ++;
			hash = calculateHash();
		}
		System.out.println("区块开采:" + hash);
	}
}
