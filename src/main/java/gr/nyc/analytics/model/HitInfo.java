package gr.nyc.analytics.model;

import java.util.Date;

public class HitInfo
{
	private String trackingId;
	private Date hitDate;
	private String ip;
	
	public String getTrackingId()
	{
		return trackingId;
	}

	public void setTrackingId(String trackingId)
	{
		this.trackingId = trackingId;
	}

	public Date getHitDate()
	{
		return hitDate;
	}
	
	public void setHitDate(Date hitDate)
	{
		this.hitDate = hitDate;
	}
	
	public String getIp()
	{
		return ip;
	}
	
	public void setIp(String ip)
	{
		this.ip = ip;
	}
	
	@Override
	public String toString()
	{
		return "Tracking Id: " + trackingId + ", Date: " + hitDate + ", IP: " + ip;
	}
}
