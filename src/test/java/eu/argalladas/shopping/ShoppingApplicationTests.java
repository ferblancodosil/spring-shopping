package eu.argalladas.shopping;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;

import eu.argalladas.shopping.domain.SalesDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ShoppingApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testCase1() throws Exception {
		String date = "2020-06-14T10:00:00";
		String product = "35455";
		String brand = "1";
		String startDate = "2020-06-14T00:00";
		String endDate = "2020-12-31T23:59:59";
		Double price = Double.parseDouble("35.50");
		Long priceList = Long.parseLong("1");
		genericTest(date, product, brand, startDate, endDate, price, priceList);
	}

	@Test
	public void testCase2() throws Exception {
		String date = "2020-06-14T16:00:00";
		String product = "35455";
		String brand = "1";
		String startDate = "2020-06-14T15:00";
		String endDate = "2020-06-14T18:30";
		Double price = Double.parseDouble("25.45");
		Long priceList = Long.parseLong("2");
		genericTest(date, product, brand, startDate, endDate, price, priceList);
	}

	@Test
	public void testCase3() throws Exception {
		String date = "2020-06-14T21:00:00";
		String product = "35455";
		String brand = "1";
		String startDate = "2020-06-14T00:00";
		String endDate = "2020-12-31T23:59:59";
		Double price = Double.parseDouble("35.50");
		Long priceList = Long.parseLong("1");
		genericTest(date, product, brand, startDate, endDate, price, priceList);
	}

	@Test
	public void testCase4() throws Exception {
		String date = "2020-06-15T10:00:00";
		String product = "35455";
		String brand = "1";
		String startDate = "2020-06-15T00:00";
		String endDate = "2020-06-15T11:00";
		Double price = Double.parseDouble("30.50");
		Long priceList = Long.parseLong("3");
		genericTest(date, product, brand, startDate, endDate, price, priceList);
	}

	@Test
	public void testCase5() throws Exception {
		String date = "2020-06-16T21:00:00";
		String product = "35455";
		String brand = "1";
		String startDate = "2020-06-15T16:00";
		String endDate = "2020-12-31T23:59:59";
		Double price = Double.parseDouble("38.95");
		Long priceList = Long.parseLong("4");
		genericTest(date, product, brand, startDate, endDate, price, priceList);
	}

	@Test
	public void test404() throws Exception {
		String date = "2023-06-16T21:00:00";
		String product = "35455";
		String brand = "1";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<SalesDTO> response = restTemplate.exchange(
				new URI(String.format("http://localhost:%s/api/sales?date=%s&productId=%s&brandId=%s", port, date, product, brand)), HttpMethod.GET, entity, SalesDTO.class);

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

	}

	public void genericTest(String date, String product, String brand, String startDate, String endDate, Double price, Long priceList) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<SalesDTO> response = restTemplate.exchange(
				new URI(String.format("http://localhost:%s/api/sales?date=%s&productId=%s&brandId=%s", port, date, product, brand)), HttpMethod.GET, entity, SalesDTO.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());

		assertEquals(response.getBody().getBrand(), Long.parseLong(brand));
		assertEquals(response.getBody().getProduct(), Long.parseLong(product));
		assertEquals(response.getBody().getStartDate().toString(), startDate);
		assertEquals(response.getBody().getEndDate().toString(), endDate);
		assertEquals(response.getBody().getPrice(), price);
		assertEquals(response.getBody().getPriceList(), priceList);
	}
}

