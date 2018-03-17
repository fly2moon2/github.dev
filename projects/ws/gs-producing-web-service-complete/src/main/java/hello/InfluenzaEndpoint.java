package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.InfluenzaReq;
import io.spring.guides.gs_producing_web_service.InfluenzaRsp;
import io.spring.guides.gs_producing_web_service.InfluenzaRspDtl;

@Endpoint
public class InfluenzaEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private InfluenzaRepository fluRepository;

	@Autowired
	public InfluenzaEndpoint(InfluenzaRepository fluRepository) {
		this.fluRepository = fluRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "influenzaReq")
	@ResponsePayload
	public InfluenzaRsp getFluResponse(@RequestPayload InfluenzaReq request) {
		//InfluenzaRsp response = new InfluenzaRsp();
		InfluenzaRsp response = new InfluenzaRsp();
		//response.setCountry(fluRepository.findFlu(request.getName()));
		response.setInfluenzaRspDtl(fluRepository.findFlu("HK-88855"));
		//response.setCountry(fluRepository.findFlu("HK-44456"));
		return response;
	}
}
