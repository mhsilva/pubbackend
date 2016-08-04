package com.pub.api.gcm.impl;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.pub.api.gcm.PubGcmRestService;
import com.pub.api.utils.PubConstants;

@Service
public class PubGcmRestServiceImpl implements PubGcmRestService {

	@Override
	public void sendGcmNotification(String to, String message) {
		try {
			JSONObject jGcmData = new JSONObject();
			JSONObject jData = new JSONObject();
			jData.put("message", message);
			jGcmData.put("to", to);
			jGcmData.put("data", jData);
			URL url = new URL(PubConstants.GCM_BASE_URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("Authorization", "key=" + PubConstants.API_KEY);
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);

			OutputStream outputStream = conn.getOutputStream();
			outputStream.write(jGcmData.toString().getBytes());

			InputStream inputStream = conn.getInputStream();
			String resp = IOUtils.toString(inputStream);
			System.out.println(resp);
			System.out.println("Check your device/emulator for notification or logcat for "
					+ "confirmation of the receipt of the GCM message.");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
