package com.bankapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BankingAppTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testEnquire() throws Exception {
		System.out.println("BEGIN TEST");
		
		
		//enquire first
		//enquire account ID with 1
		//balance = $123.0
		//account ID = 2
		//balance = $3000
		JSONObject json = new JSONObject();
		json.put("accountId", 1);

		JSONObject json2 = new JSONObject();
		json2.put("accountId", 2);
		
		this.mockMvc.perform(get("/enquire").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
		          .content(json.toString())).andDo(print()).andExpect(status().isOk())
		.andExpect(jsonPath("$.responseCode").value("000"))
		.andExpect(jsonPath("$.account.id").value("1"))
		.andExpect(jsonPath("$.account.balance").value(new BigDecimal("123.0")))
		.andExpect(jsonPath("$.transactions").isEmpty());
		
		
		this.mockMvc.perform(get("/enquire").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
		          .content(json2.toString())).andDo(print()).andExpect(status().isOk())
		.andExpect(jsonPath("$.responseCode").value("000"))
		.andExpect(jsonPath("$.account.id").value("2"))
		.andExpect(jsonPath("$.account.balance").value(new BigDecimal("3000.0")))
		.andExpect(jsonPath("$.transactions").isEmpty());
	
		
		//do send money
		//from 2 to 1
		//300
		
		JSONObject sendMoneyJson = new JSONObject();
		sendMoneyJson.put("senderId", 2);
		sendMoneyJson.put("receiverId", 1);
		sendMoneyJson.put("amount", 300.3);
		
		this.mockMvc.perform(post("/sendMoney").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
		          .content(sendMoneyJson.toString())).andDo(print()).andExpect(status().isOk())
		.andExpect(jsonPath("$.responseCode").value("000"));
		
		
		
		//enquire same account 
		//account id 1 balance = 423.3
		//account id 2 balance = 2699.7
		this.mockMvc.perform(get("/enquire").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
		          .content(json.toString())).andDo(print()).andExpect(status().isOk())
		.andExpect(jsonPath("$.responseCode").value("000"))
		.andExpect(jsonPath("$.account.id").value("1"))
		.andExpect(jsonPath("$.account.balance").value("423.3"))
		.andExpect(jsonPath("$.transactions").isNotEmpty());
		
		
		this.mockMvc.perform(get("/enquire").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
		          .content(json2.toString())).andDo(print()).andExpect(status().isOk())
		.andExpect(jsonPath("$.responseCode").value("000"))
		.andExpect(jsonPath("$.account.id").value("2"))
		.andExpect(jsonPath("$.account.balance").value("2699.7"))
		.andExpect(jsonPath("$.transactions").isNotEmpty());
		
		
		
		System.out.println("----------------------------END TEST------------------------");
		
	}
}
