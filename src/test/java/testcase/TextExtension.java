package testcase;

public class TextExtension {
	
	public String noLineBreaker(String text) {
		return text.replaceAll("[\\n\\r]", "");
	}
	
	public String toUppercase(String text) {
		return text.toUpperCase();
	}	
	
}


