package com.mp.database.message;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Message {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String senderUid;
	private String reciverUid;
	
	private Date sendTime;
	
	@Lob
	@Column(length = 1000)
	private String content;
	
	Message(){}
	
	public Message(String senderUid, String reciverUid, Date sendTime, String content) {
		this.senderUid = senderUid;
		this.reciverUid = reciverUid;
		this.sendTime = sendTime;
		this.content = content;
	}
	
	public String getSenderUid() {
		return senderUid;
	}



	public void setSenderUid(String senderUid) {
		this.senderUid = senderUid;
	}



	public String getReciverUid() {
		return reciverUid;
	}



	public void setReciverUid(String reciverUid) {
		this.reciverUid = reciverUid;
	}



	public Date getSendTime() {
		return sendTime;
	}



	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	private Long generateId() {
		Long result  = Long.valueOf(senderUid.hashCode() + reciverUid.hashCode() + sendTime.hashCode());
		return result;
	}

}
