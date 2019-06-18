package gr.nyc.analytics.model;

import java.util.UUID;

public class SiteInfo
{
	private String siteName;
	private UUID trackingId;
	
	public SiteInfo(String siteName, UUID trackingId)
	{
		this.siteName = siteName;
		this.trackingId = trackingId;
	}
	
	public String getSiteName()
	{
		return siteName;
	}
	
	public void setSiteName(String siteName)
	{
		this.siteName = siteName;
	}
	
	public UUID getTrackingId()
	{
		return trackingId;
	}
	
	public void setTrackingId(UUID trackingId)
	{
		this.trackingId = trackingId;
	}
}
