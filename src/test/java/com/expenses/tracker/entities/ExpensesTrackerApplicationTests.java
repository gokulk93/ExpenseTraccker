package com.expenses.tracker.entities;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ExpensesTrackerApplicationTests {

	@LocalServerPort
	int randomServerPort;

	@Test
	public void testGetAllExpenses() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:" + randomServerPort + "/getReport";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		//Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(true, result.getBody().contains("expenseList"));
	}

	@Test
	public void testAddExpenseMissingHeader() throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:"+randomServerPort+"/employees/";
		URI uri = new URI(baseUrl);
		Expense expenses = new Expense("Test",236.12,"Junit Test",LocalDate.of(2019,12,26));

		HttpHeaders headers = new HttpHeaders();

		HttpEntity<Expense> request = new HttpEntity<>(expenses, headers);

		try
		{
			restTemplate.postForEntity(uri, request, String.class);
			Assert.fail();
		}
		catch(HttpClientErrorException ex)
		{
			//Verify bad request and missing header
			Assert.assertEquals(400, ex.getRawStatusCode());
			Assert.assertEquals(true, ex.getResponseBodyAsString().contains("Missing request header"));
		}
	}

}
