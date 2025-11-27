package com.brelin.loginPage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class LoginPageApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginPageApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void openBrowser() {
		String url = "http://localhost:8080";
		String os = System.getProperty("os.name").toLowerCase();
		
		System.out.println("🚀 Application started! Opening browser...");
		System.out.println("📍 URL: " + url);
		
		try {
			if (os.contains("win")) {
				// Windows
				Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
			} else if (os.contains("mac")) {
				// macOS
				Runtime.getRuntime().exec("open " + url);
			} else if (os.contains("nix") || os.contains("nux")) {
				// Linux
				Runtime.getRuntime().exec("xdg-open " + url);
			} else {
				System.out.println("⚠️  Could not detect OS. Please open: " + url);
			}
		} catch (Exception e) {
			System.out.println("⚠️  Could not open browser automatically.");
			System.out.println("📍 Please open manually: " + url);
		}
	}

}
