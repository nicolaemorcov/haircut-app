package com.commons.service;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ServiceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serviceId;
	@Column(name = "service_name")
	private String serviceName;
	@Column(name = "service_price")
	private double servicePrice;
	@Column(name = "service_description")
	private String serviceDescription;
	
	//constructor
	//constructor
		public ServiceEntity(int serviceId, String serviceName, double servicePrice, String description) {
			this.setServiceId(serviceId);
			this.setServiceName(serviceName);
			this.setServicePrice(servicePrice);
			this.setServiceDescription(description);
		}
	
		//getters
		public int getServiceId() {
			return serviceId;
		}
		public String getServiceName() {
			return serviceName;
		}
		public double getServicePrice() {
			return servicePrice;
		}
		public String getServiceDescription() {
			return serviceDescription;
			}
		
		//setters
		public void setServiceId(int serviceId) {
			this.serviceId = serviceId;
			}
		public void setServiceName(String serviceName) {
			this.serviceName = serviceName;
			}
		public void setServicePrice(double servicePrice) {
			this.servicePrice = servicePrice;
			}
		public void setServiceDescription(String description) {
			this.serviceDescription = description;
		}

	
	//add services to list
	public void addService(ServiceEntity newService) {
		System.out.println("Adding to dataBase");
	}
	
	//remove service from list
	public void removeService(ServiceEntity service) {
		System.out.println("Remove from database");
	}
	
//	System.out.println(Arrays.toString(services.toArray()));
	
	
	
	
	
	
	
	
	
}
	