package no.adstate.mail.notification.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import no.adstate.mail.notification.dto.UserDto;

public class JsonConversionUtil {

	private final static ObjectMapper objectMapper = new ObjectMapper();

	public static String wrapObjectToJsonString(UserDto userDto) {
		String data = null;
		try {
			data = objectMapper.writeValueAsString(userDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public static UserDto unwrapJsonStringToObject(String data) {
		UserDto userDto = null;
		try {
			userDto = objectMapper.readValue(data, UserDto.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDto;
	}

}
