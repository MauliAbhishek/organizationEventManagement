package com.orgination.managemen.vo;

public class EventRegisterVo extends EventVo {

	private String eventLbl;
	private String descriptionLbl;
	private String resourcesLbl;
	private Long mid;
	private Long eventId;
	public String getEventLbl() {
		return eventLbl;
	}
	public void setEventLbl(String eventLbl) {
		this.eventLbl = eventLbl;
	}
	public String getDescriptionLbl() {
		return descriptionLbl;
	}
	public void setDescriptionLbl(String descriptionLbl) {
		this.descriptionLbl = descriptionLbl;
	}
	public String getResourcesLbl() {
		return resourcesLbl;
	}
	public void setResourcesLbl(String resourcesLbl) {
		this.resourcesLbl = resourcesLbl;
	}
	public Long getMid() {
		return mid;
	}
	public void setMid(Long mid) {
		this.mid = mid;
	}
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	@Override
	public String toString() {
		return "EventRegisterVo [eventLbl=" + eventLbl + ", descriptionLbl=" + descriptionLbl + ", resourcesLbl="
				+ resourcesLbl + ", mid=" + mid + ", eventId=" + eventId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((descriptionLbl == null) ? 0 : descriptionLbl.hashCode());
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		result = prime * result + ((eventLbl == null) ? 0 : eventLbl.hashCode());
		result = prime * result + ((mid == null) ? 0 : mid.hashCode());
		result = prime * result + ((resourcesLbl == null) ? 0 : resourcesLbl.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventRegisterVo other = (EventRegisterVo) obj;
		if (descriptionLbl == null) {
			if (other.descriptionLbl != null)
				return false;
		} else if (!descriptionLbl.equals(other.descriptionLbl))
			return false;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		if (eventLbl == null) {
			if (other.eventLbl != null)
				return false;
		} else if (!eventLbl.equals(other.eventLbl))
			return false;
		if (mid == null) {
			if (other.mid != null)
				return false;
		} else if (!mid.equals(other.mid))
			return false;
		if (resourcesLbl == null) {
			if (other.resourcesLbl != null)
				return false;
		} else if (!resourcesLbl.equals(other.resourcesLbl))
			return false;
		return true;
	}
	
	
	
	
}
