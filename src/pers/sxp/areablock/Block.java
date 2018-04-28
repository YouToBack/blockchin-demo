
package pers.sxp.areablock;

import java.util.Date;

/**
 * 区块链类块
 * @author Bryce
 * 时间:2018年4月15日下午8:16:09
 */
public class Block {
	public String hash;
	public String previousHash;
	private String data;	//our data will be a simple message
	private long timeStamp;	//as number of milliseconds since
	
	//Block Constructor
	public Block(String data, String previousHash){
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
	}
}
