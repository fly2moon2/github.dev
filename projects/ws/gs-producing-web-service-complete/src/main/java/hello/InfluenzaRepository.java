package hello;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import io.spring.guides.gs_producing_web_service.InfluenzaRsp;
import io.spring.guides.gs_producing_web_service.InfluenzaRspDtl;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class InfluenzaRepository {
	private static final Map<String, InfluenzaRspDtl> fluresponses = new HashMap<>();

	@PostConstruct
	public void initData() {
		InfluenzaRspDtl fluRsp1 = new InfluenzaRspDtl();
		fluRsp1.setHkRegNo("HK-44455");

		fluresponses.put(fluRsp1.getHkRegNo(), fluRsp1);

		InfluenzaRspDtl fluRsp2 = new InfluenzaRspDtl();
		fluRsp2.setHkRegNo("HK-55589");

		fluresponses.put(fluRsp2.getHkRegNo(), fluRsp2);
		
		InfluenzaRspDtl fluRsp3 = new InfluenzaRspDtl();
		fluRsp3.setHkRegNo("HK-88855");

		fluresponses.put(fluRsp3.getHkRegNo(), fluRsp3);
		

	}

	public InfluenzaRspDtl findFlu(String hkRegNo) {
		Assert.notNull(hkRegNo, "The HK Registration No. must not be null");
		return fluresponses.get(hkRegNo);
	}
}
