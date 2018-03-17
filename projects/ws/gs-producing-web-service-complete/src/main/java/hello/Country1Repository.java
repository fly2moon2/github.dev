package hello;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import io.spring.guides.gs_producing_web_service.Country1;
import io.spring.guides.gs_producing_web_service.Currency1;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class Country1Repository {
	private static final Map<String, Country1> countries = new HashMap<>();

	@PostConstruct
	public void initData() {
		Country1 spain = new Country1();
		spain.setName("Spain");
		spain.setCapital("Madrid");
		spain.setCurrency(Currency1.EUR);
		spain.setPopulation(46704314);

		countries.put(spain.getName(), spain);

		Country1 poland = new Country1();
		poland.setName("Poland");
		poland.setCapital("Warsaw");
		poland.setCurrency(Currency1.PLN);
		poland.setPopulation(38186860);

		countries.put(poland.getName(), poland);

		Country1 uk = new Country1();
		uk.setName("United Kingdom");
		uk.setCapital("London");
		uk.setCurrency(Currency1.GBP);
		uk.setPopulation(63705000);

		countries.put(uk.getName(), uk);
	}

	public Country1 findCountry(String name) {
		Assert.notNull(name, "The country's name must not be null");
		return countries.get(name);
	}
}
