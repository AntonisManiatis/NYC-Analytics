package gr.nyc.analytics.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "hit")
public class HitStatistics
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	
	@Column(nullable = false)
	private String trackingId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "hitDate")
	private Date hitDate;
	
	private String ip;
	
	public HitStatistics()
	{
		// empty constructor for Hibernate
	}
	
	public HitStatistics(String trackingId, Date hitDate, String ip)
	{
		this.trackingId = trackingId;
		this.hitDate = hitDate;
		this.ip = ip;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

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
}
