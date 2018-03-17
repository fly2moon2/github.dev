package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetCountry1Request;
import io.spring.guides.gs_producing_web_service.GetCountry1Response;

@Endpoint
public class Country1Endpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private Country1Repository country1Repository;

	@Autowired
	public Country1Endpoint(Country1Repository country1Repository) {
		this.country1Repository = country1Repository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountry1Request")
	@ResponsePayload
	public GetCountry1Response getCountry(@RequestPayload GetCountry1Request request) {
		GetCountry1Response response = new GetCountry1Response();
		response.setCountry(country1Repository.findCountry(request.getName()));

		return response;
	}
}
